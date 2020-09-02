package com.github.superguideguy.g3ep;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class BinCreator implements Runnable, ActionListener {

	JFrame			frame;
	JTabbedPane		pane;
	JPanel			panelNews, panelCard, panelEvent;

	JSpinner		newsId;
	ButtonGroup		newsDistributeGroup;
	JRadioButton	newsNonDistribute, newsReDistribute;
	JSpinner		newsColor;
	JRadioButton	newsColorYellow, newsColorCyan, newsColorRed, newsColorGreen, newsColorBlue, newsColorOlive,
			newsColorGold, newsColorSilver;
	JTextField[]	newsText;

	JSpinner		cardId;
	JSpinner		icon;
	ButtonGroup		cardDistributeGroup;
	JRadioButton	cardNonDistribute, cardOneDistribute, cardReDistribute;
	JSpinner		cardColor;
	JTextField[]	cardText;
	// TODO stamp mode
	// TODO counter mode

	JTextArea		eventScript;

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
		panelNews = new JPanel();

		pane.setSelectedIndex(1);
		frame.getContentPane().add(pane, null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
