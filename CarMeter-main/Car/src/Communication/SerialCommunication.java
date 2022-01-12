
package Communication;
//import gnu.io.CommPort;
import static buttons.initialize.serialComm;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.Enumeration;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
/**
 *
 * @author Hanna Nabil
 */
public class SerialCommunication  {
    BufferedReader buf;
    int flag =0;
    String temp = null;
    String portName;
    Thread thread_serial;
    SerialPort sp;
     public SerialCommunication()
    {
        super();
    }
    
     public void connect () throws Exception
    {
        
        System.out.println("Communication.SerialCommunication.connect()");
        Enumeration<?> e = CommPortIdentifier.getPortIdentifiers();
        while (e.hasMoreElements()) {
                        CommPortIdentifier portIdentifier = (CommPortIdentifier) e.nextElement();
                        //System.out.println("gowa el while");
                        if ( portIdentifier.isCurrentlyOwned() )
                        {
                            System.out.println("Error: Port is currently in use");
                        }
                        else{
                            if (portIdentifier.getPortType() == CommPortIdentifier.PORT_SERIAL) {//only serial ports will be handled
                                    portName = portIdentifier.getName();
                                    System.out.println(portName);//print the serial port name
                                    
                                    sp = (SerialPort) portIdentifier.open(this.getClass().getName(),2000);
                                    sp.setSerialPortParams(19200, SerialPort.DATABITS_8,SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                                    
                                    InputStream in = sp.getInputStream();
                                  
                                    thread_serial =new Thread(new SerialReader(in));
                                    thread_serial.start();
                                    System.out.println("serial thread started");
                            }
                        }                   
                                
			}    
    }
     
    
     public void disconnect(){
         if (thread_serial.isAlive()){
         thread_serial.stop();
         sp.close();
         System.out.println("serial thread terminated");
         }
     }
     
     public void reportAndLogException(final Throwable t) {
        Platform.runLater(() -> {
            //Adding audio file here 
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("GPS Connection!!");
            alert.setHeaderText("Your deviced is disconnected");
            alert.setContentText("Please ! Reconnect and restart the app");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                System.exit(0);
            }
        });
    }
     class SerialReader implements Runnable 
    {
        InputStream in;
        String temp2;
        
        public SerialReader ( InputStream in )
        {
            this.in = in;
        }
        
        @Override
        public void run ()
        {
            byte[] buffer = new byte[1024];
            int len = -1;
            try
            {
                while (( len = this.in.read(buffer)) > -1 )
                {
                    String str =new String(buffer,0,len);
                    
                    if (str.equals("$")){flag =1;continue;}// this is beacuse when handling GGA sentence the mobile sends a newline $ then the GGA sentence
                    if (flag ==1){str="$"+str;flag =0;}
                    Reader inputString = new StringReader(str);
                    buf = new BufferedReader(inputString);
                    //System.out.println(str);//new String(buffer,int offset,int length)	
                }
                System.out.println("ByeBye");
            }
            catch ( IOException e )
            {
                reportAndLogException(e);
                
            } 
        }
    }
    /*
    public static void main ( String[] args )
    {
        try
        {
            (new SerialCommunication()).connect();
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }
*/
}
