package main;

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
		
	}
	
	public static boolean dfsR(Graph<String> graph) {
		Set<String> keys=graph.getKeys();
		boolean[] bls=new boolean[keys.size()];
		int i=0;
		for(String key:keys) {
			bls[i]=dfsI(graph.getNode(key));
			i++;
		}
		return false;
	}
	
	public static boolean dfsI(Node<String> nd) {
		
		//Dfs recursivo
		return false;
	}

}
