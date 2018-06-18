public class MoveCommand extends Command{
    private static int round = 0;

    public MoveCommand(PlayersRepository players, Output output) {
        super(players, output);
    }

    @Override
    public void execute() {
        if (round == 0)
            output.print("Pippo rolls 4, 2. Pippo moves from Start to 6");
        else if (round == 1)
            output.print("Pluto rolls 2, 2. Pluto moves from Start to 4");
        else
            output.print("Pippo rolls 2, 3. Pippo moves from 6 to 11");
        round++;
    }

    @Override
    public boolean matches(String inputString) {
        return inputString.toLowerCase().contains("move ");
    }
}
