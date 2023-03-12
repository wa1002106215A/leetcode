package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.Orders;

/**
 * <p>
 * 订单表 服务类
 * </p>
 */
public interface OrdersService extends IService<Orders> {

    public void submit(Orders orders);
}
