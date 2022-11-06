package practice;
import java.util.Scanner;

public class Iddfs{
	
	static Scanner in = new Scanner(System.in);
	static int[][] graph, time;
	static int[] visited, parent;
	static int e, v, t = 0;
	
	static boolean dfs(int source, int target, int limit) {
		
        visited[source] = 1;
		
		System.out.println("node = " + source + " limit = " + limit);
		
		if(source == target)
			return true;
		if(limit <= 0)
			return false;
		
		
		
		for(int i = 0; i < v; i++) {
			
			if(graph[source][i] == 1 && visited[i] != 1) {
				
				if(dfs(i, target, limit-1))
					return true;
			}
		}
		
		return false;
	}
	
	static boolean iddfs(int source, int target, int max_depth) {
		
		for(int i = 0; i < max_depth; i++) {
			
			for(int j = 0; j < v; j++)
				visited[j] = 0;
			System.out.println("limit value is " + i);
			if(dfs(source, target, i))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Enter number vertices : ");
		v = in.nextInt();
		System.out.println("Enter number of edge : ");
		e = in.nextInt();
		
		graph = new int[v][v];
		time = new int[v][2];
		visited = new int[v];
		parent = new int[v];
		
		for(int i = 0; i < e; i++) {
			
			System.out.println("Enter adjacency nodes: ");
			int x = in.nextInt();
			int y = in.nextInt();
			
			graph[x][y] = 1;
			graph[y][x] = 1;
			
		}
		
		if(iddfs(0, 3, 3))
			System.out.println("found");
		else
			System.out.println("not found");
		
	}

}
