import java.io.File;
import java.util.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Numberguessing{
    public static void main(String args[]){

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int randomNumber = rand.nextInt(100) + 1;
    
        int attempts = 5;
        int i;

        // System.out.println("<<<<----The Game Is About The Guess The number selected By The Computer---->>>>> \n ");
        System.out.println("\n------------------------ The Number Guessing System ------------------------\n");

        // int tryCount = 0;
            for(i=1; i<=attempts; i++){
                System.out.print("Attempt "+ i + ": Enter your Guess between (1-100): ");
                int playerGuess = sc.nextInt();
            
            if(playerGuess == randomNumber){
                System.out.println("CORRECT!! YOU WIN");
                playSound("Win.wav");
                break;
                // System.out.println("it took you "+ tryCount +" tries");
            }
            else if(randomNumber > playerGuess ){
                System.out.println("NOPE! THE NUMBER IS HIGHER. GUESS AGAIN \n");
            }
            else{
                System.out.println("NOPE! THE NUMBER IS LOWER. GUESS AGAIN \n");
            }
            if(i == attempts){
                System.out.println("Sorry, you've used all 5 attempts");
                playSound("Lose2.wav");
            }
        }
        System.out.println("\n THE GUESSED NUMBER IS : "+randomNumber);
    }

    private static void playSound(String filename) {
        try {
            File soundFile = new File(filename);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 900);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}