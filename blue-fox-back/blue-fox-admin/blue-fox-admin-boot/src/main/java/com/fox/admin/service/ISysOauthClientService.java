package com.fox.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fox.admin.pojo.entity.SysOauthClient;

public interface ISysOauthClientService extends IService<SysOauthClient> {

    void cleanCache();

}
