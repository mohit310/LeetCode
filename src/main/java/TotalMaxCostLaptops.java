import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;


class TotalMaxCostLaptops {
    public static int maxCost(List<Integer> cost, List<String> labels, int dailyCount) {
        int totalCost = 0;
        int legalCount = 0;
        for (int i = 0; i < cost.size(); i++) {
            if (labels.get(i).equals("legal") && legalCount < dailyCount) {
                totalCost = totalCost + cost.get(i);
                legalCount++;
            }
        }
        return totalCost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int costCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> cost = IntStream.range(0, costCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int labelsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> labels = IntStream.range(0, labelsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int dailyCount = Integer.parseInt(bufferedReader.readLine().trim());

        int result = TotalMaxCostLaptops.maxCost(cost, labels, dailyCount);

        bufferedReader.close();

    }

}