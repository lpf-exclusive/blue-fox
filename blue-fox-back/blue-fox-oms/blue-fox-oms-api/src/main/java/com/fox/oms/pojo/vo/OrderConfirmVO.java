package com.fox.oms.pojo.vo;

import com.fox.common.base.BaseVO;
import com.fox.oms.pojo.dto.OrderItemDTO;
import com.fox.ums.pojo.entity.UmsAddress;
import lombok.Data;

import java.util.List;


@Data
public class OrderConfirmVO extends BaseVO {

    private String orderToken;

    private List<OrderItemDTO> orderItems;

    private List<UmsAddress> addresses;

}
