/**************************************
 * Package: com.lbi.tile
 * Author: deyi
 * Date: Created in 2018/3/27 20:58
 **************************************/
package com.lbi.tile;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*************************************
 * Class Name: Application
 * Description:〈启动入口〉
 * @author deyi
 * @create 2018/3/27
 * @since 1.0.0
 ************************************/
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication application = new SpringApplication(Application.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
