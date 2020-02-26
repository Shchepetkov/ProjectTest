package com.devcolibri.mavenjavafxapp.controller;

import com.devcolibri.mavenjavafxapp.MainApp;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import net.proselyte.jdbc.util.DeveloperMapper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Hunter {

    private MainApp JDBC = new MainApp();
    private Thread pressingThread;
    private Thread pressingThread2;
    private Thread pressingThread3;
    private boolean kill = true;
    private static String strYears = "1";
    private int[] time1 = {5};

    @FXML
        public Label eat,label,year;

    @FXML
        private ImageView kil,h1,eating,egg,dirty,Wash,stat,cry;

    @FXML
        private Button feed,walking,clean,restart;

    @FXML
        private ProgressBar progress;

    @FXML
        void initialize() throws ParseException
            {
                TimerYear();
                FirstStart();
                MinusProgressBarAndDeathInGame();
                restart.setDisable(true);
                walking.setDisable(true);
                    if (DeveloperMapper.Person.equals("Hunter"))
                        {
                            egg.setVisible(false);
                            h1.setVisible(true);
                            kill = true;
                        }
                    clean.setDisable(true);

            }

    private void FirstStart() throws ParseException
        {
            if (!DeveloperMapper.Data_OLD.equals("00:00:00"))
                {
                    BrogressBarMinusDate();
                    DifferenceOfTwoDates();
                } else
                    {
                        kill= false;
                        Birth();
                    }
        }

    private void Birth()
        {
            if (!kill)
                {
                    feed.setDisable(true);
                    walking.setDisable(true);
                    Timeline timeline = new Timeline(
                            new KeyFrame(
                                    Duration.millis(150 * 60), ae ->
                                {
                                    time1[0]--;
                                    egg.setVisible(false);
                                    h1.setVisible(true);
                                    feed.setDisable(false);
                                }));

                    timeline.setCycleCount(1);
                    timeline.play();
                }
        }

    @FXML
        public void OnActionRestart()
            {
                if (kill){
                    JDBC.jdbcTemplateDeveloperDao.restart();
                    restart.getScene().getWindow().hide();
                    FXMLLoader loader5 = new FXMLLoader();
                    loader5.setLocation(getClass().getResource("/fxml/sample.fxml"));
                    Reg.Back(loader5);
                }
            }

    @FXML
        public void OnActionEat()
            {
                onRelease2();
                stat.setVisible(false);
                walking.setDisable(false);
                onPress();
            }

    @FXML
        public void OnActionWalk()
            {
                onRelease();
                walking.setDisable(true);
                stat.setVisible(false);
                eating.setVisible(false);
                h1.setVisible(true);
                MinusProgressBarAndDeathInGame();
            }


    @FXML
        private void OnActionClean()
            {
                Wash.setVisible(true);
                dirty.setVisible(false);

                Timeline timeline = new Timeline(
                        new KeyFrame(
                                Duration.millis(150 * 60), ae ->
                        {
                            time1[0]--;
                            stat.setVisible(true);
                            Wash.setVisible(false);
                            clean.setDisable(true);
                            feed.setDisable(false);
                            walking.setDisable(false);
                        }));

                timeline.setCycleCount(1);
                timeline.play();
            }

    @FXML
        private void onPress()
            {
                Eat();
                final int initDelay = 10000;
                final int repeatDelay = 5000;
                pressingThread = new Thread(() ->
                    {
                        try
                            {
                                Thread.sleep(initDelay);
                                while (true)
                                    {
                                        Platform.runLater(() ->
                                            {
                                                progress.setProgress(progress.getProgress() + 3);

                                                    if (progress.getProgress() > 10)
                                                        {
                                                            Dirty();
                                                        }
                                            });
                                        JDBC.jdbcTemplateDeveloperDao.InsertDeveloper();
                                        Thread.sleep(repeatDelay);
                                    }
                            } catch (InterruptedException ignored) {}
                    });
                pressingThread.setDaemon(true);
                pressingThread.start();
            }

    private void Dirty()
        {
            onRelease();
            dirty.setVisible(true);
            eating.setVisible(false);
            walking.setDisable(true);
            feed.setDisable(true);
            clean.setDisable(false);
        }

    private void Eat()
        {
            eating.setVisible(true);
            h1.setVisible(false);
            cry.setVisible(false);
        }

    private float DifferenceOfTwoDates() throws ParseException
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date date1 = dateFormat.parse(DeveloperMapper.Data_OLD);
            Date date2 = new Date(); dateFormat.format(date2);
            Date date3 = dateFormat.parse(dateFormat.format(date2));
            float milliseconds = date3.getTime() - date1.getTime();
            float minutes = (milliseconds / (60 * 1000));//~= 91 min. 19 sec.
            return (minutes/100);
        }

    private void BrogressBarMinusDate() throws ParseException
        {
            progress.setProgress( progress.getProgress() - DifferenceOfTwoDates() );
              if (kill)
                {
                    if (DifferenceOfTwoDates() > (progress.getProgress() + DifferenceOfTwoDates()))
                        {
                            progress.setProgress(-1);
                            egg.setVisible(false);
                            Death();
                            restart.setDisable(false);
                        }else
                            {
                                kill = false;
                            }
                }
        }

    private void MinusProgressBarAndDeathInGame()
        {
            final int repeatDelay = 540000;//~= 540000/  1 hr. 30 min.  на 0.1 ~= 9 min.
            pressingThread2 = new Thread(() ->
                {
                    try
                        {
                            while (true)
                                {
                                    Platform.runLater(() ->
                                        {
                                            progress.setProgress(progress.getProgress() - 0.1);
                                                        String formattedDouble = String.format("%.2f", (float) progress.getProgress());
                                                        label.setText(formattedDouble);

                                        });

                                                    if (progress.getProgress() < 0)
                                                        {
                                                            Death();
                                                            onRelease2();
                                                            onRelease3();
                                                            restart.setDisable(false);
                                                        }

                                                    else if (progress.getProgress() < 0.6)
                                                        {
                                                            cry.setVisible(true);
                                                            h1.setVisible(false);
                                                        }

                                    Thread.sleep(repeatDelay);
                                }
                        } catch (InterruptedException ignored) {}
                });
            pressingThread2.setDaemon(true);
            pressingThread2.start();
        }

    private void Death()
        {
            h1.setVisible(false);
            kil.setVisible(true);
            feed.setDisable(true);
            walking.setDisable(true);
            eat.setVisible(true);
            cry.setVisible(false);
        }

    private void TimerYear()
        {
            AtomicInteger num = new AtomicInteger(Integer.parseInt(DeveloperMapper.Years));
            final int repeatDelay = 1000;

             pressingThread3 = new Thread(() ->
                {
                    try {
                        while (true)
                            {
                                Platform.runLater(() ->
                                    {
                                        year.setText(String.valueOf(num));
                                        num.getAndIncrement();
                                        strYears = year.getText();
                                    });
                                JDBC.jdbcTemplateDeveloperDao.InsertYears();

                                Thread.sleep(repeatDelay);
                            }
                    } catch (InterruptedException ignored) { }
                });

            pressingThread3.setDaemon(true);
            pressingThread3.start();

            year.getText();
        }

    @FXML
        private void onRelease()
            {
                pressingThread.interrupt();
            }

    @FXML
        private void onRelease2()
            {
                pressingThread2.interrupt();
            }

    @FXML
        private void onRelease3()
            {
                pressingThread3.interrupt();
            }

    public static String getStrYears()
        {
            return strYears;
        }
}