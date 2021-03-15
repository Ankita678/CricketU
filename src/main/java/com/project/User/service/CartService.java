package com.project.User.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.User.dto.CartDTO;

import com.project.User.entity.Cart;
import com.project.User.entity.CompositePK;
import com.project.User.entity.Wishlist;
import com.project.User.repository.CartRepository;
import com.project.User.repository.WishlistRepository;

@Service
public class CartService {

Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	WishlistRepository wishlistRepo;
	
	public void addCart(CartDTO cartDTO) {
		logger.info("Add product request to cart", cartDTO);
		Cart cart = cartDTO.createEntity();
		cartRepo.save(cart);
	}
	
	public List<CartDTO> allCart(){
		List<Cart> cart = cartRepo.findAll();
		List<CartDTO> cartDTOs = new ArrayList<>();
		
			for(Cart c: cart) {
				CartDTO cartDTO = CartDTO.valueOf(c);
				cartDTOs.add(cartDTO);
			}
		logger.info("Cart details : {}", cartDTOs);
		return cartDTOs;
	}
	
	public void removeProduct(CartDTO cartDTO) {
		logger.info("Delete product from cart", cartDTO);
		CompositePK compKey = new CompositePK();
		compKey.setBuyerId(cartDTO.getBuyerId());
		compKey.setProdId(cartDTO.getProdId());
		Optional <Cart> cart = cartRepo.findById(compKey);
		if(cart.isPresent()) {
			cartRepo.deleteById(compKey);
		}
	}
	
	public boolean wishlistToCart(CartDTO cartDTO) {
		logger.info("Move Product from cart", cartDTO);
		CompositePK compKey = new CompositePK();
		compKey.setBuyerId(cartDTO.getBuyerId());
		compKey.setProdId(cartDTO.getProdId());
		Optional <Wishlist> wishlist = wishlistRepo.findById(compKey);
		if(wishlist.isPresent()) {
			Cart cart = cartDTO.createEntity();
			cartRepo.save(cart);
			wishlistRepo.deleteById(compKey);
			return true;
		}
		return false;
	}
	
	public List<CartDTO> getCart(int buyerid){
		List<Cart> cart = cartRepo.findByBuyerId(buyerid);
		List<CartDTO> cartDTO = new ArrayList<>();
		for(Cart c:cart) {
			CartDTO cartD = CartDTO.valueOf(c);
			cartDTO.add(cartD);
		}
		
		return cartDTO;
	}
	
}
