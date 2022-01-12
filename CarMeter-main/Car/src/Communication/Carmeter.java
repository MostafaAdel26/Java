package Communication;
//fakjfawje;ijf;joifj;eaoijefwa
import java.io.IOException;



import net.sf.marineapi.nmea.parser.SentenceFactory;
import net.sf.marineapi.nmea.sentence.GGASentence;
import net.sf.marineapi.nmea.sentence.RMCSentence;
import net.sf.marineapi.nmea.sentence.Sentence;
import net.sf.marineapi.nmea.sentence.SentenceValidator;

import static buttons.initialize.serialComm;

//import variables
import static buttons.initialize.Speed;
import static buttons.initialize.Lat;
import static buttons.initialize.Long;
import static buttons.initialize.flag_position;
import java.util.logging.Level;
import java.util.logging.Logger;





/**
 *
 * @author Hanna Nabil
 */
public class Carmeter {
    
    
    double i = 0.0001;
    double latitude=30.0813565;double longitude=31.2383316; double speed =0;
   // TextField text_latitude;

    Thread thread_readLine;

    
    
    public void init(){
        try {
 
            serialComm=new SerialCommunication();
            
            thread_readLine = new Thread(new ReadLine());
        
            //thread_readLine.start();
         
        } catch (Exception ex) {
            System.out.println("Init Exception");
            ex.printStackTrace();
        }
    }
    

    //----------------------------------------------------------------------------------------------------------

  
    public static class ReadLine implements Runnable 
    {
        @Override
        public void run ()
        {  
            while(true)
            {
                
            try {
                //System.out.println("serial " + serialComm.buf);
                Thread.sleep(10);
                //System.out.println(serialComm.buf.readLine());
                while(serialComm.buf != null &&((serialComm.temp = serialComm.buf.readLine()) != null)){
                    if (SentenceValidator.isValid(serialComm.temp)) {
                    //System.out.println("reading .. ");
                    
                    SentenceFactory sf = SentenceFactory.getInstance();
                    //if (sf.hasParser(serialComm.temp)){
                    Sentence s= sf.createParser(serialComm.temp);
                
                    if("RMC".equals(s.getSentenceId())) { 
				RMCSentence rmc= (RMCSentence) s;
                                Speed =rmc.getSpeed();
                                System.out.println("RMC speed: " + rmc.getSpeed());
                                
                                //text_speed.setText(Double.toString(rmc.getSpeed()));
                               
         
                    }
                    else if ("GGA".equals(s.getSentenceId())) {
                            GGASentence gga = (GGASentence) s;
                            Lat = gga.getPosition().getLatitude();
                            Long = gga.getPosition().getLongitude();
                         
                            System.out.println("latitude: " + Lat);
                            System.out.println(",longitude: " + Long);
                            System.out.println("GGA position: " + gga.getPosition());
                            flag_position = 1;
                    }
                    
                    //}
                          }
                }
            } catch (IOException ex) {
                    //ex.printStackTrace();
                    System.out.println("please connect your mobile or make sure or if you are already connected make sure that you have gps now connected on your device");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Carmeter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }      
        
        }
    }
    
    
}
