/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ems.task;

import ems.controller.ReportController;
import static ems.main.Ems.log;
import ems.model.MyModelSimpleStringProperty;
import static ems.util.Constants.IMAGE_FAVICON;
import static ems.util.Constants.TITLE_ABOUT;
import ems.util.DataHandler;
import ems.util.JavaFXUtils;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author vl
 */
public class DashboardReports extends Task<Void> {

    private final String dashboardReportType;
    private final String param;
    List<MyModelSimpleStringProperty> reportDetails;

    public DashboardReports(Stage stage, Window window, String dashboardReportType, String param) {

        this.dashboardReportType = dashboardReportType;
        this.param = param;

        setOnSucceeded((WorkerStateEvent event) -> {
            if (stage != null) {
                window.getScene().getRoot().setEffect(null);
                stage.hide();
            }

            Stage reportDetailsStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ems/fxml/ReportDetails.fxml"));
            Parent root;
            try {
                root = loader.load();
                ReportController reportController = loader.<ReportController>getController();
                reportController.initReportDetails(reportDetails,"");
                Scene scene = new Scene(root);
                reportDetailsStage.setTitle(TITLE_ABOUT);
                reportDetailsStage.setScene(scene);
                reportDetailsStage.getIcons().add(new Image(IMAGE_FAVICON));
                reportDetailsStage.show();
            } catch (IOException ex) {
                log.error(ex.getMessage());
                JavaFXUtils.exceptionDialog(ex);
            }
        });
    }

    @Override
    protected Void call() throws Exception {
        try {
            reportDetails = DataHandler.getDashboardReportDetails(dashboardReportType, param);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
