package ec.edu.pucem.bocaurna.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

import ec.edu.pucem.bocaurna.models.Curso;
import ec.edu.pucem.bocaurna.models.Estudiante;


public class FrmCrearEstudiante extends JInternalFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private Estudiante estudiante;
    private JTable table;
    private DefaultTableModel model;
    private JTextField txtNombres;
    private JButton btnGuardar;
    private JButton btnNuevo;
    private JButton btnCancelar;
    private List<Estudiante> estudiantes;
    private JComboBox<Curso> cmbCurso;
    private JLabel lblCedula;
    private JTextField txtCedula;
    private JTextField txtApellidos;
    private JLabel lblEmail;
    private JTextField txtEmail;

    public FrmCrearEstudiante(List<Curso> cursos, List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;

        setTitle("Registro de nuevos estudiantes");
        setBounds(100, 100, 570, 500);
        getContentPane().setLayout(null);

        JLabel lblNombres = new JLabel("Nombres:");
        lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblNombres.setBounds(22, 43, 67, 15);
        getContentPane().add(lblNombres);

        txtNombres = new JTextField();
        txtNombres.setBounds(99, 41, 309, 19);
        getContentPane().add(txtNombres);
        txtNombres.setColumns(10);

        lblCedula = new JLabel("Cédula:");
        lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblCedula.setBounds(22, 14, 53, 15);
        getContentPane().add(lblCedula);

        txtCedula = new JTextField();
        txtCedula.setBounds(98, 12, 203, 19);
        getContentPane().add(txtCedula);
        txtCedula.setColumns(10);

        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblApellidos.setBounds(22, 74, 53, 15);
        getContentPane().add(lblApellidos);

        txtApellidos = new JTextField();
        txtApellidos.setBounds(99, 72, 309, 19);
        getContentPane().add(txtApellidos);
        txtApellidos.setColumns(10);

        lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblEmail.setBounds(22, 104, 44, 13);
        getContentPane().add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(98, 101, 218, 19);
        getContentPane().add(txtEmail);
        txtEmail.setColumns(10);

        JLabel lblCurso = new JLabel("Curso:");
        lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblCurso.setBounds(22, 137, 53, 15);
        getContentPane().add(lblCurso);

        cmbCurso = new JComboBox<>();
        DefaultComboBoxModel<Curso> comboBoxModel = new DefaultComboBoxModel<>(cursos.toArray(new Curso[0]));
        cmbCurso.setModel(comboBoxModel);
        cmbCurso.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                if (value instanceof Curso) {
                    Curso curso = (Curso) value;
                    value = curso.getNombreCurso();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
        cmbCurso.setBounds(99, 132, 100, 24);
        getContentPane().add(cmbCurso);

        btnNuevo = new JButton("Nuevo");
        btnNuevo.setBounds(449, 14, 90, 30);
        btnNuevo.addActionListener(this);
        getContentPane().add(btnNuevo);

        btnGuardar = new JButton("Agregar");
        btnGuardar.setBounds(449, 54, 90, 30);
        btnGuardar.addActionListener(this);
        getContentPane().add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(449, 97, 90, 30);
        btnCancelar.addActionListener(this);
        getContentPane().add(btnCancelar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 177, 529, 272);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][] {},
                new String[] { "Cédula", "Nombres", "Apellidos", "Email", "Curso" }));
        scrollPane.setViewportView(table);

        model = (DefaultTableModel) table.getModel();
        agregarFila();
    }

    private void nuevo() {
        estudiante = new Estudiante();
        txtNombres.setText("");
        txtCedula.setText("");
        txtApellidos.setText("");
        txtEmail.setText("");
        cmbCurso.setSelectedIndex(0);
    }

    private void agregarEstudiante() {
        if (txtCedula.getText().isEmpty() || txtNombres.getText().isEmpty() || txtApellidos.getText().isEmpty()
                || txtEmail.getText().isEmpty() || cmbCurso.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Por favor, llene todos los campos.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            estudiante = new Estudiante();
            estudiante.setCedula(txtCedula.getText());
            estudiante.setNombres(txtNombres.getText());
            estudiante.setApellidos(txtApellidos.getText());
            estudiante.setEmail(txtEmail.getText());
            estudiante.setCurso((Curso) cmbCurso.getSelectedItem());

            estudiantes.add(estudiante);
            agregarFila();
            nuevo();
        }
    }

    private void agregarFila() {
        model.setRowCount(0);
        for (Estudiante estudiante : estudiantes) {
            Object[] fila = new Object[5];
            fila[0] = estudiante.getCedula();
            fila[1] = estudiante.getNombres();
            fila[2] = estudiante.getApellidos();
            fila[3] = estudiante.getEmail();
            fila[4] = estudiante.getCurso().getNombreCurso();
            model.addRow(fila);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNuevo) {
            nuevo();
        } else if (e.getSource() == btnGuardar) {
            agregarEstudiante();
        } else if (e.getSource() == btnCancelar) {
            dispose();
        }
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}

