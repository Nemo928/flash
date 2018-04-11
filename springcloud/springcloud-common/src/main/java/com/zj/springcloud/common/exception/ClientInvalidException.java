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

public class ClientInvalidException extends BaseException
{
    /**
     * serialVersionUID long
     */
    private static final long serialVersionUID = -5347780288322515132L;

    public ClientInvalidException(String message)
    {
        super(CommonConstants.CLIENT_INVALID_CODE, message);
    }
}
