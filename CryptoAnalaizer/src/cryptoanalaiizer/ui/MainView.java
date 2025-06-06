package cryptoanalaiizer.ui;

import cryptoanalaiizer.model.DefaultRussianAlphabet;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainView {
    private TextArea logArea;
    private Button selectFileButtonIn;
    private Button selectFileButtonOut;
    private TextField filePathFieldIn;
    private TextField filePathFieldOut;
    private CheckBox encryptCheckBox;
    private CheckBox deryptCheckBox;
    private Spinner<Integer> key;
    private Button startButton;


    public Scene createScene() {
        //TODO вынести в константы названия кнопок
        VBox selectionPanelAll = getPathFilePanel();
        VBox controlPanelAll = getControlPanelAll();
        ScrollPane logPane = getLogPane();

        BorderPane root = new BorderPane();
        root.setTop(selectionPanelAll);
        root.setCenter(controlPanelAll);
        root.setBottom(logPane);
        return new Scene(root, 800, 800);
    }


    private VBox getControlPanelAll() {
        Label keyTip = new Label("Укажите длину ключа:");
        HBox.setMargin(keyTip, new Insets(0, 0, 0, 20));
        int minKeyLenght = 1;
        int maxKeyLength = DefaultRussianAlphabet.values().length - 1;
        key = new Spinner<>(minKeyLenght, maxKeyLength, 1);
        HBox keyInfo = new HBox(10, keyTip, key);

        encryptCheckBox = new CheckBox("Шифровать");
        encryptCheckBox.setSelected(true);
        HBox.setMargin(encryptCheckBox, new Insets(0, 0, 0, 20));
        deryptCheckBox = new CheckBox("Расшифровать");
        deryptCheckBox.setSelected(false);
        HBox.setMargin(deryptCheckBox, new Insets(0, 0, 0, 20));
        HBox controlPanelCheck = new HBox(10, encryptCheckBox, deryptCheckBox);

        startButton = new Button("Запустить обработку");
        startButton.setDisable(true);
        HBox.setMargin(startButton, new Insets(0, 0, 0, 20));
        HBox controlPanelStart = new HBox(10, startButton);

        VBox controlPanelAll = new VBox(10, keyInfo, controlPanelCheck, controlPanelStart);
        BorderPane.setMargin(controlPanelAll, new Insets(10, 0, 0, 0)); // (top, right, bottom, left)
        return controlPanelAll;
    }

    private VBox getPathFilePanel() {
        Label labelForInput = new Label("Путь к файлу с входными данными:");
        HBox.setMargin(labelForInput, new Insets(0, 0, 0, 20));
        filePathFieldIn = new TextField();
        filePathFieldIn.setEditable(false);
        selectFileButtonIn = new Button("Выбрать файл");

        Label labelForOutput = new Label("Путь к файлу с выходными данными:");
        HBox.setMargin(labelForOutput, new Insets(0, 0, 0, 20));
        filePathFieldOut = new TextField();
        filePathFieldOut.setEditable(false);
        selectFileButtonOut = new Button("Выбрать файл");


        HBox selectionPanelIn = new HBox(10, labelForInput, filePathFieldIn, selectFileButtonIn);
        HBox selectionPanelOut = new HBox(10, labelForOutput, filePathFieldOut, selectFileButtonOut);
        VBox selectionPanelAll = new VBox(10, selectionPanelIn, selectionPanelOut);
        return selectionPanelAll;
    }

    private ScrollPane getLogPane() {
        logArea = new TextArea();
        logArea.setEditable(false);
        logArea.setWrapText(true);
        logArea.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        ScrollPane logScrollPane = new ScrollPane(logArea);
        logScrollPane.setFitToWidth(true);
        logScrollPane.setFitToHeight(true);
        return logScrollPane;
    }

    public CheckBox getEncryptCheckBox() {
        return encryptCheckBox;
    }

    public CheckBox getDeryptCheckBox() {
        return deryptCheckBox;
    }

    public Button getStartButton() {
        return startButton;
    }

    public TextArea getlogArea() {
        return logArea;
    }

    public Button getSelectFileButtonIn() {
        return selectFileButtonIn;
    }

    public TextField getFilePathFieldIn() {
        return filePathFieldIn;
    }

    public Button getSelectFileButtonOut() {
        return selectFileButtonOut;
    }

    public TextField getFilePathFieldOut() {
        return filePathFieldOut;
    }

    public Spinner<Integer> getSpinner() {
        return key;
    }
}
