public class GameData {
    private final Player player;
    private final String firstDice;
    private final String secondDice;

    public GameData(Player player, String firstDice, String secondDice) {

        this.player = player;
        this.firstDice = firstDice;
        this.secondDice = secondDice;
    }

    public static GameData from(PlayersRepository players, String inputString) {
        String[] elements = inputString.split(" ");
        String playerName = elements[1];
        Player player = players.get(playerName);
        String firstDice = elements[2].replace(",", "");
        String secondDice = elements[3];
        return new GameData(player, firstDice, secondDice);
    }

    public int getSecondDice() {
        return Integer.valueOf(secondDice);
    }

    public int getFirstDice() {
        return Integer.valueOf(firstDice);
    }

    public Player getPlayer() {
        return player;
    }
}
