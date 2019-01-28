module com.gluonhq.ignite.spring {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.beans;

    exports com.gluonhq.ignite.spring;
    opens com.gluonhq.ignite.spring;

}