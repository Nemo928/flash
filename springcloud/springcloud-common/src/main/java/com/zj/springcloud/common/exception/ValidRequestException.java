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

public class ValidRequestException extends BaseException
{
    /**
     * serialVersionUID long
     */
    private static final long serialVersionUID = -3445105673063734021L;

    public ValidRequestException(String message)
    {
        super(CommonConstants.VALID_REQUEST_ERROR_CODE, message);
    }
}
