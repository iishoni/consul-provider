package com.iishoni.consulprovider;

import com.spring4all.swagger.EnableSwagger2Doc;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;

import java.util.Iterator;
import java.util.Properties;

@SpringCloudApplication
@EnableHystrix
@EnableFeignClients
@EnableSwagger2Doc
@MapperScan("com.iishoni.consulprovider.mapper")
@ImportResource("classpath*:spring-context.xml")
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        Properties props = System.getProperties();
        for (Object o : props.keySet()) {
            String key = (String) o;
            if ("user.timezone".equals(key)) {
                log.info("===============================================================================" + key + " : " + props.get(key));
            }
        }
    }

}
