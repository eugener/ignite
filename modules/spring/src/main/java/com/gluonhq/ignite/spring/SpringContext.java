package com.gluonhq.ignite.spring;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Objects;
import java.util.Optional;

public final class SpringContext {

    private ConfigurableApplicationContext appContext;
    private Class<?> starterClass;
    private Application app;


    public SpringContext(Class<?> starterClass, Application app ) {
        this.starterClass = Objects.requireNonNull(starterClass);
        this.app = Objects.requireNonNull(app);
    }

    public void init() {
        ApplicationContextInitializer<GenericApplicationContext> initializer =
                ctx -> {
                    ctx.registerBean(Application.class, () -> app);
                    ctx.registerBean( FXMLLoader.class, () -> {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setControllerFactory(ctx::getBean);
                        return loader;
                    });
                };

        appContext =  new SpringApplicationBuilder()
                .sources(starterClass)
                .initializers(initializer)
                .run( app.getParameters().getRaw().toArray(new String[0]));
    }

    public final void stop() {
        Optional.ofNullable(appContext).ifPresent(ConfigurableApplicationContext::close);
    }

}
