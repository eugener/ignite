package com.gluonhq.ignite.dagger.sample;


import com.gluonhq.ignite.dagger.DaggerContext;
import dagger.Module;
import dagger.Provides;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

public class DaggerApp extends Application {

    private final DaggerContext context = new DaggerContext(this, () -> List.of(new DaggerModule()));

    @Inject
    FXMLLoader fxmlLoader;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        context.init();

        fxmlLoader.setLocation( getClass().getResource("view.fxml"));
        Parent view = fxmlLoader.load();

        primaryStage.setTitle("Dagger Example");
        primaryStage.setScene(new Scene(view));
        primaryStage.show();

    }

}

@Module( library = true, injects = {DaggerApp.class,ViewController.class}, complete = false)
class DaggerModule  {
    @Provides
    public Service provideService() {
        return new Service();
    }
}

