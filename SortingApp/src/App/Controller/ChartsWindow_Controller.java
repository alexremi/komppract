package App.Controller;

import App.Model.RadixSorter;
import App.Model.PatienceSorter;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class ChartsWindow_Controller
{
    @FXML AnchorPane sortTimeTab;
    private BarChart sortTime_chart;

    @FXML AnchorPane sortComparisonTab;
    private BarChart sortComparison_chart;

    @FXML AnchorPane sortExchangesTab;
    private BarChart sortExchanges_chart;

    @FXML
    void initialize() throws Exception {
        sortTime_chart = initSortChart("Время");
        sortExchanges_chart = initSortChart("Перестановки");
        sortComparison_chart = initSortChart("Сравнения");

        sortTimeTab.getChildren().add(sortTime_chart);
        sortExchangesTab.getChildren().add(sortExchanges_chart);
        sortComparisonTab.getChildren().add(sortComparison_chart);
        AnchorPane.setTopAnchor(sortTime_chart, 0.);
        AnchorPane.setTopAnchor(sortExchanges_chart, 0.);
        AnchorPane.setTopAnchor(sortComparison_chart, 0.);
        AnchorPane.setBottomAnchor(sortTime_chart, 0.);
        AnchorPane.setBottomAnchor(sortExchanges_chart, 0.);
        AnchorPane.setBottomAnchor(sortComparison_chart, 0.);
        AnchorPane.setLeftAnchor(sortTime_chart, 0.);
        AnchorPane.setLeftAnchor(sortExchanges_chart, 0.);
        AnchorPane.setLeftAnchor(sortComparison_chart, 0.);
        AnchorPane.setRightAnchor(sortTime_chart, 0.);
        AnchorPane.setRightAnchor(sortExchanges_chart, 0.);
        AnchorPane.setRightAnchor(sortComparison_chart, 0.);

        List<File> sequenceFiles = MainWindow_Controller.getSequenceFiles();

        XYChart.Series RadixSortTimeResult = new XYChart.Series();
        RadixSortTimeResult.setName("RadixSort");

        XYChart.Series RadixSortExchangesResult = new XYChart.Series();
        RadixSortExchangesResult.setName("RadixSort");

        XYChart.Series RadixSortComparisonResult = new XYChart.Series();
        RadixSortComparisonResult.setName("RadixSort");

        int[] sequence;
        RadixSorter radixSorter = new RadixSorter();

        sortTime_chart.getData().add(RadixSortTimeResult);
        sortExchanges_chart.getData().add(RadixSortExchangesResult);
        sortComparison_chart.getData().add(RadixSortComparisonResult);

        for(File file : sequenceFiles) {
            sequence = readSequenceFromFile(file.getAbsolutePath());
            radixSorter.sort(sequence);
            RadixSortTimeResult.getData().add(new XYChart.Data(file.getName(), radixSorter.getTime()));
            RadixSortExchangesResult.getData().add(new XYChart.Data(file.getName(), radixSorter.getExchanges()));
            RadixSortComparisonResult.getData().add(new XYChart.Data(file.getName(), radixSorter.getComparison()));
        }



        XYChart.Series PatienceSortTimeResult = new XYChart.Series();
        PatienceSortTimeResult.setName("PatienceSort");

        XYChart.Series PatienceSortExchangesResult = new XYChart.Series();
        PatienceSortExchangesResult.setName("PatienceSort");

        XYChart.Series PatienceSortComparisonResult = new XYChart.Series();
        PatienceSortComparisonResult.setName("PatienceSort");

        PatienceSorter patienceSorter = new PatienceSorter();

        sortTime_chart.getData().add(PatienceSortTimeResult);
        sortExchanges_chart.getData().add(PatienceSortExchangesResult);
        sortComparison_chart.getData().add(PatienceSortComparisonResult);

        for(File file : sequenceFiles) {
            sequence = readSequenceFromFile(file.getAbsolutePath());
            patienceSorter.sort(sequence);
            PatienceSortTimeResult.getData().add(new XYChart.Data(file.getName(), patienceSorter.getTime()));
            PatienceSortExchangesResult.getData().add(new XYChart.Data(file.getName(), patienceSorter.getExchanges()));
            PatienceSortComparisonResult.getData().add(new XYChart.Data(file.getName(), patienceSorter.getComparison()));
        }

        /*sortTime_chart.setMinSize(1200, 720);
        sortExchanges_chart.setMinSize(1200, 720);
        sortComparison_chart.setMinSize(1200, 720);*/
    }

    private BarChart<String,Number> initSortChart(String name) {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Файл");
        yAxis.setLabel(name);
        return new BarChart<String,Number>(xAxis,yAxis);
    }

    private int[] readSequenceFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        byte[] bytes = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(bytes);
        fis.close();
        String[] valueStr = new String(bytes).trim().split("\\s+");
        int[] result = new int[valueStr.length];
        for (int i = 0; i < valueStr.length; i++)
            result[i] = Integer.parseInt(valueStr[i]);

        return result;
    }
 }
