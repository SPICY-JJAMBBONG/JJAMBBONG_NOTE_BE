package com.jjambbong.note.serviceImpl;

import com.jjambbong.note.dto.BlockDto;
import com.jjambbong.note.entity.BlockPage;
import com.jjambbong.note.entity.BlockText;
import com.jjambbong.note.mapper.BlockMapper;
import com.jjambbong.note.service.BlockPageService;
import com.jjambbong.note.service.BlockPageWService;
import com.jjambbong.note.service.BlockTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BlockPageWServiceImpl implements BlockPageWService {

    private static ConcurrentHashMap<String, BlockDto> map = new ConcurrentHashMap<>();
    static Date lastSavedTime = new Date();

    @Autowired
    BlockPageService blockPageService;
    @Autowired
    BlockTextService blockTextService;

    @Override
    public void transferBlockToMap(BlockDto blockDto) {
        // TODO: 여기서 line 22에 new ConcurrentHashMap<>()을 해주지 않으면 nullPointException이 뜸 - 사유 확인 필요
        map.put(blockDto.getId(), blockDto);
        Date currentTime = new Date();
        //if ((currentTime.getTime() - lastSavedTime.getTime())/1000 > 5) {
        saveBlock(currentTime);
        //}
    }

    // TODO: 현재는 새로운 transferBlockToMap 함수가 호출됐을때만 호출되지만, 그렇지 않은 상황에서도 주기적으로 호출될수 있도록 개선 필요
    // TODO: 새로운 block을 create 할지말지 결정하는 로직을 여기에 넣을지 BlockPageServiceImpl/BlockTextServiceImpl에 넣을지 => ServiceImple에 넣기
    public synchronized void saveBlock(Date currentTime) {
        System.out.println("map = " + map);
        // 배치 돌리는 부분
        for(String blockId : map.keySet()){
            // API
            // TODO: db 저장에 실패했을때, 소켓으로 이미 보내진 정보를 다시 원래 정보로 rollback 할수있는 방안 필요
            if(blockId.contains("page")){
                //BlockPage blockPage = blockMapper.BlockDtoToBlockPage();
                blockPageService.updateBlockPage(map.remove(blockId), blockId);
            } else if(blockId.contains("text")){
                //BlockText blockText = blockMapper.BlockDtoToBlockText(map.remove(blockId));
                blockTextService.updateBlockText(map.remove(blockId), blockId);
            }
        }
        lastSavedTime = new Date();
    }
}
