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
package com.zj.springcloud.test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import com.zj.springcloud.common.utils.RsaKeyHelper;

public class RsaKeyTest
{
    @Test
    public void generateJWTKey() throws NoSuchAlgorithmException, IOException
    {
        new RsaKeyHelper().generateKey("src/main/resources/jwt/pub.key",
                "src/main/resources/jwt/pri.key", "123456");
    }
    
    @Test
    public void generateClientKey() throws NoSuchAlgorithmException, IOException
    {
        new RsaKeyHelper().generateKey("src/main/resources/client/pub.key",
                "src/main/resources/client/pri.key", "123456");
    }
}
