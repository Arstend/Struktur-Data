import java.util.*;

public class tugas3_contoh {
	/*
	 * Buatlah program pencarian menggunakan algoritma Depth-First Search (DFS) dalam bahasa Java.
	 * - Gunakan graf dengan 7 node yang mewakili a1, a2, a3, a4, a5, a6, a7 (tentukan sendiri nilai hubungan antar node).
	 * - Lakukan pencarian angka n pada graf tersebut dengan DFS.
	 * - Jelaskan tahap demi tahap proses pencarian dan gambarkan dengan rinci prosesnya.
	 */

	/* static Map<String, List<String>> graph = new HashMap<>();
	static Map<String, Integer> nodeValue = new HashMap<>();
	static Set<String> visited = new HashSet<>();

	public static void main(String[] args){
		// Membangun node
		graph.put("a1", Arrays.asList("a2", "a3"));
		graph.put("a2", Arrays.asList("a1", "a4", "a5"));
		graph.put("a3", Arrays.asList("a1", "a6", "a7"));
		graph.put("a4", Arrays.asList("a2"));
		graph.put("a5", Arrays.asList("a2"));
		graph.put("a6", Arrays.asList("a3"));
		graph.put("a7", Arrays.asList("a3"));

		// Memberikan nilai pada tiap node
		nodeValue.put("a1", 14);
		nodeValue.put("a2", 10);
		nodeValue.put("a3", 8);
		nodeValue.put("a4", 2);
		nodeValue.put("a5", 12);
		nodeValue.put("a6", 4);
		nodeValue.put("a7", 6);

		// Set target number
		int targetNumber = 12; // Default 12

		// Print mencari value
		System.out.println("Searching value " + targetNumber + " with Depth-First Search (DFS)\n");

		boolean result = dfSearch("a1", targetNumber);
		
		// Cek apakah ada return true atau false
		if(result){ // Jika return true
			System.out.print("Value " + targetNumber + " has found!");
		}else{ // Jika return false atau NULL
			System.out.print("Value " + targetNumber + " not found!");
		}
	}

	// Fungsi utama DFS
	public static boolean dfSearch(String current, int targetNumber){
		System.out.println("Visiting node " + current + " with value " + nodeValue.get(current));
		// Menambahkan node yang telah dikunjungi ke variabel visited
		visited.add(current);

		// Cek apakah value pada node sama dengan target
		if(nodeValue.get(current) == targetNumber){
			return true;
		}

		for(String neighbor : graph.get(current)){
			// Cek apakah daftar node yang sudah dikunjungi terdapat tetangga atau tidak
			if(!visited.contains(neighbor)){
				if(dfSearch(neighbor, targetNumber)){
					return true;
				}
			}
		}

		return false;
	} */

	/*
	 * Buatlah program pencarian menggunakan algoritma Breadth-First Search (BFS) dalam bahasa Java.
	 * - Gunakan graf dengan 7 node yang mewakili a1, a2, a3, a4, a5, a6, a7 (tentukan sendiri nilai hubungan antar node).
	 * - Lakukan pencarian angka n pada graf tersebut dengan BFS.
	 * - Jelaskan tahap demi tahap proses pencarian dan gambarkan dengan rinci prosesnya.
	 */

	static Map<String, List<String>> graph = new HashMap<>();
	static Map<String, Integer> nodeValue = new HashMap<>();
	static Set<String> visited = new HashSet<>();

	public static void main(String[] args){
		// Membangun node
		graph.put("a1", Arrays.asList("a2", "a3"));
		graph.put("a2", Arrays.asList("a1", "a4", "a5"));
		graph.put("a3", Arrays.asList("a1", "a6", "a7"));
		graph.put("a4", Arrays.asList("a2"));
		graph.put("a5", Arrays.asList("a2"));
		graph.put("a6", Arrays.asList("a3"));
		graph.put("a7", Arrays.asList("a3"));

		// Memberikan nilai pada tiap node
		nodeValue.put("a1", 14);
		nodeValue.put("a2", 10);
		nodeValue.put("a3", 8);
		nodeValue.put("a4", 2);
		nodeValue.put("a5", 4);
		nodeValue.put("a6", 12);
		nodeValue.put("a7", 6);

		// Set target number
		int targetNumber = 12; // Default 12

		// Print mencari value
		System.out.println("Searching value " + targetNumber + " with Breadth-First Search (DFS)\n");

		boolean result = bfSearch("a1", targetNumber);

		// Cek apakah ada return true atau false
		if(result){ // Jika return true
			System.out.print("Value " + targetNumber + " has found!");
		}else{ // Jika return false atau NULL
			System.out.print("Value " + targetNumber + " not found!");
		}
	}

	// Fungsi utama BFS
	public static boolean bfSearch(String start, int targetNumber){
		Queue<String> queue = new LinkedList<>();
		// Membersihan daftar node yang sudah dikunjungi
		visited.clear();
		// Menambahan ke antrian
		queue.add(start);
		// Menambahkan node yang telah dikunjungi ke variabel visited
		visited.add(start);

		// Ketika antrian kosong
		while(!queue.isEmpty()){
			String current = queue.poll();
			int currentValue = nodeValue.get(current);
			System.out.println("Visiting node " + current + " with value " + currentValue);

			// Cek apakah value pada node sama dengan target
			if(currentValue == targetNumber){
				return true;
			}

			for(String neighbor : graph.get(current)){
				// Cek apakah daftar node yang sudah dikunjungi terdapat tetangga atau tidak
				if(!visited.contains(neighbor)){
					// Menambahan ke antrian
					queue.add(neighbor);
					// Menambahkan node yang telah dikunjungi ke variabel visited
					visited.add(neighbor);
				}
			}
		}

		return false;
	}
}