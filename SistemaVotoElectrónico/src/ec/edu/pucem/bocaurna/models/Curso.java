package ec.edu.pucem.bocaurna.models;

public class Curso {
	private Long idCurso;
	private String nombreCurso;
	private Mesa mesa;
	
	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}
	
	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Mesa getMesa() {
		return mesa;
	}


}
