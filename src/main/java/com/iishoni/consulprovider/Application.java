package com.iishoni.consulprovider;

import com.spring4all.swagger.EnableSwagger2Doc;

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
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        Properties props = System.getProperties();
        for (Object o : props.keySet()) {
            String key = (String) o;
            System.out.println(key + " = " + props.get(key));
        }
    }

}
