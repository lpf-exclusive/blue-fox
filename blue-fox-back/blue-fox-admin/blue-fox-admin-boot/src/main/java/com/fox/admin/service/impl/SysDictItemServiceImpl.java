package com.fox.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fox.admin.mapper.SysDictItemMapper;
import com.fox.admin.pojo.entity.SysDictItem;
import com.fox.admin.service.ISysDictItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDictItemServiceImpl extends ServiceImpl<SysDictItemMapper, SysDictItem> implements ISysDictItemService {

    @Override
    public IPage<SysDictItem> list(Page<SysDictItem> page, SysDictItem dict) {
        List<SysDictItem> list = this.baseMapper.list(page, dict);
        page.setRecords(list);
        return page;
    }

}
