package ec.edu.pucem.bocaurna.models;


public class Estudiante extends Persona {
    
    private Curso curso;
    private boolean estado; 
    private Candidato candidatoVotado; 

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Candidato getCandidatoVotado() {
        return candidatoVotado;
    }

    public void setCandidatoVotado(Candidato candidatoVotado) {
        this.candidatoVotado = candidatoVotado;
    }
}
