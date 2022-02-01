import GameObjects.Board;
import GameObjects.Tile;

public class ConsoleGameEngine {
    public static void main(String[] args){
        var board = new Board(10,15, 9);
        System.out.println(boardToString(board));
    }

    private static String boardToString(Board board){
        var boardString = "";
        for(int y = 0; y < board.getHeight(); y++){
            boardString += "|";
            for(int x = 0; x < board.getWidth(); x++){

                boardString += tileToString(board.getTile(x, y)) + "|";
            }
            boardString += "\n";
        }
        return boardString;
    }

    private static String tileToString(Tile tile){
        String charToShow = "";
        if(tile.isVisible() || true){ // TODO
            if(tile.isBomb()){ charToShow = "B"; }
            else{ charToShow += tile.getNumberOfAdjacentBombs(); }
        }
        return charToShow;
    }
}
