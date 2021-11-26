package com.fox.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fox.pms.pojo.dto.admin.AttributeFormDTO;
import com.fox.pms.pojo.entity.PmsAttribute;

public interface IPmsAttributeService extends IService<PmsAttribute> {

    boolean saveBatch(AttributeFormDTO attributeForm);
}
