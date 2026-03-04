package GameEngine;

import javax.swing.*;

public class LatestRuns {
    private final int MAX_RUNS = 3;
    private final String FILE_NAME = "latestRuns.txt";

    private DefaultListModel<String> listModel;

    private int[] runs;
    private int size;

    public LatestRuns() {
        listModel = new DefaultListModel<>();
        runs = new int[MAX_RUNS];
        size = 0;
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
}
