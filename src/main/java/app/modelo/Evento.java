package app.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Evento implements Serializable {

    @ManyToMany(targetEntity = Coche.class)
    @JoinTable(name = "coche_like", joinColumns = @JoinColumn(name = "evento_id"), inverseJoinColumns = @JoinColumn(name = "coche_id"))
    private List<Coche> cocheListEvento=new ArrayList<>();






    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombreEvento, recinto, ciudad, fecha, hora, pathImagen, infoCOmplemetnaria;
    private String puntoSalida, horaSalida;



    public Evento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPuntoSalida() {
        return puntoSalida;
    }

    public void setPuntoSalida(String puntoSalida) {
        this.puntoSalida = puntoSalida;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }


    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getRecinto() {
        return recinto;
    }

    public void setRecinto(String recinto) {
        this.recinto = recinto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getPathImagen() {
        return pathImagen;
    }

    public void setPathImagen(String pathImagen) {
        this.pathImagen = pathImagen;
    }

    public String getInfoCOmplemetnaria() {
        return infoCOmplemetnaria;
    }

    public void setInfoCOmplemetnaria(String infoCOmplemetnaria) {
        this.infoCOmplemetnaria = infoCOmplemetnaria;
    }
}
