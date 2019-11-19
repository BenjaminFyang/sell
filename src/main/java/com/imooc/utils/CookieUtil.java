package com.imooc.utils;

import com.google.common.collect.Maps;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * cookie工具类
 *
 * @author : Fy
 * @implSpec : Created with IntelliJ IDEA.
 * @date : 2018-03-05 11:30
 * @deprecated :cookie工具类
 */
public class CookieUtil {

    /**
     * 设置cookie
     *
     * @param response 返回页面的参数
     * @param name     cookie的名字
     * @param value    cookie的值
     * @param maxAge   设置cookie的过期时间
     */
    public static void set(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 获取用户的Cookie的值
     *
     * @param request 页面传过来的请求的参数
     * @param name    Cookie的名字
     */
    public static Cookie get(HttpServletRequest request, String name) {

        Map<String, Cookie> cookieMap = readCookieMap(request);
        return cookieMap.getOrDefault(name, null);
    }

    /**
     * 将cookie封装成Map
     *
     * @param request 页面请求的参数
     * @return Map
     */
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = Maps.newHashMap();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}
