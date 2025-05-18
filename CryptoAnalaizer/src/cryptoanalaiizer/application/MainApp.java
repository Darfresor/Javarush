package cryptoanalaiizer.application;

import cryptoanalaiizer.controller.MainController;
import cryptoanalaiizer.ui.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        MainView view= new MainView();
        Scene scene = view.createScene();
        new MainController(view);

        stage.setTitle("Криптоанализатор");
        stage.setScene(scene);
        stage.show();
    }

    ;

    public static void main(String[] args) {
        launch(args);
    }
}
