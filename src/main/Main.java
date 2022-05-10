package main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

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
		
		boolean dfsRslt=dfsR(grph);
		if(dfsRslt) {
			System.out.println("Es fuertemente conexo");
		}else {
			System.out.println("No es fuertemente conexo");
		}
		
		boolean bfsRslt=bfsResult(grph);
		if(bfsRslt) {
			System.out.println("Es fuertemente conexo");
		}else {
			System.out.println("No es fuertemente conexo");
		}
		
	}
	
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
	
	public static void dfsI(Node<String> nd, HashMap<String, Boolean> vis) {
		if(vis.get(nd.getItem())) {
			return;
		}
		vis.put(nd.getItem(), true);
		for(Node<String> node:nd.getNghbr()) {
			dfsI(node, vis);
		}
	}
	
	public static boolean bfsResult(Graph<String> graph) {
		Set<String> keys=graph.getKeys();
		for(String key:keys) {
			bfsIterative(graph.getNode(key));
			return false;
		}
		return true;
	}
	
	@SuppressWarnings({ "unlikely-arg-type", "rawtypes" })
	public static boolean bfsIterative(Node<String> node) {
		Queue<Node> queueNodes = new LinkedList<Node>();
		node.setVisited(true);
		queueNodes.add(node);
		while(!queueNodes.isEmpty()) {
			Node actualNode = queueNodes.remove();
			System.out.println(actualNode);
			for(Node nodes : actualNode.getNghbr()) {
				if(!nodes.isVisited()) {
					nodes.setVisited(true);
					queueNodes.add(nodes);
				}
			}
		}
	}
	
	
}
