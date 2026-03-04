package GameEngine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FileHandler {

    public static void saveFile(String fileName, int[] data, int size) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < size; i++) {
                bw.write(data[i]);
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error saving file" + e.getMessage());
        }
    }
}
