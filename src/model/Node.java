package model;

import java.util.ArrayList;

public class Node<T> {
	
	T item;
	ArrayList<Node<T>> nghbr;
	
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

	public ArrayList<Node<T>> getNghbr() {
		return nghbr;
	}

	public void setNghbr(ArrayList<Node<T>> nghbr) {
		this.nghbr = nghbr;
	}
}
