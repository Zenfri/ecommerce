package com.ecomerce.proyecto.model.entity;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="usu_id")
    private Long id;
    @Column(name="usu_nombre")
    private String nombre;
    @Column(name="usu_email")    
    private String email;
    @Column(name="usu_direccion")
    private String direccion;
    @Column(name="usu_telefono")
    private String telefono;
    @Column(name="usu_tipo")
    private String tipo; //admin o usuario
    @Column(name="usu_usuario")
    private String usuario;
    @Column(name="usu_clave")
    private String clave;

    @OneToMany(mappedBy = "oUsuario")
    private List<Producto> lProductos;

    @OneToMany(mappedBy = "oUsuario")
    private List<Orden> lOrdenes;
}
