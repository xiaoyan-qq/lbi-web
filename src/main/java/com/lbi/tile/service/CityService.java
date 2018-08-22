package com.lbi.tile.service;


import com.lbi.tile.dao.CityDao;
import com.lbi.tile.model.CityDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("cityService")
public class CityService {
    @Resource(name="cityDao")
    private CityDao cityDao;

    public List<CityDO> getCityList(){
        return cityDao.getCityList();
    }
}
