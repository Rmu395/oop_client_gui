module com.example.client_gui2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    opens com.example.client_gui2 to javafx.fxml;
    exports com.example.client_gui2;
}