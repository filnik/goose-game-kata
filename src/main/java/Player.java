import java.util.Objects;

public class Player {
    private String playerName;

    private Player(String playerName) {
        this.playerName = playerName;
    }

    public static Player fromInputString(String inputString) {
        return new Player(inputString.replace("add player ", ""));
    }

    @Override
    public String toString() {
        return playerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(playerName, player.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }
}
