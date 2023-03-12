package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Setmeal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 套餐 Mapper 接口
 * </p>
 */
@Mapper
public interface SetmealMapper extends BaseMapper<Setmeal> {

//    List<SetmealDish> listSetmeal(int page, int pageSize, String name);
//
//    SetmealDto getSetmealData(Long id);
}
