package com.fox.oms.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @desc 订单提交实体类
 * @email huawei_code@163.com
 * @date 2021/1/16
 */
@Data
public class OrderConfirmDTO {

    private Long skuId;

    private Integer count;

}
