import java.util.ArrayList;

public class PlayersRepository extends ArrayList<Player> {

    public Player get(String name) {
        for (Player player : this) {
            if (player.getName().equals(name)){
                return player;
            }
        }
        return null;
    }
}
