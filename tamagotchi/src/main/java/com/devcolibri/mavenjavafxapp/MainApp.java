package com.devcolibri.mavenjavafxapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.proselyte.jdbc.dao.jdbc.JdbcTemplateDeveloperDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.IOException;

public class MainApp extends Application
    {
       private ApplicationContext context = new ClassPathXmlApplicationContext("jdbctemplate-developer-config.xml");
       public JdbcTemplateDeveloperDaoImpl jdbcTemplateDeveloperDao = (JdbcTemplateDeveloperDaoImpl) context.getBean("jdbcTemplateDeveloperDao");

            @Override
                public void start(Stage stage) throws IOException
                    {
                        String fxmlFile = "/fxml/VHOD.fxml";
                        FXMLLoader loader = new FXMLLoader();
                        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));

                        stage.setScene(new Scene(root));
                        stage.show();
                }

        public static void main(String[] args){ launch(args); }
    }
