//-------------------------------------------------------------------------
// Copyright (c) 2000-2016 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: zhaojin
//
//-------------------------------------------------------------------------
// APACHE
//-------------------------------------------------------------------------
package com.zj.springcloud.config;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.zj.springcloud.dao")
public class MybatisPlusConfig
{
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.druidLoginName}")
    private String druidLoginName;

    @Value("${spring.datasource.druidPassword}")
    private String druidPassword;

    @Bean(name="dataSource",destroyMethod = "close", initMethod="init")
    @Primary
    public DataSource getDataSource()
    {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor()
    {
        return new PaginationInterceptor();
    }
    @Bean
    public SqlPrintInterceptor sqlPrintInterceptor(){
        return new SqlPrintInterceptor();
    }
    @Bean
    public ServletRegistrationBean druidServlet()
    {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*"); // url 匹配
        reg.addInitParameter("allow", "127.0.0.1"); // IP白名单
                                                    // (没有配置或者为空，则允许所有访问)
        reg.addInitParameter("deny", "192.168.1.1"); // IP黑名单
                                                        // (存在共同时，deny优先于allow)
        reg.addInitParameter("loginUsername", this.druidLoginName);// 登录名
        reg.addInitParameter("loginPassword", this.druidPassword);// 登录密码
        reg.addInitParameter("resetEnable", "false"); // 禁用HTML页面上的“Reset All”功能
        return reg;
    }

    @Bean(name = "druidWebStatFilter")
    public FilterRegistrationBean filterRegistrationBean()
    {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions",
                "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*"); // 忽略资源
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        filterRegistrationBean.addInitParameter("principalCookieName",
                "USER_COOKIE");
        filterRegistrationBean.addInitParameter("principalSessionName",
                "USER_SESSION");
        return filterRegistrationBean;
    }
}
