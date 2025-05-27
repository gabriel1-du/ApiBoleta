package com.example.ApiBoleta.Model;

import java.time.LocalDateTime;


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
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "boleta")
public class Boleta {


    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boleta_id")
    private Integer boletaId;

    @Column(name = "subtotal", nullable = false, length =  13)
    private Integer subtotal;

    @Column(name = "impuesto", nullable = false, length = 13)
    private Integer impuesto;

    @Column(name = "total", nullable = false, length = 13)
    private Integer total;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDateTime fecha_emision;



    //Relacion con otras clases/entidades
    //Relacion con la clase pedido
    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    //Relacion con la clase usuario
    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    


}
