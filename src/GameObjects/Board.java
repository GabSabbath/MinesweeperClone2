package GameObjects;

import java.util.Random;

public class Board {
    private Tile[][] gameBoard;
    private boolean gameover;
    public boolean isGameover(){ return gameover; }

    public int getHeight (){ return gameBoard[0].length; }
    public int getWidth (){ return gameBoard.length; }
    public Tile getTile(int x, int y){ return  gameBoard[x][y]; }

    public Board(int width, int height, int bombsCount){
        gameBoard = new Tile[width][height];
        gameover = false;
        fillBoardWithEmptyTiles();
        insertRandomBombs(bombsCount);
        linkTiles();
    }

    private void fillBoardWithEmptyTiles(){
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[0].length; j++){
                gameBoard[i][j] = new EmptyTile();
            }
        }
    }

    private void insertRandomBombs(int bombsCount){
        for(int i = 0; i <= bombsCount; i++){
            Random rng = new Random();
            int randomX = rng.nextInt(gameBoard.length);
            int randomY = rng.nextInt(gameBoard[0].length);

            while(gameBoard[randomX][randomY].isBomb()){
                randomX = rng.nextInt(gameBoard.length);
                randomY = rng.nextInt(gameBoard[0].length);
            }
            gameBoard[randomX][randomY] = new BombTile();
        }
    }

    private void linkTiles(){
        for(int x = 0; x < gameBoard.length; x++){
            for(int y = 0; y < gameBoard[0].length; y++){
                var targetTile = gameBoard[x][y];
                boolean isAtFarLeft = x <= 0;
                boolean isAtFarRight = x >= gameBoard.length - 1;
                boolean isAtTop = y >= gameBoard[0].length - 1;
                boolean isAtBottom = y <= 0;

                if(!isAtFarRight)
                    targetTile.addAdjacentTile(gameBoard[x+1][y]);
                if(!isAtFarRight && !isAtTop)
                    targetTile.addAdjacentTile(gameBoard[x+1][y+1]);
                if(!isAtTop)
                    targetTile.addAdjacentTile(gameBoard[x][y+1]);
                if(!isAtTop && !isAtFarLeft)
                    targetTile.addAdjacentTile(gameBoard[x-1][y+1]);
                if(!isAtFarLeft)
                    targetTile.addAdjacentTile(gameBoard[x-1][y]);
                if(!isAtFarLeft && !isAtBottom)
                    targetTile.addAdjacentTile(gameBoard[x-1][y-1]);
                if(!isAtBottom)
                    targetTile.addAdjacentTile(gameBoard[x][y-1]);
                if(!isAtFarRight && !isAtBottom)
                    targetTile.addAdjacentTile(gameBoard[x+1][y-1]);
            }
        }
    }

    public void discoverAllTiles(){
        for (Tile[] row:gameBoard) {
            for (Tile tile:row) {
                tile.setVisible();
            }
        }
    }

    public void discover(int x, int y){
        var discoveredTile = getTile(x, y);
        if(discoveredTile.isBomb()){
            gameover = true;
            discoverAllTiles();
        }
        else{
            discoveredTile.discover();
        }
    }
}
