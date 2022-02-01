package Tests;

import GameObjects.BombTile;
import GameObjects.EmptyTile;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TileTests {

    @Test
    public void testBombCount(){
        var tile = new EmptyTile();

        // Add 3 empty tiles
        for(int i = 0; i < 3; i++){
            tile.addAdjacentTile(new EmptyTile());
        }
        // Add 4 bombs
        for(int i = 0; i < 4; i++){
            tile.addAdjacentTile(new BombTile());
        }

        assertEquals(4, tile.getNumberOfAdjacentBombs());

        // Add an extra bomb
        tile.addAdjacentTile(new BombTile());
        assertEquals(5, tile.getNumberOfAdjacentBombs());
    }

}
