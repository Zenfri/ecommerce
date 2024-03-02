package com.ecomerce.proyecto.producto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class CProducto {

    @GetMapping()
    public String index(){
        return "productos/index";
    }
    
}
