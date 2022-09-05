package com.bootcamp.profilemaster.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
public class InformacionAcademica {

    private Integer idInformacionAcademica;
    private String descripcionInformacionAcademica;
    private String institucion;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaInicio;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaTermino;
    private String tipoEducacion;
    private int idUsuario;

    public Integer getIdInformacionAcademica() {
        return idInformacionAcademica;
    }

    public void setIdInformacionAcademica(Integer idInformacionAcademica) {
        this.idInformacionAcademica = idInformacionAcademica;
    }

    public String getDescripcionInformacionAcademica() {
        return descripcionInformacionAcademica;
    }

    public void setDescripcionInformacionAcademica(String descripcionInformacionAcademica) {
        this.descripcionInformacionAcademica = descripcionInformacionAcademica;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getTipoEducacion() {
        return tipoEducacion;
    }

    public void setTipoEducacion(String tipoEducacion) {
        this.tipoEducacion = tipoEducacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
