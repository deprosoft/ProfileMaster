package com.bootcamp.profilemaster.persistence.models;

import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "portafolio")
public class PortafolioDAO {

    @Id
    @Column(name = "id_portafolio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPortafolio;

    @Column(name = "dispuesto_cambio_residencia")
    @NonNull
    private String dispuestoCambioResidencia;

    @Positive
    @Min(0)
    @Max(60)
    @Column(name = "anios_experiencia")
    @NonNull
    private Integer aniosExperiencia;

    private String descripcion;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @OneToOne
    @JoinColumn(name="id_usuario", insertable = false, updatable = false)
    private UsuarioDAO portafolioUsuario;

    public String getDispuestoCambioResidencia() {
        return dispuestoCambioResidencia;
    }

    public void setDispuestoCambioResidencia(String dispuestoCambioResidencia) {
        this.dispuestoCambioResidencia = dispuestoCambioResidencia;
    }

    public Integer getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(Integer aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdPortafolio() {
        return idPortafolio;
    }

    public void setIdPortafolio(Integer idPortafolio) {
        this.idPortafolio = idPortafolio;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioDAO getPortafolioUsuario() {
        return portafolioUsuario;
    }
    public void setPortafolioUsuario(UsuarioDAO portafolioUsuario) {
        this.portafolioUsuario = portafolioUsuario;
    }
}