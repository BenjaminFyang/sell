package com.imooc.utils;

import com.imooc.vo.ResultVO;

/**
 * @author 方洋
 * :把所用可能返回的方法都列举出来
 * @date 2018/1/30 14:28
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    /**
     * 表示的是方法出错的时候
     *
     * @param code 错误码
     * @param msg  错误信息
     * @return 该订单的详情
     */
    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;

    }


}
