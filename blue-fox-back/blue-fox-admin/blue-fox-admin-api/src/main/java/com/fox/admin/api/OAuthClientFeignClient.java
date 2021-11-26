package com.fox.admin.api;

import com.fox.admin.pojo.entity.SysOauthClient;
import com.fox.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author LiuPengFei
 * @email lpf.exclusive@yahoo.com       
 * @date 2021/11/26 11:10
 */
@FeignClient(value = "blue-fox-admin", contextId = "oauth-client")
public interface OAuthClientFeignClient {

    @GetMapping("/api/v1/oauth-clients/{clientId}")
    Result<SysOauthClient> getOAuthClientById(@PathVariable String clientId);
}
