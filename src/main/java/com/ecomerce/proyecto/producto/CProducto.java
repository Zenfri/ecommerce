package com.ecomerce.proyecto.producto;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecomerce.proyecto.model.entity.Usuario;

@Controller
@RequestMapping("/productos")
public class CProducto {
    private final Logger oLogger = LoggerFactory.getLogger(CProducto.class);

    @Autowired
    private IProductoService oIProductoService;

    @GetMapping()
    public String index(Model oModel){
        oModel.addAttribute("lProductos", oIProductoService.listarProductos());
        return "productos/index";
    }

    @GetMapping("/crear")
    public String crear(){
        return "productos/create";
    }

    @PostMapping("/guardar")
    public String guardar(Producto oProducto){
        oLogger.info("Este es el mensaje del producto {}",oProducto);
        Usuario usuario = new Usuario(Long.valueOf(1), "", "", "", "", "", "", "");
        oProducto.setOUsuario(usuario);
        oIProductoService.guardarProducto(oProducto);
        return "redirect:crear";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model oModel){
        Optional<Producto> optionalProducto = oIProductoService.buscarProducto(id);
        Producto oProducto = new Producto();
         
        if(optionalProducto.isPresent()){//Verificar si contiene un valor no nulo
            oProducto = optionalProducto.get();//obtener el valor que contiene un optional, en este caso "Producto":
            oLogger.info("Mensaje de busqueda del producto: {}",oProducto);
            oModel.addAttribute("producto", oProducto);
            //oModel.addAttribute("imagen", oProducto.getImagen());
        }
        
        return "productos/edit";
    }

    @PostMapping("/actualizar")
    public String actualizar(Producto oProducto){
        oLogger.info("Actualizando producto: {}",oProducto);
        oIProductoService.actualizarProducto(oProducto);
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id){
        oIProductoService.eliminarProducto(id);
        return "redirect:/productos";
    }
    
    
}
