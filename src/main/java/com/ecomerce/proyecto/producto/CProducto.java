package com.ecomerce.proyecto.producto;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    
    
}
