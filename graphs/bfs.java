/** breadthFirstSearch
*   @author obrien
*/
void bfs(ArrayList<Node> graph, Node start) {
		start.visited = true;
		Queue<Node> q = new LinkedList<>();
		q.add(start);

		while (!q.isEmpty()) {
				Node u = q.poll();
				for (int i = 0; i < u.neighbors.size(); i++) {
					if (!u.neighbors.get(i).visited) {
						u.neighbors.get(i).visited = true;
						q.add(u.neighbors.get(i));
					}
				}
			}
		}
	}
