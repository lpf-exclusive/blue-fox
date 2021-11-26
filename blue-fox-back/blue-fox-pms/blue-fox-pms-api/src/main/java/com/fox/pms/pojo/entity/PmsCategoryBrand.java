package com.fox.pms.pojo.entity;

import com.fox.common.base.BaseEntity;
import lombok.Data;

@Data
public class PmsCategoryBrand extends BaseEntity {

    private Long categoryId;

    private Long brandId;

}
