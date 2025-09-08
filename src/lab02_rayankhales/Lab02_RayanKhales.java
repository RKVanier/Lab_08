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

/**
 *
 * @author 6241246
 */
public class Lab02_RayanKhales extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    @Override
    public void start(Stage primarystage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 250, 300);
        primarystage.setTitle("Java Games");
        primarystage.show();
        VBox middle = new VBox();
        Label top = new Label("Random Game");
        Label bottom = new Label("Waiting");
        Label lblImage = new Label();
        root.setTop(top);
        root.setBottom(bottom);
        middle.getChildren().add(lblImage);
        root.setCenter(middle);
        
        String path = "file:src/images/";
        Random random = new Random();
        int randomNumber = random.nextInt(120 - 101 + 1) + 101;
        Image image = new Image(path + randomNumber + ".jpg");
        lblImage.setGraphic(new ImageView(image));
         
        primarystage.setScene(scene);
        primarystage.show();
        
        
    }
    
}
