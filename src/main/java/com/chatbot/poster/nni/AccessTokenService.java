package com.chatbot.poster.nni;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class AccessTokenService {

    private static final Logger LOG = LoggerFactory.getLogger(AccessTokenService.class);

    private static String access_token;
    private static long expires;

    private static String url = "http://124.42.103.156:8089/maap/developer/messaging/v1/accessToken/125300470000009/requests?grant_type=client_credential&appid=60470&appsecret=ffa6b4f0fddf31ec184be9a8e82f80f7";

    @Autowired
    RestTemplate restTemplate;

    public String getToken() {

        LOG.info("current access_token is : {}", access_token);
        LOG.info("current access_token expires in : {}, current timestamp : {}", expires, System.currentTimeMillis());

        if(null == access_token || expires < System.currentTimeMillis()) {

            String result = restTemplate.getForObject(url, String.class);
            LOG.info("access_token is null or expired. get access_token from nni : {}", result);

            HashMap<String, String> map  = JSONObject.parseObject(result, HashMap.class);
            if(null != map && map.containsKey("access_token")) {
                access_token = map.get("access_token");
                expires = System.currentTimeMillis() + 7200*1000;

                LOG.info("refresh AccessToken success! access_token : {}, expires : {}", access_token, expires);
            }

        }

        LOG.info("get access_token from cache : {}", access_token);

        return access_token;
    }
}
