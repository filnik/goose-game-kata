public class GooseGame {
    private Input input;
    private Output output;

    public GooseGame(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        CommandFactory commandFactory = new CommandFactory(output);
        while(input.hasNext()) {
            Command command = commandFactory.from(input.next());
            command.execute();
        }
    }
}
