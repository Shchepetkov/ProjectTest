package com.devcolibri.mavenjavafxapp.controller;

import com.devcolibri.mavenjavafxapp.MainApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import net.proselyte.jdbc.util.DeveloperMapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller {


    public static String getNane() {
        return name;
    }

    private static String name = "";

    @FXML
    private Button IDRina;

    @FXML
    void initialize()
        {
            MainApp JDBC = new MainApp();
            JDBC.jdbcTemplateDeveloperDao.InsertDeveloper();
            IDRina.setOnAction(event ->
                {
                    name = "Hunter";
                    JDBC.jdbcTemplateDeveloperDao.InstPerson();

                    IDRina.getScene().getWindow().hide();
                    FXMLLoader loader4 = new FXMLLoader();
                    loader4.setLocation(getClass().getResource("/fxml/IDHunter.fxml"));
                    Hunter(loader4);
                });
        }

    private static void Hunter(FXMLLoader loader4)
        {
            Reg.Back(loader4);
        }

    public static String DataOLD()
        {
            Date date = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("HH:mm:ss");
            return formatForDateNow.format(date);
        }


//    public static Date DataOLD() throws ParseException {
//
//        SimpleDateFormat formatForDateNow = new SimpleDateFormat("HH:mm:ss");
//        SimpleDateFormat ft = new SimpleDateFormat ("HH:mm:ss");
//        Date parsingDate;
//
//            parsingDate = ft.parse(DataString());
//            System.out.println(parsingDate);
//
//
//        return parsingDate;
//    }

}
