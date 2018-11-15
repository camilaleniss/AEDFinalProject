package test;

import static org.junit.Assert.*;
import org.junit.Test;
import model.AdjListGraph;

public class TestAdjListGraph {

	private AdjListGraph<Integer> directedG;
	private AdjListGraph<Integer> simpleG;
	private AdjListGraph<String> simpleSG;
	
	public TestAdjListGraph(){
		simpleG = new AdjListGraph<Integer>(false, true);
	}

	public void setUpStage1() {
		simpleG= new AdjListGraph<Integer>(false, true);
		simpleG.addVertex(1);
		simpleG.addVertex(2);
		simpleG.addVertex(4);
	}
	
	public void setUpStage2() {
		directedG= new AdjListGraph<Integer>(true, true);
		directedG.addVertex(1);
		directedG.addVertex(2);
		directedG.addVertex(5);
		directedG.addVertex(7);
	}
	
	public void setUpStage3() {
		simpleG= new AdjListGraph<Integer>(false, true);
		simpleG.addVertex(1);
		simpleG.addVertex(2);
		simpleG.addVertex(5);
		simpleG.addVertex(7);
	}
	
	public void setUpStage4() {
		setUpStage2();
		directedG.addEdge(1, 2, 3);
		directedG.addEdge(1, 5, 6);
		directedG.addEdge(5, 2, 3);
		directedG.addEdge(7, 5, 5);
	}
	
	public void setUpStage5() {
		simpleG= new AdjListGraph<Integer>(false, true);
		simpleG.addVertex(1);
		simpleG.addVertex(2);
		simpleG.addVertex(3);
		simpleG.addVertex(4);
		simpleG.addEdge(1, 2, 1);
		simpleG.addEdge(2, 3, 1);
		simpleG.addEdge(3, 4, 1);
		simpleG.addEdge(4, 1, 1);
	}
	
	public void setUpStage6() {
		setUpStage2();
		directedG.addEdge(1, 2, 3);
		directedG.addEdge(1, 5, 6);
		directedG.addEdge(5, 2, 3);
		directedG.addEdge(7, 5, 5);
		directedG.addEdge(5, 7, 3);
		directedG.addEdge(1, 1, 8);
	}
	
	public void setUpStage7() {
		simpleSG = new AdjListGraph<>(false, false);
		simpleSG.addVertex("r");
		simpleSG.addVertex("s");
		simpleSG.addVertex("t");
		simpleSG.addVertex("u");
		simpleSG.addVertex("v");
		simpleSG.addVertex("w");
		simpleSG.addVertex("x");
		simpleSG.addVertex("y");
		simpleSG.addEdge("r", "v");
		simpleSG.addEdge("r", "s");
		simpleSG.addEdge("s", "w");
		simpleSG.addEdge("w", "t");
		simpleSG.addEdge("w", "x");
		simpleSG.addEdge("t", "u");
		simpleSG.addEdge("t", "x");
		simpleSG.addEdge("x", "u");
		simpleSG.addEdge("u", "y");
		simpleSG.addEdge("x", "y");
	}
	
	//Basic operation tests
	
	@Test
	public void testAddVertex() {
		//Test 1
		simpleG.addVertex(1);
		assertTrue(simpleG.isInGraph(1));
		assertTrue(simpleG.getVertices().size()==1);
		
		//Test 2
		setUpStage1();
		simpleG.addVertex(3);
		assertTrue(simpleG.isInGraph(3));
		assertTrue(simpleG.getVertices().size()==4);
		
		//Test 3
		setUpStage1();
		simpleG.addVertex(4);
		assertTrue(simpleG.isInGraph(1));
		assertTrue(simpleG.isInGraph(2));
		assertTrue(simpleG.isInGraph(4));
		assertTrue(simpleG.getVertices().size()==3);
	}
	
	@Test
	public void testAddEdge() {
		//Test 1
		setUpStage2();
		directedG.addEdge(5, 7, 3);
		assertTrue(directedG.searchVertex(5).isAdjacent(directedG.searchVertex(7)));
		assertTrue(directedG.searchVertex(5).findEdge(directedG.searchVertex(7)).getWeight()==3);
		assertTrue(directedG.searchVertex(7).findEdge(directedG.searchVertex(5))==null);
		
		//Test 2
		setUpStage3();
		simpleG.addEdge(5, 7, 3);
		assertTrue(simpleG.searchVertex(5).isAdjacent(simpleG.searchVertex(7)));
		assertTrue(simpleG.searchVertex(5).findEdge(simpleG.searchVertex(7)).getWeight()==3);
		assertTrue(simpleG.searchVertex(7).findEdge(simpleG.searchVertex(5))!=null);
		
		//Test 3
		setUpStage2();
		directedG.addEdge(5, 5, 8);
		assertTrue(directedG.searchVertex(5).isAdjacent(directedG.searchVertex(5)));
		assertTrue(directedG.searchVertex(5).findEdge(directedG.searchVertex(5)).getWeight()==8);
		
		//Test 4
		setUpStage3();
		simpleG.addEdge(5, 5, 8);
		assertTrue(simpleG.searchVertex(5).isAdjacent(simpleG.searchVertex(5)));
		assertTrue(simpleG.searchVertex(5).findEdge(simpleG.searchVertex(5)).getWeight()==8);
		
		//Test 5
		setUpStage4();
		directedG.addEdge(5, 7, 3);
		assertTrue(directedG.searchVertex(5).isAdjacent(directedG.searchVertex(2)));
		assertTrue(directedG.searchVertex(5).isAdjacent(directedG.searchVertex(7)));
		assertTrue(directedG.searchVertex(5).findEdge(directedG.searchVertex(2)).getWeight()==3);
	}
	
	
}
