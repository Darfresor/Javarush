package cryptoanalaiizer.application;

import cryptoanalaiizer.controller.MainController;
import cryptoanalaiizer.ui.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
//TODO добавить "демонстрационный режим". Заранее файл для ввода взять из ресурсов программы? А выход по умолчанию название файла и его создание?
//TODO при выборе выходного файла, нужно добавить возможно создать новый, а не только выбрать готовый?
//TODO оптимизация для работы с большими файлами
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
