package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import model.*;

class TestAdjMatrixGraph {

	private AdjMatrixGraph<Integer> directedG;
	private AdjMatrixGraph<Integer> simpleG;
	private AdjMatrixGraph<String> simpleSG;
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
		// EXAMPLE OF "Matem�tica discreta y sus aplicaciones"
		simpleSG = new AdjMatrixGraph<>(false, true);
		simpleSG.addVertex("Boston");
		simpleSG.addVertex("Nueva York");
		simpleSG.addVertex("Chicago");
		simpleSG.addVertex("Dallas");
		simpleSG.addVertex("Denver");
		simpleSG.addVertex("San Francisco");
		simpleSG.addVertex("Los Angeles");
		// Edges
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

}
