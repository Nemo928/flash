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

public class RestResponse<T> extends BaseResponse
{
    private T       data;

    private boolean rel;

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public boolean isRel()
    {
        return rel;
    }

    public void setRel(boolean rel)
    {
        this.rel = rel;
    }
    
    public RestResponse<T> rel(boolean rel) {
        this.setRel(rel);
        return this;
    }


    public RestResponse<T> data(T data) {
        this.setData(data);
        return this;
    }
}
