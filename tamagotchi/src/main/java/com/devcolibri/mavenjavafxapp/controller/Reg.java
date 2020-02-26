package com.devcolibri.mavenjavafxapp.controller;

import java.io.IOException;
import com.devcolibri.mavenjavafxapp.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Reg {

    private static String lab;

    @FXML
    private Label fix;

    @FXML
    private Button back,rege;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password,password1;

    @FXML
    void initialize()
        {
            back.setOnAction(event ->
                {
                    back.getScene().getWindow().hide();
                    FXMLLoader loader5 = new FXMLLoader();
                    loader5.setLocation(getClass().getResource("/fxml/VHOD.fxml"));
                    Back(loader5);
                });

            rege.setOnAction(event ->
                {
                        if(RegisterData())
                            {
                                MainApp JDBC = new MainApp();
                                JDBC.jdbcTemplateDeveloperDao.createDeveloper();
                                System.out.println("ok");
                            }
                });
        }


    private boolean RegisterData()
        {
            lab = login.getText();
            String pas = password.getText();
            String pas1 = password1.getText();

            fix.setVisible(true);
            if(lab.equals(""))
                {
                    fix.setText("Пожалуйста, Введите Login)");
                    return false;
                }

            if(pas.equals(""))
                {
                    fix.setText("Пожалуйста, Введите (Пароль)");
                    return false;
                }

            if(pas1.equals(""))
                {
                    fix.setText("Пожалуйста, Введите (Подтвердите Пароль)");
                    return false;
                }

            if(!pas.equals(pas1))
                {
                    fix.setText("Пожалуйста, Введите Пароль или (Пароль Не Совпадает!)");
                    return false;
                }

            return true;
        }

    static void Back(FXMLLoader lo)
        {
            try {
                lo.load();}catch (IOException e){e.printStackTrace();}
            Parent root4 = lo.getRoot();
            Stage stage4 = new Stage();
            stage4.setScene(new Scene(root4));
            stage4.show();
        }


    public static String getLab(){
        return lab;
    }
    public static String getPas(){
        return lab;
    }
}
