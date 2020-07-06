package com.chatbot.poster.business;


import com.chatbot.poster.dao.RecallMsg;
import com.chatbot.poster.nni.SendMsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @author huangshihuan
 */
@RestController
public class SimpleController {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleController.class);

    @Autowired
    SendMsgService sendMsgService;

    @PostMapping(path = "/callback", consumes = "text/xml", produces = "application/json")
    public String receiveMessage(@RequestBody RecallMsg msg, HttpServletRequest request) {
        LOG.info(msg.toString());

        if ("text".equals(msg.getMsgType())) {
            String textMsg = new String(Base64.getDecoder().decode(msg.getContent()), Charset.defaultCharset());

            LOG.info("receive msg : {}", textMsg);

            String responseMsg = textMsg.replace("吗", "").replace("嘛","")
                    .replace("？","！").replace("?","!");

            LOG.info("responding msg : {}", responseMsg);

            sendMsgService.sendMaapMsg(msg.getFromUserName(),responseMsg);

        }

        return "{\"code\":\"200\"}";

    }

}
