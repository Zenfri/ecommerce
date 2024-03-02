package com.ecomerce.proyecto.model.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ordenes")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ord_id")
    private Long id;
    @Column(name="ord_numero")
    private String numero;
    @Column(name="ord_fecha_creacion")
    private Date fecha_creacion;
    @Column(name="ord_fecha_recibida")
    private Date fecha_recibida;
    @Column(name="ord_total")
    private double total;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario oUsuario;

    @OneToMany(mappedBy = "oOrden")
    private List<DetalleOrden> lDetalleOrdenes;
}
