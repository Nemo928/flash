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
package com.zj.springcloud.common.jwt;

import java.io.Serializable;

import com.zj.springcloud.common.entity.BaseVo;

public class JWTInfo extends BaseVo implements Serializable, IJWTInfo
{

    /**
     * serialVersionUID long
     */
    private static final long serialVersionUID = -7392239165634943239L;

    private String            loginName;

    private String            userName;

    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getLoginName()
    {
        return loginName;
    }

    @Override
    public String getUniqueName()
    {
        return loginName;
    }

    @Override
    public Long getUserId()
    {
        return id;
    }

    @Override
    public String getUserName()
    {
        return userName;
    }
}
