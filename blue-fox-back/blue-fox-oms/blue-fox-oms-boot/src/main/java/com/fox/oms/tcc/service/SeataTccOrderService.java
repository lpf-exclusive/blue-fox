package com.fox.oms.tcc.service;

import com.fox.oms.pojo.dto.OrderSubmitDTO;
import com.fox.oms.pojo.entity.OmsOrder;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

@LocalTCC
public interface SeataTccOrderService {

    @TwoPhaseBusinessAction(name = "prepareSubmitOrder", commitMethod = "commitSubmitOrder", rollbackMethod = "rollbackSubmitOrder")
    OmsOrder prepareSubmitOrder(BusinessActionContext businessActionContext,
                                @BusinessActionContextParameter(paramName = "orderSubmitDTO") OrderSubmitDTO orderSubmitDTO);

    boolean commitSubmitOrder(BusinessActionContext businessActionContext);

    boolean rollbackSubmitOrder(BusinessActionContext businessActionContext);
}
