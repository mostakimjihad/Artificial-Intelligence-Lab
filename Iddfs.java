package clp;
import java.util.Scanner;
public class Ids {
	
	static Scanner in = new Scanner(System.in);
	static int[][] graph;
	static int[] visited;
	static int e, v;
	
	static boolean dls(int source, int target, int limit) {
		
		if(source == target)
			return true;
		if(limit <= 0)
			return false;
		
		for(int i = 0; i < v; i++)
			if(graph[source][i] == 1 && visited[i] != 1)
				if(dls(i, target, limit-1))
					return true;
		
		return false;
	}
	static boolean ids(int source, int target, int max_depth) {
		
		for(int i = 0; i < max_depth; i++) {
			
			for(int j = 0; j < v; j++)
				visited[j] = 0;
			
			if(dls(source, target, i))
				return true;
			
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Enter number vertices : ");
		v = in.nextInt();
		
		System.out.println("Enter number edges : ");
		e = in.nextInt();
		
		graph = new int[v][v];
		visited = new int[v];
		
		for(int i = 0; i < e; i++) {
			
			System.out.println("Enter adjacency nodes :");
			int x = in.nextInt();
			int y = in.nextInt();
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		
		System.out.println("Enter source node : ");
		int source = in.nextInt();
		
		System.out.println("Enter Max depth");
		int max_depth = in.nextInt();
		
		System.out.println("Enter target : ");
		int target = in.nextInt();
		
		if(ids(source,target, max_depth))
			System.out.println("target node found");
		else
			System.out.println("target node not found");
	}
}
