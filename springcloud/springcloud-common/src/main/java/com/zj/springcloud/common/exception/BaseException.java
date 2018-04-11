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

public class BaseException extends Exception
{

    /**
     * serialVersionUID long
     */
    private static final long serialVersionUID = 7631885226363834955L;

    private int               status           = 200;

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public BaseException()
    {

    }

    public BaseException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BaseException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public BaseException(String message)
    {
        super(message);
    }

    public BaseException(int status, String message)
    {
        super(message);
        this.status = status;
    }

    public BaseException(Throwable cause)
    {
        super(cause);
    }

}
