package com.sagmade.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagmade.apirest.apirest.Entities.Products;

public interface ProductoRepository extends JpaRepository<Products, Long>{

}
