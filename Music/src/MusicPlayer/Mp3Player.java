package MusicPlayer;

import javazoom.jl.player.Player;
import java.io.FileInputStream;

public class Mp3Player {
    public static void main(String[] args) {
        try {
            // Path to the MP3 file
            String filePath = "path/to/your/song.mp3";

            // Create a FileInputStream to the file
            FileInputStream fis = new FileInputStream(filePath);

            // Create a Player object
            Player player = new Player(fis);

            // Play the MP3 file
            System.out.println("Playing the MP3 file...");
            player.play();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
