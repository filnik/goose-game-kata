import java.util.ArrayList;

public class Command {
    private PlayersRepository players;
    private Output output;
    private String inputString;

    public Command(PlayersRepository players, Output output, String inputString) {
        this.players = players;
        this.output = output;
        this.inputString = inputString;
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
}
