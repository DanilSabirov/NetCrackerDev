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
import jdk.nashorn.internal.parser.DateParser;
import manager.Main;
import manager.controller.Editor;
import manager.controller.EditorController;
import manager.model.Sorting;
import manager.task.Task;

import java.io.IOException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

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
    }

    private void initPriority(){
        ArrayList<Integer> num = new ArrayList<>(11);
        for(int i = 0; i <= 10; i++){
            num.add(i);
        }
        priority.setItems(FXCollections.observableArrayList(num));
        priority.getSelectionModel().select(5);
    }

    public void show(String title){
        if(root == null){
            Runtime.getRuntime().exit(0);
        }
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
