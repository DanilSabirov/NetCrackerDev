package manager.view;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import manager.Main;
import manager.controller.Editor;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Editor window.
 */

public class EditorView {
    @FXML
    public TextField name;

    @FXML
    public TextArea description;

    @FXML
    public DatePicker endDate;

    @FXML
    public ChoiceBox<Integer> priority;

    @FXML
    public ChoiceBox<Integer> hours;

    @FXML
    public ChoiceBox<Integer> minutes;

    @FXML
    public ColorPicker color;

    @FXML
    public Button saver;


    private Parent root;

    private FXMLLoader fxmlLoader;

    private Editor controller;

    private Stage dialogStage;

    public EditorView(Editor controller) {
        fxmlLoader = new FXMLLoader(getClass().getResource("fxml/editor.fxml"));
        fxmlLoader.setController(this);
        this.controller = controller;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        initPriority();
        initTime();
    }

    private void initPriority(){
        ArrayList<Integer> num = new ArrayList<>(11);
        for(int i = 0; i <= 10; i++){
            num.add(i);
        }
        priority.setItems(FXCollections.observableArrayList(num));
        priority.getSelectionModel().select(5);
    }

    private void initTime(){
        ArrayList<Integer> hours = new ArrayList<>(24);
        ArrayList<Integer> minutes = new ArrayList<>(60);
        for(int i = 0; i < 24; i++){
            hours.add(i);
        }
        for(int i = 0; i < 60; i++){
            minutes.add(i);
        }
        this.hours.setItems(FXCollections.observableArrayList(hours));
        this.minutes.setItems(FXCollections.observableArrayList(minutes));
        this.hours.getSelectionModel().select(0);
        this.minutes.getSelectionModel().select(0);
    }

    /**
     * Shows editor window.
     */
    public void show(String title){
        dialogStage = new Stage();
        dialogStage.setTitle(title);
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(Main.getStage());
        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.setResizable(false);
        dialogStage.showAndWait();
    }

    @FXML
    private void onClickSave(ActionEvent actionEvent){
        if(name.getText().length() != 0 || description.getText().length() != 0){
            controller.save();
            dialogStage.close();
        }
    }

}
