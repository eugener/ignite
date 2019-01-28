module com.gluonhq.ignite.dagger.sample {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires javax.inject;

    requires dagger;

    requires com.gluonhq.ignite.dagger;

    exports com.gluonhq.ignite.dagger.sample;
    opens com.gluonhq.ignite.dagger.sample;

}