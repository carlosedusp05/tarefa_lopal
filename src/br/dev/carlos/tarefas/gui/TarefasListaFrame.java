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
import br.dev.carlos.tarefas.dao.TarefaDAO;
import br.dev.carlos.tarefas.model.Funcionario;
import br.dev.carlos.tarefas.model.Tarefa;

public class TarefasListaFrame {

	private JLabel labelTitulo;
	private JTable tabelaTarefas;
	private DefaultTableModel modelTarefas;
	private JScrollPane scroll;
	private JButton btnNovo;
	private JButton btnSair;
	
	private String[] colunas = {"CÓDIGO","NOME", "RESPONSÁVEL"};
	
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
		
		modelTarefas = new DefaultTableModel(colunas,1);
		carregarDados();
		
	
		
		tabelaTarefas = new JTable(modelTarefas);
		scroll = new JScrollPane(tabelaTarefas);
		scroll.setBounds(10, 60, 580, 300);
		
		btnNovo = new JButton("Novo");
		btnNovo.setBounds(10, 380, 150, 40);
		
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastroTarefasFrame(tela);
				carregarDados();
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
	
	private Object[][] carregarDados() {
		TarefaDAO dao = new TarefaDAO(null);
		List<Tarefa> tarefas = dao.getTarefas();
		
		Object[][] dados = new Object [tarefas.size()][3];
		
		int i =0;
		for(Tarefa tr : tarefas) {
			dados [i][0] = tr.getCodigo();
			dados [i][1] = tr.getNome();
			dados [i][2] = tr.getResponsavel();
			i++;
	
		}
		modelTarefas.setDataVector(dados, colunas);
		return dados;
	}
}
