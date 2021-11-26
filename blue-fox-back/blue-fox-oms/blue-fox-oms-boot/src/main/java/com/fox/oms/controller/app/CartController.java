package com.fox.oms.controller.app;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.fox.common.result.Result;
import com.fox.common.web.util.JwtUtils;
import com.fox.oms.pojo.dto.CartItemDTO;
import com.fox.oms.service.ICartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @author huawei
 * @email huawei_code@163.com
 * @date 2020-12-30 22:31:10
 */

@Api(tags = "【移动端】购物车")
@RestController
@RequestMapping("/app-api/v1/carts")
@Slf4j
@AllArgsConstructor
public class CartController {

    private ICartService cartService;

    @ApiOperation(value = "查询购物车")
    @GetMapping
    @ApiOperationSupport(order = 1)
    public <T> Result<T> getCart() {
        try {
            Long memberId = JwtUtils.getUserId();
            List<CartItemDTO> result = cartService.listCartItemByMemberId(memberId);
            return Result.success((T) result);
        } catch (Exception e) {
            return Result.success((T) Collections.EMPTY_LIST);
        }
    }

    @ApiOperation(value = "删除购物车")
    @DeleteMapping
    @ApiOperationSupport(order = 2)
    public <T> Result<T> deleteCart() {
        boolean result = cartService.deleteCart();
        return Result.judge(result);
    }

    @ApiOperation(value = "添加购物车商品")
    @ApiImplicitParam(name = "skuId", value = "SKU ID", required = true, paramType = "param", dataType = "Long")
    @PostMapping
    @ApiOperationSupport(order = 3)
    public <T> Result<T> addCartItem(@RequestParam Long skuId) {
        cartService.addCartItem(skuId);
        return Result.success();
    }

    @ApiOperation(value = "更新购物车商品")
    @PutMapping("/skuId/{skuId}")
    @ApiOperationSupport(order = 4)
    public <T> Result<T> updateCartItem(@PathVariable Long skuId, @RequestBody CartItemDTO cartItem) {
        cartItem.setSkuId(skuId);
        boolean result = cartService.updateCartItem(cartItem);
        return Result.judge(result);
    }

    @ApiOperation(value = "删除购物车商品")
    @ApiImplicitParam(name = "skuId", value = "SKU ID", required = true, paramType = "param", dataType = "Long")
    @DeleteMapping("/skuId/{skuId}")
    @ApiOperationSupport(order = 5)
    public <T> Result<T> removeCartItem(@PathVariable Long skuId) {
        boolean result = cartService.removeCartItem(skuId);
        return Result.judge(result);
    }

    @ApiOperation(value = "全选/全不选购物车商品")
    @ApiImplicitParam(name = "checked", value = "全选/全不选", required = true, paramType = "param", dataType = "Boolean")
    @PatchMapping("/_check")
    @ApiOperationSupport(order = 6)
    public <T> Result<T> check(boolean checked) {
        boolean result = cartService.checkAll(checked);
        return Result.judge(result);
    }
}
