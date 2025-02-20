package com.virtues.agenda.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.virtues.agenda.controller.Controller;
import com.virtues.agenda.model.Compromisso;

public class UpdateUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Controller controller;
	private JTextArea textArea;
	private JTextField textField_3;

	public UpdateUI() {

		controller = new Controller();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("DATA (YYYY-MM-DD)");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(29, 82, 190, 46);
		contentPane.add(lblNewLabel);

		JLabel lblHorahhmm = new JLabel("HORA (HH:MM)");
		lblHorahhmm.setFont(new Font("Arial", Font.BOLD, 14));
		lblHorahhmm.setBounds(29, 160, 190, 46);
		contentPane.add(lblHorahhmm);

		JLabel lblDescricao = new JLabel("DESCRICAO");
		lblDescricao.setFont(new Font("Arial", Font.BOLD, 14));
		lblDescricao.setBounds(29, 235, 190, 46);
		contentPane.add(lblDescricao);

		textField = new JTextField();
		textField.setBounds(250, 82, 258, 46);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(250, 160, 258, 46);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(250, 235, 258, 46);
		contentPane.add(textField_2);

		JButton btnNewButton = new JButton("SALVAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id = Integer.parseInt(textField_3.getText());
				controller.updateCompromisso(id, textField.getText(), textField_1.getText(), textField_2.getText());
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(29, 333, 174, 46);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("LISTAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				List<Compromisso> compromisso = controller.obterCompromisso();

				textArea.setText("");

				for (Compromisso c : compromisso) {

					textArea.append(c.getID() + " " + c.getData() + " " + c.getHora() + " " + c.getDescricao() + "\n");

				}

			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1.setBounds(229, 333, 174, 46);
		contentPane.add(btnNewButton_1);

		textArea = new JTextArea();
		textArea.setBounds(545, 74, 366, 488);
		contentPane.add(textArea);

		textField_3 = new JTextField();
		textField_3.setBounds(62, 10, 48, 46);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 14, 45, 34);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_2 = new JButton("OK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(textField_3.getText());

				List<Compromisso> lista = controller.obterCompromisso(id);

				for (Compromisso c : lista) {

					if (id == c.getID()) {
						textField.setText(c.getData());
						textField_1.setText(c.getHora());
						textField_2.setText(c.getDescricao());

					}

				}

			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_2.setBounds(120, 10, 55, 51);
		contentPane.add(btnNewButton_2);
	}

	public void iniciar() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUI frame = new UpdateUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
