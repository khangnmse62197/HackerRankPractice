package main.java.com.basic.ClimbingTheLeaderboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Solution {

  /**
   * An arcade game player wants to climb to the top of the leaderboard and track their ranking. The game uses Dense Ranking, so its leaderboard works like this:
   *
   * The player with the highest score is ranked number  on the leaderboard.
   * Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately following ranking number.
   * @param ranked example list ranked = [100, 90, 90, 80]
   * @param player player = [70,80,105]
   * @return [4, 3, 1]
   */
  public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

    List<Integer> rs = new ArrayList<>();
    ranked = ranked.stream().sorted(Comparator.reverseOrder()).distinct().collect(Collectors.toList());
    Integer[] arraySorted = ranked.stream().sorted(Comparator.reverseOrder()).distinct()
        .collect(Collectors.toList()).toArray(new Integer[ranked.size()]);
    Map<Integer,Integer> pointRank =new HashMap<>();


    Task task1 = new Task(arraySorted,pointRank,player.subList(0, player.size() / 2));
    Task task2 = new Task(arraySorted,pointRank,player.subList(player.size() / 2,  player.size()));

    ExecutorService executor = Executors.newFixedThreadPool(2);

    Future<List<Integer>> rsTask1 = executor.submit(task1);
    Future<List<Integer>> rsTask2 = executor.submit(task2);

    try {
      rs.addAll(rsTask1.get());
      rs.addAll(rsTask2.get());
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    } finally {
      executor.shutdown();

    }


    return rs;
//    List<Integer> rs = new ArrayList<>();
//    ranked = ranked.stream().sorted(Comparator.reverseOrder()).distinct().collect(Collectors.toList());
//    Map<Integer,Integer> pointRank =new HashMap<>();
//
//    for (Integer interger : player
//    ) {
//      if (pointRank.containsKey(interger)){
//        rs.add(pointRank.get(interger));
//        continue;
//
//      }
//
//      if (interger >= ranked.get(0)) {
//        rs.add(1);
//        pointRank.put(interger,1);
//        continue;
//      }
//
//      if (ranked.contains(interger)) {
//        int tmp = ranked.indexOf(interger) + 1;
//        rs.add(tmp);
//        pointRank.put(interger,tmp);
//        continue;
//      }
//      int counter = interger;
//
//      while (true){
//          counter++;
//          if (ranked.contains(counter)){
//            int tmp = ranked.indexOf(counter) + 2;
//            rs.add(tmp);
//            pointRank.put(interger,tmp);
//            break;
//          }
//        }
//
//    }
//
//    return rs;

//    Set<Integer> hs = new TreeSet<>(Comparator.reverseOrder());
//    hs.addAll(ranked);
//
//    List<Integer> rs = new ArrayList<>();
//
//    for (Integer integer : player) {
//      Set<Integer> hs2 = new TreeSet<>(Comparator.reverseOrder());
//      hs2.addAll(hs);
//      if (!hs2.contains(integer)) {
//        hs2.add(integer);
//
//      }
//
//      List<Integer> tmp = new ArrayList<>(hs2);
//      rs.add(tmp.indexOf(integer) + 1);
//    }
//    return rs;

  }

  static class Task implements Callable<List<Integer>> {
    final Integer[] ranked;
    Map<Integer,Integer> pointRank;
    final List<Integer> player;

    public Task(Integer[] ranked, Map<Integer, Integer> pointRank, List<Integer> player) {
      this.ranked = ranked;
      this.pointRank = pointRank;
      this.player = player;
    }

    @Override
    public List<Integer> call() {
      List<Integer> rs = new ArrayList<>();
      for (Integer integer : player
      ) {

        if (pointRank.containsKey(integer)){
          rs.add(pointRank.get(integer));
          continue;
        }

        if (integer >= ranked[0]) {
          rs.add(1);
          pointRank.put(integer,1);
          continue;
        }
//        if (ranked.contains(integer)) {
        if (Arrays.asList(ranked).contains(integer)) {
          int tmp =  Arrays.binarySearch(ranked, integer, Comparator.reverseOrder()) + 1;
//          int tmp = ranked.indexOf(integer) + 1;
          rs.add(tmp);
          pointRank.put(integer,tmp);
          continue;
        }
        AtomicInteger counter = new AtomicInteger(integer);

        while (true){
          counter.incrementAndGet();
//          if (ranked.contains(counter)){
          if ( Arrays.stream(ranked).anyMatch(x-> x == counter.get())){
            int tmp = Arrays.binarySearch(ranked, counter.get(), Comparator.reverseOrder()) + 2;

//            int tmp = ranked.indexOf(counter) + 2;
            rs.add(tmp);
            pointRank.put(integer,tmp);
            break;
          }
        }

      }
      return rs;
    }
  }

  public static void main(String[] args) {
//    System.out.println(climbingLeaderboard(new ArrayList<>(
//        Arrays.asList(100,100,50,40,40,20,10)
//    ), new ArrayList<>(
//        Arrays.asList(5,25,50,120) )));

//    List<Integer> intList = new ArrayList<>(
//        Arrays.asList(295,294,291,287,287,285,285,284,283,279,277,274,274,271,270,268,268,268,264,260
//            ,259,258,257,255,252,250,244,241,240,237,236,236,231,227,227,227,226,225,224,223,216
//            ,212,200,197,196,194,193,189,188,187,183,182,178,177,173,171,169,165,143,140,137,135,133
//            ,130,130,130,128,127,122,120,116,114,113,109,106,103,99,92,85,81,69,68,63,63,63,61,57,51,47,46,38,30,28,25,22,15,14,12,6,4)
//    );


//    Map<Integer, List<Integer>> groups =
//        intList.stream().collect(Collectors.groupingBy(s -> (s - 1) / 3));
//    List<List<Integer>> subSets = new ArrayList<List<Integer>>(groups.values());
//    System.out.println("a");

    System.out.println(climbingLeaderboard(new ArrayList<>(
        Arrays.asList(295,294,291,287,287,285,285,284,283,279,277,274,274,271,270,268,268,268,264,260
            ,259,258,257,255,252,250,244,241,240,237,236,236,231,227,227,227,226,225,224,223,216
            ,212,200,197,196,194,193,189,188,187,183,182,178,177,173,171,169,165,143,140,137,135,133
            ,130,130,130,128,127,122,120,116,114,113,109,106,103,99,92,85,81,69,68,63,63,63,61,57,51,47,46,38,30,28,25,22,15,14,12,6,4)
    ), new ArrayList<>(
        Arrays.asList(5,5,6,14,19,20,23,25,29,29,30,30,32,37,38,38,38,41,41,44,45,45,47,59,59,62,63,65,67,69,70,72,72,76,79,82,83,90,91,92,93,98,98,100,100,102,103,105,106,107,109,112,115,118,118,121,122,122,123,125,125,125,127,128,131,131,133,134,139,140,141,143,144,144,144,144,147,150,152,155,156,160,164,164,165,165,166,168,169,170,171,172,173,174,174,180,184,187,187,188,194,197,197,197,198,201,202,202,207,208,211,212,212,214,217,219,219,220,220,223,225,227,228,229,229,233,235,235,236,242,242,245,246,252,253,253,257,257,260,261,266,266,268,269,271,271,275,276,281,282,283,284,285,287,289,289,295,296,298,300,300,301,304,306,308,309,310,316,318,318,324,326,329,329,329,330,330,332,337,337,341,341,349,351,351,354,356,357,366,369,377,379,380,382,391,391,394,396,396,400) )));
  }
}
