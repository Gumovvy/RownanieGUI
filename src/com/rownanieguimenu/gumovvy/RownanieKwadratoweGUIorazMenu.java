package com.rownanieguimenu.gumovvy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.SliderUI;

public class RownanieKwadratoweGUIorazMenu extends JFrame implements ActionListener {
	private JMenuBar mbMenu;
	private JMenu mPlik, mNarzedzia, mPomoc, mOpcje;
	private JMenuItem miOtworz, miZapisz, miWyjscie, miNarzedzie1, miNarzedzie2, miOprogramie, miOpcja1, miOpcja2;
	private JLabel lPolecenie, lZmiennaA, lZmiennaB, lZmiennaC, lWynik;
	private JTextField tZmiennaA, tZmiennaB, tZmiennaC, tWynik;
	private JButton bWyjscie, bWynik;
	private JCheckBoxMenuItem chbKolor;
	private JTextArea taNotatnik;

	public RownanieKwadratoweGUIorazMenu() {
		Toolkit zestaw = Toolkit.getDefaultToolkit();
		Dimension rozdzielczoscEkranu = zestaw.getScreenSize();
		int szerokoscEkarnu = rozdzielczoscEkranu.width;
		int wysokoscEkranu = rozdzielczoscEkranu.height;
		setSize(szerokoscEkarnu / 3, wysokoscEkranu / 3);
		setLocation(szerokoscEkarnu / 3, wysokoscEkranu / 4);
		setTitle("Rownanie kwadratowe");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(23, 45, 67));
		// Bar
		mbMenu = new JMenuBar();
		setJMenuBar(mbMenu);
		// plik

		mPlik = new JMenu("Plik");
		miOtworz = new JMenuItem("Otworz", 'O');
		miOtworz.addActionListener(this);
		miZapisz = new JMenuItem("Zapisz");
		miZapisz.addActionListener(this);
		miWyjscie = new JMenuItem("Wyjscie");
		// miWyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
		miWyjscie.addActionListener(this);

		mPlik.add(miOtworz);
		mPlik.add(miZapisz);
		mPlik.addSeparator();
		mPlik.add(miWyjscie);

		// Narzedzia
		mNarzedzia = new JMenu("Narzedzia");
		chbKolor = new JCheckBoxMenuItem("Narzedzie 1");
		chbKolor.addActionListener(this);
		miNarzedzie2 = new JMenuItem("Narzedzie 2");
		mNarzedzia.add(chbKolor);
		mNarzedzia.add(miNarzedzie2);

		mOpcje = new JMenu("Opcje");
		miOpcja1 = new JMenuItem("Opcja 1");
		miOpcja2 = new JMenuItem("Opcja 2");
		mNarzedzia.add(mOpcje);
		mOpcje.add(miOpcja1);
		mOpcje.add(miOpcja2);

		// Pomoc
		mPomoc = new JMenu("Pomoc");
		miOprogramie = new JMenuItem("O programie");
		miOprogramie.addActionListener(this);
		mPomoc.add(miOprogramie);

		mbMenu.add(mPlik);
		mbMenu.add(mNarzedzia);
		// mbMenu.add(Box.createHorizontalGlue());
		mbMenu.add(mPomoc);

		// Label

		lPolecenie = new JLabel("Wpisz liczby aby otrzymać wynik równania kwadratowego:");
		lPolecenie.setBounds(10, 10, 450, 25);
		lPolecenie.setForeground(Color.white);
		add(lPolecenie);

		lZmiennaA = new JLabel("A: ");
		lZmiennaA.setBounds(10, 50, 50, 25);
		lZmiennaA.setForeground(Color.white);
		add(lZmiennaA);

		lZmiennaB = new JLabel("B:");
		lZmiennaB.setBounds(160, 50, 50, 25);
		lZmiennaB.setForeground(Color.white);
		add(lZmiennaB);

		lZmiennaC = new JLabel("C:");
		lZmiennaC.setBounds(310, 50, 50, 25);
		lZmiennaC.setForeground(Color.white);
		add(lZmiennaC);

		lWynik = new JLabel("Wynik: ");
		lWynik.setBounds(10, 80, 80, 25);
		lWynik.setForeground(Color.white);
		add(lWynik);

		// Text Fieldy

		tZmiennaA = new JTextField("");
		tZmiennaA.setBounds(40, 50, 100, 25);
		add(tZmiennaA);

		tZmiennaB = new JTextField("");
		tZmiennaB.setBounds(190, 50, 100, 25);
		add(tZmiennaB);

		tZmiennaC = new JTextField("");
		tZmiennaC.setBounds(340, 50, 100, 25);
		add(tZmiennaC);

		tWynik = new JTextField("");
		tWynik.setBounds(60, 80, 380, 25);
		add(tWynik);

		// Buttony

		bWynik = new JButton("Oblicz");
		bWynik.setBounds(20, 130, 100, 25);
		bWynik.addActionListener(this);
		add(bWynik);

		bWyjscie = new JButton("Wyjscie");
		bWyjscie.setBounds(350, 130, 100, 25);
		bWyjscie.addActionListener(this);
		add(bWyjscie);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object zrodlo = e.getSource();

		if (zrodlo == miWyjscie || zrodlo == bWyjscie) {
			int odp = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz wyjsc?", "", JOptionPane.YES_NO_OPTION);
			if (odp == JOptionPane.YES_OPTION) {
				dispose();
			} else if (odp == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Dzieki ze ze mna zostales :)");
			} else if (odp == JOptionPane.CLOSED_OPTION) {
				JOptionPane.showMessageDialog(null, "Zostajesz!");
			}
		} else if (zrodlo == bWynik) {
			double zmA = Double.parseDouble(tZmiennaA.getText());
			double zmB = Double.parseDouble(tZmiennaB.getText());
			double zmC = Double.parseDouble(tZmiennaC.getText());
			RownanieKwadratowe rown = new RownanieKwadratowe(zmA, zmB, zmC);
			tWynik.setText(rown.rozwiazanie());
		} else if (zrodlo == miOprogramie) {
			JOptionPane.showMessageDialog(this, "Wersja programu 1.0.\n Projected and designed by Gmv");
		} else if (zrodlo == chbKolor) {
			if (chbKolor.isSelected()) {
				lPolecenie.setForeground(Color.yellow);
			} else {
				lPolecenie.setForeground(Color.white);
			}

		}
	}

	public static void main(String[] args) {
		RownanieKwadratoweGUIorazMenu aplikacja = new RownanieKwadratoweGUIorazMenu();
		aplikacja.setVisible(true);

	}

}
