package br.dev.carlos.tarefas.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TarefasListaFrame {

	private JLabel labelTitulo;
	private JTable tabelaTarefas;
	private DefaultTableModel modelTarefas;
	private JScrollPane scroll;
	private JButton btnNovo;
	private JButton btnSair;
	
	private String[] colunas = {"NOME", "DESCRIÇÃO", "RESPONSÁVEL", "DATA DE INÍCIO", "PRAZO", "STATUS", "DATA DE ENTREGA"};
	
	public TarefasListaFrame(JFrame tela) {
		criarTela(tela);
		
	}
		
	private void criarTela(JFrame parent) {
		
		JDialog tela = new JDialog(parent, true);
		tela.setTitle("Tabela de tarefas");
		tela.setSize(615, 480);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		
		labelTitulo = new JLabel("Lista de tarefas");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 28));
		labelTitulo.setForeground(new Color(100, 0, 100));
		labelTitulo.setBounds(10, 10, 400, 40);
		
		modelTarefas = new DefaultTableModel(colunas,1) {
		};
		
	
		
		tabelaTarefas = new JTable(modelTarefas);
		scroll = new JScrollPane(tabelaTarefas);
		scroll.setBounds(10, 60, 580, 300);
		
		btnNovo = new JButton("Novo");
		btnNovo.setBounds(10, 380, 150, 40);
		
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastroTarefasFrame(tela);
				
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(170, 380, 150, 40);
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(tela, "Sair do sistema?");
				System.out.println(resposta);
				if (resposta == 0) {
				tela.dispose();
				}
			}
		});
		
		
		Container painel = tela.getContentPane();
		painel.add(labelTitulo);
		painel.add(scroll);
	    painel.add(btnNovo);
		painel.add(btnSair);
	    
		tela.setVisible(true);
	}
	
}
