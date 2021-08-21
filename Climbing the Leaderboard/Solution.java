package climbingTheLeaderboard;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here
    ArrayList<Integer> leaderBoard = (ArrayList<Integer>)ranked;
    ArrayList<Integer> playerScores = (ArrayList<Integer>)player;
    ArrayList<Integer> ranks = new ArrayList<>();
    HashMap<Integer, Integer> rankings = new HashMap<>();
    int rank =1;
    for(int i=0; i<leaderBoard.size(); i++){
            if(!rankings.containsKey(leaderBoard.get(i))){
                rankings.put(leaderBoard.get(i),rank++);
            }
        }
        int initial = leaderBoard.size()-1;
        for(int score : playerScores){
            for(int i=initial; i>=0; i--){
                if(score >= leaderBoard.get(i)){
                    rank = rankings.get(leaderBoard.get(i));
                    initial = i-1;
                }
                else{
                    break;
                }
            }
            ranks.add(rank);
        }
        return ranks;
    }
    

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

