package com.ecomerce.proyecto.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prod_id")
    private Long id;
    @Column(name="prod_nombre")
    private String nombre;
    @Column(name="prod_descripcion")
    private String descripcion;
    @Column(name="prod_imagen")
    private String imagen;
    @Column(name="prod_precio")
    private String precio;
    @Column(name="prod_stock")
    private String stock;
}
