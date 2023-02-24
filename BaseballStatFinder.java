import java.util.*;
import java.io.*;
import java.net.*;


public class BaseballStatFinder{

    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args)throws IOException{
       String[] playerInfo = getPlayer();
    }


    // This method handles getting the general information of a specific player
    private static String[] getPlayer() throws IOException{

        String[] playerInfo = new String[24];
        System.out.print("Enter the first and last name of the player: ");
        String playerName = keyboard.nextLine().trim();

        // Makes name comma separated
        int index = playerName.indexOf(" ");
        playerName = playerName.substring(0,index) + "," + playerName.substring(index+1);



        URL url = new URL("https://raw.githubusercontent.com/chadwickbureau/baseballdatabank/master/core/People.csv");
        Scanner scan = new Scanner(url.openStream());
        scan.useDelimiter(",");


        while(scan.hasNextLine() && playerInfo[0] == null){

            String line = scan.nextLine();

            if(line.contains(playerName)){
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(",");
                for(int i = 0; i < playerInfo.length; i++)
                    playerInfo[i] = lineScanner.next();
                lineScanner.close();
            }
                
        }

        scan.close();
        return playerInfo;

    }
}