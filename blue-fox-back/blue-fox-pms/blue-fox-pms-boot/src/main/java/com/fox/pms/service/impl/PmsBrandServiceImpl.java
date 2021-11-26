package com.fox.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fox.pms.pojo.entity.PmsBrand;
import com.fox.pms.mapper.PmsBrandMapper;
import com.fox.pms.service.IPmsBrandService;
import org.springframework.stereotype.Service;

@Service
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandMapper, PmsBrand> implements IPmsBrandService {
}
