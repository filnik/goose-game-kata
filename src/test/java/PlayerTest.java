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
    public void addAPlayer(){
        input.write("add player Pippo");
        input.write("add player Pluto");

        gooseGame.start();

        verify(output).print("players: Pippo");
        verify(output).print("players: Pippo, Pluto");
    }

    @Test
    public void duplicatedPlayer(){
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
}
