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

import java.util.Optional;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zj.springcloud.common.constants.CommonConstants;
import com.zj.springcloud.common.jwt.IJWTInfo;
import com.zj.springcloud.common.jwt.JWTInfo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTHelper
{
    private Logger              LOGGER       = LoggerFactory
            .getLogger(getClass());

    private static RsaKeyHelper rsaKeyHelper = new RsaKeyHelper();

    /**
     * 密钥加密token
     * 
     * @since 2017年11月8日
     * @author allnas
     * @param info
     * @return
     * @throws Exception
     */
    protected String generateToken(IJWTInfo info, int expire, String priKeyPath)
            throws Exception
    {
        String compactJws = Jwts.builder().setSubject(info.getUniqueName())
                .claim(CommonConstants.JWT_USER_ID, info.getUserId())
                .claim(CommonConstants.JWT_USERNAME, info.getUserName())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256,
                        rsaKeyHelper.getPrivateKey(priKeyPath))
                .compact();
        LOGGER.info("compactJws:{}", compactJws);
        return compactJws;
    }

    /**
     * 解析token
     * 
     * @since 2017年11月8日
     * @author allnas
     * @param token
     * @throws Exception
     */
    protected Jws<Claims> parserToken(String token, String pubKeyPath)
            throws Exception
    {
        return Jwts.parser()
                .setSigningKey(rsaKeyHelper.getPublicKey(pubKeyPath))
                .parseClaimsJws(token);
    }

    protected JWTInfo getInfoFromToken(String token, String pubKeyPath)
            throws Exception
    {
        Jws<Claims> claimsJws = parserToken(token, pubKeyPath);
        Claims body = claimsJws.getBody();
        JWTInfo jwtInfo = new JWTInfo();
        jwtInfo.setLoginName(body.getSubject());
        jwtInfo.setId(Optional
                .ofNullable(Long.valueOf(
                        body.get(CommonConstants.JWT_USER_ID).toString()))
                .orElse(-1L));
        jwtInfo.setUserName(Optional
                .ofNullable(body.get(CommonConstants.JWT_USERNAME).toString())
                .orElse(""));
        return jwtInfo;
    }
}
