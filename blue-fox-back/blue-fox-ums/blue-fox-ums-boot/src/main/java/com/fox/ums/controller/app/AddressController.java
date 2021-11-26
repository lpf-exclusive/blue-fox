package com.fox.ums.controller.app;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.fox.common.result.Result;
import com.fox.common.web.util.JwtUtils;
import com.fox.ums.pojo.entity.UmsAddress;
import com.fox.ums.service.IUmsAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Api(tags = "【移动端】会员地址")
@RestController
@RequestMapping("/app-api/v1/addresses")
@Slf4j
@AllArgsConstructor
public class AddressController {

    private IUmsAddressService iUmsAddressService;

    private final Integer ADDRESS_DEFAULTED = 1;

    @ApiOperation(value = "获取登录会员的地址列表")
    @GetMapping
    public Result<List<UmsAddress>> list() {
        Long memberId = JwtUtils.getUserId();
        List<UmsAddress> addressList = iUmsAddressService.list(new LambdaQueryWrapper<UmsAddress>()
                .eq(UmsAddress::getMemberId, memberId)
                .orderByDesc(UmsAddress::getDefaulted));
        return Result.success(addressList);
    }

    @ApiOperation(value = "新增地址")
    @PostMapping
    public <T> Result<T> add(@RequestBody @Validated UmsAddress address) {
        Long memberId = JwtUtils.getUserId();
        address.setMemberId(memberId);
        if (ADDRESS_DEFAULTED.equals(address.getDefaulted())) { // 修改其他默认地址为非默认
            iUmsAddressService.update(new LambdaUpdateWrapper<UmsAddress>()
                    .eq(UmsAddress::getMemberId, memberId)
                    .eq(UmsAddress::getDefaulted, ADDRESS_DEFAULTED)
                    .set(UmsAddress::getDefaulted, 0)
            );
        }
        boolean status = iUmsAddressService.save(address);
        return Result.judge(status);
    }


    @ApiOperation(value = "修改地址")
    @PutMapping("/{id}")
    public <T> Result<T> update(@PathVariable Long id, @RequestBody @Validated UmsAddress address) {
        Long memberId = JwtUtils.getUserId();
        // 修改其他默认地址为非默认
        if (ADDRESS_DEFAULTED.equals(address.getDefaulted())) {
            iUmsAddressService.update(new LambdaUpdateWrapper<UmsAddress>()
                    .eq(UmsAddress::getMemberId, memberId)
                    .eq(UmsAddress::getDefaulted, 1)
                    .set(UmsAddress::getDefaulted, 0)
            );
        }
        boolean status = iUmsAddressService.updateById(address);
        return Result.judge(status);
    }

    @ApiOperation(value = "删除地址")
    @ApiImplicitParam(name = "ids", value = "id集合字符串，英文逗号分隔", required = true, paramType = "query", dataType = "String")
    @DeleteMapping("/{ids}")
    public <T> Result<T> delete(@PathVariable String ids) {
        boolean status = iUmsAddressService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.judge(status);
    }

    @ApiOperation(value = "根据id查询收货地址详情")
    @ApiImplicitParam(name = "id", value = "地址 id", required = true, paramType = "path", dataType = "String")
    @GetMapping("/{id}")
    public Result<UmsAddress> getAddressById(@PathVariable("id") String id) {
        return Result.success(iUmsAddressService.getById(id));
    }
}
