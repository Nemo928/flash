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

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zj.springcloud.common.constants.CommonConstants;

public class BaseContextHandler
{
    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    public static void set(String key, Object value)
    {
        Map<String, Object> map = threadLocal.get();
        if (map == null)
        {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key)
    {
        Map<String, Object> map = threadLocal.get();
        if (map == null)
        {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        return map.get(key);
    }

    public static Long getUserId()
    {
        Object value = get(CommonConstants.CONTEXT_KEY_USER_ID);
        return Optional.ofNullable(Long.valueOf(value.toString()))
                .orElse(-1L);
    }

    public static String getLoginName()
    {
        Object value = get(CommonConstants.CONTEXT_KEY_LOGIN_NAME);
        return Optional.ofNullable(value.toString()).orElse("");
    }

    public static String getUserName()
    {
        Object value = get(CommonConstants.CONTEXT_KEY_USER_NAME);
        return Optional.ofNullable(value.toString()).orElse("");
    }

    public static String getToken()
    {
        Object value = get(CommonConstants.CONTEXT_KEY_USER_TOKEN);
        return Optional.ofNullable(value.toString()).orElse("");
    }

    public static void setToken(String token)
    {
        set(CommonConstants.CONTEXT_KEY_USER_TOKEN, token);
    }

    public static void setUserId(Long userId)
    {
        set(CommonConstants.CONTEXT_KEY_USER_ID, userId);
    }

    public static void setLoginName(String loginName)
    {
        set(CommonConstants.CONTEXT_KEY_LOGIN_NAME, loginName);
    }

    public static void setUserName(String userName)
    {
        set(CommonConstants.CONTEXT_KEY_USER_NAME, userName);
    }

    public static void remove()
    {
        threadLocal.remove();
    }

    @RunWith(MockitoJUnitRunner.class)
    public static class UnitTest
    {
        private Logger logger = LoggerFactory.getLogger(UnitTest.class);

        @Test
        public void testSetContextVariable() throws InterruptedException
        {
            BaseContextHandler.set("test", "main");
            new Thread(() -> {
                BaseContextHandler.set("test", "moo");

                try
                {
                    TimeUnit.SECONDS.sleep(3);
                }
                catch (InterruptedException e)
                {
                    logger.error(e.getLocalizedMessage(), e);
                }
                assertEquals(BaseContextHandler.get("test"), "moo");
                logger.info("thread one done!");
            }).start();
            new Thread(() -> {
                BaseContextHandler.set("test", "moo2");
                assertEquals(BaseContextHandler.get("test"), "moo2");
                logger.info("thread two done!");
            }).start();

            TimeUnit.SECONDS.sleep(5);
            assertEquals(BaseContextHandler.get("test"), "main");
            logger.info("main one done!");
        }

        @Test
        public void testSetUserInfo()
        {
            BaseContextHandler.setUserName("test");
            assertEquals(BaseContextHandler.getUserName(), "test");
        }
    }
}
