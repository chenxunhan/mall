package com.sxt.utils;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.Map;
import java.util.Random;

/**
 * 阿里云发送短信工具类
 */
public class AlibabaSendMsgUtils {


    public static String sendMsg(String phone,int code) {

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G7maL9SqXRzMRqDUebr", "c2eQXoSPV6kUAKDQ5KikP9LhwdPTon");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "ting域主持人");
        request.putQueryParameter("TemplateCode", "SMS_191816424");
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());//{"RequestId":"4BF09326-89EF-4DF1-914A-4A5AFFF2A598","Message":"OK","BizId":"797921809637221453^0","Code":"OK"}
            return response.getData();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getRandom(){
        Random random = new Random();
        int number = random.nextInt(9000)+1000;
        return number;
    }


    public static void main(String[] args) {

        String msg = "{\"RequestId\":\"4BF09326-89EF-4DF1-914A-4A5AFFF2A598\",\"Message\":\"OK\",\"BizId\":\"797921809637221453^0\",\"Code\":\"OK\"}";

        Map map = JSON.parseObject(msg, Map.class);

        System.out.println(map.getClass().getName());
        System.out.println(map);


    }

}
