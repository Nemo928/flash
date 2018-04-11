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
package com.zj.springcloud.common.handler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zj.springcloud.common.constants.CommonConstants;
import com.zj.springcloud.common.exception.BaseException;
import com.zj.springcloud.common.exception.ClientForbiddenException;
import com.zj.springcloud.common.exception.ClientInvalidException;
import com.zj.springcloud.common.exception.TokenErrorException;
import com.zj.springcloud.common.exception.UserInValidException;
import com.zj.springcloud.common.exception.ValidRequestException;
import com.zj.springcloud.common.msg.BaseResponse;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(BaseException.class)
    public BaseResponse baseException(HttpServletResponse response,
            BaseException exception)
    {
        return new BaseResponse(exception.getStatus(), exception.getMessage());
    }

    @ExceptionHandler(TokenErrorException.class)
    public BaseResponse tokenErrorException(HttpServletResponse response,
            TokenErrorException exception)
    {
        return new BaseResponse(exception.getStatus(), exception.getMessage());
    }

    @ExceptionHandler(UserInValidException.class)
    public BaseResponse userValidException(HttpServletResponse response,
            UserInValidException exception)
    {
        return new BaseResponse(exception.getStatus(), exception.getMessage());
    }

    @ExceptionHandler(ClientInvalidException.class)
    public BaseResponse clientInvalidException(HttpServletResponse response,
            ClientInvalidException exception)
    {
        return new BaseResponse(exception.getStatus(), exception.getMessage());
    }
    
    @ExceptionHandler(ClientForbiddenException.class)
    public BaseResponse clientForbiddenException(HttpServletResponse response,
            ClientForbiddenException exception)
    {
        return new BaseResponse(exception.getStatus(), exception.getMessage());
    }
    
    @ExceptionHandler(ValidRequestException.class)
    public BaseResponse validRequestException(HttpServletResponse response,
            ValidRequestException exception)
    {
        return new BaseResponse(exception.getStatus(), exception.getMessage());
    }
    
    @ExceptionHandler(Exception.class)
    public BaseResponse otherException(HttpServletResponse response,
            Exception exception)
    {
        return new BaseResponse(CommonConstants.OTHER_ERROR_CODE,
                exception.getMessage());
    }
}
