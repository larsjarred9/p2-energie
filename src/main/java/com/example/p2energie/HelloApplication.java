package com.example.p2energie;

import com.example.p2energie.screens.HomeScreen;
import javafx.stage.Stage;

public class HelloApplication extends javafx.application.Application {

    public static Stage mainStage;

    public static int[] applicationSize = {1200, 650};

    @Override
    public void start(Stage stage) {

        mainStage = stage;
        mainStage.setWidth(applicationSize[0]);
        mainStage.setHeight(applicationSize[1]);
        mainStage.setResizable(false);
        mainStage.setTitle("van de bron - Energy Management ");

        mainStage.setScene(new HomeScreen().getHomeScene());
        mainStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}