package com.fox.oms.pojo.dto;

import com.fox.oms.pojo.entity.OmsOrder;
import com.fox.oms.pojo.entity.OmsOrderItem;
import com.fox.ums.pojo.dto.MemberDTO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @desc
 * @email huawei_code@163.com
 * @date 2021/1/19
 */
@Data
@Accessors(chain = true)
public class OrderDTO {

    private OmsOrder order;

    private List<OmsOrderItem> orderItems;

    private MemberDTO member;

}
