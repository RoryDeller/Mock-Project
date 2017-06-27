import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;;
import javafx.stage.WindowEvent;
import javafx.scene.text.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ListView;
import java.util.ArrayList;


public class Application
{
    private static TextField addStreet;
    private static TextField addCity;
    private static TextField addpostCode;
    private static ListView<Address> AddListView;
    private static Address currentlySelectedAddress = null;
    
   public static void main(String args[]){    
    launchFX();    
    }
    
    private static void launchFX() {
    new JFXPanel();
    Platform.runLater(() -> initialiseGUI());
    }
    
    private static void initialiseGUI()
    {
        Stage stage = new Stage();
        stage.setTitle("Top Universities by Rory");
        stage.setResizable(false);
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.show();
        stage.setOnCloseRequest((WindowEvent we) -> terminate());
        
        AddListView = new ListView<Address>();
        AddListView.setLayoutX(700);
        AddListView.setLayoutY(50);
        AddListView.setOnMouseClicked((MouseEvent me) -> {
            currentlySelectedAddress = (Address) AddListView.getSelectionModel().getSelectedItem();
        });
        rootPane.getChildren().add(AddListView);
        //updateListView();
        
        Text text = new Text();
        text.setFont(new Font(14));
        text.setLayoutX(100);
        text.setLayoutY(80);
        text.setWrappingWidth(200);
        text.setText("Enter details of top university");
        rootPane.getChildren().add(text);
        
        addStreet = new TextField();
        addStreet.setLayoutX(100);
        addStreet.setLayoutY(110);
        addStreet.setPrefWidth(200);
        addStreet.setPromptText("Enter ranking");
        rootPane.getChildren().add(addStreet);
        
        addCity = new TextField();
        addCity.setLayoutX(100);
        addCity.setLayoutY(140);
        addCity.setPrefWidth(200);
        addCity.setPromptText("Enter name");
        rootPane.getChildren().add(addCity);
        
        addpostCode = new TextField();
        addpostCode.setLayoutX(100);
        addpostCode.setLayoutY(170);
        addpostCode.setPrefWidth(200);
        addpostCode.setPromptText("Enter Post Code");
        rootPane.getChildren().add(addpostCode);
        
        Image image = new Image("Super-Cool-Ski-Instructor");
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        iv1.setLayoutX(100);
        iv1.setLayoutY(250);
        iv1.setFitWidth(500);
        iv1.setPreserveRatio(true);
        rootPane.getChildren().add(iv1);
        
         Button delete = new Button();
        delete.setText("Delete");
        delete.setLayoutX(100);
        delete.setLayoutY(500);
        delete.setOnAction((ActionEvent ae) -> deleteItem());
        rootPane.getChildren().add(delete);
        
        Button btn = new Button();
        btn.setText("Enter");
        btn.setLayoutX(100);
        btn.setLayoutY(450);
        btn.setOnAction((ActionEvent ae) -> addNewItem());
        rootPane.getChildren().add(btn);
    }
    
       private static void terminate()
    {
        System.exit(0);
    }
    
    private static void updateListView(){
         AddListView.getItems().clear();
        for (Address add : ApplicationHelper.myAddresses) {
           AddListView.getItems().add(add);
       }
    
    }
    
    private static void addNewItem(){
       String Street = addStreet.getText();
       String City = addCity.getText();
       String postCode = addpostCode.getText();
       myAddresses.add(new Address(Street, City, postCode));
       updateListView();
     
      
    }
    
    private static void deleteItem(){
    uniArrList.remove(currentlySelectedAddress);
    updateListView();
    
    }
}