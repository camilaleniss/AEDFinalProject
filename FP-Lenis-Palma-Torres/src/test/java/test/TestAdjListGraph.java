package test;

import static org.junit.Assert.*;
import org.junit.Test;
import model.AdjListGraph;
import model.AdjVertex;
import model.Vertex;

public class TestAdjListGraph {

	private AdjListGraph<Integer> directedG;
	private AdjListGraph<Integer> simpleG;
	private AdjListGraph<String> simpleSG;
	private AdjListGraph<Character> directedCG;
	
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
	
	public void setUpStage8() {
		simpleG = new AdjListGraph<>(false, false);
		simpleG.addVertex(1);
		simpleG.addVertex(2);
		simpleG.addVertex(3);
		simpleG.addVertex(4);
		simpleG.addVertex(5);
		simpleG.addEdge(1,2);
		simpleG.addEdge(1,5);
		simpleG.addEdge(2,5);
		simpleG.addEdge(5,4);
		simpleG.addEdge(2,4);
		simpleG.addEdge(2,3);
		simpleG.addEdge(3,4);
	}
	
	public void setUpStage9() {
		//EXAMPLE OF "Matem�tica discreta y sus aplicaciones"
		simpleSG = new AdjListGraph<>(false, true);
		simpleSG.addVertex("Boston");
		simpleSG.addVertex("Nueva York");
		simpleSG.addVertex("Chicago");
		simpleSG.addVertex("Dallas");
		simpleSG.addVertex("Boston"); 
		simpleSG.addVertex("Denver");
		simpleSG.addVertex("San Francisco");
		simpleSG.addVertex("Los Angeles");
		simpleSG.addEdge("San Francico", "Los Angeles", 400);
		simpleSG.addEdge("San Franciso", "Denver", 1000);
		simpleSG.addEdge("San Francisco", "Chicago", 1500);
		simpleSG.addEdge("Los Angeles", "Chicago", 1400);
		simpleSG.addEdge("Los Angeles", "Dallas", 1100);
		simpleSG.addEdge("Denver", "Chicago", 500);
		simpleSG.addEdge("Denver", "Dallas", 600);
		simpleSG.addEdge("Dallas", "Chicago", 800);
		simpleSG.addEdge("Dallas", "Nueva York", 1200);
		simpleSG.addEdge("Chicago", "Nueva York", 700);
		simpleSG.addEdge("Boston", "Nueva York", 300);
		simpleSG.addEdge("Boston", "Chicago", 900);
	}
	
	public void setUpStage10() {
		simpleSG = new AdjListGraph<>(false, true);
		simpleSG.addVertex("A");
		simpleSG.addVertex("B");
		simpleSG.addVertex("C");
		simpleSG.addVertex("D");
		simpleSG.addVertex("E");
		simpleSG.addVertex("F");
		simpleSG.addVertex("G");
		simpleSG.addEdge("A", "B", 7);
		simpleSG.addEdge("A", "D", 5);
		simpleSG.addEdge("D", "B", 9);
		simpleSG.addEdge("D", "E", 15);
		simpleSG.addEdge("D", "F", 6);
		simpleSG.addEdge("F", "E", 8);
		simpleSG.addEdge("F", "G", 11);
		simpleSG.addEdge("E", "G", 9);
		simpleSG.addEdge("C", "E", 5);
		simpleSG.addEdge("B", "C", 8);
		simpleSG.addEdge("E", "B", 7);
	}
	
	public void setUpStage11() {
		setUpStage4();
		directedG.addEdge(5, 7, 3);
	}
	
	public void setUpStage12() {
		directedG = new  AdjListGraph<>(true, true);
		directedG.addVertex(3);
		directedG.addVertex(4);
		directedG.addVertex(5);
	}
	
	public void setUpStage13() {
		setUpStage11();
		directedG.addEdge(1, 1, 8);
	}
	
	public void setUpStage14() {
		directedCG = new AdjListGraph<Character>(true, false);
		directedCG.addVertex('u');
		directedCG.addVertex('v');
		directedCG.addVertex('w');
		directedCG.addVertex('x');
		directedCG.addVertex('y');
		directedCG.addVertex('z');
		directedCG.addEdge('u', 'v');
		directedCG.addEdge('u', 'x');
		directedCG.addEdge('x', 'v');
		directedCG.addEdge('v', 'y');
		directedCG.addEdge('y', 'x');
		directedCG.addEdge('w', 'y');
		directedCG.addEdge('w', 'z');
		directedCG.addEdge('z', 'z');
	}
	
	public void setUpStage15() {
		simpleG = new AdjListGraph<Integer>(false, false);
		simpleG.addVertex(1);
		simpleG.addVertex(2);
		simpleG.addVertex(3);
		simpleG.addVertex(4);	
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
	
	@Test
	public void testRemoveVertex() {
		//Test 1
		setUpStage11();
		directedG.removeVertex(2);
		assertTrue(directedG.searchVertex(1).getAdjList().size()==1);
		assertTrue(directedG.searchVertex(1).getAdjList().get(0).getDestination().getValue()==5);
		assertTrue(directedG.searchVertex(5).getAdjList().size()==1);
		assertTrue(directedG.searchVertex(5).getAdjList().get(0).getDestination().getValue()==7);
		
		//Test 2
		setUpStage11();
		directedG.removeVertex(1);
		assertTrue(directedG.searchVertex(1)==null);
		
		//Test 3
		setUpStage11();
		directedG.removeVertex(5);
		assertTrue(directedG.searchVertex(1).getAdjList().size()==1);
		assertTrue(directedG.searchVertex(1).getAdjList().get(0).getDestination().getValue()==2);
		assertTrue(directedG.searchVertex(7).getAdjList().size()==0);
		
		//Test 4
		setUpStage5();
		simpleG.removeVertex(2);
		assertTrue(simpleG.searchVertex(1).getAdjList().size()==1);
		assertTrue(simpleG.searchVertex(1).getAdjList().get(0).getDestination().getValue()==4);
		assertTrue(simpleG.searchVertex(3).getAdjList().size()==1);
		assertTrue(simpleG.searchVertex(3).getAdjList().get(0).getDestination().getValue()==4);
	}
	
	@Test
	public void testRemoveEdge() {
		//Test 1
		setUpStage13();
		directedG.removeEdge(1, 2);
		assertTrue(directedG.searchVertex(1).getAdjList().size()==2);
		assertTrue(directedG.searchVertex(1).getAdjList().get(0).getDestination().getValue()==5);
		assertTrue(directedG.searchVertex(1).getAdjList().get(1).getDestination().getValue()==1);
		
		//Test 2
		setUpStage13();
		directedG.removeEdge(5, 7);
		assertTrue(directedG.searchVertex(7).isAdjacent(directedG.searchVertex(5)));
		assertTrue(!directedG.searchVertex(5).isAdjacent(directedG.searchVertex(7)));
		
		//Test 3
		setUpStage5();
		simpleG.removeEdge(1, 2);
		assertTrue(!simpleG.searchVertex(1).isAdjacent(simpleG.searchVertex(2)));
		assertTrue(!simpleG.searchVertex(2).isAdjacent(simpleG.searchVertex(1)));
		
		//Test 4
		setUpStage5();
		simpleG.removeEdge(3, 4);
		assertTrue(!simpleG.searchVertex(3).isAdjacent(simpleG.searchVertex(4)));
		assertTrue(!simpleG.searchVertex(4).isAdjacent(simpleG.searchVertex(3)));
	}
	
	@Test
	public void testSearchVertex() {
		AdjVertex<Integer> ver;
		
		//Test 1
		setUpStage5();
		ver= simpleG.searchVertex(1);
		assertTrue(ver.getValue()==1);
		assertTrue(ver.getAdjList().size()==2);
		assertTrue(ver.isAdjacent(simpleG.searchVertex(2)));
		assertTrue(ver.isAdjacent(simpleG.searchVertex(4)));
		
		//Test 2
		ver= simpleG.searchVertex(5);
		assertTrue(ver==null);
		
		//Test 3
		setUpStage13();
		ver = directedG.searchVertex(2);
		assertTrue(ver.getValue()==2);
		assertTrue(ver.getAdjList().size()==0);
		
		//Test 4
		ver = directedG.searchVertex(1);
		assertTrue(ver.getValue()==1);
		assertTrue(ver.getAdjList().size()==3);
		assertTrue(ver.isAdjacent(directedG.searchVertex(1)));
		assertTrue(ver.isAdjacent(directedG.searchVertex(2)));
		assertTrue(ver.isAdjacent(directedG.searchVertex(5)));
		
		//Test
		ver= directedG.searchVertex(8);
		assertTrue(ver==null);
	}
	
	@Test
	public void testAreAdjacent() {
		//Test 1
		setUpStage5();
		assertTrue(simpleG.areAdjacent(simpleG.searchVertex(1), simpleG.searchVertex(2)));
		
		//Test 2
		assertTrue(!simpleG.areAdjacent(simpleG.searchVertex(1), simpleG.searchVertex(3)));
		
		//Test 3
		setUpStage13();
		assertTrue(directedG.areAdjacent(directedG.searchVertex(1), directedG.searchVertex(2)));
		
		//Test 4
		assertTrue(!directedG.areAdjacent(directedG.searchVertex(2), directedG.searchVertex(1)));
	
		//Test 5
		assertTrue(directedG.areAdjacent(directedG.searchVertex(1), directedG.searchVertex(1)));
	}
	
	//Algorithms test
	
	@Test
	public void testBfs() {
		//Test 1
		setUpStage7();
		simpleSG.bfs(simpleSG.searchVertex("u"));
		assertTrue(simpleSG.searchVertex("u").getPred()==null);
		assertTrue(simpleSG.searchVertex("v").getPred().getValue().equals("r"));
		assertTrue(simpleSG.searchVertex("r").getPred().getValue().equals("s"));
		assertTrue(simpleSG.searchVertex("s").getPred().getValue().equals("w"));
		assertTrue(simpleSG.searchVertex("w").getPred().getValue().equals("t"));
		assertTrue(simpleSG.searchVertex("t").getPred().getValue().equals("u"));
		assertTrue(simpleSG.searchVertex("x").getPred().getValue().equals("u"));
		assertTrue(simpleSG.searchVertex("y").getPred().getValue().equals("u"));
		
		//Test 2
		setUpStage8();
		simpleG.bfs(simpleG.searchVertex(3));
		assertTrue(simpleG.searchVertex(3).getPred()==null);
		assertTrue(simpleG.searchVertex(2).getPred().getValue()==3);
		assertTrue(simpleG.searchVertex(4).getPred().getValue()==3);
		assertTrue(simpleG.searchVertex(1).getPred().getValue()==2);
		assertTrue(simpleG.searchVertex(5).getPred().getValue()==2);
		
		//Test 3
		setUpStage12();
		directedG.bfs(directedG.searchVertex(3));
		assertTrue(directedG.searchVertex(3).getPred()==null);
		assertTrue(directedG.searchVertex(4).getPred()==null);
		assertTrue(directedG.searchVertex(5).getPred()==null);
		assertTrue(directedG.getVertices().size()==3);
		
	}
	
	@Test
	public void testDfs() {
		//Test 1
		setUpStage14();
		directedCG.dfs();
		//Verify the predecessors
		assertTrue(directedCG.searchVertex('x').getPred().getValue()=='y');
		assertTrue(directedCG.searchVertex('y').getPred().getValue()=='v');
		assertTrue(directedCG.searchVertex('v').getPred().getValue()=='u');
		assertTrue(directedCG.searchVertex('u').getPred()==null);
		assertTrue(directedCG.searchVertex('z').getPred().getValue()=='w');
		assertTrue(directedCG.searchVertex('w').getPred()==null);
		//Verify the TimeStamps
		assertTrue(directedCG.searchVertex('u').getD()==1 && directedCG.searchVertex('u').getF()==8);
		assertTrue(directedCG.searchVertex('v').getD()==2 && directedCG.searchVertex('v').getF()==7);
		assertTrue(directedCG.searchVertex('w').getD()==9 && directedCG.searchVertex('w').getF()==12);
		assertTrue(directedCG.searchVertex('x').getD()==4 && directedCG.searchVertex('x').getF()==5);
		assertTrue(directedCG.searchVertex('y').getD()==3 && directedCG.searchVertex('y').getF()==6);
		assertTrue(directedCG.searchVertex('z').getD()==10 && directedCG.searchVertex('z').getF()==11);
		
		//Test 2
		setUpStage15();
		simpleG.dfs();
		for (int i=0; i<simpleG.getVertices().size(); i++)
			assertTrue(simpleG.getVertices().get(i).getPred()==null);
		
		//Test 3
		setUpStage8();
		simpleG.dfs();
		//Verify the predecessors
		assertTrue(simpleG.searchVertex(1).getPred()==null);
		assertTrue(simpleG.searchVertex(2).getPred().getValue()==1);
		assertTrue(simpleG.searchVertex(3).getPred().getValue()==4);
		assertTrue(simpleG.searchVertex(4).getPred().getValue()==5);
		assertTrue(simpleG.searchVertex(5).getPred().getValue()==2);
		//Verify the TimeStamps
		assertTrue(simpleG.searchVertex(1).getD()==1 && simpleG.searchVertex(1).getF()==10);
		
		//THIS IS WHERE THE TEST FAILS DUE TO THE ORDER OF THE DISCOVER FO VERTICES 
		assertTrue(simpleG.searchVertex(2).getD()==2 && simpleG.searchVertex(1).getF()==9);
		assertTrue(simpleG.searchVertex(3).getD()==3 && simpleG.searchVertex(1).getF()==8);
		assertTrue(simpleG.searchVertex(4).getD()==4 && simpleG.searchVertex(1).getF()==7);
		assertTrue(simpleG.searchVertex(5).getD()==5 && simpleG.searchVertex(1).getF()==6);
	}
	
	@Test
	public void testDijkstra() {
		
	}
	
	@Test
	public void testFloydWarshall() {
		
	}
	
	@Test
	public void testPrim() {
		
	}
	
	@Test
	public void testKruskal() {
		
	}
}
