package Tools;

import GameObjects.Board;
import GameObjects.Tile;

import java.util.Scanner;

public class ConsoleHelper {
    public static String boardToString(Board board){
        var boardString = "   ";
        for(int x = 0; x < board.getWidth(); x++){
            boardString += (x < 10? '0' + Integer.toString(x) : x) + "|";
        }

        for(int y = 0; y < board.getHeight(); y++){
            boardString += "\n";
            boardString += (y < 10? '0' + Integer.toString(y) : y) + "|";
            for(int x = 0; x < board.getWidth(); x++){

                boardString += tileToString(board.getTile(x, y)) + " |";
            }
        }
        return boardString;
    }

    private static String tileToString(Tile tile){
        String charToShow = "";
        if(tile.isVisible()){ // TODO
            if(tile.isBomb()){ charToShow = "B"; }
            else{ charToShow += tile.getNumberOfAdjacentBombs(); }
        }
        else{
            charToShow = "X";
        }
        return charToShow;
    }

    public static Coordinate getCoordinatesToDiscover(Board board){
        Scanner in = new Scanner(System.in);
        System.out.println("Select x: ");
        int x = in.nextInt();
        while (x < 0 || x >= board.getWidth()){
            System.out.println("Error:\nEnter an x value between 0 and " + (board.getWidth() - 1) + ": ");
            x = in.nextInt();
        }
        System.out.println("Select y: ");
        int y = in.nextInt();
        while (y < 0 || y >= board.getHeight()){
            System.out.println("Error:\nEnter a y value between 0 and " + (board.getHeight() - 1) + ": ");
            y = in.nextInt();
        }
        return new Coordinate(x, y);
    }

    public static class Coordinate{
        public int x;
        public int y;
        public Coordinate(int x, int y){
            this.x = x; this.y =y;
        }
    }
}
