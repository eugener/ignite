package com.gluonhq.ignite.spring.sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ViewController implements Initializable {

    @Autowired
    SimpleService service;

    @FXML Label label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText(service.getText());
    }


}
