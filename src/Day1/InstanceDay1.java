package Day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InstanceDay1 {
    private final String name;
    private Set<Integer>[] graph;

    public InstanceDay1(String name) {
        this.name = name;
        readInstance(name);
    }

    public void readInstance(String name) {
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(name));
            List<String> lines = buffer.lines().toList();
            String instanceInfo = lines.getFirst();
            String[] instanceParts = instanceInfo.split(" ");
            int n = Integer.parseInt(instanceParts[0]);
            int m = Integer.parseInt(instanceParts[1]);
            this.graph = new Set[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new HashSet<>();
            }
            for (int i = 1; i < m; i++) {
                String line = lines.get(i);
                String[] tokens = line.split(" ");
                int u = Integer.parseInt(tokens[1]) - 1;
                int v = Integer.parseInt(tokens[2]) - 1;
                graph[u].add(v);
                graph[v].add(u);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public Set<Integer> getAdjacents(int u) {
        return this.graph[u];
    }

    public int getN() {
        return this.graph.length;
    }

    public String getName() {
        return this.name;
    }
}
