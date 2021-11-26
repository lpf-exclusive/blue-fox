package com.fox.ums.controller.admin;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fox.common.result.Result;
import com.fox.ums.pojo.entity.UmsMember;
import com.fox.ums.service.IUmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static com.fox.common.constant.GlobalConstants.STATUS_YES;

@Api(tags = "系统管理端-会员管理")
@RestController("AdminMemberController")
@RequestMapping("/api/v1/users")
@Slf4j
@AllArgsConstructor
public class MemberController {

    private IUmsMemberService iUmsMemberService;

    @ApiOperation(value = "列表分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "limit", value = "每页数量", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "nickName", value = "会员昵称", paramType = "query", dataType = "String")
    })
    @GetMapping
    public Result<List<UmsMember>> list(
            Integer page,
            Integer limit,
            String nickName
    ) {
        LambdaQueryWrapper<UmsMember> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ne(UmsMember::getDeleted, STATUS_YES);
        queryWrapper.like(StrUtil.isNotBlank(nickName), UmsMember::getNickName, nickName);
        IPage<UmsMember> result = iUmsMemberService.list(new Page<>(page, limit),nickName);
        return Result.success(result.getRecords(), result.getTotal());

    }

    @ApiOperation(value = "会员详情")
    @ApiImplicitParam(name = "id", value = "会员ID", required = true, paramType = "path", dataType = "Long")
    @GetMapping("/{id}")
    public Result<UmsMember> getMemberById(
            @PathVariable Long id
    ) {
        UmsMember user = iUmsMemberService.getById(id);
        return Result.success(user);
    }

    @ApiOperation(value = "修改会员")
    @ApiImplicitParam(name = "id", value = "资源id", required = true, paramType = "path", dataType = "Long")
    @PutMapping(value = "/{id}")
    public <T> Result<T> update(
            @PathVariable Long id,
            @RequestBody UmsMember member) {
        boolean status = iUmsMemberService.updateById(member);
        return Result.judge(status);
    }

    @ApiOperation(value = "选择性更新")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "path", dataType = "Long")
    @PatchMapping("/{id}")
    public <T> Result<T> patch(@PathVariable Long id, @RequestBody UmsMember user) {
        LambdaUpdateWrapper<UmsMember> updateWrapper = new LambdaUpdateWrapper<UmsMember>().eq(UmsMember::getId, id);
        updateWrapper.set(user.getStatus() != null, UmsMember::getStatus, user.getStatus());
        boolean status = iUmsMemberService.update(updateWrapper);
        return Result.judge(status);
    }

    @ApiOperation(value = "删除会员")
    @ApiImplicitParam(name = "ids", value = "id集合", required = true, paramType = "query", dataType = "String")
    @DeleteMapping("/{ids}")
    public <T> Result<T> delete(@PathVariable String ids) {
        boolean status = iUmsMemberService.update(new LambdaUpdateWrapper<UmsMember>()
                .in(UmsMember::getId, Arrays.asList(ids.split(",")))
                .set(UmsMember::getDeleted, STATUS_YES));
        return Result.judge(status);
    }
}
