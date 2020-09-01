package com.github.superguideguy.g3ep;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Runner implements Runnable, ActionListener {

	JFrame		frame;
	JTabbedPane	pane;
	JPanel		panelSav, panelRom, panelBin;

	JLabel		savInLabel, savOutLabel, binInLabel, romInLabel, romOutLabel;
	JTextField	savInField, savOutField, binInField, romInField, romOutField;
	JButton		savInBrowse, savOutBrowse, binInBrowse, romInBrowse, romOutBrowse;
	JButton		savPatcherCalc, romPatcherCalc, binOpenCalc;

	public static void main(String[] args) {
		Thread t = new Thread(new Runner());
		t.start();
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		frame = new JFrame("Pokémon Generation III Event Patcher");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 600, 190);
		pane = new JTabbedPane();

		panelSav = new JPanel();
		panelSav.setLayout(null);
		savInLabel = new JLabel("Current Save File:");
		savInLabel.setBounds(10, 10, 130, 20);
		panelSav.add(savInLabel);
		savInField = new JTextField();
		savInField.setBounds(150, 10, 390, 20);
		panelSav.add(savInField);
		savInBrowse = new JButton(UIManager.getIcon("FileView.directoryIcon"));
		savInBrowse.setBounds(550, 10, 20, 20);
		savInBrowse.setActionCommand("savInBrowse");
		savInBrowse.addActionListener(this);
		panelSav.add(savInBrowse);
		savOutLabel = new JLabel("New Save File:");
		savOutLabel.setBounds(10, 40, 130, 20);
		panelSav.add(savOutLabel);
		savOutField = new JTextField();
		savOutField.setBounds(150, 40, 390, 20);
		panelSav.add(savOutField);
		savOutBrowse = new JButton(UIManager.getIcon("FileView.directoryIcon"));
		savOutBrowse.setBounds(550, 40, 20, 20);
		savOutBrowse.setActionCommand("savOutBrowse");
		savOutBrowse.addActionListener(this);
		panelSav.add(savOutBrowse);
		binInLabel = new JLabel("Event File:");
		binInLabel.setBounds(10, 70, 130, 20);
		panelSav.add(binInLabel);
		binInField = new JTextField();
		binInField.setBounds(150, 70, 390, 20);
		panelSav.add(binInField);
		binInBrowse = new JButton(UIManager.getIcon("FileView.directoryIcon"));
		binInBrowse.setBounds(550, 70, 20, 20);
		binInBrowse.setActionCommand("binInBrowse");
		binInBrowse.addActionListener(this);
		panelSav.add(binInBrowse);
		savPatcherCalc = new JButton("Patch SAV File");
		savPatcherCalc.setBounds(200, 100, 200, 20);
		savPatcherCalc.setActionCommand("savPatcherCalc");
		savPatcherCalc.addActionListener(this);
		panelSav.add(savPatcherCalc);
		pane.add("SAV Patcher", panelSav);

		panelRom = new JPanel();
		panelRom.setLayout(null);
		// ...
		pane.add("ROM Patcher", panelRom);

		panelBin = new JPanel();
		panelBin.setLayout(null);
		// ...
		pane.add("Event BIN Creator", panelBin);

		pane.setSelectedIndex(0);
		frame.getContentPane().add(pane, null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
