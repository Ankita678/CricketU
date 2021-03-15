package com.project.User.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.User.dto.WishlistDTO;

import com.project.User.entity.CompositePK;
import com.project.User.entity.Wishlist;
import com.project.User.repository.WishlistRepository;

@Service
public class WishlistService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	WishlistRepository wishlistRepo;
	
	
	public void addWishlist(WishlistDTO wishlistDTO) {
		logger.info("Add product request to wishlist", wishlistDTO);
		Wishlist wishlist = wishlistDTO.createEntity();
		if(wishlist == null) {
			
		}
		wishlistRepo.save(wishlist);
	}
	
	public List<WishlistDTO> allWishlist(){
		List<Wishlist> wishlist = wishlistRepo.findAll();
		List<WishlistDTO> wishlistDTOs = new ArrayList<>();
		
			for(Wishlist w: wishlist) {
				WishlistDTO wishlistDTO = WishlistDTO.valueOf(w);
				wishlistDTOs.add(wishlistDTO);
			}
		logger.info("wishlist details : {}", wishlistDTOs);
		return wishlistDTOs;
	}
	
	public void removeProduct(WishlistDTO wishlistDTO) throws Exception{
		logger.info("Delete product from wishlist", wishlistDTO);
		Optional <Wishlist> wishlist = wishlistRepo.findById(new CompositePK(wishlistDTO.getBuyerId(),wishlistDTO.getProdId()));
		if(wishlist.isPresent()) {
			wishlistRepo.deleteById(new CompositePK(wishlistDTO.getBuyerId(),wishlistDTO.getProdId()));
		}else {
			throw new Exception("Wishlist.NOT_AVAILABLE");
		}
	}
	
}
