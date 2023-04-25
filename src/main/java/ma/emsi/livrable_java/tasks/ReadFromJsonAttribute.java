package ma.emsi.livrable_java.tasks;


import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromJsonAttribute {
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        String fileName = "src/main/resources/game.json";
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(fileName));
            JSONArray gamesArray = (JSONArray) obj;

            Gson gson = new Gson();
            for (Object gameObj : gamesArray) {
                JSONObject gameJson = (JSONObject) gameObj;
                String title = (String) gameJson.get("title");
                System.out.println(title); // or do something else with the game object
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
