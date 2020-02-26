package com.devcolibri.mavenjavafxapp.controller;

import com.devcolibri.mavenjavafxapp.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import net.proselyte.jdbc.util.DeveloperMapper;

public class VHOD {

    private static Boolean status = false;
    private static String strUsername;
    private static String strPassword;

    @FXML
        private PasswordField IDPassword;

    @FXML
        private TextField IDLogin;

    @FXML
        private Button IDvhod,IDreg;

    @FXML
        private Label IDRep;

    @FXML
        void initialize()
            {

            }

    @FXML
        private void OnActionReg()
            {
                IDreg.getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/Reg.fxml"));
                Reg(fxmlLoader);
            }

    @FXML
        private void OnActionVhod()
            {
                if (Login())
                    {
                        if (DeveloperMapper.Person.equals("Hunter"))
                            {
                                IDvhod.getScene().getWindow().hide();
                                FXMLLoader loader2 = new FXMLLoader();
                                loader2.setLocation(getClass().getResource("/fxml/IDHunter.fxml"));
                                Reg(loader2);

                            }else if (DeveloperMapper.Person.equals("0"))
                                    {
                                        IDvhod.getScene().getWindow().hide();
                                        FXMLLoader loader2 = new FXMLLoader();
                                        loader2.setLocation(getClass().getResource("/fxml/sample.fxml"));
                                        Reg(loader2);
                                    }
                    }
                    else
                        {
                            IDRep.setVisible(true);
                        }
            }

    private boolean Login()
        {
            strUsername = IDLogin.getText();
            strPassword = IDPassword.getText();

                if (LoginDB())
                    {
                        status = true;
                    }
                return status;
        }

    private static boolean LoginDB()
        {
            MainApp JDBC = new MainApp();
            JDBC.jdbcTemplateDeveloperDao.listDevelopers();


            if (VHOD.getStrUsername().equals(DeveloperMapper.Usernam) && (VHOD.getStrPassword().equals(DeveloperMapper.Passwor)))
                {
                    return true;
                }

            if (VHOD.getStrUsername().equals(""))
                {
                    return false;
                }

            if (VHOD.getStrPassword().equals(""))
                {
                    return false;
                }

            return false;
        }

    private void Reg(FXMLLoader lo)
        {
            Reg.Back(lo);
        }

    public static String  getStrUsername()
        {
            return strUsername;
        }

    public static String getStrPassword()
        {
        return strPassword;
    }
}
