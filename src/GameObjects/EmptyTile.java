package GameObjects;

public class EmptyTile extends Tile{

    @Override
    public boolean isBomb() { return false; }

    @Override
    public void discover() {
        if(!isFlagged()){
            setVisible();
            if(getNumberOfAdjacentBombs() == 0){
                for (var adjacentTile: adjacentTiles) {
                    if(!adjacentTile.isBomb() &&
                            !adjacentTile.isVisible() &&
                            !adjacentTile.isFlagged()){

                        adjacentTile.discover();
                    }
                }
            }
        }
    }


}
