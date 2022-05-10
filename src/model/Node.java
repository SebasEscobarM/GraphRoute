package model;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
	
	T item;
	List<Node<T>> nghbr;
	
	public Node(T item){
		this.item=item;
		this.nghbr=new ArrayList<>(); 
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public void addNghbr(Node<T> node) {
		nghbr.add(node);
	}

	public List<Node<T>> getNghbr() {
		return nghbr;
	}

	public void setNghbr(List<Node<T>> nghbr) {
		this.nghbr = nghbr;
	}
}
