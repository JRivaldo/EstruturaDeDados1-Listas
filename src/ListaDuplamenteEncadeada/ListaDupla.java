package ListaDuplamenteEncadeada;

public class ListaDupla<E> {

	private NoDuplo<E> primeiro;
	private NoDuplo<E> ultimo;
	private int size;
	
	public ListaDupla(){
		this.primeiro = null;
		this.ultimo = null;
		this.size = 0;
	}
	
	public void add(E objeto){
		NoDuplo<E> no = new NoDuplo<E>(objeto);
		if(this.primeiro == null){
			this.primeiro = no;
			this.ultimo = no;
			this.size++;
			return;
		}
		
		NoDuplo<E> aux = this.primeiro;
		while(aux.getProximo() != null){
			aux = aux.getProximo();
		}
		no.setProximo(aux.getProximo());
		no.setAnterior(aux);
		this.ultimo = no;
		aux.setProximo(this.ultimo);
		;		
		this.size++;
	}
	
	public void addFim(E objeto){
		if(this.size == 0){
			this.add(objeto);
			return;
		}
		NoDuplo<E> no = new NoDuplo<E>(objeto);
		no.setAnterior(this.ultimo);
		no.setProximo(this.ultimo.getProximo());
		this.ultimo.setProximo(no);
		this.ultimo = no;
		this.size++;
	}
	
	public void addInicio(E objeto){
		if(this.size == 0){
			this.add(objeto);
			return;
		}
		NoDuplo<E> no = new NoDuplo<E>(objeto);
		this.primeiro.setAnterior(no);
		no.setProximo(this.primeiro);
		this.primeiro = no;
		this.size++;
		
	}
	
	public void add(E objeto, int pos){
		if((pos < 0) || (pos >= size)){
			throw new IndexOutOfBoundsException();
		}
		if(pos == 0){
			this.addInicio(objeto);
			return;
		}
		if(pos == size - 1){
			this.addFim(objeto);
			return;
		}
		NoDuplo<E> no = new NoDuplo<E>(objeto);
		NoDuplo<E> aux = this.primeiro;
		for(int i = 0; i < pos -1; i++){
			aux = aux.getProximo();
		}
		no.setProximo(aux.getProximo());
		no.setAnterior(aux);
		aux.setProximo(no);
		this.size++;
	}
	
	public E removerInicio(){
		if(this.size == 0){
			throw new RuntimeException("Erro ao remover objeto em lista vazia.");
		}
		int tam = this.size;
		this.size--;
		if(tam == 1){
			E removido = this.primeiro.getObjeto();
			this.primeiro = null;
			this.ultimo = null;
			return removido;
		}
		E removido = this.primeiro.getObjeto();
		this.primeiro = this.primeiro.getProximo();
		this.primeiro.setAnterior(null);
		this.size--;
		return removido;
		
	}
	
	public E removerFim(){
		if(this.size == 0){
			throw new RuntimeException("Erro ao remover objeto em lista vazia.");
		}
		int tam = this.size;
		this.size--;
		if(tam == 1){
			E removido = this.ultimo.getObjeto();
			this.ultimo = null;
			this.primeiro = null;
			return removido;
		}
		E removido = this.ultimo.getObjeto();
		this.ultimo = this.ultimo.getAnterior();
		this.ultimo.setProximo(null);
		return removido;
	}
	
	public E removerPos(int pos){
		if(this.size == 0){
			throw new RuntimeException("Erro ao remover objeto em lista vazia.");
		}
		if((pos < 0) || (pos >= size)){
			throw new IndexOutOfBoundsException();
		}
		if(pos == 0){
			return this.removerInicio();
		}
		if(pos == this.size - 1){			
			return this.removerFim();
		}
		
		NoDuplo<E> aux = this.primeiro;
		
		for(int i = 0; i < pos - 1; i++){
			aux = aux.getProximo();
		}
		NoDuplo<E> removido = aux.getProximo();
		E remover = removido.getObjeto();
		aux.setProximo(removido.getProximo());
		aux.setAnterior(removido.getAnterior());
		this.size--;
		return remover;
		
		
	}
	
	public int tamanho(){
		return this.size;
	}
	
	public E getObjeto(int pos){		
		return this.getNo(pos).getObjeto();
	}
	
	private NoDuplo<E> getNo(int pos){
		if((pos < 0) || (pos >= size)){
			throw new IndexOutOfBoundsException();
		}
		NoDuplo<E> temp = this.primeiro;
		for(int i = 0; i < pos; i++){
			temp =  temp.getProximo();
		}			
		return temp;
	}
	
	
	public String mostrarAntProx(int pos){
		String mostrar = "Objeto atual: " +this.getNo(pos).getObjeto() + "   Anterior: " + this.getNo(pos).getAnterior().getObjeto() 
				+ "   Proximo: " + this.getNo(pos).getProximo().getObjeto();
		return mostrar;
	}
	
	public String toString() {
		if(this.size == 0){ 
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		NoDuplo<E> atual = this.primeiro;
		
		for (int i = 0; i < this.size -1; i++) { 
			builder.append(atual.getObjeto()); 
			builder.append(", "); 
			atual = atual.getProximo(); 
		}
		
		builder.append(atual.getObjeto()); 
		builder.append("]");
		return builder.toString(); 
	}
	
}
