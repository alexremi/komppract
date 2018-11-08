package App.Controller;

import App.Model.Constants;
import App.Model.SequenceGenerator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainWindow_Controller
{
    @FXML private AnchorPane generationTab;
    @FXML private ChoiceBox sequenceType_choiceBox;
    @FXML private TextField elementsCount_textField;
    @FXML private Button generateSequence_button;
    @FXML private TextField Rad_textField;

    @FXML private Button openDialog_button;
    @FXML private TextArea selectedFilesList_textArea;
    @FXML private Button startExperiment_button;

    private static String sequenceType;
    public static String getSequenceType() { return sequenceType; }

    private static int elementsCount;
    public static int getElementsCount() { return elementsCount; }

    private static int radCount;
    public static int getRadCount() { return radCount; }

    private static List<File> sequenceFiles;
    public static List<File> getSequenceFiles() { return sequenceFiles; }

    @FXML
    void initialize()
    {
        //Начальные значения
        sequenceType = "Up";
        elementsCount = 0;
        radCount = 0;
        final FileChooser fileChooser = new FileChooser();
        initFileChooser(fileChooser);
        sequenceType_choiceBox.getItems().addAll("Up", "Down", "Random", "Repeatable");
        sequenceType_choiceBox.setValue("Up");

        //Обработка событий
        generateSequence_button.setOnAction(actionEvent -> generateSequence());

        generationTab.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().getName().equals("Enter")) generateSequence();
        });

        openDialog_button.setOnAction(actionEvent -> {
            System.out.println("OpenDialogButtonPressed");

            sequenceFiles = fileChooser.showOpenMultipleDialog(openDialog_button.getScene().getWindow());
            printFileListInTextArea(sequenceFiles, selectedFilesList_textArea);
        });

        startExperiment_button.setOnAction(actionEvent -> {
            System.out.println("StartExperimentButtonPressed");

            if(sequenceFiles != null && !sequenceFiles.isEmpty()) {
                //sort
                loadChartsWindow();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Выберите хотя бы один файл");
                alert.showAndWait();
            }
        });
    }

    //Внутренние функции
    private void generateSequence() {
        sequenceType = sequenceType_choiceBox.getValue().toString();

        try { elementsCount = Integer.parseInt(elementsCount_textField.getText()); }
        catch (NumberFormatException e) {elementsCount = 0;}

        if(elementsCount < Constants.MIN_ELEMENTS || elementsCount > Constants.MAX_ELEMENTS) {
            elementsCount = 0;
            elementsCount_textField.setText("");
        }
        try { radCount = Integer.parseInt(Rad_textField.getText()); }
        catch (NumberFormatException e) {radCount = 0;}

        /*if(radCount < Constants.MIN_RAD || radCount > Constants.MAX_RAD) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Невозможно сгенерировать последовательность");
            alert.setHeaderText("Ошибка");
            alert.setContentText("Проверьте введённые данные");
            alert.showAndWait();
        }*/

        System.out.println("Generation( ST: " + sequenceType + " EC: " + elementsCount +"RC: " +  radCount + " )...");

        if ((elementsCount > 0)&&(radCount >= Constants.MIN_RAD) &&( radCount <= Constants.MAX_RAD)) SequenceGenerator.generateSequence(sequenceType, elementsCount, radCount);
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Невозможно сгенерировать последовательность");
            alert.setHeaderText("Ошибка");
            alert.setContentText("Проверьте введённые данные");
            alert.showAndWait();
        }
    }

    private void initFileChooser(FileChooser fileChooser) {
        fileChooser.setTitle("Последовательности");
        fileChooser.getExtensionFilters().addAll(

                new FileChooser.ExtensionFilter("UpSequence", "*.ups"),
                new FileChooser.ExtensionFilter("DownSequence", "*.dns"),
                new FileChooser.ExtensionFilter("RandomSequence", "*.rms"),
                new FileChooser.ExtensionFilter("RepeatableSequence", "*.res"),
                new FileChooser.ExtensionFilter("All", "*.*"));

    }

    private void printFileListInTextArea(List<File> files, TextArea textArea) {
        textArea.clear();
        if (files != null && !files.isEmpty())
            for (File file : files) { textArea.appendText(file.getName() + "\n"); }
    }

    private void loadChartsWindow() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/App/View/ChartsWindow_View.fxml"));

        try { loader.load(); }
        catch (IOException e) { e.printStackTrace(); }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle(Constants.CHARTWINDOW_NAME);
        stage.setResizable(true);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.centerOnScreen();
        stage.show();
    }
}


