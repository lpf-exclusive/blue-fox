package com.fox.pms.controller.app;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fox.common.result.Result;
import com.fox.pms.pojo.entity.PmsSpu;
import com.fox.pms.pojo.vo.app.GoodsDetailVO;
import com.fox.pms.pojo.vo.app.GoodsVO;
import com.fox.pms.serviceapp.IGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jodd.util.StringUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "移动端-商品信息")
@RestController(value = "appGoodsController")
@RequestMapping("/app-api/v1/goods")
@AllArgsConstructor
public class GoodsController {

    private IGoodsService goodsService;

    @ApiOperation(value = "商品分页列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", example = "1", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "limit", value = "每页数量", example = "10", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "name", value = "商品名称", example = "华为P50", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "categoryId", value = "商品类目", example = "1", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "orderBy", value = "排序字段", example = "price", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "isAsc", value = "是否升序", example = "false", paramType = "query", dataType = "Boolean")
    })
    @GetMapping
    public Result<List<GoodsVO>> list(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                      @RequestParam(name = "limit", defaultValue = "10") Integer limit,
                                      String name,
                                      Long categoryId,
                                      @RequestParam(name = "orderBy", defaultValue = "id") String orderBy,
                                      @RequestParam(name = "isAsc", defaultValue = "false") Boolean isAsc) {
        Page<PmsSpu> pageResult = goodsService.page(new Page<>(page, limit), new QueryWrapper<PmsSpu>()
                .eq(categoryId != null, "category_id", categoryId)
                .like(StrUtil.isNotBlank(name), "name", name)
                .select("id", "name", "pic_url", "price", "sales")
                .orderBy(StringUtil.isNotBlank(orderBy), isAsc, StrUtil.toUnderlineCase(orderBy))
        );

        List<GoodsVO> list = pageResult.getRecords().stream()
                .map(item -> {
                    GoodsVO goodsVO = new GoodsVO();
                    BeanUtil.copyProperties(item, goodsVO);
                    return goodsVO;
                }).collect(Collectors.toList());
        return Result.success(list, pageResult.getTotal());
    }

    @ApiOperation(value = "商品详情")
    @ApiImplicitParam(name = "id", value = "商品ID", required = true, paramType = "path", dataType = "Long")
    @GetMapping("/{id}")
    public Result<GoodsDetailVO> detail(@PathVariable Long id) {
        GoodsDetailVO goodsDetailVO = goodsService.getGoodsById(id);
        return Result.success(goodsDetailVO);
    }

    @ApiOperation(value = "商品详情")
    @ApiImplicitParam(name = "id", value = "商品SkuID", required = true, paramType = "path", dataType = "Long")
    @GetMapping("/sku/{skuId}")
    public Result<GoodsDetailVO> detailBySkuId(@PathVariable Long skuId) {
        GoodsDetailVO goodsDetailVO = goodsService.getGoodsBySkuId(skuId);
        return Result.success(goodsDetailVO);
    }
}
