package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.service.PushMessage;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Fy
 * @implSpec : Created with IntelliJ IDEA.
 * @date : 2018-03-05 17:06
 * @deprecated :
 */
@Service
@Slf4j
public class PushMessageImpl implements PushMessage {
    @Resource
    private WxMpService wxMpService;


    @Override
    public void orderStatus(OrderDTO orderDTO) {
//        WxMpTemplateMessage wxMpTemplateMessage = new WxMpTemplateMessage();
//        wxMpTemplateMessage.setTemplateId("fdsfdsfsdfsdfds");
//        wxMpTemplateMessage.setUrl("dasdsadsadsadsad");
//
//        List<WxMpTemplateData> data = Arrays.asList(
//                new WxMpTemplateData("first", "亲，记得收货"),
//                new WxMpTemplateData("keyWord1", "微信点餐"),
//                new WxMpTemplateData("keyWord2", "15623171246"),
//                new WxMpTemplateData("keyWord3", orderDTO.getOrderId()),
//                new WxMpTemplateData("keyWord4", orderDTO.getOrderStatusEnum().getMsg()),
//                new WxMpTemplateData("keyWord5", "￥" + orderDTO.getOrderAmount()),
//                new WxMpTemplateData("keyWord6", "欢迎再次光临！")
//        );
//        wxMpTemplateMessage.set
//
//        try {
//            wxMpService.getTemplateMsgService().sendTemplateMsg(wxMpTemplateMessage);
//        } catch (WxErrorException e) {
//            log.error("【微信模板消息】发送失败，{}", e);
//        }


    }
}
