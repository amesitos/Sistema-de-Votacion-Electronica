package ec.edu.pucem.bocaurna.gui;

import ec.edu.pucem.bocaurna.models.Curso;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrmCrearCurso extends JInternalFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField txtNombreCurso;
    private JTable table;
    private DefaultTableModel model;
    private Curso curso;
    private List<Curso> cursos;

    public FrmCrearCurso(List<Curso> cursos) {
        setTitle("Crear nuevo curso");
        setBounds(100, 100, 400, 400);
        getContentPane().setLayout(null);
        this.cursos = cursos;

        JLabel lblNombreCurso = new JLabel("Nombre del curso:");
        lblNombreCurso.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblNombreCurso.setBounds(21, 22, 120, 16);
        getContentPane().add(lblNombreCurso);

        txtNombreCurso = new JTextField();
        txtNombreCurso.setBounds(137, 22, 222, 20);
        getContentPane().add(txtNombreCurso);
        txtNombreCurso.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 111, 364, 237);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Cursos" }));
        scrollPane.setViewportView(table);

        JButton btnAnadirCurso = new JButton("Añadir");
        btnAnadirCurso.setBounds(147, 58, 90, 30);
        btnAnadirCurso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarCurso();
            }
        });
        getContentPane().add(btnAnadirCurso);

        JButton btnLimpiarCampos = new JButton("Limpiar");
        btnLimpiarCampos.setBounds(21, 58, 90, 30);
        btnLimpiarCampos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
        getContentPane().add(btnLimpiarCampos);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(272, 58, 90, 30);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        getContentPane().add(btnSalir);

        model = (DefaultTableModel) table.getModel();
        agregarFila();
    }

    private void agregarCurso() {
        if (txtNombreCurso.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, escriba un curso.", "Error.", JOptionPane.ERROR_MESSAGE);
        } else {
            curso = new Curso();
            curso.setNombreCurso(txtNombreCurso.getText());

            cursos.add(curso);
            agregarFila();
            limpiarCampos();
        }
    }

    private void limpiarCampos() {
        txtNombreCurso.setText("");
    }

    private void agregarFila() {
        model.setRowCount(0);
        for (Curso curso : cursos) {
            Object[] fila = new Object[1];
            fila[0] = curso.getNombreCurso();
            model.addRow(fila);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
}


