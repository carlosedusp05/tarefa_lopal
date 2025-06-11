package br.dev.carlos.tarefas.gui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EscolhaFrame {
	
	private JButton btnFuncionarios;
	private JButton btnTarefas;
	
	public EscolhaFrame() {
		criarTela();
	}
	
	private void criarTela() {
		
		JFrame tela = new JFrame("Gerenciamento de funcionários e tarefas");
		tela.setSize(800,400);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		btnFuncionarios = new JButton("Funcionários");
		btnFuncionarios.setFont(new Font("Arial", Font.BOLD, 28));
		btnFuncionarios.setBounds(100, 100, 250, 200);
		
		btnFuncionarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FuncionarioListaFrame(tela);
				
			}
		});
		
		
		btnTarefas = new JButton("Tarefas");
		btnTarefas.setFont(new Font("Arial", Font.BOLD, 28));
		btnTarefas.setBounds(400, 100, 250, 200);
		
		btnTarefas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TarefasListaFrame(tela);
				
			}
		});
		
		Container painel = tela.getContentPane();
		painel.add(btnFuncionarios);
		painel.add(btnTarefas);
		
		
		tela.setVisible(true);
	}
}


