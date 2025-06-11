package br.dev.carlos.tarefas.gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadastroTarefasFrame {

public CadastroTarefasFrame(JDialog tela) {
		
		criarTela(tela);
	}
	
	private void criarTela(JDialog parent) {
		
		
		JDialog tela = new JDialog(parent, true);
		tela.setSize(300, 900);
		tela.setTitle("Cadastro de tarefas");
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		JLabel labelNome = new JLabel("Nome da tarefa:");
		labelNome.setBounds(10, 10, 150, 30);
		JTextField txtNome = new JTextField();
		txtNome.setBounds(10, 40, 200, 30);
		
		JLabel labelNome = new JLabel("Descrição:");
		labelNome.setBounds(10, 10, 150, 30);
		JTextField txtNome = new JTextField();
		txtNome.setBounds(10, 40, 200, 30);
		
		JLabel labelResponsável = new JLabel("Responsável:");
		labelResponsável.setBounds(10, 75, 150, 30);
		JTextField txtResponsável = new JTextField();
		txtResponsável.setBounds(10, 105, 150, 30);
		
		JLabel labelSetor = new JLabel("Data de início:");
		labelSetor.setBounds(10, 140, 150, 30);
		JTextField txtSetor = new JTextField();
		txtSetor.setBounds(10, 170, 200, 30);
		
		JLabel labelNome = new JLabel("Prazo:");
		labelNome.setBounds(10, 10, 150, 30);
		JTextField txtNome = new JTextField();
		txtNome.setBounds(10, 40, 200, 30);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 250, 150, 35);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(170, 250, 150, 35);	
	
	}
}
