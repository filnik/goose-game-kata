public class BounceRule implements Rule {
    @Override
    public String applyRule(GameData gameData, Integer finalPosition, String outputString) {
        if (finalPosition > MoveCommand.FINAL_POSITION) {
            int realFinalPosition = MoveCommand.FINAL_POSITION * 2 - finalPosition;
            outputString = outputString.substring(0, outputString.length() - 2)
                    + String.format("%s. %s bounces! %s returns to %s", MoveCommand.FINAL_POSITION,
                    gameData.getPlayer().getName(), gameData.getPlayer().getName(), realFinalPosition);

        }
        return outputString;
    }
}
