package ListaDuplamenteEncadeada;

public class NoDuplo<E> {

	private NoDuplo<E> anterior;
	private NoDuplo<E> proximo;
	private E objeto;
	
	public NoDuplo(E objeto){
		this.setObjeto(objeto);
	}
	
	public NoDuplo(E objeto, NoDuplo<E> anterior, NoDuplo<E> proximo){
		this.setObjeto(objeto);
		this.setAnterior(anterior);
		this.setProximo(proximo);
	}

	public NoDuplo<E> getAnterior() {
		return anterior;
	}

	public void setAnterior(NoDuplo<E> anterior) {
		this.anterior = anterior;
	}

	public NoDuplo<E> getProximo() {
		return proximo;
	}

	public void setProximo(NoDuplo<E> proximo) {
		this.proximo = proximo;
	}

	public E getObjeto() {
		return objeto;
	}

	public void setObjeto(E objeto) {
		this.objeto = objeto;
	}
	
	

}
