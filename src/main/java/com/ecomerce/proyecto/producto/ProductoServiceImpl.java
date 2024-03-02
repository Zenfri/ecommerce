package com.ecomerce.proyecto.producto;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private IProductoDAO oIProductoDAO;

    @Override
    public void guardarProducto(Producto oProducto) {
        oIProductoDAO.save(oProducto);
    }

    @Override
    public Optional<Producto> buscarProducto(Long id) {
        return oIProductoDAO.findById(id);
    }

    @Override
    public void actualizarProducto(Producto oProducto) {
        oIProductoDAO.save(oProducto);
    }

    @Override
    public void eliminarProducto(Long id) {
        oIProductoDAO.deleteById(id);
    }
    
}
