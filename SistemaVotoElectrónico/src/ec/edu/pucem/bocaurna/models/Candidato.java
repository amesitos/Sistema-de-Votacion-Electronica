package ec.edu.pucem.bocaurna.models;

public class Candidato extends Persona {
	
	private String partido;
	private int votos; 

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}
	
    public void aumentarVotos() {
        votos++;
    }
}
