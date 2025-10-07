module org.sysicm {
    requires javafx.controls;
    requires javafx.fxml;

    requires javafx.base;


    opens org.sysicm to javafx.fxml;

    opens org.sysicm.model to javafx.base;
    opens org.sysicm.controller to javafx.fxml;

    exports org.sysicm;
    exports org.sysicm.controller to javafx.fxml;
    exports org.sysicm.model to javafx.fxml;

}