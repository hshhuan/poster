package com.chatbot.poster.accesslayer.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * All rights reserved.
 *
 * @author hshhuan
 * @version 1.0
 * @date 2020/7/6
 */

@Data
@JacksonXmlRootElement(localName = "serviceCapability")
public class ServiceCapability {

    @JacksonXmlProperty(localName = "capabilityId")
    private String capabilityId;

    @JacksonXmlProperty(localName = "version")
    private String version;

}
