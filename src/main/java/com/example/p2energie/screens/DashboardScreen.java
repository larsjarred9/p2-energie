package com.example.p2energie.screens;

import com.example.p2energie.HelloApplication;
import com.example.p2energie.model.Customer;
import com.example.p2energie.model.Gas;
import com.example.p2energie.model.Usage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
        content.relocate(325, 100);
        content.setStyle("-fx-background-color: white;");

        Gas gas = Gas.getInstance();
        System.out.println(gas.getGasUsage());

//        // Flowpane with 3 buttons week, maand, jaar
//        FlowPane buttons = new FlowPane();
//        buttons.setId("buttons");
//        buttons.setPadding(new Insets(0, 0, 0, 0));
//        buttons.setHgap(20);
//        buttons.setPrefSize(550, 50);
//
//        // Button week
//        Button week = new Button("Week");
//        week.setPrefSize(150, 50);
//
//        // Button maand
//        Button month = new Button("Maand");
//        month.setPrefSize(150, 50);
//
//        // Button jaar
//        Button year = new Button("Jaar");
//        year.setPrefSize(150, 50);
//
//        buttons.getChildren().addAll(week, month, year);


//        // Table JavaFX
//
//        TableView table = new TableView();
//        table.setPrefSize(550, 300);
//        table.setPadding(new Insets(15, 0, 0, 0));
//
//        table.setEditable(true);
//
//        TableColumn energyUsage = new TableColumn("Stroomverbruik kWh");
//        TableColumn gasUsage = new TableColumn("Gasverbuik m3");
//        TableColumn startPeriod = new TableColumn("Begin Datum");
//        TableColumn endPeriod = new TableColumn("Eind Datum");
//
//        // give colums a width
//        energyUsage.setPrefWidth(150);
//        gasUsage.setPrefWidth(150);
//        startPeriod.setPrefWidth(125);
//        endPeriod.setPrefWidth(125);
//
//
//        table.getColumns().addAll(energyUsage, gasUsage, startPeriod, endPeriod);



//        content.getChildren().addAll(buttons, table);

        FlowPane pane = new FlowPane();
        pane.setPrefSize(550, 300);
        pane.setVgap(20);

        Customer customer = Customer.getInstance();

        Text text = new Text("Welkom "+customer.getName()+", vul de gegevens in de bovestaande tabs in om uw verbruik te bekijken.");

        TableView<Usage> table = new TableView();
        table.setPadding(new Insets(10, 0, 0, 0));


        TableColumn<Usage, String> EnergyUsage =
                new TableColumn<>("Stroomverbruik kWh");

        EnergyUsage.setCellValueFactory(
                new PropertyValueFactory<>("energyUsage"));


        TableColumn<Usage, String> GasUsage =
                new TableColumn<>("Gasverbruik m3");

        GasUsage.setCellValueFactory(
                new PropertyValueFactory<>("gasUsage"));

        TableColumn<Usage, String> Week =
                new TableColumn<>("Week");

        Week.setCellValueFactory(
                new PropertyValueFactory<>("week"));


        EnergyUsage.setPrefWidth(100);
        GasUsage.setPrefWidth(150);
        Week.setPrefWidth(100);

        table.getColumns().addAll(EnergyUsage, GasUsage, Week);

        ArrayList usageList;
        usageList = Usage.getInstance();

        usageList.forEach(e -> {
            if(e instanceof Usage) {
                table.getItems().add((Usage) e);
            }
        });

        table.setPrefHeight(325);


        pane.getChildren().addAll(text, table);

        content.getChildren().add(pane);

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

