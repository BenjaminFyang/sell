package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : Fy
 * @implSpec : Created with IntelliJ IDEA.
 * @date : 2018-03-02 18:07
 * @deprecated :fff
 */
@Data
@ConfigurationProperties(prefix = "projectUrl")
@Component
public class ProjectUrlConfig {

    /**
     * 微信公众账号授权url.
     */
    public String wechatMpAuthorize;

    /**
     * 微信开发平台授权url.
     */
    public String wechatOpenAuthorized;

    /**
     * 点餐系统url.
     */
    public String sell;

}
