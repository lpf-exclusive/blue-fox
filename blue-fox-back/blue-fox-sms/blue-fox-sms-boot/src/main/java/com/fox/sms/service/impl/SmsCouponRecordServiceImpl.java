package com.fox.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fox.sms.mapper.SmsCouponRecordMapper;
import com.fox.sms.pojo.domain.SmsCouponRecord;
import com.fox.sms.service.ISmsCouponRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author huawei
 * @desc 优惠券领取记录业务实现类
 * @email huawei_code@163.com
 * @date 2021/3/14
 */
@Slf4j
@Service
public class SmsCouponRecordServiceImpl extends ServiceImpl<SmsCouponRecordMapper, SmsCouponRecord> implements ISmsCouponRecordService {
}
