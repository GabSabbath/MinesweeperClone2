import GameObjects.Board;
import GameObjects.Tile;

import java.util.Scanner;

public class ConsoleGameEngine {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);


        var board = new Board(16,10, 25);
        System.out.println(boardToString(board));
        while(!board.isGameover()){
            System.out.println("Select x: ");
            int x = in.nextInt();
            System.out.println("Select y: ");
            int y = in.nextInt();

            board.discover(x, y);

            System.out.println(boardToString(board));
        }
    }

    private static String boardToString(Board board){
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
}
