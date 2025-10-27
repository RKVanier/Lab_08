//https://github.com/RKVanier/Lab_08.git
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab02_rayankhales;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.*; 
import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 *
 * @author 6241246
 */
public class Lab8 extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    private int current = 0;
    private Boolean isRunning = false;
    private double time = 2000;
    
    @Override
    public void start(Stage primarystage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 250, 500);
        primarystage.setTitle("Java Games");
        primarystage.show();
        VBox middle = new VBox();
        
        Label top = new Label("Game Cycle");
        BorderPane.setAlignment(top, Pos.BOTTOM_CENTER);
        
        Button playPause = new Button("Play");
        Button speedUp = new Button("Speed Up");
        Button speedDown = new Button("Speed Down");
        HBox speed = new HBox(10, speedUp, speedDown);
        speed.setAlignment(Pos.TOP_CENTER);
        VBox buttons = new VBox(10, playPause, speed);
        buttons.setAlignment(Pos.TOP_CENTER);
        root.setBottom(buttons);
        
        Label lblImage = new Label();
        root.setTop(top);
        
        middle.getChildren().add(lblImage);
        middle.setAlignment(Pos.CENTER);
        root.setCenter(middle);
        
        String path = "file:src/images/";
        Image[] images = new Image[20];
        for (int i = 0; i < 20; i++) {
            int imageNumber = 101 + i;
            images[i] = new Image(path + imageNumber + ".jpg");
        }
        lblImage.setGraphic(new ImageView(images[0]));
        
        FadeTransition fadeIn = new FadeTransition(new Duration(time / 2), lblImage);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        
        FadeTransition fadeOut = new FadeTransition(new Duration(time / 2), lblImage);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        
        fadeOut.setOnFinished(e -> {
            current = (current + 1) % images.length;
            lblImage.setGraphic(new ImageView(images[current]));
            fadeIn.play();
        });
        
        fadeIn.setOnFinished(e -> {
            if(isRunning) {
                fadeOut.setDelay(new Duration(time / 2));
                fadeOut.play();
            }
        });
        
        playPause.setOnAction(e -> {
            if (isRunning) {
                isRunning = false;
                fadeOut.pause();
                fadeIn.pause();
                playPause.setText("Play");
            } else {
                isRunning = true;
                fadeOut.play();
                playPause.setText("Pause");
            }
        });
        
        speedUp.setOnAction(e -> {
            time = Math.max(500, time - 500);
            fadeOut.setDuration(new Duration(time));
            fadeIn.setDuration(new Duration(time));
        });
        
        speedDown.setOnAction(e -> {
            time += 500;
            fadeOut.setDuration(new Duration(time));
            fadeIn.setDuration(new Duration(time));
        });
         
        primarystage.setScene(scene);
        primarystage.show();  
    }  
}
