package ec.edu.pucem.bocaurna.gui;

import java.awt.Color;
import java.util.List;
import javax.swing.JInternalFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import ec.edu.pucem.bocaurna.models.Candidato;


public class FrmPanelBarras extends JInternalFrame {

    private static final long serialVersionUID = 1L;

    public FrmPanelBarras(List <Candidato> candidatos) {
    	setBackground(new Color(0, 255, 255));
    	getContentPane().setBackground(new Color(0, 255, 255));
    	setClosable(true);
        setTitle("Resultados gráficos en barras");
        setBounds(100, 100, 617, 393);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Candidato candidato : candidatos) {
            dataset.addValue(candidato.getVotos(), "Votos", candidato.getNombres());
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Resultados de Votaciones", 
                "Candidatos", 
                "Votos",
                dataset 
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(new Color(128, 128, 192));
        getContentPane().add(chartPanel);
    }
}
