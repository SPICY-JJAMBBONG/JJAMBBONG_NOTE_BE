package com.jjambbong.note.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tb_block")
public class Block{
    @Id
    private String id;
    private String type;
    private Date lastModifiedTime;
    private Double order;
    private int indent;

    //page
    @Builder.Default
    private List<String> blockList = new ArrayList<>();
    private String title;

    //text
    private String content;
    @Builder.Default
    private List<String> style = new ArrayList<>();


    //Image
    private String url;
    private String altText;


}
