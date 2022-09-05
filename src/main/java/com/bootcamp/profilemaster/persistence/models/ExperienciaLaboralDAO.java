package com.bootcamp.profilemaster.persistence.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "experiencia_laboral")
public class ExperienciaLaboralDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_experiencia_laboral")
    private Integer idExperienciaLaboral;

    @Column(name = "descripcion_experiencia_laboral")
    @NonNull
    private String descripcionExperienciaLaboral;

    @Column(name = "empresa")
    @NonNull
    private String empresa;

    @Column(name = "fecha_inicio")
    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaInicio;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "fecha_termino")
    private Date fechaTermino;

    @Column(name = "id_usuario")
    private int idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_experiencia_laboral_usuario"))
    private UsuarioDAO usuarioExpLaboral;

    public Integer getIdExperienciaLaboral() {
        return idExperienciaLaboral;
    }

    public void setIdExperienciaLaboral(Integer idExperienciaLaboral) {
        this.idExperienciaLaboral = idExperienciaLaboral;
    }

    public String getDescripcionExperienciaLaboral() {
        return descripcionExperienciaLaboral;
    }

    public void setDescripcionExperienciaLaboral(String descripcionExperienciaLaboral) {
        this.descripcionExperienciaLaboral = descripcionExperienciaLaboral;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioDAO getUsuarioExpLaboral() {
        return usuarioExpLaboral;
    }

    public void setUsuarioExpLaboral(UsuarioDAO usuarioExpLaboral) {
        this.usuarioExpLaboral = usuarioExpLaboral;
    }
}