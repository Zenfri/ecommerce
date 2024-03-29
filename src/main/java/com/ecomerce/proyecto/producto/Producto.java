package com.ecomerce.proyecto.producto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ecomerce.proyecto.model.entity.DetalleOrden;
import com.ecomerce.proyecto.model.entity.Usuario;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
    @Column(name="prod_precio")
    private String precio;
    @Column(name="prod_stock")
    private String stock;
    @Column(name="prod_imagen")
    private String imagen;
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario oUsuario;

    @OneToMany(mappedBy = "oProducto")
    private List<DetalleOrden> lDetalleOrdenes;

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
                + ", stock=" + stock + ", imagen=" + imagen + ", oUsuario id=" + oUsuario.getId() + "]";
    }

}
