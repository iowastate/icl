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

/** counting depth of breathFirstSearch
*   @obrien
*/
int breadthFirstSearch(ArrayList<Node> graph, Node start) {
	start.visited = true;
	Queue<Node> q = new LinkedList<>();
	q.add(start);
	int depth = 1;
	int depthInc = 0;
	int depthCounter = 0;

	while (!q.isEmpty()) {
		while (depth > 0) {
			Node u = q.poll();
			depth--;
			for (int i = 0; i < u.neighbors.size(); i++) {
				if (!u.neighbors.get(i).visited) {
					u.neighbors.get(i).visited = true;
					q.add(u.neighbors.get(i));
					depthInc++;
				}
			}
		}
		depth = depthInc;
		depthInc = 0;
		depthCounter++;
	}
	return depthCounter;
}
