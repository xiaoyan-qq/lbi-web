/**************************************
 * Package: com.lbi.tile
 * Author: deyi
 * Date: Created in 2018/3/27 20:58
 **************************************/
package com.lbi.tile;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/*************************************
 * Class Name: Application
 * Description:〈启动入口〉
 * @author deyi
 * @create 2018/3/27
 * @since 1.0.0
 ************************************/
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.lbi.tile"})
@ServletComponentScan
public class Application {
    public static void main(String[] args){
        SpringApplication application = new SpringApplication(Application.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
