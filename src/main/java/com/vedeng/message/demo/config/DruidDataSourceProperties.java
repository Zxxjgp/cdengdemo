package com.vedeng.message.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.datasource.druid")
@Data
public class DruidDataSourceProperties {

    private String driverClassName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/DEV_MESSAGE?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
    private String username = "root";
    private String password = "123456";

    private int initialSize =1;
    private int minIdle =1;
    private int maxActive = 100;
    private long maxWait =60000;
    private long timeBetweenEvictionRunsMillis =60000;
    private long minEvictableIdleTimeMillis =30000;
    private String validationQuery ="select 'x'";
    private boolean testWhileIdle =true;
    private boolean testOnBorrow =false;
    private boolean testOnReturn =false;
    private boolean poolPreparedStatements =true;
    private int maxPoolPreparedStatementPerConnectionSize = 50;
    private String filters ="20";
}
