package com.github.superguideguy.g3ep;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class BinCreator implements Runnable, ActionListener {

	JFrame			frame;
	JTabbedPane		pane;
	JPanel			panelNews, panelCard, panelEvent;

	JSpinner		newsId;
	ButtonGroup		newsDistributeGroup, newsColorGroup;
	JRadioButton	newsNonDistribute, newsReDistribute;
	JRadioButton	newsColorYellow, newsColorCyan, newsColorRed, newsColorGreen, newsColorBlue, newsColorOlive,
			newsColorGold, newsColorSilver;
	JTextField		newsText[];

	JSpinner		cardId;
	JSpinner		icon;
	// TODO reserved elements and flags/color
	JTextField		cardText[];

	// TODO panelEvent

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		frame = new JFrame("Pokémon Generation III Event Creator");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setBounds(0, 0, 600, 400);
		pane = new JTabbedPane();

		// ...

		pane.setSelectedIndex(1);
		frame.getContentPane().add(pane, null);
		frame.setVisible(true);
	}

}
