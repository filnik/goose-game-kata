public class Command {
    private Output output;
    private static int round = 0;

    public Command(Output output) {
        this.output = output;
    }

    public void execute() {
        if (round == 0){
            output.print("players: Pippo");
            round++;
        } else {
            output.print("players: Pippo, Pluto");
        }
    }
}
