package com.itheima.reggie.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜品及套餐分类 前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    /**
     * 新增菜品分类
     * @param category 接收菜品分类对象
     * @return
     */
    @PostMapping
    public R<Category> save(@RequestBody Category category){
        log.info("新增菜品分类");
        categoryService.save(category);
        return R.success(category);
    }

    /**
     * 菜品列表功能
     * @param page 第几页
     * @param pageSize 每页查几条数据
     * @return
     */
    @GetMapping("/page")
    public R<Page> listCategory(int page,int pageSize){
        //分页构造器
        Page<Category> pageInfo = new Page(page, pageSize);
        //条件构造器
        LambdaQueryWrapper<Category> lambdaQueryWrapper = new LambdaQueryWrapper();
        //添加排序条件
        lambdaQueryWrapper.orderByDesc(Category::getSort);
        categoryService.page(pageInfo,lambdaQueryWrapper);
        return R.success(pageInfo);
    }


    /**
     * 删除菜品种类
     * @param ids 分类ID
     * @return
     */
    @DeleteMapping
    public R<String> delCategory(Long ids){
        categoryService.removeById(ids);
        categoryService.removeCategory(ids);
        return R.success("删除成功");
    }

    /**
     * 更新菜品分类
     *
     * @param category 传回来的菜品分类对象
     */
    @PutMapping()
    public R<String> updateCategory(@RequestBody Category category) {
        log.info("更新种类{}", category);
        categoryService.updateById(category);
        return R.success("菜品种类更新完成");
    }


    /**
     * 菜品新增页面菜品下拉列表
     * @param category 从前端接收一个type=1的标注，目的是在分类表中，菜品分类是1，套餐分类是2，把二者区分开
     * @return
     */
    @GetMapping("/list")
    public R<List> listShowCategory(Category category){
        //条件构造器
        LambdaQueryWrapper<Category> lambdaQueryWrapper = new LambdaQueryWrapper();
        //MP也支持把对象先判断一下，非空才能进行查询
        lambdaQueryWrapper.eq(category.getType() != null, Category::getType, category.getType());
        //lambdaQueryWrapper.eq(Category::getType, category.getType());
        //按时间倒叙排序
        lambdaQueryWrapper.orderByDesc(Category::getUpdateTime);
        //查询
        List<Category> categoryList = categoryService.list(lambdaQueryWrapper);
        return R.success(categoryList);
    }

}
