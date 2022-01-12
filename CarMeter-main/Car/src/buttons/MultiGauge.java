
package buttons;

import static buttons.LightDark.foregroundBaseColor;
import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.Gauge.NeedleShape;
import eu.hansolo.medusa.Gauge.NeedleSize;
import eu.hansolo.medusa.GaugeBuilder;
import eu.hansolo.medusa.TickMarkType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import static buttons.initialize.pane;
import static buttons.initialize.rpmGauge;
import static buttons.initialize.gradient1;
import static buttons.initialize.gradient2;
import javafx.scene.layout.StackPane;

public class MultiGauge extends Region {
    private static final double PREFERRED_WIDTH  = 320;
    private static final double PREFERRED_HEIGHT = 320;
    private static final double MINIMUM_WIDTH    = 5;
    private static final double MINIMUM_HEIGHT   = 5;
    private static final double MAXIMUM_WIDTH    = 1024;
    private static final double MAXIMUM_HEIGHT   = 1024;

//    public  static Gauge   rpmGauge;
       
//     public static RadialGradient gradient1;
//     public static RadialGradient gradient2;

    //constructor
    public MultiGauge() {
       
        
//getStylesheets().add("CSS/styles.css");
        
        init();
        
        
    }


    // ******************** Initialization ************************************
    public void init() {
        if (Double.compare(getPrefWidth(), 0.0) <= 0 || Double.compare(getPrefHeight(), 0.0) <= 0 ||
            Double.compare(getWidth(), 0.0) <= 0 || Double.compare(getHeight(), 0.0) <= 0) {
            if (getPrefWidth() > 0 && getPrefHeight() > 0) {
                setPrefSize(getPrefWidth(), getPrefHeight());
            } else {
                setPrefSize(PREFERRED_WIDTH, PREFERRED_HEIGHT);
            }
        }

        if (Double.compare(getMinWidth(), 0.0) <= 0 || Double.compare(getMinHeight(), 0.0) <= 0) {
            setMinSize(MINIMUM_WIDTH, MINIMUM_HEIGHT);
        }

        if (Double.compare(getMaxWidth(), 0.0) <= 0 || Double.compare(getMaxHeight(), 0.0) <= 0) {
            setMaxSize(MAXIMUM_WIDTH, MAXIMUM_HEIGHT);
        }
    }

    StackPane initGraphics() {
        
        
        Button btn = new Button();
        btn.setText("Start");
        
        gradient1 = new RadialGradient(0,
            .1,
            300,
            300,
            170,
            false,
            CycleMethod.NO_CYCLE,
            new Stop(0,Color.BLUE ),//ALICEBLUE or blue
            new Stop(1, Color.BLACK));   //white or black
            
        gradient2 = new RadialGradient(0,
            .1,
            300,
            300,
            170,
            false,
            CycleMethod.NO_CYCLE,
            new Stop(0,Color.ALICEBLUE ),//ALICEBLUE or blue
            new Stop(1, Color.web("#8FBC8F")));   //white or black
        rpmGauge = GaugeBuilder.create()
                               .borderPaint(Color.HONEYDEW)    //FlORALWHITE , HONEYDEW, AQUA
                               .foregroundBaseColor(foregroundBaseColor)
                                   //black or white
                               
                               .borderWidth(3.0)
                               .prefSize(initialize.paneWidth,initialize.paneHight)
                               .startAngle(300)
                               .angleRange(240)
                               .minValue(0)
                               .maxValue(160)
                               .valueVisible(false)
                               .minorTickMarksVisible(true)
                               .majorTickMarkType(TickMarkType.TRIANGLE)
                               .mediumTickMarkType(TickMarkType.BOX)
                               .title("KM/HR")
                               .needleShape(NeedleShape.ROUND)     
                               .needleSize(NeedleSize.THICK)
                               .needleColor(Color.rgb(234, 67, 38))   //needle color
                               .knobColor(Gauge.DARK_COLOR)    //point of the 
                               .customTickLabelsEnabled(true)
                               .customTickLabelFontSize(40)
                               .customTickLabels("0", "20", "40", "60", "80", "100", "120", "140", "160")
                               .animated(true)
                               .build();
        rpmGauge.setBackgroundPaint(gradient1);

     
        btn.setLayoutX(300);
        btn.setLayoutY(600);
        
        pane = new StackPane(rpmGauge); //add btn if u want
       

btn.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("Starting.....");
                     
                        rpmGauge.setValue(80);
    
                    }});
        return pane;
    }

        
    public Gauge getRpmGauge()  { return rpmGauge; }
//    public Gauge getTempGauge() { return tempGauge; }
//    public Gauge getOilGauge()  { return oilGauge; }


}
