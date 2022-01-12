/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buttons;

//import Communication.Carmeter;
import static buttons.initialize.thread_readLine;
import Communication.Carmeter.ReadLine;
import static buttons.initialize.gx;
import static buttons.initialize.gy;
import static buttons.initialize.ix;
import static buttons.initialize.iy;
import static buttons.initialize.pane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import getMap.Map;
import static buttons.initialize.img;
import static buttons.initialize.img2;
import static buttons.initialize.img3;
import static buttons.initialize.img4;
import static buttons.initialize.img5;
import static buttons.initialize.img6;
import static buttons.initialize.img7;
import static buttons.initialize.img8;
import static buttons.initialize.view;
import static buttons.initialize.view2;
import static buttons.initialize.view3;
import static buttons.initialize.view4;
import static buttons.initialize.view5;
import static buttons.initialize.view6;
import static buttons.initialize.view7;
import static buttons.initialize.view8;
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
//import static buttons.initialize.map;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import static buttons.initialize.player;
import com.sun.jmx.snmp.daemon.CommunicatorServer;
import static buttons.initialize.serialComm;
import Communication.SerialCommunication;
import static buttons.initialize.mapView;
/**
 *
 * @author yasmin
 */
public class Draw {
    
    public  static void DrawButton(){
             //Creating a graphic (image of start button)  
        
             //serial thread realine init
       thread_readLine = new Thread(new ReadLine());
       serialComm=new SerialCommunication();
        
       img = new Image("buttons/start.png");
        
     
      //Creating a graphic (image of stop button) 
      
       img2 = new Image("buttons/stop.jpg");
      
      
      //Creating a graphic (image of latitude button)
      
       img3 = new Image("buttons/latitude.png");
      
      //Creating a graphic (image of longtitude button)
      
       img4 = new Image("buttons/longtitude.jpg");
        
     //Creating a graphic (image of SoundOff button)
      
       img5 = new Image("buttons/soundoff.jpg");

       
    //Creating a graphic (image of Switch button)
      
      img6 = new Image("buttons/switch.jpg");
      
      
      //Creating a graphic (image of light mode button)
      
      img7 = new Image("buttons/light.png");
      
      //Creating a graphic (image of dark button)
      
      img8 = new Image("buttons/dark.png");



    //viewing start img
       view = new ImageView(img);
      
      //viewing stop img
      
       view2 = new ImageView(img2);
      
      
        //viewing latitude img
      
       view3 = new ImageView(img3);
      
      
       //viewing longtitude img
      
       view4 = new ImageView(img4);
      
            //viewing soundOff img
      
       view5 = new ImageView(img5);

       //viewing switch img
      
       view6 = new ImageView(img6);
      
      //viewing light mode img
      
       view7 = new ImageView(img7);
      
      //viewing dark mode img
      
       view8 = new ImageView(img8);
      

      //viewing the image of start button
      
      view.setFitHeight(100);
      view.setFitWidth(40);
     
      view.setPreserveRatio(true);
      
      
      //viewing the image of stop button
      
      view2.setFitHeight(40);
      
      view2.setPreserveRatio(true);
      

      //viewing the image of latitude button
      
      view3.setFitHeight(60);
      
      view3.setPreserveRatio(true);


      //viewing the image of longtitude button
      
      view4.setFitHeight(60);
      
      view4.setPreserveRatio(true);
     //viewing the image of soundOff button
      
      view5.setFitHeight(40);
      
      view5.setPreserveRatio(true);
      //viewing the image of switch button
      
      view6.setFitHeight(40);
      
      view6.setPreserveRatio(true);
      
      //viewing the image of light mode button
      
      view7.setFitHeight(40);
      
      view7.setPreserveRatio(true);
      
      //viewing the image of dark mode button
      
      view8.setFitHeight(40);
      
      view8.setPreserveRatio(true);
      
      //Creating play, stop, latitude, longtitude, soundOff, switch, light mode and dark mode buttons
      

      //Creating play, stop, latitude and longtitude buttons
      
       start = new ToggleButton();
      
       stop = new ToggleButton();
      
       latitude = new ToggleButton();
      
       longtitude = new ToggleButton();
      
       soundOff = new ToggleButton();
	   
      //setting darkmode 
      dark = new ToggleButton();
      light = new ToggleButton();
      Switch = new ToggleButton();
      LatitudeText=new Text();
      LongitudeText=new Text(); 
      
      LatitudeText.setFill(Color.DARKGRAY);
      LatitudeText.setFont(Font.font("Helvetica", FontPosture.ITALIC, 36));
      LongitudeText.setFill(Color.DARKGRAY);
      LongitudeText.setFont(Font.font("Helvetica", FontPosture.ITALIC, 36));
      //Setting the location of play button
      
      start.setTranslateX(20);
      
      start.setTranslateY(25);
      
      //Setting the location of stop button
      
      stop.setTranslateX(95);
      
      stop.setTranslateY(25);
      
      
      //Setting the location of latitude button
      
      latitude.setTranslateX(25);
      
      latitude.setTranslateY(620);
      
      LatitudeText.setTranslateX(140);
      LatitudeText.setTranslateY(680);
      
      
      //Setting the location of longtitude button
      
      longtitude.setTranslateX(25);
      
      longtitude.setTranslateY(700);
      
      LongitudeText.setTranslateX(140);
      LongitudeText.setTranslateY(750);
       //Setting the location of soundOff button
      
      soundOff.setTranslateX(1110);
      
      soundOff.setTranslateY(25);
      //Setting the location of switch button
      
      Switch.setTranslateX(1110);
      
      Switch.setTranslateY(80);
      
        //Setting the location of light mode button
      
      light.setTranslateX(900);
      
      light.setTranslateY(25);
      
        //Setting the location of dark mode button
      
      dark.setTranslateX(970);
      
      dark.setTranslateY(25);
      //Setting the size of the buttons
      
      start.setPrefSize(20,20);
      
      stop.setPrefSize(20,20);
      
      latitude.setPrefSize(80,40);
      
      longtitude.setPrefSize(80,40);
      
      soundOff.setPrefSize(30,30);
      
      Switch.setPrefSize(60,60);
      
      light.setPrefSize(60,60);
      
      dark.setPrefSize(60,60);
      //Setting the graphics to the buttons
      
      
      start.setGraphic(view);
      
      stop.setGraphic(view2);
      
      latitude.setGraphic(view3);
      
      longtitude.setGraphic(view4);
      
      soundOff.setGraphic(view5);
      
       Switch.setGraphic(view6);
      
      light.setGraphic(view7);
      
      dark.setGraphic(view8);
      
      player = new AudioPlay();
    }
//    public static void DrawMap(){
//
//       mapView.setTranslateX(ix);
//       mapView.setTranslateY(iy);
//    }
    public static void DrawSpeedometer(){
       MultiGauge gauge = new MultiGauge();        
       pane = gauge.initGraphics();
       
       pane.setTranslateX(gx);
       pane.setTranslateY(gy);
        
    }
    
}
