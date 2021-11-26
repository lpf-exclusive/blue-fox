package com.fox.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fox.admin.pojo.entity.SysMenu;
import com.fox.admin.pojo.vo.MenuVO;
import com.fox.admin.pojo.vo.RouteVO;
import com.fox.admin.pojo.vo.SelectVO;
import com.fox.admin.pojo.vo.TreeSelectVO;

import java.util.List;

/**
 * @date 2020-11-06
 */
public interface ISysMenuService extends IService<SysMenu> {

    /**
     * 菜单表格（Table）层级列表
     *
     * @param name 菜单名称
     * @return
     */
    List<MenuVO> listTable(String name);

    /**
     * 菜单下拉（Select）层级列表
     *
     * @return
     */
    List<SelectVO> listSelect();

    /**
     * 菜单路由（Route）层级列表
     *
     * @return
     */
    List<RouteVO> listRoute();

    /**
     * 菜单下拉(TreeSelect)层级列表
     *
     * @return
     */
    List<TreeSelectVO> listTreeSelect();

    /**
     * 新增菜单
     *
     * @param menu
     * @return
     */
    boolean saveMenu(SysMenu menu);

    /**
     * 修改菜单
     *
     * @param menu
     * @return
     */
    boolean updateMenu(SysMenu menu);

    /**
     * 清理路由缓存
     */
    void cleanCache();
}
