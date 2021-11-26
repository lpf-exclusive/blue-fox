package com.fox.sms.pojo.vo;

import com.fox.sms.pojo.enums.CouponCategoryEnum;
import com.fox.sms.pojo.enums.CouponOfferStateEnum;
import com.fox.sms.pojo.enums.CouponUsedStateEnum;
import com.fox.sms.pojo.enums.CouponVerifyStateEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinyi
 * @desc: 优惠券模板实体类：基础属性 + 规则属性
 * @date 2021/6/26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmsCouponTemplateInfoVO {

    /**
     * 主键自增ID
     */
    private Long id;

    /**
     * 优惠券名称
     */
    private String name;

    /**
     * 优惠券logo
     */
    private String logo;

    /**
     * 优惠券描述
     */
    private String description;

    /**
     * 优惠券分类
     */
    private CouponCategoryEnum category;

    private String categoryCode;

    private CouponVerifyStateEnum verifyState;

    /**
     * 优惠券审核状态
     * 0: 待审核
     * 1: 已审核
     */
    private Integer verifyStateCode;

    private CouponOfferStateEnum offerState;

    /**
     * 优惠券发放状态
     * (已审核且在允许发放时间之内，才允许发放)
     * 0: 未开始
     * 1: 进行中
     * 2: 已结束
     */
    private Integer offerStateCode;

    /**
     * 优惠券发放最早时间
     */
    private Long offerStartTime;

    /**
     * 优惠券发放最晚时间
     */
    private Long offerEndTime;

    private List<Long> offerTime;

    private CouponUsedStateEnum usedState;

    /**
     * 优惠券使用状态
     * 0：未生效：（未审核，未到最早使用时间）
     * 1：生效中（已审核，正在使用时间中）
     * 2：已结束（超过最晚使用时间）
     */
    private Integer usedStateCode;

    /**
     * 优惠券最早使用时间
     */
    private Long usedStartTime;

    /**
     * 优惠券最晚使用时间
     */
    private Long usedEndTime;

    private List<Long> usedTime;

    /**
     * 总数
     */
    private Integer total;

    /**
     * 优惠券模板编码
     */
    private String code;

    /**
     * 优惠券规则
     */
    private CouponTemplateRuleInfoVO rule;

    public List<Long> getOfferTime() {
        List<Long> offerTime = new ArrayList<>(2);
        offerTime.add(this.offerStartTime);
        offerTime.add(this.offerEndTime);
        return offerTime;
    }

    public List<Long> getUsedTime() {
        List<Long> usedTime = new ArrayList<>(2);
        usedTime.add(this.usedStartTime);
        usedTime.add(this.usedEndTime);
        return usedTime;
    }

    public Integer getVerifyStateCode() {
        return this.verifyState.getCode();
    }

    public Integer getUsedStateCode() {
        return this.usedState.getCode();
    }

    public Integer getOfferStateCode() {
        return this.offerState.getCode();
    }

    public String getCategoryCode() {
        return this.category.getCode();
    }
}
