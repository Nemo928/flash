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

public class TokenErrorException extends BaseException
{

    /**
     * serialVersionUID long
     */
    private static final long    serialVersionUID = 3781386446320905417L;

    public TokenErrorException(int status, String message)
    {
        super(CommonConstants.TOKEN_ERROR_CODE, message);
    }
}
