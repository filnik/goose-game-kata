public class WinRule implements Rule {
    @Override
    public String applyRule(GameData gameData, Integer finalPosition, String outputString) {
        if (finalPosition == MoveCommand.FINAL_POSITION) {
            outputString += String.format(". %s Wins!!", gameData.getPlayer().getName());
        }
        return outputString;
    }
}
