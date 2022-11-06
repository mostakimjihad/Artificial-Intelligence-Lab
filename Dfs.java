package practice;
import java.util.Scanner;

public class Dfs {
	
	static Scanner in = new Scanner(System.in);
	static int[][] graph;
	static int[] visited;
	static int e, v;
	
	static void dfs(int source) {
		
		System.out.print(source + " ");
		visited[source] = 1;
		for(int i = 0; i < v; i++)
			if(graph[source][i] == 1 && visited[i] != 1)
				dfs(i);
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Enter number vertices : ");
		v = in.nextInt();
		System.out.println("Enter number of edge : ");
		e = in.nextInt();
		
		graph = new int[v][v];
		visited = new int[v];
		
		for(int i = 0; i < e; i++) {
			
			System.out.println("Enter adjacency nodes: ");
			int x = in.nextInt();
			int y = in.nextInt();
			
			graph[x][y] = 1;
			graph[y][x] = 1;
			
		}
		
		System.out.println("Enter source node : ");
		int source = in.nextInt();
		dfs(source);
		
	}

}
