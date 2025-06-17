package br.dev.carlos.tarefas.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.carlos.tarefas.dao.FuncionarioDAO;
import br.dev.carlos.tarefas.model.Funcionario;

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
		
		JLabel labelNomeTarefa = new JLabel("Nome da tarefa:");
		labelNomeTarefa.setBounds(10, 10, 150, 30);
		JTextField txtNomeTarefa = new JTextField();
		txtNomeTarefa.setBounds(10, 40, 200, 30);
		
		JLabel labelDescricao = new JLabel("Descrição:");
		labelDescricao.setBounds(10, 10, 150, 30);
		JTextField txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 40, 200, 30);
		
		JLabel labelResponsavel = new JLabel("Responsável:");
		labelResponsavel.setBounds(10, 75, 150, 30);
		JTextField txtResponsavel = new JTextField();
		txtResponsavel.setBounds(10, 105, 150, 30);
		
		JLabel labelDataInicio = new JLabel("Data de início:");
		labelDataInicio.setBounds(10, 140, 150, 30);
		JTextField txtDataInicio = new JTextField();
		txtDataInicio.setBounds(10, 170, 200, 30);
		
		JLabel labelPrazo = new JLabel("Prazo:");
		labelPrazo.setBounds(10, 10, 150, 30);
		JTextField txtPrazo = new JTextField();
		txtPrazo.setBounds(10, 40, 200, 30);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 250, 150, 35);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(170, 250, 150, 35);	
	
		
		Container painel = tela.getContentPane();
		painel.add(labelNomeTarefa);
		painel.add(txtNomeTarefa);
		painel.add(labelDescricao);
		painel.add(txtDescricao);
		painel.add(labelResponsavel);
		painel.add(txtResponsavel);
		painel.add(labelDataInicio);
		painel.add(txtDataInicio);
		painel.add(labelPrazo);
		painel.add(txtPrazo);
		painel.add(btnSalvar);
		painel.add(btnSair);
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
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
		
		tela.setVisible(true);
	}
}
