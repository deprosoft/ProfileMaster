package com.bootcamp.profilemaster.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Portafolio {

    private Integer idPortafolio;
    private String dispuestoCambioResidencia;
    private Integer aniosExperiencia;
    private String descripcion;
    private Integer idUsuario;
    private Usuario portafolioUsuario;

    public Integer getIdPortafolio() {
        return idPortafolio;
    }

    public void setIdPortafolio(Integer idPortafolio) {
        this.idPortafolio = idPortafolio;
    }

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

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getPortafolioUsuario() {
        return portafolioUsuario;
    }

    public void setPortafolioUsuario(Usuario portafolioUsuario) {
        this.portafolioUsuario = portafolioUsuario;
    }
}
