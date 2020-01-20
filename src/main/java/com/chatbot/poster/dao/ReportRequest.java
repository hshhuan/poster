package com.chatbot.poster.dao;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportRequest {
    @JacksonXmlText
    private String reportRequest;
}
