package GameEngine;

import javax.swing.*;
import java.io.*;

public class LatestRuns {
    private final int MAX_RUNS = 3;
    private final String FILE_NAME = "latestRuns.txt";

    private DefaultListModel<String> listModel;

    private int[] runs = new int[MAX_RUNS];
    private int size;

    public LatestRuns() {
        listModel = new DefaultListModel<>();
        load();
    }

    public void add(int score) {
        for (int i = Math.min(size, MAX_RUNS - 1); i > 0; i--) {
            runs[i] = runs[i - 1];
        }
        runs[0] = score;
        if (size < MAX_RUNS) size++;

        listModel.clear();
        for (int i = 0; i < size; i++) {
            listModel.addElement((i + 1) + ". " + runs[i]);
        }
    }

    public DefaultListModel<String> getModel() {
        return listModel;
    }


    private void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("latestruns.txt"))) {
            for (int i = 0; i < size; i++) {
                bw.write(String.valueOf(runs[i]));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving: " + e.getMessage());
        }
    }

    private void load() {
        try (BufferedReader br = new BufferedReader(new FileReader("latestruns.txt"))) {
            String line;
            while ((line = br.readLine()) != null && size < MAX_RUNS) {
                runs[size] = Integer.parseInt(line.trim());
                size++;
            }
        } catch (IOException e) {
            size = 0;
        }
    }
}

