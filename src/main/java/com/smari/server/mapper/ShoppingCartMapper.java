package com.smari.server.mapper;

import com.smari.server.dto.ShoppingCartModel;
import com.smari.server.entity.ShoppingCart;

/**
 * @author smari
 */
public class ShoppingCartMapper {
    public static ShoppingCart convertModelToEntity(ShoppingCartModel model) {
        ShoppingCart cart = new ShoppingCart();
        if(model != null){
            if(model.getId() != null) cart.setId(model.getId());
            cart.setTotalAmount(model.getTotalAmount());
        }
        return cart;
    }

    public static ShoppingCartModel convertEntityToModel(ShoppingCart entity) {
        ShoppingCartModel cartModel = new ShoppingCartModel();
        if(entity != null){
            if(entity.getId() != null) cartModel.setId(entity.getId());
            cartModel.setTotalAmount(entity.getTotalAmount());
        }
        return cartModel;
    }
}
