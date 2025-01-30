package main.java.view;

import main.java.controller.AgendaController;
import main.java.model.Compromisso;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AgendaUI {
    private JFrame frame;
    private JTextField txtData, txtHora, txtDescricao;
    private JTextArea txtAgenda;
    private AgendaController controller;

    public AgendaUI() {
        controller = new AgendaController();
        criarInterface();
    }

    private void criarInterface() {
        frame = new JFrame("Agenda de Compromissos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(6, 1));

        txtData = new JTextField();
        txtHora = new JTextField();
        txtDescricao = new JTextField();
        txtAgenda = new JTextArea();
        JButton btnSalvar = new JButton("Salvar");
        JButton btnAtualizar = new JButton("Atualizar");
        JButton btnRemover = new JButton("Remover");

        frame.add(new JLabel("Data (YYYY-MM-DD):"));
        frame.add(txtData);
        frame.add(new JLabel("Hora (HH:MM):"));
        frame.add(txtHora);
        frame.add(new JLabel("Descrição:"));
        frame.add(txtDescricao);
        frame.add(btnSalvar);
        frame.add(btnAtualizar);
        frame.add(btnRemover);
        frame.add(new JScrollPane(txtAgenda));

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.adicionarCompromisso(txtData.getText(), txtHora.getText(), txtDescricao.getText());
                JOptionPane.showMessageDialog(frame, "Compromisso salvo!");
                atualizarAgenda();
            }
        });

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarAgenda();
            }
        });

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idStr = JOptionPane.showInputDialog(frame, "Digite o ID do compromisso para remover:");
                if (idStr != null && !idStr.isEmpty()) {
                    int id = Integer.parseInt(idStr);
                    controller.removerCompromisso(id);
                    atualizarAgenda();
                }
            }
        });

        atualizarAgenda();
        frame.setVisible(true);
    }

    private void atualizarAgenda() {
        List<Compromisso> compromissos = controller.obterCompromissos();
        txtAgenda.setText("");
        for (Compromisso c : compromissos) {
            txtAgenda.append("ID: " + c.getId() + " | " + c.getData() + " " + c.getHora() + " - " + c.getDescricao() + "\n");
        }
    }
}
