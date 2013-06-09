package Pilha;

import ListaDuplamenteEncadeada.ListaDupla;

public class PilhaEncadeada<E> extends ListaDupla<E> implements Pilha<E>{
	
		
	public void inserir(E objeto){
		this.add(objeto);
	}
	
	public E remover(){
		return this.removerFim();
	}
	
	public E espreitar(){
		return this.getObjeto(this.tamanho() -1);
	}
	
	public boolean vazia(){
		return this.tamanho() == 0;
	}
	
}
