package com.project.User.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.project.User.entity.Cart;
import com.project.User.entity.CompositePK;

@Repository
public interface CartRepository extends JpaRepository<Cart, CompositePK>{
	public List<Cart> findByBuyerId(int buyerid);

}
