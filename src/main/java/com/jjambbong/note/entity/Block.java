package com.jjambbong.note.entity;

import lombok.NoArgsConstructor;

import java.util.Date;

public interface Block {
    public String getId();
    public String getType();
    public Date getLastModifiedTime();

}
