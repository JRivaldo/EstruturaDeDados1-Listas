package Pilha;

public class TestePilha {
	
	public static void main(String [] args){
		Pilha<Integer> pilha = new PilhaEncadeada<Integer>();
		pilha.inserir(5);
		pilha.inserir(4);
		pilha.inserir(3);
		pilha.inserir(2);
		pilha.inserir(1);
		
		System.out.println(pilha.tamanho());
		
		System.out.println(pilha.remover());
		
		System.out.println(pilha.tamanho());
		
		System.out.println(pilha.espreitar());
	}

}
