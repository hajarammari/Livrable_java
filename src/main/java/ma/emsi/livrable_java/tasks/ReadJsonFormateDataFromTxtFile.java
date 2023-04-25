package ma.emsi.livrable_java.tasks;


import ma.emsi.livrable_java.entities.Game;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

public class ReadJsonFormateDataFromTxtFile {
    public static void main(String[] args) {
        String fileName = "src/main/resources/game.json";


        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(fileName)); // replace "games.json" with your file path
            JSONArray gamesArray = (JSONArray) obj;
            Iterator<JSONObject> iterator = gamesArray.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObject = iterator.next();
                String title = (String) jsonObject.get("title");
                String genre = (String) jsonObject.get("genre");
                int releaseYear = Integer.parseInt(jsonObject.get("releaseYear").toString());
                double price = Double.parseDouble(jsonObject.get("price").toString());
                int rating = Integer.parseInt(jsonObject.get("rating").toString());
                Game game = new Game(title, genre, releaseYear, price, rating);
                System.out.println(game.toString()); // or do something else with the game object
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
