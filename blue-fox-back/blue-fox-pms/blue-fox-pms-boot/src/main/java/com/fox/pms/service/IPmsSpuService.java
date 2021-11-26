package com.fox.pms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fox.pms.pojo.dto.admin.GoodsFormDTO;
import com.fox.pms.pojo.entity.PmsSpu;
import com.fox.pms.pojo.vo.admin.GoodsDetailVO;

import java.util.List;


public interface IPmsSpuService extends IService<PmsSpu> {

    IPage<PmsSpu> list(Page<PmsSpu> page,  String name,Long categoryId);

    boolean addGoods(GoodsFormDTO goodsFormDTO);

    boolean removeByGoodsIds(List<Long> spuIds);

    boolean updateGoods(GoodsFormDTO goodsFormDTO);

    GoodsDetailVO getGoodsById(Long id);
}
