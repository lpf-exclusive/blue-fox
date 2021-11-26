package com.fox.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;;
import com.fox.oms.mapper.OrderDeliveryMapper;
import com.fox.oms.pojo.entity.OmsOrderDelivery;
import com.fox.oms.service.IOrderDeliveryService;
import org.springframework.stereotype.Service;

@Service("orderDeliveryService")
public class OrderDeliveryServiceImpl extends ServiceImpl<OrderDeliveryMapper, OmsOrderDelivery> implements IOrderDeliveryService {

}
