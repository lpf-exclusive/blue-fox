package com.fox.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fox.sms.pojo.SmsAdvert;
import com.fox.sms.mapper.SmsAdvertMapper;
import com.fox.sms.service.ISmsAdvertService;
import org.springframework.stereotype.Service;

@Service
public class SmsAdvertServiceImpl extends ServiceImpl<SmsAdvertMapper, SmsAdvert> implements ISmsAdvertService {

}
