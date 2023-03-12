package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.dto.DishDto;
import com.itheima.reggie.entity.Dish;

/**
 * <p>
 * 菜品管理 服务类
 * </p>
 *
 */
public interface DishService extends IService<Dish> {
    public DishDto getByIdWithFlavor(Long id);

    public void addDishWithFlavor(DishDto dishDto);

    public void updateDishWithFlavor(DishDto dishDto);

}
