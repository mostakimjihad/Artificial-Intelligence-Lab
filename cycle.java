import java.util.Scanner;

public class dfs{

	static Scanner in = new Scanner(System.in);
	static int[][] graph;
	static int[] visited, parent;
	static int v, e;

	static boolean dfs(int source){

		visited[source] = 1;
		System.out.print(source + " ");

		for(int i = 0; i < v; i++){

			if ( graph[source][i] == 1 && visited[i] == 1 && parent[source] != i )
				return false;

			if ( graph[source][i] == 1 && visited[i] != 1 ) {

				parent[i] = source;
				dfs(i);
			}
		}

		return true;

	}

	public static void main(String[] args){

		System.out.println("Enter number of vertices : ");
		v = in.nextInt();

		System.out.println("Enter number of edges : ");
		e = in.nextInt();

		graph = new int[v][v];
		visited = new int[v];
		parent = new int[v];

		for(int i = 0; i < e; i++){

			System.out.println("Enter adjacency nodes : ");
			int x = in.nextInt();
			int y = in.nextInt();

			graph[x][y] = 1;
			graph[y][x] = 1;

		}

		System.out.println("Enter source node : ");
		int source = in.nextInt();

		System.out.println("DFS : ");
		if (dfs(source))
			System.out.println("garph contain no cycle");
		else
			System.out.println("graph contain cycle");

	}

}
