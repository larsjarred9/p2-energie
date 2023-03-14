module com.example.p2energie {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.p2energie to javafx.fxml;
    exports com.example.p2energie;

    opens com.example.p2energie.model to javafx.base;


}