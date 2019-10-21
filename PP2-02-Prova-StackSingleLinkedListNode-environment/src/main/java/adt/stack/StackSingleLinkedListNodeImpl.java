package adt.stack;

import adt.linkedList.SingleLinkedListNode;

/**
 * Classe que representa um apilha implementada usando-se um noh de uma lista
 * simplesmente ligada, como estrutura sobrejacente. 
 * 
 * Restricoes:
 * - voce DEVE obedecer a politica de acesso e complexidade dos metodos de pilha, ou seja, todos em O(1).
 * - voce NÃO pode usar memoria extra (estrutura auxiliar)
 * - qualquer metodo auxiliar que voce necessite DEVE ser implementado nesta classe
 * - voce NÃO pode modificar a classe SingleLinkedListNode
 * 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class StackSingleLinkedListNodeImpl<T> implements Stack<T> {
	
	private SingleLinkedListNode<T> top;
	private int tamanhoMaximo;
	private int tamanhoConsumido;
	
	/**
	 * A pilha para ser criada precisa ter um tamanho maximo
	 * @param tamanhoMaximo
	 */
	public StackSingleLinkedListNodeImpl(int tamanhoMaximo) {
		this.top = new SingleLinkedListNode<T>();
		this.tamanhoMaximo = tamanhoMaximo;
		this.tamanhoConsumido = 0;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(tamanhoConsumido < tamanhoMaximo) {
			if (element != null) {
				if(!top.isNIL()) {
					SingleLinkedListNode<T> aux = new SingleLinkedListNode<>();
					aux.setNext(top.getNext());
					aux.setData(top.getData());
					top.setNext(aux);
					top.setData(element);
					
					tamanhoConsumido++;
				} else {
					top.setData(element);
					top.setNext(new SingleLinkedListNode<>());
					
					tamanhoConsumido++;
				}
			}
		} else {
			throw new StackOverflowException();
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(!top.isNIL()) {
			if(!top.getNext().isNIL()) {
				T result = top.getData();
				top.setData(top.getNext().getData());
				top.setNext(top.getNext().getNext());
				return result;
				
			} else {
				T result = top.getData();
				top.setNext(null);
				top.setData(null);
				return result;
			}
			
		} else {
			throw new StackUnderflowException();
		}
	}

	@Override
	public T top() {
		if(!top.isNIL()) {
			return top.getData();
		} else {
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		return top.isNIL();
	}
	
	@Override
	public boolean isFull() {
		return tamanhoConsumido == tamanhoMaximo;
	}

}
