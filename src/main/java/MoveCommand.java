public class MoveCommand extends Command{

    public static final int FINAL_POSITION = 63;
    private Rule[] rules = new Rule[]{new WinRule(), new BounceRule()};

    public MoveCommand(PlayersRepository players, Output output) {
        super(players, output);
    }

    @Override
    public void execute() {
        GameData gameData = GameData.from(players, inputString);

        String outputString = "%s rolls %s, %s. %s moves from %s to %s";
        Player player = gameData.getPlayer();
        Integer finalPosition = gameData.getFirstDice() + gameData.getSecondDice() + player.getPosition();
        String fromPosition = player.getPosition() == 0 ? "Start" : player.getPosition().toString();
        player.setPosition(finalPosition);

        for (Rule rule : rules){
            outputString = rule.applyRule(gameData, finalPosition, outputString);
        }

        output.print(String.format(outputString, player.getName(), gameData.getFirstDice(),
                gameData.getSecondDice(), player.getName(), fromPosition, finalPosition));

    }

    @Override
    public boolean matches(String inputString) {
        return inputString.toLowerCase().contains("move ");
    }
}
