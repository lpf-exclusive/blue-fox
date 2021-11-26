package com.fox.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fox.pms.pojo.entity.PmsCategory;
import com.fox.pms.pojo.vo.CascadeVO;
import com.fox.pms.pojo.vo.CategoryVO;

import java.util.List;


/**
 * 商品分类
 *
 * @author <a href="mailto:xianrui0365@163.com">xianrui</a>
 */
public interface IPmsCategoryService extends IService<PmsCategory> {


    /**
     * 分类列表（树形）
     *
     * @param parentId
     * @return
     */
    List<CategoryVO> listCategory(Long parentId);

    /**
     * 分类列表（级联）
     * @return
     */
    List<CascadeVO> listCascadeCategory();


    /**
     *
     * 保存（新增/修改）分类
     *
     *
     * @param category
     * @return
     */
    Long saveCategory(PmsCategory category);

}
