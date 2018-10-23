package com.yingzi.center.pi;

import com.taobao.pandora.boot.PandoraBootstrap;
import com.yingzi.lib.logging.Logger;
import com.yingzi.lib.logging.YZLogManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
@EnableAsync
@MapperScan(basePackages = {"com.yingzi.center.pi"})
public class HSFProviderApplication {
    @Autowired
    static ApplicationContext context;

    private static final Logger logger = YZLogManager.getLogger(HSFProviderApplication.class);
    public static void main(String[] args) {
        logger.info("-----ApplicationContext init !------");
        PandoraBootstrap.run(args);
        SpringApplication.run(HSFProviderApplication.class, args);
        PandoraBootstrap.markStartupAndWait();
    }
}
