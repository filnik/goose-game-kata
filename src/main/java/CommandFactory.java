public class CommandFactory {
    private final PlayersRepository players;
    private Output output;

    public CommandFactory(Output output) {
        this.output = output;
        this.players = new PlayersRepository();
    }

    public Command from(String inputString) {
        return new Command(players, output, inputString);
    }
}
