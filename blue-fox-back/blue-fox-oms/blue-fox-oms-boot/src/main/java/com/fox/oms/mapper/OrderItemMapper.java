package com.fox.oms.mapper;

import com.fox.oms.pojo.entity.OmsOrderItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 订单商品信息表
 *
 * @author huawei
 * @email huawei_code@163.com
 * @date 2020-12-30 22:31:10
 */
@Mapper
public interface OrderItemMapper extends BaseMapper<OmsOrderItem> {

    @Select("<script>" +
            "  select id,order_id,sku_id,sku_name,sku_pic,sku_price,sku_quantity,sku_total_price,spu_name from oms_order_item where order_id=#{orderId}" +
            "</script>")
    List<OmsOrderItem> listByOrderId(Long orderId);

}
