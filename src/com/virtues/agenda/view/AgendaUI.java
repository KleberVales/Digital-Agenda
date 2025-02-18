package com.virtues.agenda.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.virtues.agenda.controller.Controller;
import com.virtues.agenda.model.Compromisso;

public class AgendaUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Controller controller;
	private JTextArea textArea;
	private JFrame frame;
	private UpdateUI update;

	public AgendaUI() {
		controller = new Controller();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1126, 659);
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
		
		JButton btnNewButton_1 = new JButton("LISTAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Compromisso> compromisso = controller.obterCompromisso();
				
				textArea.setText("");
				
				for(Compromisso c: compromisso) {
					textArea.append("Compromisso: " + c.getID() + " " + c.getData() + " " + c.getHora() + " " + c.getDescricao() + "\n");
				}
				
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1.setBounds(156, 324, 123, 34);
		contentPane.add(btnNewButton_1);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.BOLD, 14));
		textArea.setEditable(false);
		textArea.setBounds(520, 71, 556, 510);
		contentPane.add(textArea);
		
		JButton btnNewButton_2 = new JButton("DELETAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String idStr = JOptionPane.showInputDialog(frame, "Insira o id do compromisso que sera removido");
				
				if(idStr != null && !idStr.isEmpty()) {
					
					int id = Integer.parseInt(idStr);
					
					controller.deletarCompromisso(id);
					
				}
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_2.setBounds(21, 379, 123, 34);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("UPDATE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				
				update = new UpdateUI();
		        update.iniciar(); // Abre a janela UpdateUI
		        dispose(); // Fecha apenas a janela atual (AgendaUI)
				
				
				
			}
		});
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_3.setBounds(154, 375, 125, 38);
		contentPane.add(btnNewButton_3);
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
