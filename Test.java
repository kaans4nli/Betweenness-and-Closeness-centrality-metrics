package data_hw2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		
		Graph graph = new Graph();
		
		String row;		
		String[] splitted;
		File file = new File("src/karate_club_network.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		while ((row = br.readLine()) != null) {
			splitted = row.split(" ");
			graph.addEdge(splitted[0], splitted[1]);
		}
		br.close();
		
		System.out.println("");
		System.out.println(file.getName());
		graph.getShortestPath();
		graph.print();
		
		/*Graph graph2 = new Graph();
		file = new File("src/facebook_social_network.txt");
		BufferedReader br2 = new BufferedReader(new FileReader(file));
		while ((row = br2.readLine()) != null) {
			splitted = row.split(" ");
			graph2.addEdge(splitted[0], splitted[1]);
		}
		br2.close();
		
		System.out.println("-------");
		System.out.println(file.getName());
		graph2.getShortestPath();
		graph2.print();*/
		
		
		
		
				
	}

}
