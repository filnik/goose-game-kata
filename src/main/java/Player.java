import java.util.Objects;

public class Player {
    private String playerName;
    private Integer position;

    private Player(String playerName) {
        this.position = 0;
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

    public String getName() {
        return playerName;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
