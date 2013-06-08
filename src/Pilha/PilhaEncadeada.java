package Pilha;

import ListaDuplamenteEncadeada.ListaDupla;

public class PilhaEncadeada<E> implements Pilha<E>{
	
	private ListaDupla<E> objetos;
	
	public PilhaEncadeada(){
		this.objetos = new ListaDupla<E>();
	}
	
	public void inserir(E objeto){
		this.objetos.add(objeto);
	}
	
	public E remover(){
		return this.objetos.removerPos(this.objetos.tamanho() -1);
	}
	
	public E espreitar(){
		return this.objetos.getObjeto(this.objetos.tamanho() -1);
	}
	
	public boolean vazia(){
		return this.objetos.tamanho() == 0;
	}
	
	public int tamanho(){
		return this.objetos.tamanho();
	}
}
