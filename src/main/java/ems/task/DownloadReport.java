/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ems.task;

import static ems.main.Ems.log;
import ems.util.DataHandler;
import ems.util.JavaFXUtils;
import ems.util.jrviewer.JRViewerFx;
import ems.util.jrviewer.JRViewerFxMode;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.Window;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author tanujv
 */
public class DownloadReport extends Task<Void> {

    String[] params;
    File file;
    boolean status;
    Window window;
    JasperPrint jasperPrint;

    public DownloadReport(Stage stage, Window window, String... params) {
        this.params = params;
//        this.file = file;
        this.window = window;
        setOnSucceeded((WorkerStateEvent event) -> {
            try {
                if (stage != null) {
                    window.getScene().getRoot().setEffect(null);
                    stage.hide();
                }
                if (jasperPrint != null) {
                    Stage newjrviewerStage = new Stage();
                    JRViewerFx viewer = new JRViewerFx(jasperPrint, JRViewerFxMode.REPORT_VIEW, newjrviewerStage);
                    viewer.start(newjrviewerStage);
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Success");
//                alert.setHeaderText("Export successful!");
//                alert.setContentText("Successfully exported the report.");
//                ButtonType buttonTypeOne = new ButtonType("Open Folder");
//                ButtonType buttonTypeTwo = new ButtonType("Open File");
//                ButtonType buttonTypeOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
//                alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeOk);
//
//                Optional<ButtonType> result = alert.showAndWait();
//                try {
//                    if (result.get() == buttonTypeOne) {
//                        MyUtils.openFolderWithFileSelected(file.getAbsolutePath());
//                    } else if (result.get() == buttonTypeTwo) {
//                        MyUtils.openFile(file.getAbsolutePath());
//                    }
//                } catch (Exception e) {
//                    JavaFXUtils.exceptionDialog(e);
//                }
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Failure");
                    alert.setHeaderText("Export unsuccessful!");
                    alert.setContentText("Unable to export the report.");
                    alert.showAndWait();
                }
            } catch (Exception e) {
                log.error(e.getMessage());
                JavaFXUtils.exceptionDialog(e);
            }

        });
    }

    @Override
    protected Void call() throws Exception {
        try {
            jasperPrint = DataHandler.exportData(params);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

}
