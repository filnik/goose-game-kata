import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class PlayerTest {

    private MemoryInput input = new MemoryInput();
    private Output output = Mockito.mock(Output.class);
    private GooseGame gooseGame;

    @BeforeEach
    void setUp() {
        gooseGame = new GooseGame(input, output);
    }

    @Test
    void add(){
        input.write("add player Pippo");
        input.write("add player Pluto");

        gooseGame.start();

        verify(output).print("players: Pippo");
        verify(output).print("players: Pippo, Pluto");
    }

    @Test
    void duplicated(){
        /*
        If there is already a participant "Pippo"
        the user writes: "add player Pippo"
        the system responds: "Pippo: already existing player"
         */
        input.write("add player Pippo");
        input.write("add player Pippo");

        gooseGame.start();

        verify(output).print("players: Pippo");
        verify(output).print("Pippo: already existing player");
    }

    @Test
    void move() {
        /*
        If there are two participants "Pippo" and "Pluto" on space "Start"
        the user writes: "move Pippo 4, 2"
        the system responds: "Pippo rolls 4, 2. Pippo moves from Start to 6"
        the user writes: "move Pluto 2, 2"
        the system responds: "Pluto rolls 2, 2. Pluto moves from Start to 4"
        the user writes: "move Pippo 2, 3"
        the system responds: "Pippo rolls 2, 3. Pippo moves from 6 to 11"
         */

        input.write("add player Pippo");
        input.write("add player Pluto");
        input.write("move Pippo 4, 2");
        input.write("move Pluto 2, 2");
        input.write("move Pippo 2, 3");

        gooseGame.start();

        verify(output).print("players: Pippo");
        verify(output).print("players: Pippo, Pluto");
        verify(output).print("Pippo rolls 4, 2. Pippo moves from Start to 6");
        verify(output).print("Pluto rolls 2, 2. Pluto moves from Start to 4");
        verify(output).print("Pippo rolls 2, 3. Pippo moves from 6 to 11");
    }

    @Test
    void win() {
        /*
        If there is one participant "Pippo" on space "60"
        the user writes: "move Pippo 3, 2"
        the system responds: "Pippo rolls 3, 2. Pippo moves from 60 to 63. Pippo bounces! Pippo returns to 61"

         */

        input.write("add player Pippo");
        input.write("move Pippo 4, 56");
        input.write("move Pippo 1, 2");

        gooseGame.start();

        verify(output).print("players: Pippo");
        verify(output).print("Pippo rolls 4, 56. Pippo moves from Start to 60");
        verify(output).print("Pippo rolls 1, 2. Pippo moves from 60 to 63. Pippo Wins!!");
    }

    @Test
    void bounces() {
        /*
        If there is one participant "Pippo" on space "60"
        the user writes: "move Pippo 3, 2"
        the system responds: "Pippo rolls 3, 2. Pippo moves from 60 to 63. Pippo bounces! Pippo returns to 61"
         */

        input.write("add player Pippo");
        input.write("move Pippo 4, 56");
        input.write("move Pippo 3, 2");

        gooseGame.start();

        verify(output).print("players: Pippo");
        verify(output).print("Pippo rolls 4, 56. Pippo moves from Start to 60");
        verify(output).print("Pippo rolls 3, 2. Pippo moves from 60 to 63. Pippo bounces! Pippo returns to 61");
    }
}
