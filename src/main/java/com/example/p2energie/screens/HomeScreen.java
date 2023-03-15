package com.example.p2energie.screens;

import com.example.p2energie.HelloApplication;
import com.example.p2energie.Utils;
import com.example.p2energie.model.Customer;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


public class HomeScreen {

    private final Scene homeScene;

    public HomeScreen() {
        Pane container = new Pane();
        container.setId("container");

        container.getChildren().addAll(getContent());

        homeScene = new Scene(container);
        homeScene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;700;900");
        homeScene.getStylesheets().add(HelloApplication.class.getResource("stylesheets/style.css").toString());
    }

    /**
     * Get the home scene
     * @return Scene
     */
    public Scene getHomeScene() {
        return homeScene;
    }

    private Pane getContent() {
        FlowPane content = new FlowPane();
        content.setId("register");
        content.setPadding(new Insets(50, 25, 50, 25));
        content.relocate(365, 40);
        content.setStyle("-fx-background-color: white;");

        content.setAlignment(Pos.CENTER);

        Image logo = new Image(HelloApplication.class.getResource("images/logo.png").toString());
        ImageView logoView = new ImageView(logo);
        logoView.setFitWidth(100);
        logoView.setFitHeight(25);

        Text title = new Text("Wij hebben enkele gegevens van uw nodig om verder te gaan.");

        FlowPane form = new FlowPane();
        form.setOrientation(Orientation.VERTICAL);
        form.setVgap(20);
        form.setAlignment(Pos.CENTER);


        Label labelId = new Label("Klantnummer");

        TextField id = new TextField();
        id.setPromptText("Klantnummer");
        id.setPrefWidth(300);

        Label labelName = new Label("Naam");

        TextField name = new TextField();
        name.setPromptText("Naam");
        name.setPrefWidth(300);

        Label labelEmail = new Label("Email");

        TextField email = new TextField();
        email.setPromptText("Email");
        email.setPrefWidth(300);

        Label labelDeposit = new Label("Jaarlijks Voorschot");

        TextField deposit = new TextField();
        deposit.setPromptText("Jaarlijks Voorschot");
        deposit.setPrefWidth(300);

        Button submit = new Button("Ga verder →");

        form.getChildren().addAll(labelId, id, labelName, name, labelEmail, email, labelDeposit, deposit, submit);

        Text error = new Text("");

        content.getChildren().addAll(logoView, title, form, error);

        // button action
        submit.setOnAction(e -> {

            // validate form
            if (id.getText().isEmpty() || name.getText().isEmpty() || email.getText().isEmpty() || deposit.getText().isEmpty()) {
                error.setText("Vul alle velden in.");
                return;
            }

            // check if id is a number
            if(!Utils.isInteger(id.getText())) {
                error.setText("Klantnummer moet een getal zijn.");
                return;
            }

            Integer num = Integer.parseInt(id.getText());


            // check if email is valid syntax
            if (!email.getText().contains("@")) {
                error.setText("Email is niet geldig.");
                return;
            }

            // check if deposit is a number
            try {
                Integer.parseInt(deposit.getText());
            } catch (NumberFormatException ex) {
                error.setText("Voorschot moet een getal zijn.");
                return;
            }

            // Set customer data
            Boolean status = new Customer().addCustomer(new Customer(num, name.getText(), email.getText(), deposit.getText()));


            // If customer is added, go to dashboard
            if(status) {
                // Create instance of customer (for dashboard)
                Customer customer = Customer.getInstance();
                customer.setId(num);
                customer.setName(name.getText());
                customer.setEmail(email.getText());
                customer.setDeposit(deposit.getText());
                HelloApplication.mainStage.setScene(new DashboardScreen().getDashboardScene());
            } else {
                error.setText("Er is iets fout gegaan. Probeer het opnieuw.");
            }
        });

        return content;
    }
}
