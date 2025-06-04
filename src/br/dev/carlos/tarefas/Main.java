package br.dev.carlos.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.UUID;

import br.dev.carlos.tarefas.dao.FuncionarioDAO;
import br.dev.carlos.tarefas.gui.FuncionarioFrame;
import br.dev.carlos.tarefas.gui.FuncionarioListaFrame;
import br.dev.carlos.tarefas.model.Funcionario;
import br.dev.carlos.tarefas.model.Tarefa;

public class Main {
	
	static String caminho = "/Users/25132872/tarefasDS1TA/tarefas";
	
	public static void main(String[] args) {
		
		//FuncionarioDAO dao = new FuncionarioDAO(null);
		//dao.getFuncionarios();
		
		new FuncionarioListaFrame();
		//new FuncionarioFrame();
		
	}
		
//		UUID uuid = UUID.randomUUID();
//		System.out.println(uuid);
//		
//		String uuid8 = uuid.toString().substring(0, 8);
//		System.out.println(uuid8);
//		
//		//Tarefa tarefa1 = new Tarefa("hoje.");
//		
//		//escreverArquivo();
//		//lerArquivo();
//		
//		Funcionario f = new Funcionario("Pedro", "Programador");
//		f.setSetor("TI");
//		
//		Funcionario f2 = new Funcionario();
//		f2.setCargo("analista de sistemas");
//		f2.setNome("Gabriel");
//		f2.setSetor("TI");
//		
//		FuncionarioDAO dao = new FuncionarioDAO(f2);
//		dao.salvar();
//	}
//	
	private static void escreverArquivo() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(caminho, true);
			bw = new BufferedWriter(fw);
			
			bw.append("Senai Jandira\n");
			bw.append(" Carlos\n");
			bw.append(" Lógica de programação\n");
			
			
			bw.flush();
			
			
		} catch (Exception e) {

		}
		
	}

	private static void lerArquivo() {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(caminho);
			br = new BufferedReader(fr);
			
		
			String retorno = br.readLine();
			
			while (retorno != null) {
			
				System.out.println(retorno);
				retorno = br.readLine();
				
			}
			
		} catch (FileNotFoundException erro) {
			System.out.println("O arquivo não foi encontrado!");
		} catch (Exception erro) {
			System.out.println("Ocorreu um erro!");

		}
		System.out.println("fim");
	}

}
