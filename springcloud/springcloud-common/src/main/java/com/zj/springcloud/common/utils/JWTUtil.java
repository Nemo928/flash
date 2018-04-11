//-------------------------------------------------------------------------
// Copyright (c) 2000-2016 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: allnas
//
//-------------------------------------------------------------------------
// APACHE
//-------------------------------------------------------------------------
package com.zj.springcloud.common.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.zj.springcloud.common.jwt.IJWTInfo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

@Component
public class JWTUtil extends JWTHelper
{
    @Value("${jwt.expire}")
    private int    expire;

    @Value("${jwt.pri-key.path}")
    private String priKeyPath;

    @Value("${jwt.pub-key.path}")
    private String pubKeyPath;

    /**
     * 密钥加密token
     * 
     * @since 2017年11月8日
     * @author allnas
     * @param info
     * @throws Exception
     */
    public String generateToken(IJWTInfo info) throws Exception
    {
        return generateToken(info, expire, priKeyPath);
    }

    /**
     * 解析token
     * 
     * @since 2017年11月8日
     * @author allnas
     * @param token
     * @throws Exception
     */
    public IJWTInfo getInfoFromToken(String token) throws Exception
    {
        return getInfoFromToken(token, pubKeyPath);
    }

    public Jws<Claims> parserToken(String token) throws Exception
    {
        return parserToken(token, pubKeyPath);
    }
}
