package com.ecomerce.proyecto.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_ordenes")
public class DetalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="det_ord_id")
    private Long id;
     @Column(name="det_ord_precio_unitario") //historial del precio del producto
    private Long precio_unitario;
    @Column(name="det_ord_cantidad")
    private Long cantidad;
    @Column(name="det_ord_subtotal")
    private Long subtotal;
    
    @ManyToOne
    @JoinColumn(name = "id_orden")
    private Orden oOrden;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto oProducto;
}
