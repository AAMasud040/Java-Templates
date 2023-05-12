//package sample;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import java.io.FileOutputStream;
//
//public class Main extends Application {
//
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        /*FileHandlingInput FI = new FileHandlingInput("in.txt");
//        //F.readFileCharSOUT();
//        //F.readLineSOUT();
//        //F.readFileChar();
//
//        FileHandlingOutput FO = new FileHandlingOutput("out.txt");
//
//        FO.WriteLine("First FIle using Template");
//
//
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));*/
//        Button b1 = new Button("B1");
//        Button b2 = new Button("B2");
//        Button b3 = new Button("B3");
//        Button b4 = new Button("B4");
//        Button b5 = new Button("B5");
//        Button b6 = new Button("B6");
//        Button b7 = new Button("B7");
//        Button b8 = new Button("B8");
//        Button b9 = new Button("B9");
//        Button b10 = new Button("B10");
//
//        HBox h1 = new HBox();
//        h1.getChildren().addAll(b1,b2,b3,b4);
//        HBox h2 = new HBox();
//        h2.getChildren().addAll(b5,b6,b7);
//        HBox h3 = new HBox();
//        h3.getChildren().addAll(b8,b9);
//        HBox h4 = new HBox();
//        h4.getChildren().addAll(b10);
//
//
//        VBox root = new VBox();
//        root.getChildren().addAll(h1,h2,h3,h4);
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 600, 400));
//        primaryStage.show();
//        /*FI.CloseAll();
//        FO.CloseAll();*/
//    }
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
