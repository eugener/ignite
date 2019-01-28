package com.gluonhq.ignite.spring.sample;

import com.gluonhq.ignite.spring.SpringContext;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;


/**
 * Descendants of SpringFXApplication are automatically autowired
 */
public class FXApp extends Application {

    private SpringContext appContext;

    @Autowired
    FXMLLoader loader;

    @Override
    public void init() {
        appContext = new SpringContext( SpringBootApp.class, this);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        loader.setLocation(getClass().getResource("view.fxml"));
        Parent view = loader.load();

        primaryStage.setTitle("Spring Example");
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }

    @Override
    public final void stop() throws Exception {
        appContext.stop();
        Platform.exit();
    }

}

