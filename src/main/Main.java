package main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import model.Graph;
import model.Node;

public class Main {

	public static Scanner rd=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Ingrese la cantidad de vertices del grafo:");
		int nd=Integer.parseInt(rd.nextLine());
		Graph<String> grph=new Graph<>();
		
		for(int i=0;i<nd;i++) {
			System.out.println("Ingrese el valor del vertice #"+(i+1)+": ");
			String item=rd.nextLine();
			grph.add(new Node<String>(item));		
		}
		
		boolean stop=false;
		
		System.out.println("Ingrese todos las aristas del grafo:");
		do {
			System.out.println("Ingrese la ariste de la forma 'A,B' siendo A donde inicia y B a donde apunta la arista:");
			System.out.println("Si no va a ingresar mas aristas digite 'end'.");
			String in=rd.nextLine();
			if(in.equalsIgnoreCase("end")) {
				stop=true;
			}else {
				String[] vls=in.split(",");
				grph.addEdge(vls[0], vls[1]);
			}
			
		}while(!stop);
		
		System.out.println("DFS");
		boolean dfsRslt=dfsR(grph);
		if(dfsRslt) {
			System.out.println("Es fuertemente conexo");
		}else {
			System.out.println("No es fuertemente conexo");
		}
		
		System.out.println("BFS");
		boolean bfsRslt=bfsResult(grph);
		if(bfsRslt) {
			System.out.println("Es fuertemente conexo");
		}else {
			System.out.println("No es fuertemente conexo");
		}
		
		System.out.println("Dfs Iterativo");
		boolean dfsItRslt=dfsIterative(grph);
		if(dfsItRslt) {
			System.out.println("Es fuertemente conexo");
		}else {
			System.out.println("No es fuertemente conexo");
		}
		
	}
	
	//Disparador de DFS iterativo
	public static boolean dfsIterative(Graph<String> graph) {
		Set<String> keys=graph.getKeys();
		HashMap<String, Boolean> vis=new HashMap<>();
		for(String key:keys) {
			vis.put(key, false);
		}
		for(String key:keys) {
			vis.replaceAll((ke,itm)-> itm=false);
			dfsIterative(graph.getNode(key), vis);
			for(String k:keys) {
				if(!vis.get(graph.getNode(k).getItem())) {
					return false;
				}
			}
		}
		return true;
	}
	
	//DFS iterativo
	public static void dfsIterative(Node<String> nd, HashMap<String, Boolean> vis) {
		Stack<Node<String>> toVisit=new Stack<Node<String>>();
		toVisit.add(nd);
		do {
			Node<String> actNd=toVisit.pop();
			if(!vis.get(actNd.getItem())) {
				toVisit.addAll(actNd.getNghbr());
				vis.put(actNd.getItem(), true);
			}
		}while(!toVisit.empty());
	}
	
	//Disparador de DFS recursivo
	public static boolean dfsR(Graph<String> graph) {
		Set<String> keys=graph.getKeys();
		HashMap<String, Boolean> vis=new HashMap<>();
		for(String key:keys) {
			vis.put(key, false);
		}
		for(String key:keys) {
			vis.replaceAll((ke,itm)-> itm=false);
			dfsI(graph.getNode(key), vis);
			for(String k:keys) {
				if(!vis.get(graph.getNode(k).getItem())) {
					return false;
				}
			}
		}
		return true;
	}
	
	//DFS recursivo
	public static void dfsI(Node<String> nd, HashMap<String, Boolean> vis) {
		if(vis.get(nd.getItem())) {
			return;
		}
		vis.put(nd.getItem(), true);
		for(Node<String> node:nd.getNghbr()) {
			dfsI(node, vis);
		}
	}

	//Disparador de BFS
	public static boolean bfsResult(Graph<String> graph) {
		Set<String> keys=graph.getKeys();
		HashMap<String, Boolean> vis=new HashMap<>();
		for(String key:keys) {
			vis.put(key, false);
		}
		for(String key:keys) {
			vis.replaceAll((ke,itm)-> itm=false);
			bfsIterative(graph.getNode(key), vis);
			for(String k:keys) {
				if(!vis.get(graph.getNode(k).getItem())) {
					return false;
				}
			}
		}
		return true;
	}
	
	//BFS
	public static void bfsIterative(Node<String> node, HashMap<String, Boolean> vis) {
		Queue<Node<String>> queueNodes = new LinkedList<Node<String>>();
		vis.put(node.getItem(), true);
		queueNodes.add(node);
		while(!queueNodes.isEmpty()) {
			Node<String> actualNode = queueNodes.remove();
			for(Node<String> nodes : actualNode.getNghbr()) {
				if(!vis.get(nodes.getItem())) {
					vis.put(nodes.getItem(), true);
					queueNodes.add(nodes);
				}
			}
		}
	}
	
	
}
