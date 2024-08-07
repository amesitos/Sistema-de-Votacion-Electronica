package ec.edu.pucem.bocaurna.gui;

import ec.edu.pucem.bocaurna.models.Curso;
import ec.edu.pucem.bocaurna.models.Estudiante;
import ec.edu.pucem.bocaurna.models.Mesa;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrmEntradaSufragio extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField txtCedulaEstudiante;

    public FrmEntradaSufragio(final FrmMenuPrincipal menuPrincipal) {
        setTitle("Proceso de sufragio");
        setBounds(100, 100, 400, 300);
        getContentPane().setLayout(null);

        JLabel lblSaludo = new JLabel("¡Bienvenido, estudiante!");
        lblSaludo.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblSaludo.setBounds(97, 52, 240, 22);
        getContentPane().add(lblSaludo);

        JLabel lblIngreso = new JLabel("Ingrese su cédula:");
        lblIngreso.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblIngreso.setBounds(129, 87, 150, 22);
        getContentPane().add(lblIngreso);

        txtCedulaEstudiante = new JTextField();
        txtCedulaEstudiante.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtCedulaEstudiante.setBounds(63, 119, 258, 23);
        txtCedulaEstudiante.setColumns(10);
        getContentPane().add(txtCedulaEstudiante);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnEntrar.setBounds(127, 167, 133, 23);
        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cedulaIngresada = txtCedulaEstudiante.getText().trim();

                // Verificar si la cédula es nula o vacía
                if (cedulaIngresada == null || cedulaIngresada.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese una cédula.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                List<Estudiante> estudiantes = menuPrincipal.getEstudiantes();
                Estudiante estudianteEncontrado = null;

                // Buscar al estudiante por cédula
                for (Estudiante estudiante : estudiantes) {
                    if (estudiante.getCedula().equals(cedulaIngresada)) {
                        estudianteEncontrado = estudiante;
                        break;
                    }
                }

                // Verificar si el estudiante fue encontrado y si tiene una mesa asignada
                if (estudianteEncontrado != null) {
                    Curso cursoDelEstudiante = estudianteEncontrado.getCurso();
                    Mesa mesaDelCurso = cursoDelEstudiante.getMesa();
                    
                    System.out.println("Estudiante encontrado: " + estudianteEncontrado.getNombres() + " " + estudianteEncontrado.getApellidos());
                    System.out.println("Mesa del estudiante: " + (mesaDelCurso != null ? mesaDelCurso.getNombreMesa() : "No asignada"));
                    
                    if (mesaDelCurso != null) {
                        dispose();
                        menuPrincipal.abrirProcesoSufragio(cedulaIngresada);
                    } else {
                        JOptionPane.showMessageDialog(null, "Estudiante no registrado en mesa.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Estudiante no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        getContentPane().add(btnEntrar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnSalir.setBounds(127, 200, 133, 23);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
            }
        });
        getContentPane().add(btnSalir);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}

