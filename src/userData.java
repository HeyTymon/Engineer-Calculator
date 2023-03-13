import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class userData
{
    protected HashMap<String,String> userInfo = new HashMap<>();

    File dataFile = new File("data.txt");
    Scanner dataScanner = new Scanner(dataFile);

    userData() throws FileNotFoundException {

        String login, password;

        try {
            FileReader fileReader = new FileReader(dataFile);

            while(dataScanner.hasNextLine())
            {
                login = dataScanner.nextLine();
                password = dataScanner.nextLine();

                userInfo.put(login,password);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //System.out.println(userInfo);
    }

    protected HashMap<String,String> getUserInfo()
    {
        return userInfo;
    }

}
