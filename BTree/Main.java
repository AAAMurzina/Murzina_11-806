import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        FileWriter fileWriter_i = new FileWriter("results_insertion.txt");
        FileWriter fileWriter_r = new FileWriter("results_removals.txt");
        FileWriter fileWriter_s = new FileWriter("results_searches.txt");
        int trials = 50;

        for (int i = 0; i < 300; i++) {

            System.out.println(i);
            long insertionTime = 0;
            long deletionTime = 0;
            long searchesTime = 0;

            ArrayList<Integer> data = random.ints(i * 100, 0, 50000)
                    .boxed().collect(Collectors.toCollection(ArrayList::new));

            for (int j = 0; j < trials; j++) {
                BTree<Integer> bTree = new BTree<>(5);

                long insertionStart = System.nanoTime();
                bTree.insert(data);
                long insertionFinish = System.nanoTime();
                insertionTime += (insertionFinish - insertionStart);

                long searchesStart = System.nanoTime();
                for(int k = 0; k < i * 200; k++) {
                    int randomNumber = data.get(random.nextInt(i * 100));
                    bTree.contains(null, randomNumber);
                }
                long serachesFinish = System.nanoTime();
                searchesTime += serachesFinish - searchesStart;

            }
            fileWriter_i.write(i * 100 + " " + insertionTime / trials / 1000 + "\n");
            fileWriter_s.write(i * 100 + " " + searchesTime / trials / 1000 + "\n");
            //fileWriter_i.write(i * 100 + " " + insertionTime / trials + "\n");

            fileWriter_i.flush();
            fileWriter_s.flush();
        }
        fileWriter_i.close();
        fileWriter_s.close();
    }
}