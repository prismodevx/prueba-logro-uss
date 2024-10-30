package com.luna.pruebalogro.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Denuncias")
@EntityListeners(AuditingEntityListener.class)
public class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name = "descripcion", length = 255, nullable = true)
    private String descripcion;

    @Column(name= "ubicacion", length = 150, nullable = true)
    private String ubicacion;

    @Column(name = "estado", length = 20, nullable = true)
    private String estado;

    @Column(name= "ciudadano", length = 100, nullable = false)
    private String ciudadano;

    @Column(name = "telefono_ciudadano", length = 15, nullable = true)
    private String telefono_ciudadano;

    @Column(name = "fecha_registro ", nullable = true)
    private Date fecha_registro ;

    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name="updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updateAt;
}
