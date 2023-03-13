import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args) {

        userData data;
        try {
            data = new userData();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        new LoginPage(data.getUserInfo());
    }
}