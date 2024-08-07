package ec.edu.pucem.bocaurna.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class FrmTerminarSufragio extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private FrmMenuPrincipal sistemaDeVotacion; // Referencia al contenedor principal

    public FrmTerminarSufragio(FrmMenuPrincipal sistemaDeVotacion) {
        this.sistemaDeVotacion = sistemaDeVotacion;
        
        setBounds(100, 100, 400, 250);
        getContentPane().setLayout(null);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSalir.setBounds(135, 142, 117, 25);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        getContentPane().add(btnSalir);
        
        JLabel lblGracias = new JLabel("¡Gracias por su voto!");
        lblGracias.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblGracias.setBounds(85, 66, 214, 39);
        getContentPane().add(lblGracias);
        
        JButton btnVolver = new JButton("Nuevo voto");
        btnVolver.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnVolver.setBounds(135, 107, 117, 25);
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la pantalla actual
                sistemaDeVotacion.abrirFrmEntradaSufragio(); // Abre la pantalla FrmEntradaSufragio
            }
        });
        getContentPane().add(btnVolver);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
