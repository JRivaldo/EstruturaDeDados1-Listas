package Pilha;

public interface Pilha<E> {

	public void inserir(E objeto);
	public E remover();
	public E espreitar();
	public boolean vazia();
	public int tamanho();
	
}
