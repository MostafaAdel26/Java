/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package buttons;

import static buttons.initialize.audioClip;
import java.io.File;
import java.io.IOException;
 
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import static buttons.initialize.soundF;
import static buttons.initialize.startMode;

/**
 *
 * @author yasmin
 */
public class AudioPlay implements LineListener  {
    
    boolean playCompleted;
   

    public void play(String audioFilePath) {
        File audioFile = new File(audioFilePath);
         
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
 
            AudioFormat format = audioStream.getFormat();
 
            DataLine.Info info = new DataLine.Info(Clip.class, format);
 
            audioClip = (Clip) AudioSystem.getLine(info);
 
            audioClip.addLineListener(this);
 
            audioClip.open(audioStream);
             
            audioClip.start();
          
             
            while (!playCompleted) {
                // wait for the playback completes
                if((soundF==1)||(startMode==0))
                    break;
                try {
                   Thread.sleep(10);
                  
                    //audioClip.wait(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            
              playCompleted = false;
            audioClip.close(); 
            System.out.println(audioClip.getFrameLength());
            
             
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }
    }
    @Override
     public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
         
        if (type == LineEvent.Type.START) {
            System.out.println("Playback started.");

             
        } else if (type == LineEvent.Type.STOP) {
            playCompleted = true;
            System.out.println("Playback completed.");
        }
 
    }
  
}
