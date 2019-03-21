package com.demo.giftmoney.serviceImpl;

import com.demo.giftmoney.response.UploadParamsView;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class OssService {

    @Value("${aliyun.upload.host}")
    private String host;

    @Value("${aliyun.appId}")
    private String appId;

    @Value("${aliyun.appKey}")
    private String appKey;

    @Value("${aliyun.upload.endPoint}")
    private String endPoint;

    @Value("${aliyun.upload.bucket}")
    private String bucket;


    public UploadParamsView getUploadParams() throws Exception {
        UploadParamsView view = new UploadParamsView();

        view.setUrl(host);
        view.setAppId(appId);
        view.setAppKey(appKey);
        view.setBucket(bucket);
        view.setHost(endPoint);
        return view;
    }
}
