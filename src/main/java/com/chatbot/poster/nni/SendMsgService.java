package com.chatbot.poster.nni;

import com.chatbot.poster.dao.MaaPMsg;
import com.chatbot.poster.accesslayer.entity.ReportRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class SendMsgService {

    private static final Logger LOG = LoggerFactory.getLogger(SendMsgService.class);

    @Autowired
    AccessTokenService accessTokenService;

    @Autowired
    RestTemplate restTemplate;

    private static String url = "http://124.42.103.156:8089/maap/developer/messaging/v1/maap/125300470000009/requests";

    public void sendMaapMsg(String address, String msg) {

        MaaPMsg maaPMsg =  new MaaPMsg();
        maaPMsg.setAddress(address);
        maaPMsg.setBodyText(msg);
        maaPMsg.setContentType("text/plain");
        maaPMsg.setContributionID(UUID.randomUUID().toString());
        maaPMsg.setConversationID(UUID.randomUUID().toString());

        List<ReportRequest> reportRequests = new LinkedList<>();
        reportRequests.add(new ReportRequest("Delivered"));
        reportRequests.add(new ReportRequest("Failed"));
        maaPMsg.setReportRequest(reportRequests);

        LOG.info("msg : {}", maaPMsg);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.set("Authorization", "access_token:" + accessTokenService.getToken());

        HttpEntity<MaaPMsg> request = new HttpEntity<>(maaPMsg, headers);
        LOG.info("request : {}", request);

        ResponseEntity<String> result = restTemplate.postForEntity(url, request, String.class);

        LOG.info("http code : {}", result.getStatusCodeValue());

        LOG.info("response : {}", result.getBody());

    }

    public void SendTaskPointMsg(String address, String msg) {

    }
}
