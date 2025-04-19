package com.app.dsa.part2.graph.dij;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	public boolean visited;
	public List<Edge> adjList = new ArrayList<>();
	public int disFromSrc= Integer.MAX_VALUE;
	public int key;
	public boolean ap;
	public int dis;
	public int low;


	public Vertex(int key) {
		this.key = key;
	}
}
