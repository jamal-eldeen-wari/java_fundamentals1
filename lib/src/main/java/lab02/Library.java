/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lab02;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Library {
    public boolean someLibraryMethod() {
        return true;
    }

    public static void main(String[] args) throws Exception {
        int[] values = new int[]{2, 5, 3, 4, 6, 1, 10};
        int[][] weeklyMonthTemperatures = {
                {66, 64, 58, 65, 71, 57, 60},
                {57, 65, 65, 70, 72, 65, 51},
                {55, 54, 60, 53, 59, 57, 61},
                {65, 56, 55, 52, 55, 62, 57}
        };
        List<String> votes = new ArrayList<>();
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Shrub");
        votes.add("Hedge");
        votes.add("Shrub");
        votes.add("Bush");
        votes.add("Hedge");
        votes.add("Bush");

        String winner = tally(votes);
        System.out.println(winner + " received the most votes!");

        System.out.println(Arrays.toString(roll(5)));
        System.out.println(containsDuplicates(values));
        System.out.println(calculateAvg(values));
        System.out.println(Arrays.toString(arrayOfArrays(weeklyMonthTemperatures)));
        tempMethod(weeklyMonthTemperatures);
        Linter linter = new Linter();
        Path path = Paths.get("C:\\Users\\jamal\\Downloads\\gates.js");
//        System.out.println(linter.linterMethod(path.toString()));
    }

    public static int[] roll(int n) {
        int min = 1;
        int max = 6;
        int[] rolls = new int[n];
        for (int i = 0; i < n; i++) {
            rolls[i] = (int) Math.floor(Math.random() * (max - min + 1) + min);

        }

        return rolls;
    }

    public static boolean containsDuplicates(int[] elements) {
        int a;
        for (int i = 0; i < elements.length; i++) {
            a = elements[i];
            for (int j = i + 1; j < elements.length; j++) {

                if (elements[j] == a) {
                    return true;
                }
            }
        }

        return false;
    }

    public static double calculateAvg(int[] values) {
        double avg = 0.0;
        double sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum = sum + values[i];
        }
        avg = sum / values.length;
        return avg;
    }

    public static int[] arrayOfArrays(int[][] twoD) {
        double[] avgArr = new double[twoD.length];
        for (int i = 0; i < twoD.length; i++) {
            int sum = 0;
            int arrLength = twoD[i].length;
            for (int j = 0; j < arrLength; j++) {
                sum = sum + twoD[i][j];
            }
            avgArr[i] = (double) sum / arrLength;

        }
        double comp = avgArr[0];
        for (double avg : avgArr) {
            if (comp >= avg) {
                comp = avg;
            }
        }

        int index = 0;
        for (int k = 0; k < avgArr.length; k++) {
            if (comp == avgArr[k]) {
                index = k;
            }
        }
        return twoD[index];
    }

    public static void tempMethod(int[][] twoDArr) {
        int max = twoDArr[0][0];
        int min = twoDArr[0][0];
        HashSet<Integer> hashSet = new HashSet<>();

//        FOR MAXIMUM VALUE
        for (int i = 0; i < twoDArr.length; i++) {
            for (int j = 0; j < twoDArr[i].length; j++) {
                if (twoDArr[i][j] >= max) {
                    max = twoDArr[i][j];
//                    System.out.println("High:"+max);
                }

            }
        }
        System.out.println("High:" + max);
//        FOR MINIMUM VALUE
        for (int k = 0; k < twoDArr.length; k++) {
            for (int h = 0; h < twoDArr[k].length; h++) {
                hashSet.add(twoDArr[k][h]);
                if (twoDArr[k][h] <= min) {
                    min = twoDArr[k][h];
                }
            }
        }
        System.out.println("Low: " + min);

//        for (int m = 0; m< twoDArr.length; m++){
//            for (int n = 0; n< twoDArr[m].length; n++){
//                hashSet.add(twoDArr[m][n]);
//            }
//        }

        for (int w = min; w < max; w++) {
            if (!hashSet.contains(w)) {
                System.out.println("Never saw temperature " + w);
            }
        }


    }

    public static String tally(List<String> votes) {
        Map<String, Integer> voteCounter = new HashMap<>();
        for (String name : votes) {
            if (voteCounter.containsKey(name)) {
                voteCounter.put(name, voteCounter.get(name)+1);
            } else {
               voteCounter.put(name, 1);
            }
        }
        String highVotes = null;
//
        for (Map.Entry< String, Integer > e : voteCounter.entrySet()) {

            if (Objects.equals(e.getValue(), Collections.max(voteCounter.values()))) {

                highVotes = e.getKey();
            }
        }

        return highVotes;

    }
}