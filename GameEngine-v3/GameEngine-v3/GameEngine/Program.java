package GameEngine;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Program extends JFrame {
	GameBoard board;

	public Program() {
		LatestRuns latestRuns = new LatestRuns();

		board = new GameBoard(latestRuns);
		LatestRunsPanel latestRunsPanel = new LatestRunsPanel(latestRuns);
		

		setLayout(new BorderLayout());
		add(board, BorderLayout.CENTER);
		add(latestRunsPanel, BorderLayout.WEST);

		setResizable(false);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		setFocusable(true);
		requestFocus();

		board.start();
	}

	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		board.processKeyEvent(e);
	}

	public static void main(String[] args) {
		Program program = new Program();
	}
}