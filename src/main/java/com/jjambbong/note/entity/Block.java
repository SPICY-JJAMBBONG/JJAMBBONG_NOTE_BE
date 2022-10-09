package com.jjambbong.note.entity;

import lombok.NoArgsConstructor;

import java.util.Date;

// TODO: BLOCK 대통합 필요
public interface Block {
    public String getId();
    public String getType();
    public Date getLastModifiedTime();

}
