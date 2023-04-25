package ma.emsi.livrable_java.tasks;

import ma.emsi.livrable_java.entities.Game;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadWriteTxtFileAndBindWithObject {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/gameInputData.txt"));

        ArrayList<Game> list = new ArrayList<Game>();
        Game g = null;
        String readLine = br.readLine();

        while(readLine != null){

            String [] Game  = readLine.split("\\|");


            g = new Game();
            g.setTitle(Game[0].trim());
            g.setGenre(Game[1].trim());
            g.setReleaseYear(Integer.parseInt(Game[2].trim()));
            g.setPrice(Double.parseDouble(Game[3].trim()));
            g.setRating(Integer.parseInt(Game[4].trim()));
            list.add(g);
            readLine = br.readLine();
        }


        try( FileOutputStream fout = new FileOutputStream("src/main/resources/gameOutputData.txt"))
        {

            for(Game game : list){
                fout.write(game.toString().getBytes());
                fout.write('\n');

                System.out.println("Game :"+game.toString());
            }
        }
        catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

    }
}
