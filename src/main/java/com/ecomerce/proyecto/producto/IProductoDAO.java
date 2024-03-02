package com.ecomerce.proyecto.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoDAO extends JpaRepository<Producto,Long>{
    
}
