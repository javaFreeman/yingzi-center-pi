package com.yingzi.center.pi.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.yingzi.lib.config.Config;
import com.yingzi.lib.config.Configurator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @program: yingzi-app-pi
 * @description: DataSource的配置读取
 * @author: BaoGuoQiang
 * @create: 2018-10-18 10:00
 **/
// DataSourceConfig
@Configuration
public class DataSourceConfig {
    private static final String dbDataId = "com.yingzi.center.pi.datasource";

    @Bean(name="dataSource")
    public DataSource druidDataSource()throws IOException {
        Configurator configurator = Configurator.getConfigurator();
        Config config = configurator.readYaml(dbDataId);
        config = config.getChild("yz").getChild("pi").getChild("datasource");

        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(config.getString("url"));
        datasource.setUsername(config.getString("username"));
        datasource.setPassword(config.getString("password"));
        datasource.setDriverClassName(config.getString("driver-class-name"));

        if (config.getInteger("minIdle") != null) {
            datasource.setMinIdle(config.getInteger("minIdle"));
        }
        if (config.getInteger("maxActive") != null) {
            datasource.setMaxActive(config.getInteger("maxActive"));
        }
        if (config.getInteger("initialSize") != null) {
            datasource.setInitialSize(config.getInteger("initialSize"));
        }
        if (config.getInteger("timeBetweenEvictionRunsMillis") != null) {
            datasource.setTimeBetweenEvictionRunsMillis(config.getInteger("timeBetweenEvictionRunsMillis"));
        }
        if (config.getInteger("minEvictableIdleTimeMillis") != null) {
            datasource.setMinEvictableIdleTimeMillis(config.getInteger("minEvictableIdleTimeMillis"));
        }

        try {
            datasource.setFilters("stat");
        } catch (SQLException e) {
            System.out.println("druid configuration initialization filter");
        }
        return datasource;
    }
}
