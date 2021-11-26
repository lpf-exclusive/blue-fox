package com.fox.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fox.oms.mapper.OrderItemMapper;
import com.fox.oms.pojo.entity.OmsOrderItem;
import com.fox.oms.service.IOrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OmsOrderItem> implements IOrderItemService {


}
