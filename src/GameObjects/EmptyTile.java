package GameObjects;

public class EmptyTile extends Tile{

    @Override
    public boolean isBomb() { return false; }

    @Override
    public void discover() {
        setVisible();
        for (var adjacentTile: adjacentTiles) {
            if(!adjacentTile.isBomb() &&
                    !adjacentTile.isVisible() &&
                    !adjacentTile.isFlagged()){
                discover();
            }
        }
    }


}
