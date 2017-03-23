/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ems.task;

import static ems.main.Ems.log;
import ems.util.DataHandler;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author vl
 */
public class Dashboard extends Task<Void> {

    private final String reportType;
    private int recordsFound;

    public Dashboard(Stage stage, Window window, String reportType) {

        this.reportType = reportType;

        setOnSucceeded((WorkerStateEvent event) -> {
            if (stage != null) {
                window.getScene().getRoot().setEffect(null);
                stage.hide();
            }
            if (recordsFound == 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Searching Results");
                alert.setHeaderText("Records searching unsuccessful!");
                alert.setContentText("No records found. Please try again with new parameters.");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Searching Results");
                alert.setHeaderText("Records searching successful!");
                alert.setContentText(recordsFound + " records found.");
                alert.showAndWait();
            }
        });
    }

    @Override
    protected Void call() throws Exception {
        try {
            recordsFound = DataHandler.getDashaboardReports(reportType);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

}
