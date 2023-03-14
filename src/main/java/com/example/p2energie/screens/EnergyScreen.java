package com.example.p2energie.screens;

import com.example.p2energie.HelloApplication;
import com.example.p2energie.model.Energy;
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

public class EnergyScreen {


    private final Scene energyScene;

    public EnergyScreen() {
        Pane container = new Pane();
        container.setId("container");

        container.getChildren().addAll(getHeader(), getContent());

        energyScene = new Scene(container);
        energyScene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;700;900");
        energyScene.getStylesheets().add(HelloApplication.class.getResource("stylesheets/style.css").toString());
    }

    /**
     * Get the dashboard scene
     * @return Scene
     */
    public Scene getEnergyScene() {
        return energyScene;
    }

    public Pane getContent() {
        FlowPane content = new FlowPane();
        content.setId("gasform");
        content.setPadding(new Insets(30, 15, 0, 15));
        content.relocate(325, 100);
        content.setStyle("-fx-background-color: white;");
        content.setAlignment(Pos.CENTER);

        Text title = new Text("Voer uw stroomtarief in");

        // form
        FlowPane form = new FlowPane();
        form.setId("form");
        form.setOrientation(Orientation.VERTICAL);
        form.setVgap(20);
        form.setAlignment(Pos.CENTER);

        Label energyPrice = new Label("Prijs per KWh");
        TextField energyPriceInput = new TextField();
        energyPriceInput.setPrefWidth(300);

        Label weekAmount = new Label("Weeknummer");
        TextField weekInput = new TextField();
        weekInput.setPrefWidth(300);

        // button
        Button submit = new Button("Gegevens toevoegen →");

        submit.setOnAction(e -> {

            // If input is empty
            if (energyPriceInput.getText().isEmpty() || weekInput.getText().isEmpty()) {
                return;
            }

            // If week number is not a number and may not be between 1 and 52
            if (!weekInput.getText().matches("[1-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-2]")) {
                return;
            }

            // If price is not a number or a decimal
            if (!energyPriceInput.getText().matches("[0-9]+([,.][0-9]+)?")) {
                return;
            }

            // Add form to energy list
            Energy.addEnergyList(new Energy(energyPriceInput.getText(), weekInput.getText()));

        });

        form.getChildren().addAll(energyPrice, energyPriceInput, weekAmount, weekInput, submit);

        content.getChildren().addAll(title, form);



        return content;
    }

    public Pane getHeader() {
        FlowPane header = new FlowPane();
        header.setId("header");
        header.setPadding(new Insets(20, 20, 20, 20));
        header.setStyle("-fx-background-color: white;");
        header.setPrefWidth(HelloApplication.applicationSize[0]);

        // logo in header
        Image logo = new Image(HelloApplication.class.getResource("images/logo.png").toString());
        ImageView logoView = new ImageView(logo);
        logoView.setFitWidth(100);
        logoView.setFitHeight(25);

        // navigation bar horizontal java fx
        FlowPane navigation = new FlowPane();
        navigation.setId("navigation");
        navigation.setPadding(new Insets(5, 5, 5, 5));
        navigation.setStyle("-fx-background-color: white;");

        navigation.setPrefWidth(HelloApplication.applicationSize[0]);

        // navigation bar items
        Text home = new Text("Dashboard");
        Text gas = new Text("Gas");
        Text stroom = new Text("Stroom");
        Text usage = new Text("Verbruik");
        Text logout = new Text("Uitloggen");

        // add margin to navigation items
        FlowPane.setMargin(logoView, new Insets(0, 50, 0, 0));
        FlowPane.setMargin(home, new Insets(0, 20, 0, 0));
        FlowPane.setMargin(gas, new Insets(0, 20, 0, 0));
        FlowPane.setMargin(stroom, new Insets(0, 20, 0, 0));
        FlowPane.setMargin(usage, new Insets(0, 20, 0, 0));
        FlowPane.setMargin(logout, new Insets(0, 20, 0, 0));

        // Make current page text bold
        stroom.setStyle("-fx-font-weight: bold;");

        // when click on dasboard text
        home.setOnMouseClicked(e -> {
            HelloApplication.mainStage.setScene(new DashboardScreen().getDashboardScene());
        });

        // when click on text gas
        gas.setOnMouseClicked(e -> {
            HelloApplication.mainStage.setScene(new GasScreen().getGasScene());
        });

        // WHen click on stroom text
        stroom.setOnMouseClicked(e -> {
            HelloApplication.mainStage.setScene(new EnergyScreen().getEnergyScene());
        });

        // When click on usage
        usage.setOnMouseClicked(e -> {
            HelloApplication.mainStage.setScene(new UsageScreen().getUsageScene());
        });

        // when click on logout text
        logout.setOnMouseClicked(e -> {
            HelloApplication.mainStage.setScene(new HomeScreen().getHomeScene());
        });


        // add navigation items to navigation bar
        navigation.getChildren().addAll(logoView, home, gas, stroom, usage, logout);

        header.getChildren().addAll(navigation);

        return header;
    }
}
