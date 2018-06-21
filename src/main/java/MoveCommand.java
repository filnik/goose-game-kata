public class MoveCommand extends Command{

    public static final int FINAL_POSITION = 63;

    public MoveCommand(PlayersRepository players, Output output) {
        super(players, output);
    }

    @Override
    public void execute() {
        String[] elements = inputString.split(" ");
        String playerName = elements[1];
        Player player = players.get(playerName);
        String firstDice = elements[2].replace(",", "");
        String secondDice = elements[3];

        String outputString = "%s rolls %s, %s. %s moves from %s to %s";
        Integer finalPosition = Integer.valueOf(firstDice) + Integer.valueOf(secondDice) + player.getPosition();
        String fromPosition = player.getPosition() == 0 ? "Start" : player.getPosition().toString();
        player.setPosition(finalPosition);

        if (finalPosition == FINAL_POSITION){
            outputString += String.format(". %s Wins!!", playerName);
        } else if (finalPosition > FINAL_POSITION){
            int realFinalPosition = FINAL_POSITION * 2 - finalPosition;
            outputString = outputString.substring(0, outputString.length()-2)
                    + String.format("%s. %s bounces! %s returns to %s", FINAL_POSITION, playerName, playerName, realFinalPosition);
        }

        output.print(String.format(outputString, playerName, firstDice, secondDice, playerName, fromPosition, finalPosition));

    }

    @Override
    public boolean matches(String inputString) {
        return inputString.toLowerCase().contains("move ");
    }
}
