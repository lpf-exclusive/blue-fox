package com.fox.oms.api;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @description TODO
 * @createTime 2021/3/13 11:59
 */
@FeignClient("blue-fox-oms")
public interface OrderFeignClient {
}
