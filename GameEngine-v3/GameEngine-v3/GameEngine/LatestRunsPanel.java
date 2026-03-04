package GameEngine;

import javax.swing.*;
import java.awt.*;

public class LatestRunsPanel extends JPanel {

    public LatestRunsPanel(LatestRuns latestRuns) {
        JLabel title = new JLabel("Latest Runs");
        JList<String> list = new JList<>(latestRuns.getModel());

        add(title);
        add(list);
    }
}
