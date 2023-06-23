package data_hw2;

import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	private HashMap<String, Vertex> vertices;
	private HashMap<String, Edge> edges;
	private ArrayList<String> path;
	private ArrayList<Integer> path_count;
	private static String path_way;
	private static String last_path_way;
	private static int path_weight;
	private static int last_path_weight;
	private static boolean flag;

	public Graph() {
		this.vertices = new HashMap<>();
		this.edges = new HashMap<>();
		path_way = "";
		this.path = new ArrayList<String>();
		this.path_count = new ArrayList<Integer>();
	}

	public void addEdge(String source, String destination) {

		if (edges.get(source + "-" + destination) == null && edges.get(destination + "-" + source) == null) {
			Vertex source_v, destination_v;

			if (vertices.get(source) == null) {
				source_v = new Vertex(source);
				vertices.put(source, source_v);
			} else
				source_v = vertices.get(source);

			if (vertices.get(destination) == null) {
				destination_v = new Vertex(destination);
				vertices.put(destination, destination_v);
			} else
				destination_v = vertices.get(destination);

			Edge edge = new Edge(source_v, destination_v);
			source_v.addEdge(edge);
			destination_v.addEdge(edge);
			edges.put(source + "-" + destination, edge);
		} 
		else {
			System.out.println("This edge has already added!");
		}
	}
	
	public void getShortestPath() {
		
		for (Vertex sour : vertices.values()) {
			
			for (Vertex dest : vertices.values()) {
				if (sour != dest) {
					last_path_weight = 9999;
					recursion(sour, dest);
					if (flag && !(path.contains(last_path_way))) {
						path.add(last_path_way);
						path_count.add(last_path_weight);
					}
					flag = false;
				}
			}
		}
	}
	
	public void recursion(Vertex sour, Vertex dest) {
		
		for (int j = 0; j < sour.getEdges().size(); j++) {
			
			if (sour.getEdges().get(j).getDestination() == dest || sour.getEdges().get(j).getSource() == dest) {
				path_weight++;
				path_way += sour.getName() + ",";
				if (path_weight < last_path_weight) {
					path_way += dest.getName();
					last_path_way = path_way;
					last_path_weight = path_weight;
					flag = true;
				}
				path_way = "";
				path_weight = 0;
				return;
			}
			else {
				if (sour.getName() != sour.getEdges().get(j).getDestination().getName()) {
					path_weight++;
					path_way += sour.getName() + ",";
					recursion(sour.getEdges().get(j).getDestination(), dest);
				}
			}
		}
		path_way = "";
		path_weight = 0;
		return;
	}
	
	public String getHighestBetweenness() {
		String[] splitted;
		String data = "";
		int count = 0;
		int last_count = 0;
		for (Vertex v : vertices.values()) {
			
			for (int i = 0; i < path.size(); i++) {
				splitted = path.get(i).split(",");
				
				for (int j = 0; j < splitted.length; j++) {
					if (v.getName().equals(splitted[j]))
						count++;
				}
			}
			if (count > last_count) {
				last_count = count;
				data = "Vertes is " + v.getName() + ", frequency is " + String.valueOf(last_count);
			}
			count = 0;
		}
		return data;
	}
	
	public String getHighestCloseness() {
		String[] splitted;
		int count = 0;
		int last_count = 9999;
		String data = "";
		double avg = 0.0;
		for (Vertex v : vertices.values()) {
			
			for (int i = 0; i < path.size(); i++) {
				splitted = path.get(i).split(",");
				if (v.getName().equals(splitted[0])) {
					count += path_count.get(i);
				}
			}
			if (count > 0 && count < last_count) {
				last_count = count;
				avg = 1 / last_count;
				data = "Vertex is " + v.getName() + ", average is " + String.format("%f", avg);
			}
			count = 0;
		}
		return data;
	}

	public void print() {
		/*System.out.println("Source\tDestination");
		for (Edge e : edges.values()) {
			System.out.println("" + e.getSource().getName() + "\t" + e.getDestination().getName() + "\t");
		}
		System.out.println("Source\tDestination");
		for (Vertex e : vertices.values()) {
			System.out.println("" + e.getName() + "\t");
		}
		System.out.println("Source\tDestination");
		for (int i = 0 ; i < path.size() ; i++) {
			System.out.println("" + path.get(i) + "\t" + path_count.get(i));
		}*/
		System.out.println(getHighestBetweenness());
		System.out.println(getHighestCloseness());
	}

	public Iterable<Vertex> vertices() {
		return vertices.values();
	}

	public Iterable<Edge> edges() {
		return edges.values();
	}

	public int size() {
		return vertices.size();
	}

	public ArrayList<String> getPath() {
		return path;
	}

	public void setPath(ArrayList<String> path) {
		this.path = path;
	}

}
