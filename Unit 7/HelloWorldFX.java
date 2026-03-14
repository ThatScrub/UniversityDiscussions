package com.unit7discussion.unit7discussionjavafx;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;


public class HelloWorldFX extends Application {
    public void start(Stage stage) {

        ScrollPane scrollPane = new ScrollPane();
        BorderPane root = new BorderPane();


        //Sections
        VBox vertNav = new VBox(10);
        VBox content = new VBox(10);
        content.setPadding(new Insets(10, 10, 10, 10));
        vertNav.setPadding(new Insets(10));


        //Labels
        String defaultText = """
                Multiline String
                because sometimes there might need to be a massive wall of text to house certain elements
                
                
                and it also makes it easier to test how different elements resize and stuff
                """;
        Label label = new Label("");
        Label heading = new Label("Student Management System");
        Label subHeading = new Label("HOME");
        Label stackPaneLabel = new Label(defaultText);
        Label radioSelected = new Label("");

        //Radio Buttons
        RadioButton testRadio1 = new RadioButton("Test");
        RadioButton testRadio2 = new RadioButton("Another Test");
        testRadio1.setOnAction(event -> {testRadio2.setSelected(false); radioSelected.setText("Radio 1 Selected!");});
        testRadio2.setOnAction(event -> {testRadio1.setSelected(false); radioSelected.setText("Radio 2 Selected!");});

        //Buttons and Button styling
        Button homeButton = new Button("Home");
        Button resetButton = new Button("Reset");
        Button submitButton = new Button("Submit");
        homeButton.setMaxWidth(Double.MAX_VALUE);
        resetButton.setMaxWidth(Double.MAX_VALUE);

        //User input fields
        TextFlow textFlow = new TextFlow();
        TextField nameField = new TextField();
        nameField.setMaxWidth(Double.MAX_VALUE);
        nameField.setPromptText("Enter your name");

        //Button actions
        homeButton.setOnAction(event -> {label.setText("OUCH!"); subHeading.setText("AYYYY LMAO");});
        resetButton.setOnAction(event -> {label.setText(""); subHeading.setText("HOME"); stackPaneLabel.setText(defaultText);});
        submitButton.setOnAction(event -> {
            String name = nameField.getText();
            stackPaneLabel.setText("Hello, " + name + "!");
        });



        //Add the labels and buttons, the order dictates how they appear, starting from the top.
        content.getChildren().addAll(heading, subHeading, stackPaneLabel, testRadio1, testRadio2, radioSelected, nameField, submitButton);
        //Add labels and buttons to the other vertical box, used for 'navigation'
        vertNav.getChildren().addAll(label, homeButton, resetButton);
        //Wrap our 'content' section in a ScrollPane object to allow for larger things to be scrolled - or accommodate for resizing
        scrollPane.setContent(content);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); //always displays the vertical scrollbar

        //Set the alignment of sections within the root BorderPane object
        root.setLeft(vertNav); //Set left so looks like a Navigation Pane
        root.setCenter(scrollPane); // Center the 'content' pane so it can fill the remainder of the space

        //create Scene object which will display the BorderPane object
        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.setTitle("JavaFX Test");
        stage.show();
    }

    public static void main(String[] args) {
        launch(); // Run this Application.
    }
}
