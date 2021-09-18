/** depthFirstSearch - iterative
*   @author obrien
*/ 
void dfs(ArrayList<Node> graph, Node start) {
	start.visited = true;
	Stack<Node> stk = new Stack<>();
	stk.push(start);

	while (!stk.isEmpty()) {
		Node u = stk.pop();
		for (int i = 0; i < u.neighbors.size(); i++) {
			if (!u.neighbors.get(i).visited) {
				u.neighbors.get(i).visited = true;
				stk.push(u.neighbors.get(i));
			}
		}
	}
}

/** depthFirstSearch - recursive
*   @author obrien
*/
void dfs(Node start) {
	start.visited = true;
	for (int i = 0; i < start.neighbors.size(); i++) {
		if (!start.neighbors.get(i).visited) {
			dfs(start.neighbors.get(i));
		}
	}
}
