package com.example.painter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PaintController {

    // ændret kode fra bogen
    private final int SMALL = 2;
    private final int MEDIUM = 4;
    private final int LARGE = 6;
    private int penRadius = MEDIUM;
    // -

    @FXML
    private RadioButton blackRadioButton;

    @FXML
    private RadioButton blueRadioButton;

    @FXML
    private Button clearButton;

    @FXML
    private ToggleGroup colourToggleGroup;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton greenRadioButton;

    @FXML
    private RadioButton largeRadioButton;

    @FXML
    private RadioButton mediumRadioButton;

    @FXML
    private RadioButton orangeRadioButton;

    @FXML
    private RadioButton purpleRadioButton;

    @FXML
    private RadioButton redRadioButton;

    @FXML
    private ToggleGroup sizeToggleGroup;

    @FXML
    private RadioButton smallRadioButton;

    @FXML
    private Button undoButton;

    @FXML
    private RadioButton yellowRadioButton;

    private Paint brushColor = Color.BLACK;

    public void initialize() {
        blackRadioButton.setUserData(Color.BLACK);
        redRadioButton.setUserData(Color.RED);
        orangeRadioButton.setUserData(Color.rgb(255,165,0));
        yellowRadioButton.setUserData(Color.rgb(255,255,0));
        greenRadioButton.setUserData(Color.LIMEGREEN);
        blueRadioButton.setUserData(Color.DEEPSKYBLUE);
        purpleRadioButton.setUserData(Color.rgb(138,43,226));

        // ændret kode fra bogen
        smallRadioButton.setUserData(SMALL);
        mediumRadioButton.setUserData(MEDIUM);
        largeRadioButton.setUserData(LARGE);
        // -
    }



    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void colourRadioButtonSelected(ActionEvent event) {
        brushColor = (Color) colourToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if(!(event.getX() < 0 || event.getY() < 0 || event.getX() > drawingAreaPane.getWidth() || event.getY() > drawingAreaPane.getHeight())) {
            Circle newCircle = new Circle(event.getX(), event.getY(), penRadius, brushColor);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }

    @FXML
    void sizeRadioButtonSelected(ActionEvent event) {
        penRadius = Integer.parseInt(sizeToggleGroup.getSelectedToggle().getUserData().toString());
    }

    @FXML
    void undoButtonPressed(ActionEvent event) {
        int count = drawingAreaPane.getChildren().size();
        if (count > 0){
            drawingAreaPane.getChildren().remove(count - 1);
        }
    }

}
