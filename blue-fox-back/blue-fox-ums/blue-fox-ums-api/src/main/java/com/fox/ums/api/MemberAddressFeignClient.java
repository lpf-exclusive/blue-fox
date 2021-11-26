package com.fox.ums.api;

import com.fox.common.result.Result;
import com.fox.ums.pojo.entity.UmsAddress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "blue-fox-ums",contextId = "address")
public interface MemberAddressFeignClient {

    /**
     * 获取地址详情
     */
    @GetMapping("/app-api/v1/addresses/{id}")
    Result<UmsAddress> getById(@PathVariable("id") Long id);


    @GetMapping("/app-api/v1/addresses")
    Result<List<UmsAddress>> list(@RequestParam Long memberId);

}


