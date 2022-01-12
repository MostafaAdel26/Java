/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


import buttons.Draw;
import static buttons.LightDark.BackgroundColor;
import javafx.application.Application;
import javafx.stage.Stage;
import buttons.HandleButton;
import static buttons.initialize.Lat;
import static buttons.initialize.scene;
import javafx.scene.Group;
import javafx.scene.Scene;

import static buttons.initialize.start;
import static buttons.initialize.stop;
import static buttons.initialize.latitude;
import static buttons.initialize.longtitude;
import static buttons.initialize.LongitudeText;
import static buttons.initialize.LatitudeText;
import static buttons.initialize.Long;
import static buttons.initialize.soundOff;
import static buttons.initialize.dark;
import static buttons.initialize.light;
import static buttons.initialize.Switch;
import static buttons.initialize.audioFilePath;
import static buttons.initialize.flag_position;
import static buttons.initialize.ix;
import static buttons.initialize.iy;
//import static buttons.initialize.map;
import static buttons.initialize.mapView;
import static buttons.initialize.pane;
import static buttons.initialize.player;
import com.dlsc.gmapsfx.GoogleMapView;
import com.dlsc.gmapsfx.MapComponentInitializedListener;
import com.dlsc.gmapsfx.javascript.object.GoogleMap;
import com.dlsc.gmapsfx.javascript.object.LatLong;
import com.dlsc.gmapsfx.javascript.object.MapOptions;
import com.dlsc.gmapsfx.javascript.object.MapTypeIdEnum;
import com.dlsc.gmapsfx.javascript.object.Marker;
import com.dlsc.gmapsfx.javascript.object.MarkerOptions;
import com.sun.prism.paint.Color;
import static Main.MapInit.MapInit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;



/**
 *
 * @author Mostafa Adel
 */

/*besm allaaah*/
public class main extends Application implements MapComponentInitializedListener {

    
    GoogleMap mapOr;
    MarkerOptions markerOptions;
    Marker marker;
    MapOptions mapOptions;
    Process process;
    public int x = 10;

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        //create a java class and add your key API to use google map
        //mapView = new GoogleMapView("en", "Add your key here");
        //mapView.setKey("Add your key here");
        
        MapInit();

        Draw.DrawButton();
        //Draw.DrawMap();
        mapView.setTranslateX(ix);
        mapView.setTranslateY(iy);
        Draw.DrawSpeedometer();

        Group root = new Group(mapView, pane, start, stop, latitude, longtitude, soundOff, dark, light, Switch, LongitudeText, LatitudeText);

        scene = new Scene(root, 1200, 800, BackgroundColor);//DIMGREY

        primaryStage.setTitle("CarMeter");

        primaryStage.setScene(scene);

        mapView.addMapInitializedListener(this);

        HandleButton.Handle_Buttons(primaryStage);

        primaryStage.show();

        try {
            process = java.lang.Runtime.getRuntime().exec("ping www.geeksforgeeks.org");
            x = process.waitFor();
        } catch (InterruptedException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (x == 0) {
            System.out.println("Connection Successful, "
                    + "Output was " + x);
            
        } else {
            System.out.println("Internet Not Connected, "
                    + "Output was " + x);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Do you want to continue");
            alert.setTitle("Internet is not connected");
            ButtonType yes = new ButtonType("Yes");
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(yes, no);
            
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == yes){}
            
            else {
                primaryStage.close();
                System.exit(0);
            }
        }
            
        }
//            while (x > 0) {
//                try {
//                    
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(GUIForTest.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            System.out.println("Connection Successful, "
//                    + "Output was " + x);
//            mapView.addMapInitializedListener(this);
//        }

    

    @Override
    public void stop() {
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        // player.play(audioFilePath);
    }

    @Override
    public void mapInitialized() {

        mapOptions = new MapOptions();
        mapOptions.center(new LatLong(30.08056024, 31.23717248))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(13);

        //mapView.setBackground(Background.EMPTY.getFills());
        mapOr = mapView.createMap(mapOptions);
        markerOptions = new MarkerOptions();
        markerOptions.position(new LatLong(Lat, Long))
                .visible(Boolean.TRUE)
                .title("My Marker");
        marker = new Marker(markerOptions);
        mapOr.addMarker(marker);
        mapOr.removeMarker(marker);

        Thread t = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    Platform.runLater(() -> {
                        if (flag_position == 1) {
                            //i+=0.001;
                            mapOr.removeMarker(marker);
                            markerOptions = new MarkerOptions();
                            markerOptions.position(new LatLong(Lat, Long))
                                    .visible(Boolean.TRUE)
                                    .title("My Marker");
                            marker = new Marker(markerOptions);
                            mapOr.addMarker(marker);
                            mapOr.setCenter(new LatLong(Lat, Long));
                        } else {
                            mapOr.clearMarkers();
                        }
                    });
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        t.start();

    }

}
