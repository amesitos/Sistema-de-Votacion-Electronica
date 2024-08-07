package ec.edu.pucem.bocaurna.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import ec.edu.pucem.bocaurna.models.Estudiante;

import java.awt.*;
import java.util.List;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.*;


public class FrmListaEstudiantes extends JDialog {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel model;
    private List<Estudiante> estudiantes;
    private Estudiante selectedEstudiante;

    public FrmListaEstudiantes(Frame parent, List<Estudiante> estudiantes) {
        super(parent, "Lista de Estudiantes", true);
        this.estudiantes = estudiantes;

        setBounds(100, 100, 600, 400);
        getContentPane().setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Cédula", "Nombres", "Apellidos", "Email", "Curso"}
        );
        table.setModel(model);
        scrollPane.setViewportView(table);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        selectedEstudiante = estudiantes.get(selectedRow);
                    }
                }
            }
        });

        llenarTabla();

        JButton btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        getContentPane().add(btnSeleccionar, BorderLayout.SOUTH);
    }

    private void llenarTabla() {
        model.setRowCount(0);
        for (Estudiante estudiante : estudiantes) {
            model.addRow(new Object[]{
                    estudiante.getCedula(),
                    estudiante.getNombres(),
                    estudiante.getApellidos(),
                    estudiante.getEmail(),
                    estudiante.getCurso().getNombreCurso()
            });
        }
    }

    public Estudiante getSelectedEstudiante() {
        return selectedEstudiante;
    }
}


