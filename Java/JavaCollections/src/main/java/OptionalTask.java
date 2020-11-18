import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class OptionalTask {
    public static void firstTask() {

        ArrayList<String> stringsList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream("C:\\text.txt")) {
            StringBuilder word = new StringBuilder();
            int c;
            while ((c = fis.read()) != -1) {
                if (c == '\r') continue;
                if (c == '\n') {
                    stringsList.add(word.toString());
                    continue;
                }
                word.append((char) c);

            }

            for (int i = stringsList.size(); i > 0; i--) {
                System.out.println(stringsList.get(i));
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
