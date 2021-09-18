/** dijkstra's algorithm
*   @author obrien
*/
private int dijkstra(ArrayList<Node> graph, Node start, Node end) {

	start.dist = 0;
	PriorityQueue<Node> pq = new PriorityQueue<>();
	pq.addAll(graph);

	while (!pq.isEmpty()) {
     Node u = pq.poll();

		for (int i = 0; i < u.edges.size(); i++) {
			if (u.dist != Integer.MAX_VALUE) {
				if (u.dist + u.edges.get(i).weight < u.neighbors.get(i).dist) {
					u.neighbors.get(i).dist = u.dist + u.edges.get(i).weight;
					pq.add(u.neighbors.get(i));
				}
			}
		}
	}
	return end.dist;
}
