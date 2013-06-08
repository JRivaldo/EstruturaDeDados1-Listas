package ListaSimples;

public class Lista<E> {

	private E elementos[];
	private int size;
	private static final int DIMENSAO = 10;
	
	public Lista(int tam){
		if(tam < 0){
			throw new RuntimeException("Erro de tamanho na coleção!");
		}
		elementos = (E[]) new Object[tam];
		this.size = 0;
	}
	
	public void add(E e){
		if(size == elementos.length){
			this.redimencionaVetor();
		}		
		elementos[size] = e;
		++size;
	}
	
	public E get(int posicao){
		if((posicao >= size)|| (posicao < 0)){
			throw new RuntimeException("Posição inválida!");
		}
		return elementos[posicao];
		
	}
	
	public int tamanho(){
		return size;
	}
	
	private void redimencionaVetor(){
		E [] ele2 = (E[]) new Object[elementos.length + this.DIMENSAO];
		for(int i = 0; i < elementos.length; i++ ){
			ele2[i] = elementos[i];
		}
		elementos = ele2;
		
	}
	
	public void addInicio(E valor){
		add(valor,0);
	}
	
	public void add(E valor, int pos){
		if(size == elementos.length){
			this.redimencionaVetor();
		}
		if((pos > size)||(pos < 0)){
			throw new RuntimeException("Posição inválida da coleção!");
		}
		for(int i = size; i > pos; i--){
				this.elementos[i] = this.elementos[i - 1];				
		}
		
		this.elementos[pos] = valor;
		++size;
	}
	
	public E removerInicio(){
		E removido = this.get(0);
		for(int i = 0; i < size - 1; i++){
			this.elementos[i] = this.elementos[i + 1];				
		}
		this.elementos[size - 1] = null;
		--size;
		return removido;
		
	}
	
	public E remover(int pos){
		E removido = this.get(pos);
		if((pos > size)||(pos < 0)){
			throw new RuntimeException("Posição inválida da coleção!");
		}
		
		for(int i = pos; i < size; i++){
			this.elementos[i] = this.elementos[i + 1];				
		}
		this.elementos[size - 1] = null;
		--size;
		return removido;
	}
	
	public E removerFim(){
		E removido = this.get(this.size -1);
		this.elementos[this.size - 1] = null;
		this.size--;
		return removido;
	}
}
