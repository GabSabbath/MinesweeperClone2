package GameObjects;

public class BombTile extends Tile{
    @Override
    public boolean isBomb() { return true; }

    @Override
    public void discover() {
        setVisible();
    }
}
