package com.gluonhq.ignite.spring.sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.io.IOException;

public abstract class XSpringFXApplication {
//        extends Application {
//
//    private ConfigurableApplicationContext appContext;
//    private Class<?> starterClass;
//
//    protected XSpringFXApplication(Class<?> starterClass) {
//        this.starterClass = starterClass;
//    }
//
//    @Override
//    public void init() {
//        ApplicationContextInitializer<GenericApplicationContext> initializer =
//                ctx -> {
//                    ctx.registerBean(Application.class, () -> this);
//                    ctx.registerBean( FXMLLoader.class, () -> {
//                        FXMLLoader loader = new FXMLLoader();
//                        loader.setControllerFactory(ctx::getBean);
//                        return loader;
//                    });
//                };
//
//        appContext =  new SpringApplicationBuilder()
//                .sources(starterClass)
//                .initializers(initializer)
//                .run( getParameters().getRaw().toArray(new String[0]));
//    }
//
//    @Override
//    public final void stop() throws Exception {
//        appContext.stop();
//        Platform.exit();
//    }

}
