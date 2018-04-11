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
package com.zj.springcloud.common.msg;

import java.io.Serializable;

public class JwtAuthenticationResponse implements Serializable
{
    /**
     * serialVersionUID long
     */
    private static final long serialVersionUID = 7409043738135159095L;

    private final String      token;

    public JwtAuthenticationResponse(String token)
    {
        this.token = token;
    }

    public String getToken()
    {
        return this.token;
    }
}
