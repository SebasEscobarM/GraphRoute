package model;

import java.util.HashMap;
import java.util.Set;

public class Graph<T> {
	
	HashMap<T,Node<T>> nds;
	
	public Graph() {
		nds=new HashMap<>();
	}
	
	public void add(Node<T> nd) {
		nds.put(nd.getItem(), nd);
	}
	
	public void addEdge(T nd1, T nd2) {
		if(nds.get(nd1)!=null && nds.get(nd2)!=null) {
			nds.get(nd1).addNghbr(nds.get(nd2));
		}else {
			System.out.println("Ingrese un par de nodos validos.");
		}
	}
	
	public Set<T> getKeys(){
		return nds.keySet();
	}
	
	public Node<T> getNode(T key){
		return nds.get(key);
	}
}
