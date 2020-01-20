package com.chatbot.poster.dao;


import lombok.Data;

@Data
public class SendResponse {
    private String code;
    private String msgid;
    private String msg;

}
