package com.imooc.controller;

import com.google.common.collect.Maps;
import com.imooc.converter.OrderForm2OrderDtoConverter;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.OrderFrom;
import com.imooc.service.BuyerService;
import com.imooc.service.OrderService;
import com.imooc.utils.ResultVOUtil;
import com.imooc.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Map;


/**
 * 买家端
 *
 * @author 方洋
 * @date 2018/2/2 11:01
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private BuyerService buyerService;

    /**
     * 创建订单
     *
     * @param orderFrom     前端参数
     * @param bindingResult 参数校验对象
     * @return 订单的orderId
     */
    @PostMapping("/create")
    public ResultVO create(@Valid OrderFrom orderFrom, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确，orderForm={}", orderFrom);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDtoConverter.convert(orderFrom);

        //判断这个订单的购物车是否为空的情况
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailsList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String> map = Maps.newHashMap();
        map.put("orderId", createResult.getOrderId());
        return ResultVOUtil.success(map);
    }


    /**
     * 订单列表
     *
     * @param openid 微信的openid
     * @param page   当前的页数
     * @param size   每页数
     * @return 返回指定页的列表
     */
    @GetMapping("/list")
    public ResultVO list(@RequestParam("openid") String openid,
                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest request = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);

        return ResultVOUtil.success(orderDTOPage.getContent());

    }

    /**
     * 订单详情
     *
     * @param openid  微信的openid
     * @param orderId 点单的id
     * @return 该订单的详情
     */
    @GetMapping("detail")
    public ResultVO detail(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {

        if (StringUtils.isEmpty((openid))) {
            log.error("【查询订单详情】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        if (StringUtils.isEmpty(orderId)) {
            log.error("【查询订单详情】orderId为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVOUtil.success(orderDTO);
    }


    /**
     * 取消订单
     *
     * @param openid  微信的openid
     * @param orderId 点单号
     * @return 返回该订单是否已经取消成功
     */
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {

        if (StringUtils.isEmpty((openid))) {
            log.error("【查询订单详情】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        if (StringUtils.isEmpty(orderId)) {
            log.error("【查询订单详情】orderId为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        buyerService.cancelOrder(openid, orderId);
        return ResultVOUtil.success();
    }


}
