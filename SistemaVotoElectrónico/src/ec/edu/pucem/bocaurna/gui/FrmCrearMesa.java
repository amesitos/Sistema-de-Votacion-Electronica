package ec.edu.pucem.bocaurna.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

import ec.edu.pucem.bocaurna.models.Mesa;


public class FrmCrearMesa extends JInternalFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField txtNombreMesa;
    private JTextField txtPresidente;
    private JTextField txtSecretario;
    private JTextField txtUbicacion;
    private JTable table;
    private DefaultTableModel model;
    private List<Mesa> mesas;

    public FrmCrearMesa(List<Mesa> mesas) {
        this.mesas = mesas;
        initComponents();
    }

    private void initComponents() {
        setTitle("Crear nuevas mesas de votación");
        setBounds(100, 100, 450, 470);
        getContentPane().setLayout(null);

        JLabel lblNombreMesa = new JLabel("Mesa:");
        lblNombreMesa.setBounds(24, 21, 54, 20);
        getContentPane().add(lblNombreMesa);

        txtNombreMesa = new JTextField();
        txtNombreMesa.setBounds(88, 22, 204, 20);
        getContentPane().add(txtNombreMesa);
        txtNombreMesa.setColumns(10);

        JLabel lblPresidente = new JLabel("Presidente:");
        lblPresidente.setBounds(20, 51, 69, 20);
        getContentPane().add(lblPresidente);

        txtPresidente = new JTextField();
        txtPresidente.setBounds(88, 52, 204, 20);
        getContentPane().add(txtPresidente);
        txtPresidente.setColumns(10);

        JLabel lblSecretario = new JLabel("Secretario:");
        lblSecretario.setBounds(20, 79, 69, 20);
        getContentPane().add(lblSecretario);

        txtSecretario = new JTextField();
        txtSecretario.setBounds(88, 80, 204, 20);
        getContentPane().add(txtSecretario);
        txtSecretario.setColumns(10);

        JLabel lblUbicacion = new JLabel("Ubicación:");
        lblUbicacion.setBounds(20, 109, 69, 20);
        getContentPane().add(lblUbicacion);

        txtUbicacion = new JTextField();
        txtUbicacion.setBounds(88, 110, 204, 20);
        getContentPane().add(txtUbicacion);
        txtUbicacion.setColumns(10);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(317, 60, 90, 30);
        btnAgregar.addActionListener(this);
        getContentPane().add(btnAgregar);

        JButton btnNuevo = new JButton("Nuevo");
        btnNuevo.setBounds(317, 20, 90, 30);
        btnNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
        getContentPane().add(btnNuevo);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(317, 100, 90, 30);
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        getContentPane().add(btnCancelar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 149, 387, 266);
        getContentPane().add(scrollPane);

        table = new JTable();
        model = new DefaultTableModel(new Object[][]{}, new String[]{"Mesa", "Presidente", "Secretario", "Ubicación"});
        table.setModel(model);
        scrollPane.setViewportView(table);

        mostrarMesas();
    }

    private void mostrarMesas() {
        model.setRowCount(0); // Clear the table
        for (Mesa mesa : mesas) {
            Object[] row = {mesa.getNombreMesa(), mesa.getPresidente(), mesa.getSecretario(), mesa.getUbicacion()};
            model.addRow(row);
        }
    }

    private void limpiarCampos() {
        txtNombreMesa.setText("");
        txtPresidente.setText("");
        txtSecretario.setText("");
        txtUbicacion.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Agregar")) {
            String nombreMesa = txtNombreMesa.getText();
            String presidente = txtPresidente.getText();
            String secretario = txtSecretario.getText();
            String ubicacion = txtUbicacion.getText();

            if (nombreMesa.isEmpty() || presidente.isEmpty() || secretario.isEmpty() || ubicacion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                Mesa nuevaMesa = new Mesa();
                nuevaMesa.setNombreMesa(nombreMesa);
                nuevaMesa.setPresidente(presidente);
                nuevaMesa.setSecretario(secretario);
                nuevaMesa.setUbicacion(ubicacion);

                mesas.add(nuevaMesa);
                Object[] row = {nombreMesa, presidente, secretario, ubicacion};
                model.addRow(row);
                limpiarCampos();
            }
        }
    }
}



