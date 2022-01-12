/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buttons;

import javafx.scene.paint.Color;
import static buttons.initialize.rpmGauge;
import static buttons.initialize.gradient1;
import static buttons.initialize.gradient2;
        

/**
 *
 * @author Mostafa Adel
 */
public class LightDark {
    static public Color foregroundBaseColor=Color.WHITESMOKE;
    static public Color RadialGradient1 =Color.BLUE; 
    static public Color RadialGradient2=Color.BLACK ; 
    static public Color BackgroundColor=Color.BLACK ; 
    static public char Mode='d';
    
    static public void darkMode()
    {
        Mode='d';
        foregroundBaseColor=Color.WHITE;//ALICEBLUE or blue
        
        rpmGauge.setBackgroundPaint(gradient1);
        rpmGauge.setForegroundBaseColor(Color.WHITE);
        initialize.scene.setFill(Color.BLACK);
        //ToDo Dark Map
    }
    

    static public void lightMode()
    {
        Mode='l';
        rpmGauge.setBackgroundPaint(gradient2);
        rpmGauge.setForegroundBaseColor(Color.BLACK);
        initialize.scene.setFill(Color.web("FAEBD7"));
        //ToDo light Map
    }
    
}
