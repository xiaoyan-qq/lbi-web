package com.lbi.tile.controller;

import com.lbi.model.ResultBody;
import com.lbi.tile.model.CityDO;
import com.lbi.tile.service.CityService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/city")
public class CityController {
    @Resource(name="cityService")
    private CityService cityService;

    @RequestMapping(value="/getcitylist.json",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultBody getCityList() {
        List<CityDO> list=cityService.getCityList();
        if(!list.isEmpty())return new ResultBody<>(list);
        else return new ResultBody(-1,"无数据");
    }

}
