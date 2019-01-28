module com.gluonhq.ignite.guice.sample {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires javax.inject;

    requires com.google.guice;

    requires com.gluonhq.ignite.guice;

    exports com.gluonhq.ignite.guice.sample;
    opens com.gluonhq.ignite.guice.sample;

}