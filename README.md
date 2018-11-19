# Overview
In the usual formulation of **Dijkstra’s algorithm**, the number of edges in the shortest (= lightest) path is not a consideration. Here, we assume that there might be multiple shortest paths. Implement an algorithm that takes as input an undirected graph **G = (V, E)**, a non-negative cost function **w** on **E**, a source vertex **s** and a destination vertex **t**, and produces a path with the fewest edges amongst all shortest paths from **s** to **t**. If there are multiple such shortest paths with the fewest edges, your algorithm should output the unique path with the **lexicographically smallest** sequence of vertices amongst all such paths. [A vertex sequence **u1, u2, ..., ui-1, ui, ... um** is lexicographically smaller than another vertex sequence **v1, v2, ..., vi-1, vi, ... vn** if **u1 = v1, u2 = v2, ..., ui-1 = vi-1**, and **ui < vi** for some **i**. For example, **0, 3, 21, 5** is lexicographically smaller than **0, 32, 1, 5** with **i=2**.]
# Input 
The first line of input contains two integers separated by a space: the number of vertices **|V| (1<=|V|<=50)**, and the number of edges **|E| (0<=|E|<=100)**. The next **|E|** lines each describes an undirected edge. An edge is described by three integers separated by space: the end-points **u** and **v (0<=u, v<=|V|-1)**, and the cost **w(u,v) (0<=w(u,v)<=1000)**. The last line of input contains the source-destination **s** and **t (0<=s, t<=|V|-1)** separated by space.
```
13 13
0 1 2
1 3 4
3 6 12
6 7 2
0 4 3
4 2 2
2 5 7
5 7 8
7 10 3
10 12 2
7 9 1
9 11 1
11 12 3
0 12
```
# Output
This program would print two lines. In the first line, output the **cost of the optimal path** . In the second line, output **the sequence of vertices in the path** separated by spaces. 
