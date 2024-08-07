package ec.edu.pucem.bocaurna.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ec.edu.pucem.bocaurna.models.Candidato;
import ec.edu.pucem.bocaurna.models.Estudiante;


public class FrmProcesoSufragio extends JInternalFrame {
    
    private static final long serialVersionUID = 1L;
    private FrmMenuPrincipal sistemaDeVotacion;
    private Estudiante estudiante;
    
    public FrmProcesoSufragio(final FrmMenuPrincipal sistemaDeVotacion, final String cedulaEstudiante) {
        this.sistemaDeVotacion = sistemaDeVotacion;
        this.estudiante = buscarEstudiantePorCedula(cedulaEstudiante);
        
        setTitle("Proceso de sufragio");
        setBounds(100, 100, 600, 389);
        setClosable(true);
        getContentPane().setLayout(null);
        
        JLabel lblSaludo = new JLabel("¡Hola, " + estudiante.getNombres() + " " + estudiante.getApellidos() + "!");
        lblSaludo.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblSaludo.setBounds(148, 10, 295, 30);
        getContentPane().add(lblSaludo);
        
        JLabel lblMesa = new JLabel("Tu mesa es " + estudiante.getCurso().getMesa().getNombreMesa() + " en la dirección " + estudiante.getCurso().getMesa().getUbicacion() + ".");
        lblMesa.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblMesa.setBounds(111, 296, 398, 30);
        getContentPane().add(lblMesa);
        
        if (estudiante.getEstado()) {
            JLabel lblVotoExiste = new JLabel("Su voto ya ha sido registrado.");
            lblVotoExiste.setFont(new Font("Tahoma", Font.PLAIN, 15));
            lblVotoExiste.setBounds(224, 45, 200, 30);
            getContentPane().add(lblVotoExiste);
        } else {
            JLabel lblEscoga = new JLabel("Escoge tu candidato.");
            lblEscoga.setFont(new Font("Tahoma", Font.PLAIN, 15));
            lblEscoga.setBounds(224, 45, 219, 30);
            getContentPane().add(lblEscoga);
            
            int y = 80;
            for (final Candidato candidato : sistemaDeVotacion.getCandidatos()) {
                JButton btnCandidato = new JButton(candidato.getNombres());
                btnCandidato.setBounds(25, y, 200, 30);
                getContentPane().add(btnCandidato);
                y += 40;
                
                btnCandidato.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        sistemaDeVotacion.registrarVoto(cedulaEstudiante, candidato);

                        estudiante.setCandidatoVotado(candidato);
                        estudiante.setEstado(true); // Marca al estudiante como que ya votó

                        JOptionPane.showMessageDialog(null, "Voto registrado.");
                        dispose();
                        sistemaDeVotacion.abrirFrmTerminarSufragio();
                    }
                });
            }
        }
    }
    
    private Estudiante buscarEstudiantePorCedula(String cedulaEstudiante) {
        for (Estudiante estudiante : sistemaDeVotacion.getEstudiantes()) {
            if (estudiante.getCedula().equals(cedulaEstudiante)) {
                return estudiante;
            }
        }
        return null; 
    }
}


