package cli.FileManagers;

import java.io.File;
import java.util.Scanner;

import cli.CustomExceptions.CustomException;

public class FileManager {
    public String read(String fileName) throws CustomException {
        String data = "";
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                throw new CustomException("File Doesn't Exist.");
            }
            if (!file.isFile()) {
                throw new CustomException("Path is not a file.");
            }
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                data += line + (reader.hasNextLine() ? "\n" : "");
            }
            reader.close();
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
        return data;
    }
}
