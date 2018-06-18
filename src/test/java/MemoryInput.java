import java.util.ArrayList;
import java.util.Arrays;

public class MemoryInput implements Input {
    private int counter = 0;
    private ArrayList<String> inputArray = new ArrayList<String>();

    public void write(String... input) {
        this.inputArray.addAll(Arrays.asList(input));
    }

    public boolean hasNext() {
        return inputArray != null && counter < inputArray.size();
    }

    public String next() {
        return inputArray.get(counter++);
    }
}
