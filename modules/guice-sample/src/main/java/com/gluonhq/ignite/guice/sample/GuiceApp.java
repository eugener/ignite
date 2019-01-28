package com.gluonhq.ignite.guice.sample;


import com.gluonhq.ignite.guice.GuiceContext;
import com.google.inject.AbstractModule;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

public class GuiceApp extends Application {

    private GuiceContext guiceContext = new GuiceContext(this, () -> List.of(new GuiceModule()));

    @Inject
    FXMLLoader fxmlLoader;

    @Override
    public void start(Stage primaryStage) throws IOException {

        guiceContext.init();

        fxmlLoader.setLocation( getClass().getResource("view.fxml"));

        Parent view = fxmlLoader.load();

        primaryStage.setTitle("Guice Example");
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }

}

class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
//        bind(Service.class).to(Service.class);
    }
}
