package ec.edu.pucem.bocaurna.models;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
	private Long idMesa;
    private String nombreMesa;
    private String presidente;
    private String secretario;
    private String ubicacion;
    private List<Estudiante> estudiantesDeMesa;

    public Mesa() {
        this.estudiantesDeMesa = new ArrayList<>();
    }
    
    public Long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Long idMesa) {
        this.idMesa = idMesa;
    }

    public String getNombreMesa() {
        return nombreMesa;
    }

    public void setNombreMesa(String nombreMesa) {
        this.nombreMesa = nombreMesa;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getSecretario() {
        return secretario;
    }

    public void setSecretario(String secretario) {
        this.secretario = secretario;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Estudiante> getEstudiantesDeMesa() {
        return estudiantesDeMesa;
    }

    public void setEstudiantesDeMesa(List<Estudiante> estudiantesDeMesa) {
        this.estudiantesDeMesa = estudiantesDeMesa;
    }
}

