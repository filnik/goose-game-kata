public class CommandFactory {
    private Output output;

    public CommandFactory(Output output) {
        this.output = output;
    }

    public Command from(String inputString) {
        return new Command(output);
    }
}
