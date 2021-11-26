package com.fox.pms.api;

import com.fox.common.result.Result;
import com.fox.pms.pojo.dto.app.SkuDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "blue-fox-pms",contextId = "goods")
public interface GoodsFeignClient {

    /**
     * 获取商品信息
     */
    @GetMapping("/app-api/v1/stocks/{id}")
    Result<SkuDTO> getSkuById(@PathVariable Long id);
}
