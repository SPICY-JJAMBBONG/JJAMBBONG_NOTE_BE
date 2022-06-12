package com.jjambbong.note.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@RequiredArgsConstructor
public class Document {

    @Id @GeneratedValue
    private Long id;

    @NonNull
    private String content;

}
