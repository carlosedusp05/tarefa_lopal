package br.dev.carlos.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import br.dev.carlos.tarefas.model.Funcionario;
import br.dev.carlos.tarefas.model.Tarefa;

public class TarefaDAO {
	
	private Tarefa tarefa;
	private FileWriter fw;
	private BufferedWriter bw;
	private FileReader fr;
	private BufferedReader br;
	
	private String arquivoTarefas = "/Users/25132872/eclipse-workspace/tarefas/tarefas.csv";
	
	
	public TarefaDAO(Tarefa tarefa) {
		this.tarefa =tarefa;
		try {
			fw = new FileWriter(arquivoTarefas, true);
			bw = new BufferedWriter(fw);
			fr = new FileReader(arquivoTarefas);
			br = new BufferedReader(fr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void salvar() {
		try {
			bw.write(tarefa.toString());
			bw.flush();
			System.out.println(tarefa.getNome() + " gravado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Tarefa> getTarefas() {
		
		List<Tarefa> tarefas = new ArrayList<>();
		
		try {
			String linha = "";
			
			while (linha != null) {
				linha = br.readLine();
				
				if (linha!=null) {
					String[] tarefaVetor = linha.split(",");
				    Tarefa tarefa = new Tarefa();
				    tarefa.setNome(tarefaVetor[0]);
				    tarefa.setDescricao(tarefaVetor[1]);
				    //funcionario.setCargo(funcionarioVetor[2]);
				    //funcionario.setSetor(funcionarioVetor[3]);
				    tarefas.add(tarefa);
				}
			}
			return tarefas;
			
		} catch (Exception e) {
			return null;
		}
	}
}

	
