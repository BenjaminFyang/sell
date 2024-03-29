package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 方洋
 * @date 2018/2/7 11:26
 * :表示的是配置文件的设置，从application.yml文件中读取
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    /**
     * 公众平台的id.
     */
    private String mpAppId;

    /**
     * 公众平台密钥.
     */
    private String mpAppSecret;

    /**
     * 开发平台id.
     */
    private String openAppId;

    /**
     * 开放平台密钥.
     */
    private String openAppSecret;

    /**
     * 商户号
     */
    private String mchId;

    /**
     * 商户密钥
     */
    private String mchKey;

    /**
     * 商户证书路径
     */
    private String keyPath;

    /**
     * 微信支付异步通知地址
     */
    private String notifyUrl;

}
