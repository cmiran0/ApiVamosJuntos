package app.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Coche implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricula, tipo, modelo;
    private int any, nPlazas;

    @ManyToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dni_propietario")
    private Usuario propietario;

    public Usuario getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    @ManyToMany(targetEntity = Usuario.class, cascade = CascadeType.ALL)
    @JoinTable(name = "coche_pasajeros",
            joinColumns = @JoinColumn(name = "coche_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id",
                    referencedColumnName = "id"))
    private List<Usuario> pasajeros;

    public void addPasajero(Usuario usuario){
        this.pasajeros.add(usuario);
    }

    /*
    @JsonIgnore
    @ManyToMany(mappedBy = "cocheListEvento")
    private List<Evento> eventos;*/

    public Coche() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public int getnPlazas() {
        return nPlazas;
    }

    public void setnPlazas(int nPlazas) {
        this.nPlazas = nPlazas;
    }


}
