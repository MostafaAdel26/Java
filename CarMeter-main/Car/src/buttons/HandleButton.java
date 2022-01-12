/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buttons;

import static buttons.initialize.pane;
import static buttons.initialize.gx;
import static buttons.initialize.gy;
import static buttons.initialize.ix;
import static buttons.initialize.iy;
import static buttons.initialize.len;
import static buttons.initialize.width;
import static buttons.initialize.mapView;
import static buttons.initialize.startMode;
import static buttons.initialize.LongitudeMode;
import static buttons.initialize.LatitudeMode;

import static buttons.initialize.start;
import static buttons.initialize.stop;
import static buttons.initialize.latitude;
import static buttons.initialize.longtitude;
import static buttons.initialize.LongitudeText;
import static buttons.initialize.LatitudeText;
import static buttons.initialize.soundOff;
import static buttons.initialize.dark;
import static buttons.initialize.light;
import static buttons.initialize.Switch;
import static buttons.initialize.soundF;
import static buttons.initialize.Speed;
import static buttons.initialize.Lat;
import static buttons.initialize.Long;
import static buttons.initialize.audioClip;
import static buttons.initialize.audioFilePath;
import static buttons.initialize.player;
import static buttons.initialize.rpmGauge;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import static buttons.initialize.serialComm;
import Communication.Carmeter;
import static buttons.initialize.LatitudeText;
import static buttons.initialize.LongitudeText;
import static buttons.initialize.gh;
import static buttons.initialize.gw;
import static buttons.initialize.h1offset;
import static buttons.initialize.h2offset;
import static buttons.initialize.ih;
import static buttons.initialize.iw;
import static buttons.initialize.len;
import static buttons.initialize.pane;
import static buttons.initialize.sceneHight;
import static buttons.initialize.sceneWidth;
import static buttons.initialize.thread_readLine;
import static buttons.initialize.view;
import static buttons.initialize.view2;
import static buttons.initialize.view3;
import static buttons.initialize.view4;
import static buttons.initialize.view5;
import static buttons.initialize.view6;
import static buttons.initialize.view7;
import static buttons.initialize.view8;
import static buttons.initialize.w1offset;
import static buttons.initialize.w2offset;
import static buttons.initialize.x1offset;
import static buttons.initialize.x2offset;
import static buttons.initialize.y1offset;
import static buttons.initialize.y2offset;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

/**
 *
 * @author yasmin
 */
public class HandleButton {
    
    static double x1 ; //pane
    static double x2 ; //map
    static double y1;  //pane
    static double y2;  //map
    static double w1;  //pane
    static double w2;
    static double h1; //pane
    static double h2; //map
    static double maps = 1; //map
    static double maps2 = 0; //map
    
    public static void Handle_Buttons(Stage primaryStage) {
        Thread th1 = new Thread(() -> {
            while (true) {

                if ((startMode == 1) && (soundF == 0) && (Speed > 10)) {

                    player.play(audioFilePath);
                }
                try {
                    Thread.sleep(10);
                    //System.out.println("StartMode = " + startMode);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HandleButton.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        );
        th1.start();
        Thread th2 = new Thread(() -> {
            while (true) {

                width = primaryStage.getScene().getWidth();
                len = primaryStage.getScene().getHeight();
                
                x1 = gx + (width - sceneWidth) / 2 + (len - sceneHight) * x1offset; //pane  //-0.5  //1.2
                x2 = (ix + (width - sceneWidth) / 2 + (len - sceneHight) * x2offset) * maps; //map   //1.4   //-0.7
                y1 = gy - (len - sceneHight) / 2+ (len - sceneHight) * y1offset;  //pane    //0     //0.7
                y2 = (iy + (len - sceneHight) / 2+ (len - sceneHight) * y2offset) * maps; //map      //0     //-0.7
                w1 = gw * len + (len - sceneHight) * w1offset;                      //pane
                w2 = (iw * len + (len - sceneHight) * w2offset) * maps + width*maps2;//iw * len
                h1 = gh * len + (len - sceneHight) * h1offset;                      //pane
                h2 = (ih * len + (len - sceneHight) * h2offset) * maps + len*maps2;//ih
     
                pane.setTranslateX(x1);

                start.setTranslateX(20 + (width - sceneWidth) / 2 - (len - sceneHight) * 1.75);
                stop.setTranslateX(95 + (width - sceneWidth) / 2 - (len - sceneHight) * 1.4);
                latitude.setTranslateX(25 + (width - sceneWidth) / 2 - (len - sceneHight) * 1.75);
                LatitudeText.setTranslateX(140 + (width - sceneWidth) / 2 - (len - sceneHight) * 1.5);
                longtitude.setTranslateX(25 + (width - sceneWidth) / 2 - (len - sceneHight) * 1.75);
                LongitudeText.setTranslateX(140 + (width - sceneWidth) / 2 - (len - sceneHight) * 1.5);
                soundOff.setTranslateX(1110 + (width - sceneWidth) / 2 + (len - sceneHight) * 1.5);
                Switch.setTranslateX(1110 + (width - sceneWidth) / 2 + (len - sceneHight) * 1.5);
                light.setTranslateX(950 + (width - sceneWidth) / 2 + (len - sceneHight) * 0.9);
                dark.setTranslateX(1020 + (width - sceneWidth) / 2 + (len - sceneHight) * 1.2);
                mapView.setTranslateX(x2);

                start.setTranslateY(25 + (len - sceneHight) / 2 - (len - sceneHight) * 0.5);
                stop.setTranslateY(25 + (len - sceneHight) / 2 - (len - sceneHight) * 0.5);
                latitude.setTranslateY(620 + (len - sceneHight) / 2 - (len - sceneHight) * 0.3);
                LatitudeText.setTranslateY(680 + (len - sceneHight) / 2);
                longtitude.setTranslateY(700 + (len - sceneHight) / 2);
                LongitudeText.setTranslateY(750 + (len - sceneHight) / 2 +(len - sceneHight) * 0.3);
                soundOff.setTranslateY(25 + (len - sceneHight) / 2 - (len - sceneHight) * 0.5);
                Switch.setTranslateY(90 + (len - sceneHight) / 2 - (len - sceneHight) * 0.1);
                light.setTranslateY(25 + (len - sceneHight) / 2 - (len - sceneHight) * 0.5);
                dark.setTranslateY(25 + (len - sceneHight) / 2 - (len - sceneHight) * 0.5);
                pane.setTranslateY(y1);
                mapView.setTranslateY(y2);
                
                if (startMode == 1) {
                    rpmGauge.setValue(Speed);

                } else {
                    rpmGauge.setValue(0);
                }
                if (LatitudeMode == 1) {
                    LatitudeText.setText(String.format("%.3f",Lat));
                } else {
                    LatitudeText.setText("");
                }
                if (LongitudeMode == 1) {
                    LongitudeText.setText(String.format("%.3f",Long));
                } else {
                    LongitudeText.setText("");
                }
                Platform.runLater(() -> {
                    /*changes in scene must be here*/
                    
                     pane.setPrefSize(w1, h1);
                     mapView.setPrefWidth(w2);
                     mapView.setPrefHeight(h2);

                    view.setFitHeight(0.05 * len + (len - sceneHight) * 0.25);
                    view2.setFitHeight(0.05 * len + (len - sceneHight) * 0.25);
                    view3.setFitHeight(0.075 * len + (len - sceneHight) * 0.25);
                    view4.setFitHeight(0.075 * len + (len - sceneHight) * 0.25);
                    view5.setFitHeight(0.06 * len + (len - sceneHight) * 0.25);
                    view6.setFitHeight(0.05 * len + (len - sceneHight) * 0.25);
                    view7.setFitHeight(0.05 * len + (len - sceneHight) * 0.25);
                    view8.setFitHeight(0.06 * len + (len - sceneHight) * 0.25);

                    view.setFitWidth(0.05 * len + (len - sceneHight) * 0.25);
                    view2.setFitWidth(0.05 * len + (len - sceneHight) * 0.25);
                    view3.setFitWidth(0.075 * len + (len - sceneHight) * 0.25);
                    view4.setFitWidth(0.075 * len + (len - sceneHight) * 0.25);
                    view5.setFitWidth(0.06 * len + (len - sceneHight) * 0.25);
                    view6.setFitWidth(0.05 * len + (len - sceneHight) * 0.25);
                    view7.setFitWidth(0.05 * len + (len - sceneHight) * 0.25);
                    view8.setFitWidth(0.06 * len + (len - sceneHight) * 0.25);
                    
                    LongitudeText.setFont(Font.font("Helvetica", FontPosture.ITALIC, 36+ (len - sceneHight) * 0.25));
                    LatitudeText.setFont(Font.font("Helvetica", FontPosture.ITALIC, 36+ (len - sceneHight) * 0.25));

                    start.setOnAction((ActionEvent event) -> {
                        try {
                            serialComm.connect();//contains thread
                        } catch (Exception ex) {
                            System.out.println("Didn't find any port");
                            //Logger.getLogger(Carmeter.class.getName()).log(Level.SEVERE, null, ex);
                            //System.out.println("gowa el catch");
                        }
                        if (thread_readLine.isAlive() == false) {
                            thread_readLine.start();
                        } else {
                            thread_readLine.resume();
                        }
                        startMode = 1;
                    });
                    stop.setOnAction((ActionEvent event) -> {
                        
                        serialComm.disconnect();
                        if (thread_readLine.isAlive()==true){
                             thread_readLine.suspend();
                        }

                        startMode = 0;
                        soundF = 0;
                        LongitudeMode = 0;
                        LatitudeMode = 0;

                    });
                    Switch.setOnAction((ActionEvent event) -> {
                        //      System.out.println("Width in Run later="+width);
                        if (initialize.switchMode == 0) {
                            initialize.switchMode = 1;
                             /*Swap gx->ix*///gx=10 , ix=5
                            gx=gx+ix;  //15
                            ix=gx-ix;  //10
                            gx=gx-ix; //5
                            maps = 0;
                            maps2  = 1;
                         /* Swap  gy ->iy*/  
                            gy=gy+iy;  
                            iy=gy-iy;  
                            gy=gy-iy;
                          /* Swap gw ->iw*/  
                            gw=gw+iw;  
                            iw=gw-iw;  
                            gw=gw-iw;
                           /* Swap gh ->ih*/ 
                            gh=gh+ih;  
                            ih=gh-ih;  
                            gh=gh-ih;
                            
                           /* Swap w1offset ->w2offset*/ 
                            w1offset=w1offset+w2offset;  
                            w2offset=w1offset-w2offset;  
                            w1offset=w1offset-w2offset;
                            
                            
                           /* Swap h1offset ->w2offset*/ 
                            h1offset=h1offset+h2offset;  
                            h2offset=h1offset-h2offset;  
                            h1offset=h1offset-h2offset;
                           
                            
                            /* Swap x1offset ->x2offset*/ 
                            x1offset=1.2;  
                            x2offset=-0.7;  
                            y1offset=0.9;
                            y2offset=-0.7; 
//                            mapView.setTranslateX(gx);
//                            mapView.setTranslateY(gy);
//                            mapView.setPrefWidth(initialize.paneWidth);
//                            mapView.setPrefHeight(initialize.paneHight);

//                            pane.setTranslateX(ix);
//                            pane.setTranslateY(iy);
//                            pane.setPrefSize(initialize.mapWidth, initialize.mapHight);

                        } else {
                            initialize.switchMode = 0;
                            gx=gx+ix;  
                            ix=gx-ix;  
                            gx=gx-ix;
                            maps = 1;
                            maps2  = 0;
                         /* Swap  gy ->iy*/  
                            gy=gy+iy;  
                            iy=gy-iy;  
                            gy=gy-iy;
                          /* Swap gw ->iw*/  
                            gw=gw+iw;  
                            iw=gw-iw;  
                            gw=gw-iw;
                           /* Swap w1offset ->ih*/ 
                           gh=gh+ih;  
                            ih=gh-ih;  
                            gh=gh-ih;
                            
                            
                           /* Swap w1offset ->w2offset*/ 
                           w1offset=w1offset+w2offset;  
                            w2offset=w1offset-w2offset;  
                            w1offset=w1offset-w2offset;
                            
                            
                           /* Swap h1offset ->w2offset*/ 
                            h1offset=h1offset+h2offset;  
                            h2offset=h1offset-h2offset;  
                            h1offset=h1offset-h2offset;
                           
                            
                            /* Swap x1offset ->x2offset*/ 
                            x1offset=-0.5;  
                            x2offset=1.2;  
                            y1offset=0; //pane
                            y2offset=0; //map
//                            mapView.setTranslateX(ix);
//                            mapView.setTranslateY(iy);
//                            mapView.setPrefWidth(initialize.mapWidth);
//                            mapView.setPrefHeight(initialize.mapHight);

//                            pane.setTranslateX(gx);
//                            pane.setTranslateY(gy);
//                            pane.setPrefSize(initialize.paneWidth, initialize.paneHight);

                        }
                    });
                    dark.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {

                            LightDark.darkMode();
                        }
                    });

                    light.setOnAction((ActionEvent event) -> {
                        LightDark.lightMode();

                    });

                    soundOff.setOnAction((ActionEvent event) -> {
                        if (soundF == 0) {
                            soundF = 1;
                        } else {
                            soundF = 0;
                        }

                    });
                    latitude.setOnAction((ActionEvent event) -> {
                        if (startMode == 1) {
                            if (LatitudeMode == 1) {
                                LatitudeMode = 0;
                            } else {
                                LatitudeMode = 1;
                            }
                        }

                    });
                    longtitude.setOnAction((ActionEvent event) -> {
                        if (startMode == 1) {
                            if (LongitudeMode == 1) {
                                LongitudeMode = 0;
                            } else {
                                LongitudeMode = 1;
                            }
                        }

                    });
                }); //end of run later
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(initialize.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        );

        th2.start();
    }

}
