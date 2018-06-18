public abstract class Command {
    protected PlayersRepository players;
    protected Output output;
    protected String inputString;

    public Command(PlayersRepository players, Output output) {
        this.players = players;
        this.output = output;
    }

    public abstract void execute();

    public abstract boolean matches(String inputString);

    public void add(String inputString) {
        this.inputString = inputString;
    }
}
