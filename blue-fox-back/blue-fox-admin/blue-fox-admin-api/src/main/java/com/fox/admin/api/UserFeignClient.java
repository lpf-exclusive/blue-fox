package com.fox.admin.api;

import com.fox.admin.api.fallback.UserFeignFallbackClient;
import com.fox.admin.pojo.dto.UserAuthDTO;
import com.fox.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "blue-fox-admin", fallback = UserFeignFallbackClient.class)
public interface UserFeignClient {

    @GetMapping("/api/v1/users/username/{username}")
    Result<UserAuthDTO> getUserByUsername(@PathVariable String username);
}
