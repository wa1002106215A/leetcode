package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单明细表 Mapper 接口
 * </p>
 *
 */
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

}