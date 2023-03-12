package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.Category;

/**
 * <p>
 * 菜品及套餐分类 服务类
 * </p>
 */
public interface CategoryService extends IService<Category> {


     void removeCategory(Long id);
}
