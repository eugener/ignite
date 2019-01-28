package com.gluonhq.ignite.dagger.sample;

import java.net.URL;

public interface ExampleApp {

    default URL getViewLocation() {
        return getClass().getResource("/com/gluonhq/ignite/dagger/sample/view.fxml");
    }
}
