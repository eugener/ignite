module com.gluonhq.ignite.samples {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

//    requires dagger;
    requires com.google.guice;
//    requires spring.beans;

//    requires com.gluonhq.ignite.spring;
//    requires com.gluonhq.ignite.dagger;
    requires com.gluonhq.ignite.guice;

    requires javax.inject;

    exports com.gluonhq.ignite.samples;


}