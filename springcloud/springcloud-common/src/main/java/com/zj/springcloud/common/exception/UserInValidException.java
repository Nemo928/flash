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

public class UserInValidException extends BaseException
{
    /**
     * serialVersionUID long
     */
    private static final long serialVersionUID = 6504656830588756016L;

    public UserInValidException(String message)
    {
        super(CommonConstants.USER_VALID_ERROR_CODE, message);
    }
}
