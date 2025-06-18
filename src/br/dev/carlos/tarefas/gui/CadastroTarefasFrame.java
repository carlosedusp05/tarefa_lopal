package br.dev.carlos.tarefas.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.carlos.tarefas.dao.FuncionarioDAO;
import br.dev.carlos.tarefas.dao.TarefaDAO;
import br.dev.carlos.tarefas.model.Funcionario;
import br.dev.carlos.tarefas.model.Status;
import br.dev.carlos.tarefas.model.Tarefa;

public class CadastroTarefasFrame {

public CadastroTarefasFrame(JDialog tela) {
		
		criarTela(tela);
	}
	
	private void criarTela(JDialog parent) {
		
		
		JDialog tela = new JDialog(parent, true);
		tela.setSize(500, 600);
		tela.setTitle("Cadastro de tarefas");
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		JLabel labelNomeTarefa = new JLabel("Nome da tarefa:");
		labelNomeTarefa.setBounds(10, 10, 150, 30);
		JTextField txtNomeTarefa = new JTextField();
		txtNomeTarefa.setBounds(10, 40, 200, 30);
		
		JLabel labelDescricao = new JLabel("Descrição:");
		labelDescricao.setBounds(10, 90, 150, 30);
		JTextField txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 120, 200, 30);
		
		JLabel labelDataInicio = new JLabel("Data de início:");
		labelDataInicio.setBounds(10, 160, 150, 30);
		JTextField txtDataInicio = new JTextField();
		txtDataInicio.setBounds(10, 190, 200, 30);
		
		JLabel labelPrazo = new JLabel("Prazo:");
		labelPrazo.setBounds(10, 230, 150, 30);
		JTextField txtPrazo = new JTextField();
		txtPrazo.setBounds(10, 260, 200, 30);
		
		JLabel labelDataConclusao = new JLabel("Data de conclusão:");
		labelDataConclusao.setBounds(10, 300, 150, 30);
		JTextField txtDataConclusao = new JTextField();
		txtDataConclusao.setBounds(10, 330, 200, 30);
		
		JLabel labelStatus = new JLabel("Status:");
		labelStatus.setBounds(10, 370, 150, 30);
		
		JComboBox<Status> comboStatus = new JComboBox<>(Status.values());
		comboStatus.setBounds(10, 400, 200, 30);
		
		JLabel labelResponsavel = new JLabel("Responsável:");
		labelResponsavel.setBounds(10, 440, 150, 30);
		
		List<Funcionario> funcionario = new FuncionarioDAO(null).getFuncionarios();
		JComboBox<Funcionario> comboResponsavel = new JComboBox<>(funcionario.toArray(new Funcionario[0]));
		comboResponsavel.setBounds(10, 470, 150, 30);
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 520, 150, 35);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(170, 520, 150, 35);	
	
		
		Container painel = tela.getContentPane();
		painel.add(labelNomeTarefa);
		painel.add(txtNomeTarefa);
		painel.add(labelDescricao);
		painel.add(txtDescricao);
		painel.add(labelDataInicio);
		painel.add(txtDataInicio);
		painel.add(labelPrazo);
		painel.add(txtPrazo);
		painel.add(labelDataConclusao);
		painel.add(txtDataConclusao);
		painel.add(labelStatus);
		painel.add(comboStatus);
		painel.add(labelResponsavel);
		painel.add(comboResponsavel);
		painel.add(btnSalvar);
		painel.add(btnSair);
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tarefa t = new Tarefa();
				t.setNome(txtNomeTarefa.getText());
				t.setDescricao(txtDescricao.getText());
				t.setResponsavel(comboResponsavel.getSelectedItem().toString());
				t.setDataInicio(txtDataInicio.getText());
				t.setPrazo(Integer.parseInt(txtPrazo.getText()));
				t.setDataPrevisaoDeEntrega(null);
				t.setStatus(comboStatus.getSelectedItem().toString());
				t.setDataEntrega(null);
				
				TarefaDAO dao = new TarefaDAO(t);
				dao.salvar();
				
				JOptionPane.showMessageDialog(tela, t.getNome() + " gravado com sucesso!");
				
				txtNomeTarefa.setText(null);
				txtDescricao.setText(null);
				txtDataInicio.setText(null);
				txtPrazo.setText(null);
				txtDataConclusao.setText(null);
				//comboStatus.setText(null);
				//comboResponsavel.setText(null);
				txtNomeTarefa.requestFocus();;
				
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
