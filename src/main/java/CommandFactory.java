
public class CommandFactory {
    private Command[] commandsSupported;

    public CommandFactory(Output output) {
        PlayersRepository players = new PlayersRepository();
        this.commandsSupported = new Command[]{
                new AddCommand(players, output),
                new MoveCommand(players, output)
        };
    }

    public Command from(String inputString) {
        for (Command command : commandsSupported){
            if (command.matches(inputString)){
                command.add(inputString);
                return command;
            }
        }
        return nullCommand;
    }

    private Command nullCommand = new Command(null, null) {

        @Override
        public void execute() {

        }

        @Override
        public boolean matches(String inputString) {
            return false;
        }
    };
}
