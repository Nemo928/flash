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
package com.zj.springcloud.common.exception;

import com.zj.springcloud.common.constants.CommonConstants;

public class ClientForbiddenException extends BaseException
{
    /**
     * serialVersionUID long
     */
    private static final long serialVersionUID = -6924189987365347665L;

    public ClientForbiddenException(String message)
    {
        super(CommonConstants.CLIENT_FORBIDDEN_CODE, message);
    }
}
