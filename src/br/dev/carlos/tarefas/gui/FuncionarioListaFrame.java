package br.dev.carlos.tarefas.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.carlos.tarefas.dao.FuncionarioDAO;
import br.dev.carlos.tarefas.model.Funcionario;

public class FuncionarioListaFrame {
	
	private JLabel labelTitulo;
	private JButton btnNovo;
	
	private JTable tabelaFuncionarios;
	private DefaultTableModel modelFuncionarios;
	private JScrollPane scroll;
	private JButton btnSair;
	
	private String[] colunas = {"CÓDIGO", "NOME DO FUNCIONÁRIO", "CARGO"};
	
	public FuncionarioListaFrame(JFrame tela) {
		criarTela(tela);
	}
	
	private void criarTela(JFrame parent) {
		
		JDialog tela = new JDialog(parent, true);
		tela.setTitle("Lista de funcionários");
		tela.setSize(600, 500);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		labelTitulo = new JLabel("Lista de funcionários");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 28));
		labelTitulo.setForeground(new Color(100, 0, 100));
		labelTitulo.setBounds(10, 10, 400, 40);
		
		modelFuncionarios = new DefaultTableModel(colunas,1);
		carregarDados();
		
		tabelaFuncionarios = new JTable(modelFuncionarios);
		scroll = new JScrollPane(tabelaFuncionarios);
		scroll.setBounds(10, 60, 580, 340);
		
		btnNovo = new JButton("	Novo");
		btnNovo.setBounds(10, 410, 150, 40);
		
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FuncionarioFrame(tela);
				carregarDados();
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(170, 410, 150, 40);
		
		
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
		
		painel.add(labelTitulo);
		painel.add(scroll);
		painel.add(btnNovo);
		painel.add(btnSair);
		
		tela.setVisible(true);
	}

	private Object[][] carregarDados() {
		//Obter os dados que serão exibidos na tabela
		FuncionarioDAO dao = new FuncionarioDAO(null);
		List<Funcionario> funcionarios = dao.getFuncionarios();
		
		Object[][] dados = new Object [funcionarios.size()][3];
		
		int i =0;
		for(Funcionario f : funcionarios) {
			dados [i][0] = f.getMatricula();
			dados [i][1] = f.getNome();
			dados [i][2] = f.getCargo();
			i++;
	
		}
		modelFuncionarios.setDataVector(dados, colunas);
		return dados;
	}
}
                                                                           