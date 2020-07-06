package com.chatbot.poster.accesslayer.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author huangshihuan
 */
@Data
@AllArgsConstructor
public class ReportRequest {
    @JacksonXmlText
    private String reportRequest;
}
