package com.jjambbong.note.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tb_block")
public class BlockImage implements Block{

    @Id
    private String id;

    private String type;

    private String url;

    private String altText;

    private Date lastModifiedTime;
}
