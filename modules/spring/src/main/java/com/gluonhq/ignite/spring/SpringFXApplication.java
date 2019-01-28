package com.gluonhq.ignite.spring;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Objects;

public abstract class SpringFXApplication extends Application {

    private ConfigurableApplicationContext appContext;
    private Class<?> starterClass;

    protected SpringFXApplication(Class<?> starterClass) {
        this.starterClass = Objects.requireNonNull(starterClass);
    }

    @Override
    public void init() {
        ApplicationContextInitializer<GenericApplicationContext> initializer =
                ctx -> {
                    ctx.registerBean(Application.class, () -> this);
                    ctx.registerBean( FXMLLoader.class, () -> {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setControllerFactory(ctx::getBean);
                        return loader;
                    });
                };

        appContext =  new SpringApplicationBuilder()
                .sources(starterClass)
                .initializers(initializer)
                .run( getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public final void stop() throws Exception {
        appContext.stop();
        Platform.exit();
    }

}