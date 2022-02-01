package GameObjects;

import java.util.ArrayList;

public abstract class Tile {
    private boolean isVisible;
    protected ArrayList<Tile> adjacentTiles;
    public void addAdjacentTile(Tile tile){
        adjacentTiles.add(tile);
    }
    public boolean isVisible(){ return isVisible; }
    protected void setVisible(){ isVisible = true; }

    private boolean isFlagged;
    public boolean isFlagged() { return isFlagged; }
    public void setFlagged(boolean flagged) { isFlagged = flagged; }

    public abstract boolean isBomb();

    public Tile(){
        isVisible = false;
        isFlagged = false;
        adjacentTiles = new ArrayList<>();
    }

    public abstract void discover();

    public int getNumberOfAdjacentBombs(){
        int numberOfAdjacentBombs = 0;
        for (var tile: adjacentTiles ) {
            if(tile.isBomb()){ numberOfAdjacentBombs++; }
        }
        return numberOfAdjacentBombs;
    }
}
