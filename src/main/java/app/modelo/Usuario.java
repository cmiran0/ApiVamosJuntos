package app.modelo;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre, apellidos, dni;
    private int telefono;
    public Usuario() {
    }



}
