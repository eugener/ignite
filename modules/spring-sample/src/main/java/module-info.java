module com.gluonhq.ignite.spring.sample {

    requires java.sql;

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.beans;

    requires com.gluonhq.ignite;
    requires com.gluonhq.ignite.spring;

    exports com.gluonhq.ignite.spring.sample;
    opens com.gluonhq.ignite.spring.sample;

}