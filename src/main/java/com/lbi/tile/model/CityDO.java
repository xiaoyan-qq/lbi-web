/**************************************
 * Copyright (C), Navinfo
 * Package: com.lbi.tile.model
 * Author: liumingkai05559
 * Date: Created in 2018/8/6 19:57
 **************************************/
package com.lbi.tile.model;

import lombok.Getter;
import lombok.Setter;

/*************************************
 * Class Name: CityDO
 * Description:〈城市对象〉
 * @author liumingkai
 * @create 2018/8/6
 * @since 1.0.0
 ************************************/
@Getter
@Setter
public class CityDO {
    String adcode;
    String name;
    double x;
    double y;
    double minX;
    double minY;
    double maxX;
    double maxY;
}
