package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import model.*;

class TestAdjMatrixGraph {

	private AdjMatrixGraph<Integer> directedG;
	private AdjMatrixGraph<Integer> simpleG;
	private AdjMatrixGraph<String> simpleSG;
	private AdjMatrixGraph<Character> simpleCG;
	private AdjMatrixGraph<Character> directedCG;

	public TestAdjMatrixGraph() {
		simpleG = new AdjMatrixGraph<Integer>(false, true);
	}

	public void setUpStage1() {
		simpleG = new AdjMatrixGraph<Integer>(false, true);
		simpleG.addVertex(1);
		simpleG.addVertex(2);
		simpleG.addVertex(4);
	}

	public void setUpStage2() {
		directedG = new AdjMatrixGraph<Integer>(true, true);
		directedG.addVertex(1);
		directedG.addVertex(2);
		directedG.addVertex(5);
		directedG.addVertex(7);
	}

	public void setUpStage3() {
		simpleG = new AdjMatrixGraph<Integer>(false, true);
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
		simpleG = new AdjMatrixGraph<Integer>(false, true);
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
		simpleSG = new AdjMatrixGraph<>(false, false);
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
		simpleG = new AdjMatrixGraph<>(false, false);
		simpleG.addVertex(1);
		simpleG.addVertex(2);
		simpleG.addVertex(3);
		simpleG.addVertex(4);
		simpleG.addVertex(5);
		simpleG.addEdge(1, 2);
		simpleG.addEdge(1, 5);
		simpleG.addEdge(2, 3);
		simpleG.addEdge(2, 4);
		simpleG.addEdge(2, 5);
		simpleG.addEdge(5, 4);

		simpleG.addEdge(3, 4);
	}

	public void setUpStage9() {
		//EXAMPLE OF "Matem�tica discreta y sus aplicaciones"
		simpleSG = new AdjMatrixGraph<>(false, true);
		simpleSG.addVertex("Boston");
		simpleSG.addVertex("Nueva York");
		simpleSG.addVertex("Chicago");
		simpleSG.addVertex("Dallas"); 
		simpleSG.addVertex("Denver");
		simpleSG.addVertex("San Francisco");
		simpleSG.addVertex("Los Angeles");
		//Edges
		simpleSG.addEdge("San Francisco", "Los Angeles", 400);
		simpleSG.addEdge("San Francisco", "Denver", 1000);
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
		simpleSG = new AdjMatrixGraph<>(false, true);
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
		directedG = new AdjMatrixGraph<>(true, true);
		directedG.addVertex(3);
		directedG.addVertex(4);
		directedG.addVertex(5);
	}

	public void setUpStage13() {
		setUpStage11();
		directedG.addEdge(1, 1, 8);
	}

	public void setUpStage14() {
		directedCG = new AdjMatrixGraph<Character>(true, false);
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
		simpleG = new AdjMatrixGraph<Integer>(false, false);
		simpleG.addVertex(1);
		simpleG.addVertex(2);
		simpleG.addVertex(3);
		simpleG.addVertex(4);
	}

	public void setUpStage16() {
		simpleG = new AdjMatrixGraph<Integer>(false, true);
		simpleG.addVertex(1);
		simpleG.addVertex(2);
		simpleG.addVertex(3);
		simpleG.addVertex(4);
		simpleG.addEdge(1, 2, 4);
		simpleG.addEdge(1, 3, 2);
	}

	public void setUpStage17() {
		directedG= new AdjMatrixGraph<Integer>(true, true);
		directedG.addVertex(1);
		directedG.addVertex(2);
		directedG.addVertex(3);
		directedG.addVertex(4);
		directedG.addEdge(1, 3, -2);
		directedG.addEdge(3, 4, 2);
		directedG.addEdge(4, 2, -1);
		directedG.addEdge(2, 1, 4);
		directedG.addEdge(2, 3, 3);
	}
	
	public void setUpStage18() {
		directedG= new AdjMatrixGraph<Integer>(true, true);
		directedG.addVertex(1);
		directedG.addVertex(2);
		directedG.addVertex(3);
		directedG.addVertex(4);
		directedG.addEdge(1, 3, 9);
		directedG.addEdge(3, 4, 2);
		directedG.addEdge(4, 2, 3);
		directedG.addEdge(1, 2, 5);
		directedG.addEdge(2, 3, 1);
	}
	
	public void setUpStage19() {
		directedCG = new AdjMatrixGraph<>(true, true);
		directedCG.addVertex('A');
		directedCG.addVertex('B');
		directedCG.addVertex('C');
		directedCG.addVertex('D');
		directedCG.addVertex('E');
		directedCG.addEdge('A', 'D', 60);
		directedCG.addEdge('A', 'C', 12);
		directedCG.addEdge('B', 'A', 10);
		directedCG.addEdge('C', 'B', 20);
		directedCG.addEdge('C', 'D', 32);
		directedCG.addEdge('E', 'A', 7);
	}
	
	public void setUpStage20() {
		simpleG= new AdjMatrixGraph<>(false, true);
		simpleG.addVertex(1);
		simpleG.addVertex(2);
		simpleG.addVertex(3);
	}
	
	public void setUpStage21() {
		simpleCG= new AdjMatrixGraph<>(false, true);
		simpleCG.addVertex('A');
		simpleCG.addVertex('B');
		simpleCG.addVertex('C');
		simpleCG.addVertex('D');
		simpleCG.addVertex('E');
		simpleCG.addVertex('F');
		simpleCG.addVertex('G');
		
		simpleCG.addEdge('A', 'B', 7);
		simpleCG.addEdge('A', 'D', 5);
		simpleCG.addEdge('B', 'C', 8);
		simpleCG.addEdge('B', 'D', 9);
		simpleCG.addEdge('B', 'E', 7);
		simpleCG.addEdge('C', 'E', 5);
		simpleCG.addEdge('D', 'E', 15);
		simpleCG.addEdge('D', 'F', 6);
		simpleCG.addEdge('E', 'F', 8);
		simpleCG.addEdge('E', 'G', 9);
		simpleCG.addEdge('F', 'G', 11);
	}
	
	public void setUpStage22() {
		simpleCG= new AdjMatrixGraph<>(false, true);
		simpleCG.addVertex('a');
		simpleCG.addVertex('b');
		simpleCG.addVertex('c');
		simpleCG.addVertex('d');
		simpleCG.addVertex('e');
		simpleCG.addVertex('f');
		simpleCG.addVertex('g');
		simpleCG.addVertex('h');
		simpleCG.addVertex('i');
		simpleCG.addVertex('j');
		simpleCG.addVertex('k');
		simpleCG.addVertex('l');
		
		simpleCG.addEdge('a', 'b', 2);
		simpleCG.addEdge('a', 'e', 3);
		simpleCG.addEdge('b', 'c', 3);
		simpleCG.addEdge('b', 'd', 1);
		simpleCG.addEdge('c', 'd', 1);
		simpleCG.addEdge('c', 'g', 1);
		simpleCG.addEdge('d', 'h', 5);
		simpleCG.addEdge('e', 'f', 4);
		simpleCG.addEdge('e', 'i', 4);
		simpleCG.addEdge('f', 'g', 3);
		simpleCG.addEdge('f', 'j', 2);
		simpleCG.addEdge('g', 'h', 3);
		simpleCG.addEdge('g', 'k', 4);
		simpleCG.addEdge('h', 'l', 3);
		simpleCG.addEdge('i', 'j', 3);
		simpleCG.addEdge('j', 'k', 3);
		simpleCG.addEdge('k', 'l', 1);		
	}
	
	public void setUpStage23() {
		simpleG= new AdjMatrixGraph<>(false, true);
		
		simpleG.addVertex(1);
		simpleG.addVertex(2);
		simpleG.addVertex(3);
		simpleG.addVertex(4);
		simpleG.addVertex(5);
		simpleG.addVertex(6);
		simpleG.addVertex(7);
		simpleG.addVertex(8);
		simpleG.addVertex(9);
		
		simpleG.addEdge(1, 2, 4);	
		simpleG.addEdge(1, 8, 9);
		simpleG.addEdge(2, 3, 9);
		simpleG.addEdge(2, 8, 11);
		simpleG.addEdge(3, 9, 2);
		simpleG.addEdge(4, 5, 10);
		simpleG.addEdge(4, 6, 15);
		simpleG.addEdge(5, 6, 11);
		simpleG.addEdge(7, 8, 1);
		simpleG.addEdge(7, 9, 6);
		simpleG.addEdge(8, 7, 1);
		
	}
	
	@Test
	public void testAddVertex() {
		// Test 1
		simpleG.addVertex(1);
		assertTrue(simpleG.isInGraph(1));
		assertTrue(simpleG.getVertices().size() == 1);

		// Test 2
		setUpStage1();
		simpleG.addVertex(3);
		assertTrue(simpleG.isInGraph(3));
		assertTrue(simpleG.getVertices().size() == 4);

		// Test 3
		setUpStage1();
		simpleG.addVertex(4);
		assertTrue(simpleG.isInGraph(1));
		assertTrue(simpleG.isInGraph(2));
		assertTrue(simpleG.isInGraph(4));
		assertTrue(simpleG.getVertices().size() == 3);
	}

	@Test
	public void testAddEdge() {
		// Test 1
		setUpStage2();
		directedG.addEdge(5, 7, 3);
		assertTrue(directedG.getAdjMatrix().get(directedG.getIndexOf(directedG.searchVertex(5)))
				.get(directedG.getIndexOf(directedG.searchVertex(7))) == 1.0);
		assertTrue(directedG.getWeightsMatrix()[directedG.getIndexOf(directedG.searchVertex(5))]
				[directedG.getIndexOf(directedG.searchVertex(7))] == 3.0);
		assertTrue(directedG.getAdjMatrix().get(directedG.getIndexOf(directedG.searchVertex(7)))
				.get(directedG.getIndexOf(directedG.searchVertex(5))) == 0);

		// Test 2
		setUpStage3();
		simpleG.addEdge(5, 7, 3);
		assertTrue(simpleG.getAdjMatrix().get(simpleG.getIndexOf(simpleG.searchVertex(5)))
				.get(simpleG.getIndexOf(simpleG.searchVertex(7))) == 1.0);
		assertTrue(simpleG.getWeightsMatrix()[simpleG.getIndexOf(simpleG.searchVertex(5))]
				[simpleG.getIndexOf(simpleG.searchVertex(7))] == 3.0);
		assertTrue(simpleG.getAdjMatrix().get(simpleG.getIndexOf(simpleG.searchVertex(7)))
				.get(simpleG.getIndexOf(simpleG.searchVertex(5))) == 1);
		
		// Test 3
		setUpStage2();
		directedG.addEdge(5, 5, 8);
		assertTrue(directedG.getAdjMatrix().get(directedG.getIndexOf(directedG.searchVertex(5)))
				.get(directedG.getIndexOf(directedG.searchVertex(5))) == 1.0);
		assertTrue(directedG.getWeightsMatrix()[directedG.getIndexOf(directedG.searchVertex(5))]
				[directedG.getIndexOf(directedG.searchVertex(5))] == 8.0);

		// Test 4
		setUpStage3();
		simpleG.addEdge(5, 5, 8);
		assertTrue(simpleG.getAdjMatrix().get(simpleG.getIndexOf(simpleG.searchVertex(5)))
				.get(simpleG.getIndexOf(simpleG.searchVertex(5))) == 1.0);
		assertTrue(simpleG.getWeightsMatrix()[simpleG.getIndexOf(simpleG.searchVertex(5))]
				[simpleG.getIndexOf(simpleG.searchVertex(5))] == 8.0);

		// Test 5
		setUpStage4();
		directedG.addEdge(5, 7, 3);
		assertTrue(directedG.getAdjMatrix().get(directedG.getIndexOf(directedG.searchVertex(5)))
				.get(directedG.getIndexOf(directedG.searchVertex(2))) == 1.0);
		assertTrue(directedG.getAdjMatrix().get(directedG.getIndexOf(directedG.searchVertex(5)))
				.get(directedG.getIndexOf(directedG.searchVertex(7))) == 1.0);
		assertTrue(directedG.getWeightsMatrix()[directedG.getIndexOf(directedG.searchVertex(5))]
				[directedG.getIndexOf(directedG.searchVertex(2))] == 3.0);
		
	}
	
	@Test
	public void testRemoveVertex() {
		//Test 1
		setUpStage11();
		directedG.removeVertex(2);
		assertTrue(directedG.getVertices().size() == 3);
		assertTrue(directedG.getAdjMatrix().size() == 3);
		assertTrue(directedG.getWeightsMatrix().length == 3);
		assertTrue(directedG.getAdjMatrix().get(directedG.getIndexOf(directedG.searchVertex(1))).size() == 3);
		assertTrue(directedG.getNeighbors(directedG.searchVertex(1)).size() == 1);
		assertTrue(directedG.getNeighbors(directedG.searchVertex(1)).get(0).getValue() == 5);
		assertTrue(directedG.getNeighbors(directedG.searchVertex(5)).size() == 1);
		assertTrue(directedG.getNeighbors(directedG.searchVertex(5)).get(0).getValue() == 7);

		//Test 2
		setUpStage11();
		directedG.removeVertex(1);
		assertTrue(directedG.searchVertex(1)==null);
		
		//Test 3
		setUpStage11();
		directedG.removeVertex(5);
		assertTrue(directedG.getNeighbors(directedG.searchVertex(1)).size() == 1);
		assertTrue(directedG.getNeighbors(directedG.searchVertex(1)).get(0).getValue() == 2);
		assertTrue(directedG.getNeighbors(directedG.searchVertex(7)).size() == 0);
		
		//Test 4
		setUpStage5();
		simpleG.removeVertex(2);
		assertTrue(simpleG.getNeighbors(simpleG.searchVertex(1)).size() == 1);
		assertTrue(simpleG.getNeighbors(simpleG.searchVertex(1)).get(0).getValue() == 4);
		assertTrue(simpleG.getNeighbors(simpleG.searchVertex(3)).size() == 1);
		assertTrue(simpleG.getNeighbors(simpleG.searchVertex(3)).get(0).getValue() == 4);

	}
	
	@Test
	public void testRemoveEdge() {
		//Test 1
		setUpStage13();
		directedG.removeEdge(1, 2);
		assertTrue(directedG.getNeighbors(directedG.searchVertex(1)).size() == 2);
		assertTrue(directedG.getNeighbors(directedG.searchVertex(1)).get(1).getValue() == 5);
		assertTrue(directedG.getNeighbors(directedG.searchVertex(1)).get(0).getValue() == 1);
		
		//Test 2
		setUpStage13();
		directedG.removeEdge(5, 7);
		assertTrue(directedG.areAdjacent(directedG.searchVertex(7), directedG.searchVertex(5)));
		assertFalse(directedG.areAdjacent(directedG.searchVertex(5), directedG.searchVertex(7)));
		
		//Test 3
		setUpStage5();
		simpleG.removeEdge(1, 2);
		assertFalse(simpleG.areAdjacent(simpleG.searchVertex(1), simpleG.searchVertex(2)));
		assertFalse(simpleG.areAdjacent(simpleG.searchVertex(2), simpleG.searchVertex(1)));
		
		//Test 4
		setUpStage5();
		simpleG.removeEdge(3, 4);
		assertFalse(simpleG.areAdjacent(simpleG.searchVertex(3), simpleG.searchVertex(4)));
		assertFalse(simpleG.areAdjacent(simpleG.searchVertex(4), simpleG.searchVertex(3)));
	}
	
	@Test
	public void testSearchVertex() {
		Vertex<Integer> ver;
		
		//Test 1
		setUpStage5();
		ver= simpleG.searchVertex(1);
		assertTrue(ver.getValue()==1);
		assertTrue(simpleG.getNeighbors(ver).size() == 2);
		assertTrue(simpleG.areAdjacent(ver, simpleG.searchVertex(2)));
		assertTrue(simpleG.areAdjacent(ver, simpleG.searchVertex(4)));
		
		//Test 2
		ver= simpleG.searchVertex(5);
		assertTrue(ver==null);
		
		//Test 3
		setUpStage13();
		ver = directedG.searchVertex(2);
		assertTrue(ver.getValue()==2);
		assertTrue(directedG.getNeighbors(ver).size() == 0);
		
		//Test 4
		ver = directedG.searchVertex(1);
		assertTrue(ver.getValue()==1);
		assertTrue(directedG.getNeighbors(ver).size() == 3);
		assertTrue(directedG.areAdjacent(ver, directedG.searchVertex(1)));
		assertTrue(directedG.areAdjacent(ver, directedG.searchVertex(2)));
		assertTrue(directedG.areAdjacent(ver, directedG.searchVertex(5)));
		
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
		assertTrue(simpleG.searchVertex(3).getPred().getValue()==2);
		assertTrue(simpleG.searchVertex(4).getPred().getValue()==3);
		assertTrue(simpleG.searchVertex(5).getPred().getValue()==4);
		//Verify the TimeStamps
		assertTrue(simpleG.searchVertex(1).getD()==1 && simpleG.searchVertex(1).getF()==10);
		assertTrue(simpleG.searchVertex(2).getD()==2 && simpleG.searchVertex(2).getF()==9);
		assertTrue(simpleG.searchVertex(3).getD()==3 && simpleG.searchVertex(3).getF()==8);
		assertTrue(simpleG.searchVertex(4).getD()==4 && simpleG.searchVertex(4).getF()==7);
		assertTrue(simpleG.searchVertex(5).getD()==5 && simpleG.searchVertex(5).getF()==6);
	}


	@Test
	public void testDijkstra() {
		setUpStage9();
		//Test 1
		simpleSG.dijkstra(simpleSG.searchVertex("Dallas"));
		assertTrue(simpleSG.searchVertex("Boston").getD()==1500);
		
		//Test 2

		simpleSG.dijkstra(simpleSG.searchVertex("San Francisco"));
		assertTrue(simpleSG.searchVertex("Dallas").getD()==1500);
		
		//Test 3
		simpleSG.dijkstra(simpleSG.searchVertex("Chicago"));
		assertTrue(simpleSG.searchVertex("Los Angeles").getD()==1400);
		
		//Test 4
		setUpStage16();
		simpleG.dijkstra(simpleG.searchVertex(1));	
		assertTrue(simpleG.searchVertex(4).getD()==AdjListGraph.INF);
	}
	
	@Test
	public void testFloydWarshall() {
		double [][] matrix;
		
		//Test 1
		setUpStage17();
		matrix=directedG.floydwarshall();
		assertDiagMatrix(matrix);
		assertTrue(matrix[0][1]==-1);
		assertTrue(matrix[0][2]==-2);
		assertTrue(matrix[0][3]==0);
		assertTrue(matrix[1][0]==4);
		assertTrue(matrix[1][2]==2);
		assertTrue(matrix[1][3]==4);
		assertTrue(matrix[2][0]==5);
		assertTrue(matrix[2][1]==1);
		assertTrue(matrix[2][3]==2);
		assertTrue(matrix[3][0]==3);
		assertTrue(matrix[3][1]==-1);
		assertTrue(matrix[3][2]==1);
		
		//Test 2
		setUpStage18();
		matrix=directedG.floydwarshall();
		assertDiagMatrix(matrix);
		assertTrue(matrix[0][1]==5);
		assertTrue(matrix[0][2]==6);
		assertTrue(matrix[0][3]==8);
		assertTrue(matrix[1][0]==IGraph.INF);
		assertTrue(matrix[1][2]==1);
		assertTrue(matrix[1][3]==3);
		assertTrue(matrix[2][0]==IGraph.INF);
		assertTrue(matrix[2][1]==5);
		assertTrue(matrix[2][3]==2);
		assertTrue(matrix[3][0]==IGraph.INF);
		assertTrue(matrix[3][1]==3);
		assertTrue(matrix[3][2]==4);
		
		//Test 4
		setUpStage19();
		matrix=directedCG.floydwarshall();
		assertDiagMatrix(matrix);
		assertTrue(matrix[0][1]==32);
		assertTrue(matrix[0][2]==12);
		assertTrue(matrix[0][3]==44);
		assertTrue(matrix[0][4]==IGraph.INF);
		assertTrue(matrix[1][0]==10);
		assertTrue(matrix[1][2]==22);
		assertTrue(matrix[1][3]==54);
		assertTrue(matrix[1][4]==IGraph.INF);
		assertTrue(matrix[2][0]==30);
		assertTrue(matrix[2][1]==20);
		assertTrue(matrix[2][3]==32);
		assertTrue(matrix[2][4]==IGraph.INF);
		assertTrue(matrix[3][0]==IGraph.INF);
		assertTrue(matrix[3][1]==IGraph.INF);
		assertTrue(matrix[3][2]==IGraph.INF);
		assertTrue(matrix[3][4]==IGraph.INF);
		assertTrue(matrix[4][0]==7	);
		assertTrue(matrix[4][1]==39);
		assertTrue(matrix[4][2]==19);
		assertTrue(matrix[4][3]==51);
		
		//Test 5
		setUpStage20();
		matrix= simpleG.floydwarshall();
		assertDiagMatrix(matrix);
		assertTrue(matrix[0][1]==IGraph.INF);
		assertTrue(matrix[0][2]==IGraph.INF);
		assertTrue(matrix[1][0]==IGraph.INF);
		assertTrue(matrix[1][2]==IGraph.INF);
		assertTrue(matrix[2][0]==IGraph.INF);
		assertTrue(matrix[2][1]==IGraph.INF);
	}
	
	public void assertDiagMatrix(double[][] matrix) {
		for (int i=0; i<matrix.length; i++) {
			assertTrue(matrix[i][i]==0);
		}
	}

}
