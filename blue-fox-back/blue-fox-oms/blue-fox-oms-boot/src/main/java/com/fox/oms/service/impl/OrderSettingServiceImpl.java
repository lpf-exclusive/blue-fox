package com.fox.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fox.oms.mapper.OrderSettingMapper;
import com.fox.oms.pojo.entity.OmsOrderSetting;
import com.fox.oms.service.IOrderSettingService;
import org.springframework.stereotype.Service;


@Service
public class OrderSettingServiceImpl extends ServiceImpl<OrderSettingMapper, OmsOrderSetting> implements IOrderSettingService {

}
