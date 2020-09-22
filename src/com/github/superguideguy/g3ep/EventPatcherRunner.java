package com.github.superguideguy.g3ep;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class EventPatcherRunner implements ActionListener, Runnable {

	JFrame		frame;
	JPanel		panel;

	JLabel		savInLabel, savOutLabel, binInLabel, romInLabel, romOutLabel;
	JTextField	savInField, savOutField, binInField, romInField, romOutField;
	JButton		savInBrowse, savOutBrowse, binInBrowse, romInBrowse, romOutBrowse;
	JButton		savPatcherCalc, romPatcherCalc, binCreatorOpen;


	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		frame = new JFrame("Pokémon Generation III Event Patcher");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 600, 220); // h=190?
		panel = new JPanel();
		panel.setLayout(null);

		savInLabel = new JLabel("Current Save File:");
		savInLabel.setBounds(10, 10, 130, 20);
		savInField = new JTextField();
		savInField.setBounds(150, 10, 410, 20);
		savInBrowse = new JButton(UIManager.getIcon("FileView.directoryIcon"));
		savInBrowse.setBounds(570, 10, 20, 20);
		savInBrowse.setActionCommand("savInBrowse");
		savInBrowse.addActionListener(this);
		panel.add(savInLabel);
		panel.add(savInField);
		panel.add(savInBrowse);

		romInLabel = new JLabel("Current ROM File:");
		romInLabel.setBounds(10, 40, 130, 20);
		romInField = new JTextField();
		romInField.setBounds(150, 40, 410, 20);
		romInBrowse = new JButton(UIManager.getIcon("FileView.directoryIcon"));
		romInBrowse.setBounds(570, 40, 20, 20);
		romInBrowse.setActionCommand("romInBrowse");
		romInBrowse.addActionListener(this);
		panel.add(romInLabel);
		panel.add(romInField);
		panel.add(romInBrowse);

		binInLabel = new JLabel("Event File:");
		binInLabel.setBounds(10, 70, 130, 20);
		binInField = new JTextField();
		binInField.setBounds(150, 70, 410, 20);
		binInBrowse = new JButton(UIManager.getIcon("FileView.directoryIcon"));
		binInBrowse.setBounds(570, 70, 20, 20);
		binInBrowse.setActionCommand("binInBrowse");
		binInBrowse.addActionListener(this);
		panel.add(binInLabel);
		panel.add(binInField);
		panel.add(binInBrowse);

		savOutLabel = new JLabel("New Save File:");
		savOutLabel.setBounds(10, 100, 130, 20);
		savOutField = new JTextField();
		savOutField.setBounds(150, 100, 410, 20);
		savOutBrowse = new JButton(UIManager.getIcon("FileView.directoryIcon"));
		savOutBrowse.setBounds(570, 100, 20, 20);
		savOutBrowse.setActionCommand("savOutBrowse");
		savOutBrowse.addActionListener(this);
		panel.add(savOutLabel);
		panel.add(savOutField);
		panel.add(savOutBrowse);

		romOutLabel = new JLabel("New ROM File:");
		romOutLabel.setBounds(10, 130, 130, 20);
		romOutField = new JTextField();
		romOutField.setBounds(150, 130, 410, 20);
		romOutBrowse = new JButton(UIManager.getIcon("FileView.directoryIcon"));
		romOutBrowse.setBounds(570, 130, 20, 20);
		romOutBrowse.setActionCommand("romOutBrowse");
		romOutBrowse.addActionListener(this);
		panel.add(romOutLabel);
		panel.add(romOutField);
		panel.add(romOutBrowse);

		binCreatorOpen = new JButton("Open Event Creator");
		binCreatorOpen.setBounds(10, 160, 180, 20);
		binCreatorOpen.setActionCommand("binCreatorOpen");
		binCreatorOpen.addActionListener(this);
		binCreatorOpen.setEnabled(false);
		panel.add(binCreatorOpen);

		romPatcherCalc = new JButton("Patch ROM File");
		romPatcherCalc.setBounds(300, 160, 140, 20);
		romPatcherCalc.setActionCommand("romPatcherCalc");
		romPatcherCalc.addActionListener(this);
		panel.add(romPatcherCalc);

		savPatcherCalc = new JButton("Patch SAV File");
		savPatcherCalc.setBounds(450, 160, 140, 20);
		savPatcherCalc.setActionCommand("savPatcherCalc");
		savPatcherCalc.addActionListener(this);
		panel.add(savPatcherCalc);

		frame.getContentPane().add(panel, null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		boolean	success	= false;
		String	action	= arg0.getActionCommand();
		byte[]	rom		= null;
		switch (action) {
			case "savInBrowse":
				openFileBrowser(savInField);
				break;
			case "savOutBrowse":
				openFileBrowser(savOutField);
				break;
			case "binInBrowse":
				openFileBrowser(binInField);
				break;
			case "romInBrowse":
				openFileBrowser(romInField);
				break;
			case "romOutBrowse":
				openFileBrowser(romOutField);
				break;

			case "savPatcherCalc":
				byte[][] sav = FileHandler.getSaveFile(savInField.getText());
				if (sav == null) {
					JOptionPane.showMessageDialog(null,
							"The SAV file is missing or could not be read. Please check your filepath and try again.",
							"Error: Patch failed", JOptionPane.WARNING_MESSAGE);
					break;
				}
				rom = FileHandler.getRomFile(romInField.getText());
				if (rom == null) {
					JOptionPane.showMessageDialog(null,
							"The ROM file is missing or could not be read. Please check your filepath and try again.",
							"Error: Patch failed", JOptionPane.WARNING_MESSAGE);
					break;
				}
				byte[] patch = FileHandler.getRomFile(binInField.getText());
				if (patch == null) {
					JOptionPane.showMessageDialog(null,
							"The patch file is missing or could not be read. Please check your filepath and try again.",
							"Error: Patch failed", JOptionPane.WARNING_MESSAGE);
					break;
				}

				Version version = RomHandler.getVersion(rom);
				if (version == null) {
					JOptionPane.showMessageDialog(null,
							"The ROM file is corrupt or could not be read. Please check your filepath and try again.",
							"Error: Patch failed", JOptionPane.WARNING_MESSAGE);
					break;
				}
				success = SavPatcher.patchSav(sav, version, patch);
				if (!success) {
					JOptionPane.showMessageDialog(null,
							"The patch file is corrupt or incompatible with this game version. Please check your filepath and try again.",
							"Error: Patch failed", JOptionPane.WARNING_MESSAGE);
					break;
				}
				JOptionPane.showMessageDialog(null, "Success!", "Success!", JOptionPane.INFORMATION_MESSAGE);
				break;
			case "romPatcherCalc":
				rom = FileHandler.getRomFile(romInField.getText());
				if (rom == null) {
					JOptionPane.showMessageDialog(null,
							"The ROM file is missing or could not be read. Please check your filepath and try again.",
							"Error: Patch failed", JOptionPane.WARNING_MESSAGE);
					break;
				}
				RomHandler.patchRom(rom);
				JOptionPane.showMessageDialog(null, "Success!", "Success!", JOptionPane.INFORMATION_MESSAGE);
				break;
			case "binCreatorOpen":
				/*
				 * Thread t = new Thread(new BinCreator());
				 * t.start();
				 */
				break;
			default:
				JOptionPane.showMessageDialog(null,
						"WARNING: AN UNKNOWN ERROR HAS OCCURED. THE PROGRAM WILL TERMINATE.",
						"A CRITICAL ERROR HAS OCCURED", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
		}
	}

	private void openFileBrowser(JTextField output) {
		JFileChooser	browser			= new JFileChooser();
		int				hasSelectedFile	= browser.showOpenDialog(panel);
		if (hasSelectedFile == JFileChooser.APPROVE_OPTION) output.setText(browser.getSelectedFile().getAbsolutePath());
		else output.setText("");
	}

	public static void main(String[] args) {
		Thread t = new Thread(new EventPatcherRunner());
		t.start();
	}

}
