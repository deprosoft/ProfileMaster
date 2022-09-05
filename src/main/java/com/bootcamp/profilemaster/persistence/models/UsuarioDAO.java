package com.bootcamp.profilemaster.persistence.models;

import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuario")
public class UsuarioDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "documento")
    @NonNull
    private Integer documento;

    @Column(name = "nombre")
    @NonNull
    private String nombre;

    @Column(name = "apellido")
    @NonNull
    private String apellido;

    @Column(name = "email")
    @NonNull
    private String email;

    @Column(name = "direccion")
    @NonNull
    private String direccion;

    private String ciudad;

    @Column(name = "fecha_nacimiento")
    @NonNull
    private Date fechaNacimiento;

    private Integer edad;

    private String hobbie;

    @OneToMany(mappedBy = "usuarioExpLaboral")
    private List<ExperienciaLaboralDAO> experienciaLaboral;

    @OneToMany(mappedBy = "usuarioInformacionAcademica")
    private List<InformacionAcademicaDAO> informacionAcademica;

    @OneToOne(mappedBy = "portafolioUsuario")
    private PortafolioDAO portafolio;

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getEdad() {
        return getCalculaEdad(fechaNacimiento);
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getCalculaEdad(Date fechaNacimiento) {

        Period periodo = Period.between(fechaNacimiento.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate(), LocalDate.now());

        return periodo.getYears();
    }

    public List<ExperienciaLaboralDAO> getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(List<ExperienciaLaboralDAO> experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public List<InformacionAcademicaDAO> getInformacionAcademica() {
        return informacionAcademica;
    }

    public void setInformacionAcademica(List<InformacionAcademicaDAO> informacionAcademica) {
        this.informacionAcademica = informacionAcademica;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getHobbie() {
        return hobbie;
    }

    public void setHobbie(String hobbie) {
        this.hobbie = hobbie;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public PortafolioDAO getPortafolio() {
        return portafolio;
    }

    public void setPortafolio(PortafolioDAO portafolio) {
        this.portafolio = portafolio;
    }
}
