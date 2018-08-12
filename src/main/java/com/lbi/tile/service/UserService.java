/**************************************
 * Copyright (C), Navinfo
 * Package: com.pl.admin.service
 * Author: liumingkai05559
 * Date: Created in 2018/6/4 15:22
 **************************************/
package com.lbi.tile.service;

import com.lbi.tile.dao.UserDao;
import com.lbi.tile.model.SysUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*************************************
 * Class Name: UserService
 * Description:〈自定用用户服务〉
 * @author liumingkai
 * @create 2018/6/4
 * @since 1.0.0
 ************************************/
@Service("userService")
public class UserService implements UserDetailsService {
    @Resource(name="userDao")
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUser user = userDao.findByUsername(userName);
        if (user == null) {
            //throw new UsernameNotFoundException("用户名不存在");
        }
        //System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
        return user;
    }
}
