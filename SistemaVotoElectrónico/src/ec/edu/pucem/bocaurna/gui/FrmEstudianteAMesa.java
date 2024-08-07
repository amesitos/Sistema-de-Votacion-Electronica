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
import javax.swing.table.DefaultTableModel;

import ec.edu.pucem.bocaurna.models.Curso;
import ec.edu.pucem.bocaurna.models.Estudiante;
import ec.edu.pucem.bocaurna.models.Mesa;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FrmEstudianteAMesa extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JTable table;
    private DefaultTableModel model;
    private JComboBox<Mesa> comboBoxMesa;
    private JComboBox<Estudiante> comboBoxEstudiantes;

    public FrmEstudianteAMesa(List<Mesa> mesas, List<Estudiante> estudiantes) {
        initComponents(mesas, estudiantes);
    }

    private void initComponents(List<Mesa> mesas, List<Estudiante> estudiantes) {
        setTitle("Asignar mesa a estudiante");
        setBounds(10, 11, 500, 400);
        getContentPane().setLayout(null);

        JLabel lblNombreMesa = new JLabel("Mesa:");
        lblNombreMesa.setBounds(39, 58, 46, 14);
        getContentPane().add(lblNombreMesa);

        comboBoxMesa = createComboBoxMesa(mesas);
        comboBoxMesa.setBounds(110, 53, 132, 24);
        getContentPane().add(comboBoxMesa);

        JLabel lblEstudiante = new JLabel("Estudiante:");
        lblEstudiante.setBounds(39, 24, 64, 14);
        getContentPane().add(lblEstudiante);

        comboBoxEstudiantes = createComboBoxEstudiantes(estudiantes);
        comboBoxEstudiantes.setBounds(110, 19, 164, 24);
        getContentPane().add(comboBoxEstudiantes);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(21, 90, 441, 246);
        getContentPane().add(scrollPane);

        table = new JTable();
        model = new DefaultTableModel(new Object[][]{}, new String[]{"Estudiante", "Mesa"});
        table.setModel(model);
        scrollPane.setViewportView(table);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        btnCancelar.setBounds(323, 50, 90, 30);
        getContentPane().add(btnCancelar);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(e -> agregarEstudianteAMesa());
        btnAgregar.setBounds(323, 16, 90, 30);
        getContentPane().add(btnAgregar);
    }

    private JComboBox<Mesa> createComboBoxMesa(List<Mesa> mesas) {
        JComboBox<Mesa> comboBox = new JComboBox<>();
        DefaultComboBoxModel<Mesa> comboBoxModel = new DefaultComboBoxModel<>(mesas.toArray(new Mesa[0]));
        comboBox.setModel(comboBoxModel);

        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Mesa) {
                    Mesa mesa = (Mesa) value;
                    value = mesa.getNombreMesa();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });

        return comboBox;
    }

    private JComboBox<Estudiante> createComboBoxEstudiantes(List<Estudiante> estudiantes) {
        JComboBox<Estudiante> comboBox = new JComboBox<>();
        DefaultComboBoxModel<Estudiante> comboBoxModel = new DefaultComboBoxModel<>(estudiantes.toArray(new Estudiante[0]));
        comboBox.setModel(comboBoxModel);

        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Estudiante) {
                    Estudiante estudiante = (Estudiante) value;
                    value = estudiante.getNombres() + " " + estudiante.getApellidos();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });

        return comboBox;
    }

    private void agregarEstudianteAMesa() {
        Mesa mesaSeleccionada = (Mesa) comboBoxMesa.getSelectedItem();
        Estudiante estudianteSeleccionado = (Estudiante) comboBoxEstudiantes.getSelectedItem();

        if (mesaSeleccionada != null && estudianteSeleccionado != null) {
            mesaSeleccionada.getEstudiantesDeMesa().add(estudianteSeleccionado);
            Curso cursoDelEstudiante = estudianteSeleccionado.getCurso();
            cursoDelEstudiante.setMesa(mesaSeleccionada);
            agregarFila(estudianteSeleccionado, mesaSeleccionada);
            System.out.println("Mesa asignada al estudiante: " + mesaSeleccionada.getNombreMesa());
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un estudiante y una mesa.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarFila(Estudiante estudiante, Mesa mesa) {
        String nombreEstudiante = estudiante.getNombres() + " " + estudiante.getApellidos();
        String nombreMesa = mesa != null ? mesa.getNombreMesa() : "No asignada";
        model.addRow(new Object[]{nombreEstudiante, nombreMesa});
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
    }
}



