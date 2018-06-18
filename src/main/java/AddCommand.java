public class AddCommand extends Command{

    public AddCommand(PlayersRepository players, Output output) {
        super(players, output);
    }

    public void execute() {
        Player player = Player.fromInputString(inputString);
        if (players.contains(player)){
            output.print("Pippo: already existing player");
        } else {
            players.add(player);
            String outputString = "players: ";
            for (Player singlePlayer : players) {
                outputString += singlePlayer.toString() + ", ";
            }
            outputString = outputString.replaceFirst(", $", "");
            output.print(outputString);
        }
    }

    @Override
    public boolean matches(String inputString) {
        return inputString.toLowerCase().contains("add player");
    }
}
