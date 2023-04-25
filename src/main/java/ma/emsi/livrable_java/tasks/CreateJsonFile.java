package ma.emsi.livrable_java.tasks;

import com.google.gson.Gson;
import ma.emsi.livrable_java.entities.Game;

import java.io.FileWriter;
import java.io.IOException;

public class CreateJsonFile {
    public static void main(String[] args) {
        String fileName = "src/main/resources/gameJson.txt";
        // create a Game object
        Game[] games = {
                new Game("The Legend of Zelda: Breath of the Wild", "Action-adventure", 2017, 59.99, 10),
                new Game("Final Fantasy VII", "RPG", 1997, 39.99, 9),
                new Game("Super Mario 64", "Platform", 1996, 19.99, 8),
                new Game("The Last of Us", "Action-adventure", 2013, 19.99, 9),
                new Game("Red Dead Redemption 2", "Action-adventure", 2018, 59.99, 10),
                new Game("The Witcher 3: Wild Hunt", "Action-adventure", 2015, 39.99, 9),
                new Game("Grand Theft Auto V", "Action-adventure", 2013, 19.99, 9)
        };



        // convert the Game object to JSON string
        Gson gson = new Gson();
        String json = gson.toJson(games);


        // write the JSON string to a file
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(json);
            System.out.println("Successfully wrote JSON to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
