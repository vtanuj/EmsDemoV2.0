/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ems.controller;

import ems.main.Ems;
import static ems.util.Constants.HEADER_LOGIN;
import static ems.util.Constants.IMAGE_FAVICON;
import static ems.util.Constants.IMAGE_LOGO;
import static ems.util.Constants.TITLE_HOME;
import ems.util.JavaFXUtils;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import org.controlsfx.control.Notifications;
import org.controlsfx.glyphfont.FontAwesome;

/**
 * FXML Controller class
 *
 * @author tanujv
 */
public class LoginController implements Initializable {

    @FXML
    private ImageView loginImage;
    @FXML
    private Label loginHeader;
    @FXML
    private Button btnLogin;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loginImage.setImage(new Image(IMAGE_LOGO));
        loginHeader.setText(HEADER_LOGIN);
        btnLogin.setGraphic(JavaFXUtils.getGraphic("FontAwesome", FontAwesome.Glyph.SIGN_IN, 16, Color.GREEN));

    }

    @FXML
    private void onLoginClick(ActionEvent event) {
        try {
            Stage homeStage = new Stage(StageStyle.DECORATED);
            Parent root = FXMLLoader.load(getClass().getResource("/ems/fxml/Home.fxml"));
            Scene scene = new Scene(root);
            homeStage.setTitle(TITLE_HOME);
            homeStage.setScene(scene);
//            homeStage.setMaximized(true);
            homeStage.addEventHandler(WindowEvent.WINDOW_SHOWN, new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent window) {
                    Notifications.create().title("Welcome back!").text("We missed you.").showWarning();
                }
            });

            homeStage.getIcons().add(new Image(IMAGE_FAVICON));
            homeStage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (Exception ex) {
            Logger.getLogger(Ems.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
