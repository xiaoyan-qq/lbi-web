/**************************************
 * Copyright (C), Navinfo
 * Package: com.lbi.tile.controller
 * Author: liumingkai05559
 * Date: Created in 2018/8/12 16:59
 **************************************/
package com.lbi.tile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*************************************
 * Class Name: PageController
 * Description:〈页面控制器〉
 * @author liumingkai
 * @create 2018/8/12
 * @since 1.0.0
 ************************************/
@Controller
public class PageController {
    /**
     * 首页
     */
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    /**
     * 登录页面
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 元数据
     */
    @RequestMapping("/meta")
    public String meta(){
        return "meta";
    }

    @RequestMapping("/meta/loc")
    public String loc(){
        return "meta/loc";
    }

    @RequestMapping("/meta/directory")
    public String directory(){
        return "meta/directory";
    }

    @RequestMapping("/meta/mapsets")
    public String mapsets(){
        return "meta/mapsets";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/admin/logs")
    public String logs(){
        return "admin/logs";
    }
}
