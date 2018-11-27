package com.vedeng.message.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
@Data
public class DruidDataSourceProperties {

    private String driverClassName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/DEV_MESSAGE?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
    private String username = "root";
    private String password = "OUNfwrCe2MsBi5sYPwsi4ammhSbX0aZQ2X0x/oVMg+oFscD2PhMTFiukAQPc2/bKVGs+9QbzYCOu/zs+qgbImA==";
    private String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJr1efUxLEF4TgPFQdSLvlw2Wjx+J5wS93znZSJHc/KEyLcBQrIfhTE+KzUz/E3ScXcj6P2jZRr1IDVBLZOf710CAwEAAQ==";

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
    private String filters ="config,stat,wall,log4j";
    private String connectionProperties ="config.decrypt=true;config.decrypt.key=MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJr1efUxLEF4TgPFQdSLvlw2Wjx+J5wS93znZSJHc/KEyLcBQrIfhTE+KzUz/E3ScXcj6P2jZRr1IDVBLZOf710CAwEAAQ==;config.file=application.yml";
}
