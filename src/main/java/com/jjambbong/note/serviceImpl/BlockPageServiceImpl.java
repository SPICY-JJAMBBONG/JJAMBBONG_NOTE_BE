package com.jjambbong.note.serviceImpl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jjambbong.note.entity.BlockPage;
import com.jjambbong.note.repository.BlockPageRepository;
import com.jjambbong.note.service.BlockPageService;

import lombok.RequiredArgsConstructor;

@Transactional
@Component
@RequiredArgsConstructor
public class BlockPageServiceImpl implements BlockPageService {

	@Autowired
	private final BlockPageRepository blockPageRepository;

	@Transactional
	@Override
	public UUID createBlockPage(BlockPage blockPage, String currentPageId) {
		UUID uuid = blockPageRepository.save(blockPage).getBlockId(); // 새로 생성 + 생성한 id 가져오기

		if (currentPageId != null) { //하위 페이지 만들기 : 현재 tb_block_page-pageList에 1번 id추가
			Optional<BlockPage> optionalBlockPage = blockPageRepository.findById(UUID.fromString(currentPageId));

			if (optionalBlockPage.isPresent()) {

				BlockPage upperBlockPage = optionalBlockPage.get();
				upperBlockPage.getBlockList();
			}

		} else { //메인 페이지 만들기 : tb_main_page에 추가 >>> member_id는 어떻게 가져오지???

		}

		return uuid;
	}

	@Override
	public Optional<BlockPage> findById(String id) {
		return blockPageRepository.findById(UUID.fromString(id));
	}
}



/* json형태??
*
*
* {
  "block_list": [
  {
    "type": "text",
    "id": "uuid"
  },
  {
    "type": "text",
    "id": "uuid"
  },
{
    "type": "page",
    "id": "page_uuid"
  }
  ]

}


{
  "page_list": [
    "page_uuid1",
    "page_uuid2"
  ]

}
*
*
* */
