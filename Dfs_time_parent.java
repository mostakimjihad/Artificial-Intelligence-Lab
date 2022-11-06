package practice;
import java.util.Scanner;

public class Dfs_time_parent{
	
	static Scanner in = new Scanner(System.in);
	static int[][] graph, time;
	static int[] visited, parent;
	static int e, v, t = 0;
	
	static void dfs(int source) {
		
		System.out.print(source + " ");
		visited[source] = 1;
		
		time[source][0] = t;
		t++;
		
		for(int i = 0; i < v; i++) {
			if(graph[source][i] == 1 && visited[i] != 1) {
				parent[i] = source;
				dfs(i);
			}
			
		}
		time[source][1] = t;
		t++;
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
		
		System.out.println("Enter source node : ");
		int source = in.nextInt();
		System.out.print("DFS : ");
		dfs(source);
		
		System.out.println();
		for(int i = 0; i < v; i++)
			System.out.println("Node : " + i + "  parent : " + parent[i] + "  starting time : " + time[i][0] + "  ending time : " + time[i][1]);
		
	}

}
