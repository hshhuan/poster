package com.chatbot.poster.accesslayer.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

/**
 * All rights reserved.
 *
 * @author hshhuan
 * @version 1.0
 * @date 2020/7/6
 */

@Data
@JacksonXmlRootElement(localName = "outboundIMMessage")
public class OutboundIMMessge {


    private String contentType;

    private String contentEncoding;

    private String bodyText;

    private String conversationID;

    private String contributionID;

    private boolean storeSupported;

    private String fallbackSupported;

    private String fallbackContentType;

    private String fallbackEncoding;

    private String rcsBodyText;

    private String shortMessageSupported;

    private String smsBodyText;

    private String imFormat;

    private String trafficType;

    private ServiceCapability serviceCapability;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<ReportRequest> reportRequest;

}
