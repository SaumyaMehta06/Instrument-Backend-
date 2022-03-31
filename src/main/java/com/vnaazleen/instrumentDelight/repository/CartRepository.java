package com.vnaazleen.instrumentDelight.repository;

import com.vnaazleen.instrumentDelight.model.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartModel, Long> {
    public List<CartModel> findByUserId(Long id);
}
