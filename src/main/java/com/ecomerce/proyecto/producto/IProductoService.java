package com.ecomerce.proyecto.producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    public void guardarProducto(Producto oProducto);
    public Optional<Producto> buscarProducto(Long id);
    public List<Producto> listarProductos();
    public void actualizarProducto(Producto oProducto);
    public void eliminarProducto(Long id);
}
