package com.jjambbong.note.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@AllArgsConstructor
public class Document {

    @Id @GeneratedValue
    private Long id;

    private String content;

}
