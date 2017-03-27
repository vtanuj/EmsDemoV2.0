/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ems.task;

import static ems.main.Ems.log;
import static ems.util.Constants.PATH_TEMP_DB_;
import ems.util.DateUtils;
import ems.util.MyUtils;
import java.io.File;
import javafx.concurrent.Task;

/**
 *
 * @author vl
 */
public class ImportDatabase extends Task<Boolean> {

    private final File newFile;
    boolean status;

    public ImportDatabase(File newFile) {
        this.newFile = newFile;
    }

    @Override
    protected Boolean call() throws Exception {
        try {
            if (new File(PATH_TEMP_DB_ + ".tmp").exists()) {
                MyUtils.renameFile(new File(PATH_TEMP_DB_ + ".tmp"),
                        new File(PATH_TEMP_DB_ + ".tmp" + "_" + DateUtils.dateTimePlain()));
            }
            status = MyUtils.copyFileUsingStream(newFile, new File(PATH_TEMP_DB_ + ".tmp"));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return status;
    }
}
