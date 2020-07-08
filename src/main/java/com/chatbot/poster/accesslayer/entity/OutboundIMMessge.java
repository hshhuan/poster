package com.chatbot.poster.accesslayer.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
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

    @JacksonXmlProperty(localName = "contentType")
    private String contentType;

    @JacksonXmlProperty(localName = "contentEncoding")
    private String contentEncoding;

    @JacksonXmlProperty(localName = "bodyText")
    private String bodyText;

    @JacksonXmlProperty(localName = "conversationID")
    private String conversationID;

    @JacksonXmlProperty(localName = "contributionID")
    private String contributionID;

    @JacksonXmlProperty(localName = "storeSupported")
    private boolean storeSupported;

    @JacksonXmlProperty(localName = "fallbackSupported")
    private String fallbackSupported;

    @JacksonXmlProperty(localName = "fallbackContentType")
    private String fallbackContentType;

    @JacksonXmlProperty(localName = "fallbackEncoding")
    private String fallbackEncoding;

    @JacksonXmlProperty(localName = "rcsBodyText")
    private String rcsBodyText;

    @JacksonXmlProperty(localName = "shortMessageSupported")
    private String shortMessageSupported;

    @JacksonXmlProperty(localName = "smsBodyText")
    private String smsBodyText;

    @JacksonXmlProperty(localName = "imFormat")
    private String imFormat;

    @JacksonXmlProperty(localName = "trafficType")
    private String trafficType;

    @JacksonXmlProperty(localName = "serviceCapability")
    private ServiceCapability serviceCapability;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<ReportRequest> reportRequest;

}
