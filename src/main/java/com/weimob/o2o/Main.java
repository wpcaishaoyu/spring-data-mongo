package com.weimob.o2o;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author <a href="mailto:yong.zhao@weimob.com">carl.zhao<a/>
 * @version 1.0.0
 * @see Main
 * @since 1.0.0 2016-12-08
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

}
