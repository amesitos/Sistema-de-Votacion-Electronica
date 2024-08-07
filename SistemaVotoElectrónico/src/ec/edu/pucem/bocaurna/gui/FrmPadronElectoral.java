package ec.edu.pucem.bocaurna.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import ec.edu.pucem.bocaurna.models.Estudiante;
import ec.edu.pucem.bocaurna.models.Mesa;


public class FrmPadronElectoral extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JTable table;
    private DefaultTableModel model;
    private List<Mesa> mesas;
    public FrmPadronElectoral (List<Mesa> mesas, List<Estudiante> estudiantes, List<Estudiante> estudiantesDeMesa) {
        this.mesas = mesas;
        setTitle("Padrón electoral");
        setBounds(100, 100, 600, 400);
        getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 564, 306);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Cédula", "Nombres", "Apellidos", "Curso", "Mesa" }));
        scrollPane.setViewportView(table);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnCancelar.setBounds(248, 326, 90, 30);
        getContentPane().add(btnCancelar);
        model = (DefaultTableModel) table.getModel();

        addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {         
                System.out.println("PanelPadronElectoral cerrado");
            }
        });

        cargarDatosEnTabla();
    }

    private void cargarDatosEnTabla() {
        model.setRowCount(0);

        Set<String> combinacionesUnicas = new HashSet<>();

        for (Mesa mesa : mesas) {
            for (Estudiante estudiante : mesa.getEstudiantesDeMesa()) {
                String combinacion = estudiante.getNombres() + mesa.getNombreMesa();
                if (combinacionesUnicas.add(combinacion)) {
                    agregarFila(
                    		estudiante.getCedula(),
                    		estudiante.getNombres(),
                    		estudiante.getApellidos(),
                    		estudiante.getCurso().getNombreCurso(),
                    		mesa.getNombreMesa()); 
                    		
                }
            }
        }
    }


    private void agregarFila(String cedulaEstudiante, String nombreEstudiante, String apellidoEstudiante, String cursoEstudiante, String mesaEstudiante) {
        model.addRow(new Object[]{cedulaEstudiante, nombreEstudiante, apellidoEstudiante, cursoEstudiante, mesaEstudiante});
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
