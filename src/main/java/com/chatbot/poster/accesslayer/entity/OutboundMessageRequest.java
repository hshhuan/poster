package com.chatbot.poster.accesslayer.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
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
@JacksonXmlRootElement(localName = "outboundMessageRequest")
public class OutboundMessageRequest {

    @JacksonXmlProperty(localName = "address")
    private String address;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<String> destinationAddress;

    @JacksonXmlProperty(localName = "senderAddress")
    private String senderAddress;

    @JacksonXmlProperty(localName = "clientCorrelator")
    private String clientCorrelator;

    @JacksonXmlProperty(localName = "outboundIMMessage")
    private OutboundIMMessge outboundIMMessage;


    public static void main(String [] args) {

        String xml = "<outboundMessageRequest><address>phonenumber123</address><destinationAddress>phonenumber123</destinationAddress><destinationAddress>phonenumber456</destinationAddress><senderAddress>{{chatboturi}}</senderAddress><clientCorrelator>567895</clientCorrelator><outboundIMMessage><imFormat>IM</imFormat><contentType>text/plain</contentType><contentEncoding>utf8</contentEncoding><bodyText>hello，maap</bodyText><conversationID>789</conversationID><contributionID>987</contributionID><storeSupported>false</storeSupported><fallbackSupported>true</fallbackSupported><fallbackContentType>text/plain</fallbackContentType><fallbackEncoding>utf8</fallbackEncoding><rcsBodyText>hello，rcs</rcsBodyText><shortMessageSupported>true</shortMessageSupported><smsBodyText>hello，sms</smsBodyText><trafficType>advertisement</trafficType><serviceCapability><capabilityId>ChatbotSA</capabilityId><version>+g.gsma.rcs.botversion=\"#=2\"</version></serviceCapability><reportRequest>Sent</reportRequest><reportRequest>Delivered</reportRequest><reportRequest>Failed</reportRequest><reportRequest>Displayed</reportRequest><reportRequest>SMS</reportRequest></outboundIMMessage></outboundMessageRequest>\n";

        ObjectMapper mapper = new XmlMapper();

        ReportRequest reportRequest = new ReportRequest("123");

        try {
            OutboundMessageRequest omr = mapper.readValue(xml, OutboundMessageRequest.class);

            System.out.println(omr);

            System.out.println(mapper.writeValueAsString(omr));

            System.out.println(mapper.writeValueAsString(reportRequest));

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
