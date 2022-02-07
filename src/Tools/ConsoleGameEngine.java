package Tools;

import GameObjects.Board;
import Tools.ConsoleHelper;

import java.util.Scanner;

public class ConsoleGameEngine {
    public static void main(String[] args){
        var board = new Board(16,10, 25);
        System.out.println(ConsoleHelper.boardToString(board));
        while(!board.isGameover()){
            var coordinates = ConsoleHelper.getCoordinatesToDiscover(board);
            board.discover(coordinates.x, coordinates.y);
            System.out.println(ConsoleHelper.boardToString(board));
        }
    }
}
