package clp;
import java.util.Scanner;

public class Graph_coloring{
	static Scanner in = new Scanner(System.in);
	static int[][] graph;
	static int[] visited, color;
	static int v, e, c;
	
	static boolean isSafe() {
		
		for(int i = 0; i < v; i++)
			for(int j = 0; j < v; j++)
				if(graph[i][j] == 1 && color[i] == color[j])
					return false;
		return true;
	}
	
	static boolean graphColor(int node) {
		
		if(node == v) {
			if(isSafe())
				return true;
			else
				return false;
		}
		
		for(int i = 0; i < c; i++) {
			
			color[node] = i;
			
			if(graphColor(node+1))
				return true;
			
			color[node] = 0;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Enter number of vertices : ");
		v = in.nextInt();
		
		System.out.println("Enter number of eges : ");
		e = in.nextInt();
		
		graph = new int[v][v];
		color = new int[v];
		
		for(int i = 0; i < e; i++) {
			
			System.out.print("Enter adjacency nodes : ");
			int x = in.nextInt();
			int y = in.nextInt();
			
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		
		System.out.println("Enter number color : ");
		c = in.nextInt();
		
		if(graphColor(0)) {
			System.out.println("Solution exist");
			for(int i = 0; i < v; i++)
				System.out.println("node -> " + i + " color -> " + color[i]);
		}
		else
			System.out.println("Solution doesn't exist");
		
		
	}
}
