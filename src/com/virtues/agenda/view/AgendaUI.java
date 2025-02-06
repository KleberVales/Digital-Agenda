package com.virtues.agenda.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.virtues.agenda.controller.Controller;

public class AgendaUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Controller controller;

	public AgendaUI() {
		controller = new Controller();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DATA (YYYY-MM-DD)");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(21, 71, 171, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblHorahhmm = new JLabel("HORA (HH:MM)");
		lblHorahhmm.setFont(new Font("Arial", Font.BOLD, 14));
		lblHorahhmm.setBounds(21, 123, 171, 42);
		contentPane.add(lblHorahhmm);
		
		JLabel lblDescrio = new JLabel("DESCRIÇÃO");
		lblDescrio.setFont(new Font("Arial", Font.BOLD, 14));
		lblDescrio.setBounds(21, 175, 171, 42);
		contentPane.add(lblDescrio);
		
		textField = new JTextField();
		textField.setBounds(218, 71, 251, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(218, 123, 251, 34);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(218, 175, 251, 34);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("SALVAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.controllerSalvar(textField.getText(), textField_1.getText(), textField_2.getText());
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(23, 324, 123, 34);
		contentPane.add(btnNewButton);
	}

	public void iniciar() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaUI frame = new AgendaUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
