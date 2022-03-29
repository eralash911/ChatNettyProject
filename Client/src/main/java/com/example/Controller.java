package com.example;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable  {
    private Network network;
    @FXML
    TextArea mainArea;
    @FXML
    TextField msgField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        network = new Network();
        }

    public void sendMsg(ActionEvent actionEvent) {
        network.sendMsg(msgField.getText());
        msgField.clear();
        msgField.requestFocus();
    }
}
