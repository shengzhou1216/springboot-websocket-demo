package com.hzml.basic;

import lombok.Data;

@Data
public class Message {
    private String from;
    private String to;
    private String content;
}