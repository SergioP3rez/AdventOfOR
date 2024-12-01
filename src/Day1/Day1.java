package Day1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Day1 {

    public static void main(String[] args) {
        InstanceDay1 instance = new InstanceDay1("/Users/sergio/IdeaProjects/AdventOfOR/instances/day1/instance.txt");
        System.out.println(instance.getName());
        minimumColors(instance);
    }

    static void minimumColors(InstanceDay1 instance) {
        int N = instance.getN();
        int[] count = new int[N];
        int[] colors = new int[N];
        Arrays.fill(colors, 1);
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            if (count[i] == 0) {
                Q.add(i);
            }
        }

        while (!Q.isEmpty()) {
            int u = Q.peek();
            Q.remove();
            for (int x : instance.getAdjacents(u)) {
                count[x]--;
                if (count[x] == 0) {
                    Q.add(x);
                }
                if (colors[x] <= colors[u]) {
                    colors[x] = 1 + colors[u];
                }
            }
        }

        int minColor = -1;

        for (int i = 0; i < N; i++) {
            minColor = Math.max(minColor, colors[i]);
        }

        System.out.print(minColor + "\n");
    }
}
