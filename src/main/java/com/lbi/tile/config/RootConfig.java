/**************************************
 * Copyright (C), Navinfo
 * Package: com.navinfo.datalaker.ADASMapService.config
 * Author: liumingkai05559
 * Date: Created in 2018/3/24 10:41
 **************************************/
package com.lbi.tile.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

/*************************************
 * Class Name: RootConfig
 * Description:〈启动配置〉
 * @author deyi
 * @create 2018/8/8
 * @since 1.0.0
 ************************************/
@Configuration
public class RootConfig {
    @Autowired
    Environment env;

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        try{
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
            dataSource.setUrl(env.getProperty("spring.datasource.url"));
            dataSource.setUsername(env.getProperty("spring.datasource.username"));
            dataSource.setPassword(env.getProperty("spring.datasource.password"));
            dataSource.setMinIdle(10);
            dataSource.setMaxIdle(100);
            dataSource.setInitialSize(10);
            dataSource.setMaxActive(100);
            jdbcTemplate.setDataSource(dataSource);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jdbcTemplate;
    }
}
