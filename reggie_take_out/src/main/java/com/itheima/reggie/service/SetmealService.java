package com.itheima.reggie.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.dto.SetmealDto;
import com.itheima.reggie.entity.Setmeal;

import java.util.List;

/**
 * <p>
 * 套餐 服务类
 * </p>
 */
public interface SetmealService extends IService<Setmeal> {

    public void saveWithDish(SetmealDto setmealDto);
//
//    public SetmealDto getSetmealData(Long id);
//
    public void removeWithDish(List<Long> ids);
}
