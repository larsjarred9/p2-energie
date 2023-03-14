package com.example.p2energie.screens;

import com.example.p2energie.HelloApplication;
import com.example.p2energie.model.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class DashboardScreen {



    private final Scene dashboardScene;

    public DashboardScreen() {
        Pane container = new Pane();
        container.setId("container");

        container.getChildren().addAll(getHeader(), getContent());

        dashboardScene = new Scene(container);
        dashboardScene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;700;900");
        dashboardScene.getStylesheets().add(HelloApplication.class.getResource("stylesheets/style.css").toString());
    }

    /**
     * Get the dashboard scene
     * @return Scene
     */
    public Scene getDashboardScene() {
        return dashboardScene;
    }

    public Pane getContent() {
        FlowPane content = new FlowPane();
        content.setId("dashboard");
        content.setPadding(new Insets(50, 25, 50, 25));
        content.relocate(25, 100);
        content.setStyle("-fx-background-color: white;");

        FlowPane pane = new FlowPane();
        pane.setPrefSize(550, 300);
        pane.setVgap(20);

        Customer customer = Customer.getInstance();

        Text text = new Text("Welkom "+customer.getName()+", vul de gegevens in de bovestaande tabs in om uw verbruik te bekijken.");

        // Define value string
        String value = "";

        // Define amount of defined weeks
        Integer weeks = 0;

        // define price float
        Float price = (float)0;

        // Get all lists (Energy, Gas, Usage)
        ArrayList usageList = Usage.getInstance();
        ArrayList gasList = Gas.getInstance();
        ArrayList energyList = Energy.getInstance();

        // Get deposit
        String deposit = Customer.getInstance().getDeposit();

        // Check if deposit is not null or empty
        if(!deposit.isEmpty() || deposit != null) {
            value = "Geen data beschikbaar";
        }

        // calculate is deposit would cover the price per week Usage
        for (int i = 0; i < usageList.size(); i++) {

            weeks++;
            // get usage data
            Usage usage = (Usage) usageList.get(i);

            // get energy price
            Energy energy = (Energy) energyList.get(i);

            // get gas price
            Gas gas = (Gas) gasList.get(i);

            // calculate price
            price = price + calculatePrice(energy.getEnergyUsage(), gas.getGasUsage(), usage.getEnergyUsage(), usage.getGasUsage());
        }



        // If price is lower than deposit, show warning
        if((price/Float.parseFloat(deposit)) < 52) {

            value = "Je hebt vanaf week 1 tot nu € " + price + " gebruikt. Het voorschot van € " + deposit + " zouden je energiekosten niet dekken. Overweeg om je maandbedrag te verhogen.";
        } else {
            value = "Je hebt vanaf week 1 tot nu € " + price + " gebruikt. Het voorschot van € " + deposit + " zouden je energiekosten tot het einde van het jaar dekken.";
        }

        if(weeks < 1) {
            value = "Geen data beschikbaar";
        }


        Text info = new Text(value);

        pane.getChildren().addAll(text, info);

        content.getChildren().add(pane);

        return content;
    }

    private float calculatePrice(String energyPrice, String gasPrice, float energyUsage, float gasUsage) {
        float price = 0;

        // calculate price
        price = price + (Float.parseFloat(energyPrice) * energyUsage);
        price = price + (Float.parseFloat(gasPrice) * gasUsage);

        return price;
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
        home.setStyle("-fx-font-weight: bold;");

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

