package ec.edu.pucem.bocaurna.gui;

import ec.edu.pucem.bocaurna.models.Candidato;
import ec.edu.pucem.bocaurna.models.Estudiante;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;


public class FrmCrearCandidato extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField txtNombresCandidatos;
    private JTextField txtApellidosCandidato;
    private JTextField txtPartido;
    private JTable table;
    private DefaultTableModel model;
    private List<Candidato> candidatos;
    private List<Estudiante> estudiantes;

    public FrmCrearCandidato(List<Candidato> candidatos, List<Estudiante> estudiantes) {
        this.candidatos = candidatos;
        this.estudiantes = estudiantes;

        setTitle("Registrar partidarios a consejo estudiantil");
        setBounds(100, 100, 550, 470);
        getContentPane().setLayout(null);

        JLabel lblNombreCandidato = new JLabel("Nombres:");
        lblNombreCandidato.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblNombreCandidato.setBounds(35, 20, 71, 16);
        getContentPane().add(lblNombreCandidato);

        txtNombresCandidatos = new JTextField();
        txtNombresCandidatos.setBounds(105, 20, 285, 20);
        getContentPane().add(txtNombresCandidatos);
        txtNombresCandidatos.setColumns(10);

        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblApellidos.setBounds(35, 50, 53, 15);
        getContentPane().add(lblApellidos);

        txtApellidosCandidato = new JTextField();
        txtApellidosCandidato.setBounds(105, 50, 285, 20);
        getContentPane().add(txtApellidosCandidato);
        txtApellidosCandidato.setColumns(10);

        JLabel lblPartido = new JLabel("Partido:");
        lblPartido.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblPartido.setBounds(35, 80, 71, 16);
        getContentPane().add(lblPartido);

        txtPartido = new JTextField();
        txtPartido.setBounds(105, 80, 181, 20);
        getContentPane().add(txtPartido);
        txtPartido.setColumns(10);

        JButton btnBuscarEstudiante = new JButton("Buscar estudiante");
        btnBuscarEstudiante.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirListaEstudiantes();
            }
        });
        btnBuscarEstudiante.setBounds(103, 110, 138, 30);
        getContentPane().add(btnBuscarEstudiante);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
        btnLimpiar.setBounds(414, 30, 90, 30);
        getContentPane().add(btnLimpiar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancelar.setBounds(414, 100, 90, 30);
        getContentPane().add(btnCancelar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(23, 150, 488, 267);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(model.getValueAt(0, 0));
            }
        });
        table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Candidato", "Partido"}));
        scrollPane.setViewportView(table);

        JButton btnAnadir = new JButton("Añadir");
        btnAnadir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarCandidato();
            }
        });
        btnAnadir.setBounds(414, 66, 90, 30);
        getContentPane().add(btnAnadir);

        model = (DefaultTableModel) table.getModel();
        agregarFila();
    }

    private void abrirListaEstudiantes() {
        FrmListaEstudiantes listaEstudiantes = new FrmListaEstudiantes(null, estudiantes);
        listaEstudiantes.setVisible(true);

        listaEstudiantes.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Estudiante estudianteSeleccionado = listaEstudiantes.getSelectedEstudiante();
                if (estudianteSeleccionado != null) {
                    txtNombresCandidatos.setText(estudianteSeleccionado.getNombres());
                    txtApellidosCandidato.setText(estudianteSeleccionado.getApellidos());
                }
            }
        });

        listaEstudiantes.setLocationRelativeTo(null);
    }

    private void limpiarCampos() {
        txtNombresCandidatos.setText("");
        txtApellidosCandidato.setText("");
        txtPartido.setText("");
    }

    private void agregarCandidato() {
        String nombres = txtNombresCandidatos.getText();
        String apellidos = txtApellidosCandidato.getText();
        String partido = txtPartido.getText();

        if (!nombres.isEmpty() && !apellidos.isEmpty() && !partido.isEmpty()) {
            Candidato nuevoCandidato = new Candidato();
            nuevoCandidato.setNombres(nombres + " " + apellidos);
            nuevoCandidato.setPartido(partido);
            candidatos.add(nuevoCandidato);
            agregarFila();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, rellene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarFila() {
        model.setRowCount(0);
        for (Candidato candidato : candidatos) {
            Object[] fila = new Object[2];
            fila[0] = candidato.getNombres(); 
            fila[1] = candidato.getPartido();
            model.addRow(fila);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     
    }
}


