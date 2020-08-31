package com.github.superguideguy.g3ep;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Runner implements Runnable, ActionListener {

	public static void main(String[] args) {
		Thread t = new Thread(new Runner());
		t.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
