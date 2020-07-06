package com.chatbot.poster.dao;

import com.chatbot.poster.accesslayer.entity.ReportRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Data
@JacksonXmlRootElement(localName = "outboundMessageRequest")
public class MaaPMsg {

    @JacksonXmlProperty
    private String address;

    @JacksonXmlProperty
    private String contentType;

    @JacksonXmlCData
    private String bodyText;

    @JacksonXmlProperty
    private String conversationID;

    @JacksonXmlProperty
    private String contributionID;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<ReportRequest> reportRequest;

    public static void main(String [] args) {

        MaaPMsg maaPMsg = new MaaPMsg();

        maaPMsg.setAddress("+8619802021139");
        maaPMsg.setContentType("text/plain");
        maaPMsg.setBodyText("test");
        maaPMsg.setConversationID(UUID.randomUUID().toString());
        maaPMsg.setContributionID(UUID.randomUUID().toString());

        List<ReportRequest> reportRequests = new LinkedList<>();
        reportRequests.add(new ReportRequest("Delivered"));
        reportRequests.add(new ReportRequest("Failed"));
        maaPMsg.setReportRequest(reportRequests);

        ObjectMapper xmlMapper = new XmlMapper();
        try {
            String result = xmlMapper.writeValueAsString(maaPMsg);
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
