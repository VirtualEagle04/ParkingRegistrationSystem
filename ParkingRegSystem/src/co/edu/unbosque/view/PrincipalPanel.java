package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class PrincipalPanel extends JPanel {

	private JList<String> carList;
	private DefaultListModel<String> model;
	private JPanel panelList, secondbg;
	private JTextField input;
	private JScrollPane bar;
	private JButton addButton, deleteButton;
	private JLabel title;

	public PrincipalPanel() {

		setBounds(0, 0, 750, 480);
		setBackground(new Color(23, 190, 187));
		setLayout(null);

		title = new JLabel("Parking Registration");
		title.setBounds(148, 13, 600, 60);
		title.setFont(new Font("Consolas", Font.BOLD, 40));
		title.setForeground(new Color(0,18,25));
		add(title);

		carList = new JList<>();
		carList.setBounds(20, 0, 320, 330);
		model = new DefaultListModel<>();
		carList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		carList.setBackground(new Color(187, 195, 190));
		carList.setForeground(Color.black);

		bar = new JScrollPane(carList);
		bar.setBounds(0, 0, 323, 335);

		panelList = new JPanel();
		panelList.setBounds(40, 70, 320, 330);
		panelList.setLayout(null);
		panelList.add(bar);
		add(panelList);

		input = new JTextField();
		input.setBounds(472, 130, 160, 40);
		input.setBorder(null);
		input.setFont(new Font("Consolas", Font.BOLD, 20));
		add(input);

		addButton = new JButton("ADD");
		addButton.setBounds(490, 230, 120, 30);
		addButton.setFocusable(false);
		addButton.setBorderPainted(false);
		addButton.setFont(new Font("Consolas", Font.BOLD, 16));
		addButton.setBackground(new Color(0,95,115));
		addButton.setForeground(Color.WHITE);
		add(addButton);

		deleteButton = new JButton("DELETE");
		deleteButton.setBounds(490, 280, 120, 30);
		deleteButton.setFocusable(false);
		deleteButton.setBorderPainted(false);
		deleteButton.setFont(new Font("Consolas", Font.BOLD, 16));
		deleteButton.setBackground(new Color(0,95,115));
		deleteButton.setForeground(Color.WHITE);
		add(deleteButton);

		secondbg = new JPanel();
		secondbg.setBounds(0, 0, 386, 480);
		secondbg.setBackground(new Color(14,124,123));
		add(secondbg);
		
	}

	public JList<String> getCarList() {
		return carList;
	}

	public void setCarList(JList<String> carList) {
		this.carList = carList;
	}

	public DefaultListModel<String> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<String> model) {
		this.model = model;
	}

	public JPanel getPanelList() {
		return panelList;
	}

	public void setPanelList(JPanel panelList) {
		this.panelList = panelList;
	}

	public JTextField getInput() {
		return input;
	}

	public void setInput(JTextField input) {
		this.input = input;
	}

	public JScrollPane getBar() {
		return bar;
	}

	public void setBar(JScrollPane bar) {
		this.bar = bar;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}

	public JLabel getTitle() {
		return title;
	}

	public void setTitle(JLabel title) {
		this.title = title;
	}

}
