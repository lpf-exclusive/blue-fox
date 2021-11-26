package com.fox.oms.pojo.vo;

import com.fox.common.base.BaseVO;
import lombok.Data;

/**
 * @desc 订单创建响应结果VO
 * @email huawei_code@163.com
 * @date 2021/1/21
 */
@Data
public class OrderSubmitVO extends BaseVO {
    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 订单编号，进入支付页面显示
     */
    private String orderSn;

}
