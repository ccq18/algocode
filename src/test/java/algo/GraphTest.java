package algo;

import algo.graph.Graph;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class GraphTest {
    @Test
    public void testGraph(){
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);
//        graph.bfs(0,6);

        // 深度优先
        graph.dfs(0, 6);
    }
}
