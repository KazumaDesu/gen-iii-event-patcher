package com.github.superguideguy.g3ep;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

public class BinCreator implements Runnable, ActionListener {

	JFrame		frame;
	JTabbedPane	pane;
	JPanel		panelNews, panelCard, panelEvent;

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
