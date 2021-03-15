package com.project.User.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.User.entity.CompositePK;
import com.project.User.entity.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, CompositePK>{

}
