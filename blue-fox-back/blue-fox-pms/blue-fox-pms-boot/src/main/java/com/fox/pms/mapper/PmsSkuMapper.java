package com.fox.pms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fox.pms.pojo.entity.PmsSku;
import com.fox.pms.pojo.dto.app.SkuDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PmsSkuMapper extends BaseMapper<PmsSku> {

    @Select("<script>" +
            "  select * from pms_sku where spu_id=#{spuId}" +
            "</script>")
    List<PmsSku> listBySpuId(Long spuId);



    SkuDTO getSkuById(Long id);
}
