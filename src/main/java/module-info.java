module org.sysicm {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.sysicm to javafx.fxml;
    exports org.sysicm;
    exports org.sysicm.controller;
    opens org.sysicm.controller to javafx.fxml;
}