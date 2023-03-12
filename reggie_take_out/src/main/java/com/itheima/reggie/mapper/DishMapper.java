package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 菜品管理 Mapper 接口
 * </p>
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {

}
