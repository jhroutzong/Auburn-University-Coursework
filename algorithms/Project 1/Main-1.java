import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            CollectData.collectData();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
