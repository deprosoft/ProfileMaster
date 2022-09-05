package com.bootcamp.profilemaster.persistence.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "informacion_academica")
public class InformacionAcademicaDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_informacion_academica")
    private Integer idInformacionAcademica;

    @Column(name = "descripcion_informacion_academica")
    @NonNull
    private String descripcionInformacionAcademica;

    @Column(name = "institucion")
    @NonNull
    private String institucion;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "fecha_inicio")
    @NonNull
    private Date fechaInicio;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "fecha_termino")
    private Date fechaTermino;

    private String tipoEducacion;

    @Column(name = "id_usuario")
    private int idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_usuario",insertable = false,updatable = false, foreignKey = @ForeignKey(name = "FK_informacion_academica_usuario"))
    private UsuarioDAO usuarioInformacionAcademica;

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

    public UsuarioDAO getUsuarioInformacionAcademica() {
        return usuarioInformacionAcademica;
    }

    public void setUsuarioInformacionAcademica(UsuarioDAO usuarioInformacionAcademica) {
        this.usuarioInformacionAcademica = usuarioInformacionAcademica;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
