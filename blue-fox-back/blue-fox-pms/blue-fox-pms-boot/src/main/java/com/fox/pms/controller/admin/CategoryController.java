package com.fox.pms.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.fox.common.result.Result;
import com.fox.pms.pojo.entity.PmsAttribute;
import com.fox.pms.pojo.entity.PmsCategory;
import com.fox.pms.pojo.vo.CategoryVO;
import com.fox.pms.service.IPmsAttributeService;
import com.fox.pms.service.IPmsCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author <a href="mailto:xianrui0365@163.com">xianrui</a>
 */
@Api(tags = "系统管理端-分类信息")
@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
public class CategoryController {

    private IPmsCategoryService iPmsCategoryService;
    private IPmsAttributeService iPmsAttributeService;


    @ApiOperation(value = "分类列表")
    @GetMapping
    public Result<List<CategoryVO>> list() {
        List<CategoryVO> list = iPmsCategoryService.listCategory(null);
        return Result.success(list);
    }


    @ApiOperation(value = "分类级联列表")
    @GetMapping("/cascade")
    public Result cascadeCategoryList() {
        List list = iPmsCategoryService.listCascadeCategory();
        return Result.success(list);
    }


    @ApiOperation(value = "分类详情")
    @ApiImplicitParam(name = "id", value = "商品分类id", required = true, paramType = "path", dataType = "Long")
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        PmsCategory category = iPmsCategoryService.getById(id);
        return Result.success(category);
    }

    @ApiOperation(value = "新增分类")
    @PostMapping
    public Result add(@RequestBody PmsCategory category) {
        Long id = iPmsCategoryService.saveCategory(category);
        return Result.success(id);
    }

    @ApiOperation(value = "修改分类")
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable Long id, @RequestBody PmsCategory category) {
        category.setId(id);
        id = iPmsCategoryService.saveCategory(category);
        return Result.success(id);
    }

    @ApiOperation(value = "删除分类")
    @ApiImplicitParam(name = "ids", value = "id集合,以英文逗号','分隔", required = true, paramType = "query", dataType = "String")
    @DeleteMapping("/{ids}")
    @CacheEvict(value = "pms",key = "'categoryList'")
    public Result delete(@PathVariable String ids) {
        List<String> categoryIds = Arrays.asList(ids.split(","));
        Optional.ofNullable(categoryIds).ifPresent(categoryIdList -> {
            categoryIdList.forEach(categoryId -> iPmsAttributeService.remove(new LambdaQueryWrapper<PmsAttribute>().eq(PmsAttribute::getCategoryId, categoryId)));
        });
        boolean result = iPmsCategoryService.removeByIds(categoryIds);
        return Result.judge(result);
    }

    @ApiOperation(value = "选择性修改分类")
    @PatchMapping(value = "/{id}")
    @CacheEvict(value = "pms",key = "'categoryList'")
    public Result patch(@PathVariable Long id, @RequestBody PmsCategory category) {
        LambdaUpdateWrapper<PmsCategory> updateWrapper = new LambdaUpdateWrapper<PmsCategory>().eq(PmsCategory::getId, id);
        updateWrapper.set(category.getVisible() != null, PmsCategory::getVisible, category.getVisible());
        boolean result = iPmsCategoryService.update(updateWrapper);
        return Result.judge(result);
    }
}
