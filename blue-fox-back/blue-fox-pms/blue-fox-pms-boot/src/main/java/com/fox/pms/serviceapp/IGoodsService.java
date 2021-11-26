package com.fox.pms.serviceapp;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fox.pms.pojo.entity.PmsSpu;
import com.fox.pms.pojo.vo.app.GoodsDetailVO;

/**
 * @author <a href="mailto:xianrui0365@163.com">xianrui</a>
 * @date 2021/8/8
 */
public interface IGoodsService extends IService<PmsSpu> {
    GoodsDetailVO getGoodsById(Long id);

    GoodsDetailVO getGoodsBySkuId(Long skuId);
}
