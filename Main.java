import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
/*
* lexicographically smallest fewest edges shortest path
*
*/
class Main{
	public static void lexiSmallestSequence(int adj[][], int src, int des){
		//Initialize
		int d[] = new int[adj[0].length];
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				if(d[a] < d[b])
					return -1;
				else 
					return 1;
			}
		});
		//a list of list store complete sequence from src to each vertice(include current vertice)
		List<List<Integer>> path = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<>();
		//set of vertices to which shortest path from src is known
		Set<Integer> s = new HashSet<>();
		//add all vertices to priority queue on key value d[v]
		d[src] = 0; 
		for(int i = 0 ; i < adj[0].length ; i++){
			tmp = new ArrayList<>();
			if(i != src ){
				d[i] = Integer.MAX_VALUE;
				//https://stackoverflow.com/questions/8895817/arraylist-out-of-bounds-exception
				path.add(i,tmp);
			}
			else{
				tmp.add(src);
				path.add(i,tmp);
			}
			q.add(i);
		}

		//verify arraylist
		//1.to avoid "uses unchecked or unsafe operations" warning add <Integer> after List
		//2.toString have to be used as Arrays.toString(some array)
		// for(List<Integer> l : path){
		// 	System.out.println(Arrays.toString(l.toArray(new Integer[0])));
		// }

		//core part
		while(!q.isEmpty()){
			//1.Extract nearest vertice from src 
			int u = q.poll();
			//2.Add it to set s
			s.add(u);
			//3.For each v on adj[u](only v not in s)do Relax
			for(int j = 0 ; j < adj[0].length ; j++ ){
				//j is a u's neighbour and j is not in s
				if(adj[u][j] != 0 && !s.contains(j)){
					//!!since tmp only get reference, we need to create a real copy of tmp!!
					//https://stackoverflow.com/questions/8441664/how-do-i-copy-the-contents-of-one-arraylist-into-another
					tmp = path.get(u);
					List<Integer> update = new ArrayList<>();
					for(Integer vertice : tmp)
						update.add(vertice);
					update.add(j);
					//Relax
					//original dijkstra prefer shorter path
					if(d[u] + adj[u][j] < d[j]){
						d[j] = d[u] + adj[u][j];
						// path.get(j) = path.get(u).add(j);
						// update element in arraylist use set() instead of get() then add
						// aslo add() return boolean, cannot directly assign
						path.set(j,update); 
					}
					//shortest path tie 
					else if(d[u] + adj[u][j] == d[j]){
						// prefer fewer edges
						if(path.get(u).size() + 1 < path.get(j).size())
							path.set(j,update);
						//edge tie
						else if(path.get(u).size() + 1 == path.get(j).size()){
							List<Integer> prev = path.get(j);
							//prefer lexi smaller
							if(lexiUpdate(update,prev))
								path.set(j,update);
						}
						else
							;
					}
					else
						;
					q.remove(j);
					q.add(j);
				}
			}

		}
		System.out.println(d[des]);
		List<Integer> sequence = path.get(des);
		for(int i = 0; i < sequence.size() - 1; i++)
			System.out.print(sequence.get(i) + " ");
		System.out.println(sequence.get(sequence.size()-1));
	}

	private static boolean lexiUpdate(List<Integer> update, List<Integer> prev){
		for(int i = 0; i < update.size(); i++){
			int u1 = update.get(i);
			int v1 = prev.get(i);
			if(u1 == v1)
				continue;
			else if (u1 < v1)
				return true;
			else return false;
		}
		return false;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int adj[][] = new int[v][v];
		for(int k = 0; k < e; k ++){
			//undirected gragh -> assign edge weight for both adj[i][j] and adj[j][i]
			int i = sc.nextInt();
			int j = sc.nextInt();
			adj[i][j] = sc.nextInt();
			adj[j][i] = adj[i][j];
		}
		int src = sc.nextInt();
		int des = sc.nextInt();
		// for(int i = 0 ; i < adj[0].length; i++)
		// 	System.out.println(Arrays.toString(adj[i]));
		// System.out.println(src + " " + des);
		lexiSmallestSequence(adj,src,des);
	}
}