package ec.edu.pucem.bocaurna.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

import ec.edu.pucem.bocaurna.models.Candidato;
import ec.edu.pucem.bocaurna.models.Curso;
import ec.edu.pucem.bocaurna.models.Estudiante;
import ec.edu.pucem.bocaurna.models.Mesa;


public class FrmMenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private FrmCrearCurso frmCrearCurso;
	private FrmCrearEstudiante frmCrearEstudiante;
	private FrmCrearCandidato frmCrearCandidato;
	private FrmCrearMesa frmCrearMesa;
	private FrmPadronElectoral frmPadronElectoral;
	private FrmEntradaSufragio frmEntradaSufragio;
	private FrmEstudianteAMesa frmEstudianteAMesa;
	private FrmPanelBarras frmPanelBarras;
	private JPanel contentPane;
	private List <Candidato> candidatos;
	private List <Curso> cursos;
	private List <Estudiante> estudiantes;
	private List<Estudiante> estudiantesMesa;
	private List <Mesa> mesas;
    private Map<Estudiante, Mesa> asignacionesDeMesa;


	
	public FrmMenuPrincipal() {
		setTitle("Sistema de Voto Electrónico de Consejo Estudiantil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		candidatos = new ArrayList<>(); 
		cursos = new ArrayList<>(); 
		estudiantes = new ArrayList<>();
		mesas = new ArrayList<>(); 
		estudiantesMesa = new ArrayList<>();
        asignacionesDeMesa = new HashMap<>();


		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnArchivo.setForeground(new Color(0, 0, 0));
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnAdministracion = new JMenu("Administración");
		mnAdministracion.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnAdministracion);
		
		
		JMenuItem mntmCursos = new JMenuItem("Crear cursos");
		mntmCursos.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mntmCursos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frmCrearCurso == null || frmCrearCurso.isClosed()) { // Si el formulario de "Crear Cliente" no existe, crear uno
                    frmCrearCurso = new FrmCrearCurso(cursos); // y agregarlo al desktopPane.
                    contentPane.add(frmCrearCurso);
                    frmCrearCurso.setVisible(true);
                    
                    // Bloque de código para centrar el formulario "Crear Cliente"
                    Dimension desktopSize = contentPane.getSize();
                    Dimension frameSize = frmCrearCurso.getSize();
                    frmCrearCurso.setLocation((desktopSize.width - frameSize.width) / 2,
                                                (desktopSize.height - frameSize.height) / 2);
                }
            }
		});
		mntmCursos.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnAdministracion.add(mntmCursos);
        
        
		JMenuItem mntmEstudiantes = new JMenuItem("Registrar estudiantes");
		mntmEstudiantes.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mntmEstudiantes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frmCrearEstudiante == null || frmCrearEstudiante.isClosed()) { // Si el formulario de "Crear Cliente" no existe, crear uno
                    frmCrearEstudiante = new FrmCrearEstudiante(cursos, estudiantes); // y agregarlo al desktopPane.
                    contentPane.add(frmCrearEstudiante);
                    frmCrearEstudiante.setVisible(true);
                    
                    // Bloque de código para centrar el formulario "Crear Cliente"
                    Dimension desktopSize = contentPane.getSize();
                    Dimension frameSize = frmCrearEstudiante.getSize();
                    frmCrearEstudiante.setLocation((desktopSize.width - frameSize.width) / 2,
                                                (desktopSize.height - frameSize.height) / 2);
                }
            }
		});
		mntmEstudiantes.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnAdministracion.add(mntmEstudiantes);
		
		
		JMenuItem mntmCandidatos = new JMenuItem("Registrar candidatos");
		mntmCandidatos.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mntmCandidatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frmCrearCandidato == null || frmCrearCandidato.isClosed()) { // Si el formulario de "Crear Cliente" no existe, crear uno
                    frmCrearCandidato = new FrmCrearCandidato(candidatos, estudiantes); // y agregarlo al desktopPane.
                    contentPane.add(frmCrearCandidato);
                    frmCrearCandidato.setVisible(true);
                    
                    // Bloque de código para centrar el formulario "Crear Cliente"
                    Dimension desktopSize = contentPane.getSize();
                    Dimension frameSize = frmCrearCandidato.getSize();
                    frmCrearCandidato.setLocation((desktopSize.width - frameSize.width) / 2,
                                                (desktopSize.height - frameSize.height) / 2);
                }
            }
		});
		mntmCandidatos.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnAdministracion.add(mntmCandidatos);
		
		
		JMenuItem mntmMesas = new JMenuItem("Crear mesas");
		mntmMesas.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mntmMesas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frmCrearMesa == null || frmCrearMesa.isClosed()) { // Si el formulario de "Crear Cliente" no existe, crear uno
                    frmCrearMesa = new FrmCrearMesa(mesas); // y agregarlo al desktopPane.
                    contentPane.add(frmCrearMesa);
                    frmCrearMesa.setVisible(true);
                    
                    // Bloque de código para centrar el formulario "Crear Cliente"
                    Dimension desktopSize = contentPane.getSize();
                    Dimension frameSize = frmCrearMesa.getSize();
                    frmCrearMesa.setLocation((desktopSize.width - frameSize.width) / 2,
                                                (desktopSize.height - frameSize.height) / 2);
                }
            }
        });
		mntmMesas.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnAdministracion.add(mntmMesas);
		
				
				JMenuItem mntmEstudianteAMesa = new JMenuItem("Asignar estudiante a mesa");
				mntmEstudianteAMesa.setFont(new Font("Segoe UI", Font.BOLD, 16));
				mntmEstudianteAMesa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frmEstudianteAMesa == null || frmEstudianteAMesa.isClosed()) { // Si el formulario de "Crear Cliente" no existe, crear uno
                    frmEstudianteAMesa = new FrmEstudianteAMesa(mesas, estudiantes); // y agregarlo al desktopPane.
                    contentPane.add(frmEstudianteAMesa);
                    frmEstudianteAMesa.setVisible(true);
                    
                    // Bloque de código para centrar el formulario "Crear Cliente"
                    Dimension desktopSize = contentPane.getSize();
                    Dimension frameSize = frmEstudianteAMesa.getSize();
                    frmEstudianteAMesa.setLocation((desktopSize.width - frameSize.width) / 2,
                                                (desktopSize.height - frameSize.height) / 2);
                }
            }
					
		});
		mntmEstudianteAMesa.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnAdministracion.add(mntmEstudianteAMesa);

		
		JMenu mnProceso = new JMenu("Proceso");
		mnProceso.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnProceso);
		
		JMenuItem mntmSufragar = new JMenuItem("Sufragio");
		mntmSufragar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mntmSufragar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frmEntradaSufragio == null || frmEntradaSufragio.isClosed()) { // Si el formulario de "Crear Cliente" no existe, crear uno
                    frmEntradaSufragio = new FrmEntradaSufragio(FrmMenuPrincipal.this); // y agregarlo al desktopPane.
                    contentPane.add(frmEntradaSufragio);
                    frmEntradaSufragio.setVisible(true);
                    
                    // Bloque de código para centrar el formulario "Crear Cliente"
                    Dimension desktopSize = contentPane.getSize();
                    Dimension frameSize = frmEntradaSufragio.getSize();
                    frmEntradaSufragio.setLocation((desktopSize.width - frameSize.width) / 2,
                                                (desktopSize.height - frameSize.height) / 2);
                }
            }
		});
		mntmSufragar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnProceso.add(mntmSufragar);
		
				
		JMenu mnReportes = new JMenu("Reportes");
		mnReportes.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnReportes);
		
		JMenuItem mntmPadron = new JMenuItem("Padrón electoral");
		mntmPadron.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mntmPadron.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frmPadronElectoral == null || frmPadronElectoral.isClosed()) { // Si el formulario de "Crear Cliente" no existe, crear uno
                    frmPadronElectoral = new FrmPadronElectoral(mesas, estudiantes, estudiantes); // y agregarlo al desktopPane.
                    contentPane.add(frmPadronElectoral);
                    frmPadronElectoral.setVisible(true);
                    
                    // Bloque de código para centrar el formulario "Crear Cliente"
                    Dimension desktopSize = contentPane.getSize();
                    Dimension frameSize = frmPadronElectoral.getSize();
                    frmPadronElectoral.setLocation((desktopSize.width - frameSize.width) / 2,
                                                (desktopSize.height - frameSize.height) / 2);
                }
            }
		});
		mntmPadron.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnReportes.add(mntmPadron);
		
		
		JMenuItem mntmResultadosEnGrfico = new JMenuItem("Resultados generales en gráficos de barras");
		mntmResultadosEnGrfico.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mntmResultadosEnGrfico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frmPanelBarras == null || frmPanelBarras.isClosed()) { // Si el formulario de "Crear Cliente" no existe, crear uno
                    frmPanelBarras = new FrmPanelBarras(candidatos); // y agregarlo al desktopPane.
                    contentPane.add(frmPanelBarras);
                    frmPanelBarras.setVisible(true);
                    
                    // Bloque de código para centrar el formulario "Crear Cliente"
                    Dimension desktopSize = contentPane.getSize();
                    Dimension frameSize = frmPanelBarras.getSize();
                    frmPanelBarras.setLocation((desktopSize.width - frameSize.width) / 2,
                                                (desktopSize.height - frameSize.height) / 2);
                }
            }
		});
		mntmResultadosEnGrfico.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnReportes.add(mntmResultadosEnGrfico);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	}

	
	public void abrirProcesoSufragio(String cedulaEstudiante) {
	    FrmProcesoSufragio procesoSufragio = new FrmProcesoSufragio(this, cedulaEstudiante);
	    procesoSufragio.setLocation(100, 100);
	    contentPane.add(procesoSufragio);
	    procesoSufragio.setVisible(true);
	}


	public void abrirFrmEntradaSufragio() {
        FrmEntradaSufragio frmEntradaSufragio = new FrmEntradaSufragio(this);
        frmEntradaSufragio.setVisible(true);
        getContentPane().add(frmEntradaSufragio);
        try {
            frmEntradaSufragio.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }
	
	public void abrirFrmTerminarSufragio() {
        FrmTerminarSufragio frmTerminarSufragio = new FrmTerminarSufragio(this);
        frmTerminarSufragio.setVisible(true);
        getContentPane().add(frmTerminarSufragio);
        try {
            frmTerminarSufragio.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public Mesa getMesaDeEstudiante(Estudiante estudiante) {
		return asignacionesDeMesa.get(estudiante);
	}

	public Mesa getMesaPorNombre(String nombreMesa) {
		for (Mesa mesa : mesas) {
			if (mesa.getNombreMesa().equals(nombreMesa)) {
				return mesa;
			}
		}
		return null; 
	}

	public void asignarMesaAEstudiante(Estudiante estudiante, Mesa mesa) {
		asignacionesDeMesa.put(estudiante, mesa);
	}


	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public Estudiante buscarEstudiantePorCedula(String cedulaEstudiante) {
		for (Estudiante estudiante : estudiantes) {
			if (estudiante.getCedula().equals(cedulaEstudiante)) {
				return estudiante;
			}
		}
		return null; 
	}

	public void registrarVoto(String cedulaEstudiante, Candidato candidato) {
		Estudiante estudiante = buscarEstudiantePorCedula(cedulaEstudiante);
		if (estudiante != null) {
			estudiante.setCandidatoVotado(candidato);
			estudiante.setEstado(true); // Marca al estudiante como que ya votó
			candidato.aumentarVotos();
		}
	}

}

