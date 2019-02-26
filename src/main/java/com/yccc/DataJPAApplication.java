package com.yccc;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DataJPAApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(DataJPAApplication.class);
        builder.bannerMode(Banner.Mode.OFF).run(args);
//        SpringApplication.run(DataJPAApplication.class,args);
    }
}
