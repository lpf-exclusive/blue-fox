package com.fox.oms.service;

import com.fox.oms.pojo.dto.CartItemDTO;

import java.util.List;

/**
 * 购物车业务接口
 */
public interface ICartService {



    List<CartItemDTO> listCartItemByMemberId(Long memberId);

    boolean deleteCart();

    boolean addCartItem(Long skuId);

    boolean updateCartItem(CartItemDTO cartItem);

    boolean removeCartItem(Long skuId);

    boolean removeCheckedItem();

    boolean checkAll(boolean checked);

}
