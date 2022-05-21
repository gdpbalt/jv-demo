import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WorkWithBytes {
    public static void writeBytesToFile(String fileName, byte[] data) {
        try {
            Files.write(Paths.get(fileName), data);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Error write to file %s", fileName), e);
        }
    }
}
