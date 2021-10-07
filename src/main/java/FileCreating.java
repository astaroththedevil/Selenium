import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileCreating {
    public static void main(String[] args) {
        try {
            Files.createFile(Paths.get("resources/file4.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path filepath = Paths.get("resources","", "file4.txt");
        try {
            Files.writeString(filepath,"QWERTY", StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
