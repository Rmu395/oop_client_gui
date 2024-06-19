package com.example.client_gui2;

import com.fasterxml.jackson.core.JsonProcessingException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    public TextArea textArea;
    public TextField textFieldToNazwaWlasna;

    public HelloController() {
        ClientReceiver.controller = this;
    }

    @FXML
    public void onSendPress() throws JsonProcessingException {
        String message = textFieldToNazwaWlasna.getText();
        textArea.appendText( ClientReceiver.thread.clientName + ": " + message + "\n");
        textFieldToNazwaWlasna.clear();

        Message messageToSend;
        if (message.contains("/")) {
            messageToSend = new Message(
                    MessageType.Command,
                    message
            );
        }
        else  {
            messageToSend = new Message(
                    MessageType.Broadcast,
                    message
            );
        }
        ClientReceiver.thread.send(messageToSend);
    }

    public void onMessage(String message) {
        textArea.appendText(message + "\n");
    }
}