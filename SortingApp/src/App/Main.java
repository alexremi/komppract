package App;

import App.Model.Constants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("View/MainWindow_View.fxml"));
        primaryStage.setTitle(Constants.APPLICATION_NAME);
        primaryStage.setScene(new Scene(root, Constants.MAIN_WINDOW_WIDTH, Constants.MAIN_WINDOW_HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}

