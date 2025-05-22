package cryptoanalaiizer.controller;

import cryptoanalaiizer.model.Cipher;
import cryptoanalaiizer.model.DefaultRussianAlphabet;
import cryptoanalaiizer.ui.MainView;
import cryptoanalaiizer.utils.FileManager;
import cryptoanalaiizer.utils.Validator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Arrays;

public class MainController {
    MainView view;

    public MainController(MainView view) {
        this.view = view;
        setupListeners();
    }

    private void showAlertWindow(String head, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText(head);
        alert.setContentText(content);
        alert.showAndWait();
    }

    ;

    private boolean isStartButtonAvailability() {
        if (view.getFilePathFieldOut().getText() != null
                && view.getFilePathFieldIn().getText() != null
                && !view.getFilePathFieldIn().getText().isEmpty()
                && !view.getFilePathFieldOut().getText().isEmpty()
        ) {
            return true;
        } else {
            return false;
        }
    }

    private void setupListeners() {
        log("Программа запущена");
        view.getSelectFileButtonIn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                FileChooser fileChooser = new FileChooser();
                File file = fileChooser.showOpenDialog(new Stage());
                if (file != null) {
                    boolean isValidExtension = Validator.isValidExtension(file.getAbsolutePath());
                    if (!isValidExtension) {
                        view.getFilePathFieldIn().setText("");
                        showAlertWindow("Неподдерживаемый файл", "Пожалуйста, выберите файл с расширением .txt");
                    } else {
                        view.getFilePathFieldIn().setText(file.getAbsolutePath());
                        log("Выбран файл с входными данными: " + file);
                    }

                }
                if (isStartButtonAvailability()) {
                    view.getStartButton().setDisable(false);
                }
            }


        });
        view.getSelectFileButtonOut().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                FileChooser fileChooser = new FileChooser();
                File file = fileChooser.showOpenDialog(new Stage());

                if (file != null) {
                    boolean isValidExtension = Validator.isValidExtension(file.getAbsolutePath());
                    if (!isValidExtension) {
                        view.getFilePathFieldOut().setText("");
                        showAlertWindow("Неподдерживаемый файл", "Пожалуйста, выберите файл с расширением .txt");
                    } else {
                        view.getFilePathFieldOut().setText(file.getAbsolutePath());
                        log("Выбран файл с выходными данными: " + file);
                    }
                }
                ;
                if (isStartButtonAvailability()) {
                    view.getStartButton().setDisable(false);
                }
            }
        });
        view.getEncryptCheckBox().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (view.getEncryptCheckBox().isSelected()) {
                    view.getDeryptCheckBox().setSelected(false);
                }
                ;
            }
        });

        view.getDeryptCheckBox().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (view.getDeryptCheckBox().isSelected()) {
                    view.getEncryptCheckBox().setSelected(false);
                }
                ;
            }
        });

        view.getStartButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    //TODO добавить отображение ошибок в лог, если это что-то непредвиденное в том числе
                    int key = view.getSpinner().getValue();
                    log("Пользователь установил значение ключа = " + key);
                    log("Начато чтение данных из \"" + view.getFilePathFieldIn().getText() + "\"");
                    String inText = FileManager.readFile(view.getFilePathFieldIn().getText());
                    log("Чтение данных завершено.");
                    Cipher cipher = new Cipher(DefaultRussianAlphabet.cyrillicValues());
                    String resultText = "";
                    if (view.getEncryptCheckBox().isSelected()) {
                        log("Начат процесс зашифровки данных полученных из файла.");
                        resultText = cipher.encrypt(inText, key);
                        log("Завершен процесс зашифровки данных полученных из файла.");
                        throw new RuntimeException("djd djdjdjd");
                    } else {
                        log("Начат процесс расшифровки данных полученных из файла.");
                        resultText = cipher.decrypt(inText, key);
                        log("Завершен процесс расшифровки данных полученных из файла.");
                    }
                    ;
                    log("Начата запись в файл \"" + view.getFilePathFieldOut().getText() + "\"");
                    FileManager.writeFile(resultText, view.getFilePathFieldOut().getText());
                    log("Запись данных завершена");
                } catch (RuntimeException err) {
                    err.printStackTrace();
                    showAlertWindow("Призошла ошибка", "Нажмите ОК и посмотрите подробности в логе");
                    logError("В работе программы произошла ошибка!");
                    logError(err.getMessage());
                    logError(Arrays.toString(err.getStackTrace()));
                }
            }
        });

    }

    private void log(String message) {
        view.getlogArea().appendText(message + "\n");
    }

    private void logError(String message) {
        view.getlogArea().setStyle("-fx-text-fill: red;");
        view.getlogArea().appendText(message + "\n");
        // view.getlogArea().setStyle("-fx-text-fill: black;");
    }
}
