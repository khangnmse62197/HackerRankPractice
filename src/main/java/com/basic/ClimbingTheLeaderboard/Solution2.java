package main.java.com.basic.ClimbingTheLeaderboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution2 {

  /**
   * An arcade game player wants to climb to the top of the leaderboard and track their ranking. The game uses Dense Ranking, so its leaderboard works like this:
   *
   * The player with the highest score is ranked number  on the leaderboard.
   * Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately following ranking number.
   * @param ranked example list ranked = [100, 90, 90, 80]
   * @param players player = [70,80,105]
   * @return [4, 3, 1]
   */
  public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> players) {
    List<Integer> rs = new ArrayList<>();
    ranked = ranked.stream().distinct().collect(Collectors.toList());
    int indexRank = ranked.size() - 1;
    Map<Integer,Integer> mapMaintain = new HashMap<>();

    for (Integer player: players) {
      if (mapMaintain.containsKey(player)){
        rs.add(mapMaintain.get(player));
        continue;
      }

      if (player < ranked.get(ranked.size() - 1)) {
        rs.add(ranked.size() + 1);
        mapMaintain.put(player,ranked.size() + 1);
        continue;
      }
      if (player >= ranked.get(0) || indexRank < 0) {
        rs.add(1);
        mapMaintain.put(player,1);
        continue;
      }
      if (player.equals(ranked.get(indexRank))){
        rs.add(indexRank + 1);
        mapMaintain.put(player, indexRank + 1);
        indexRank--;
        continue;

      }
      if (player > ranked.get(indexRank)) {
//        indexRank--;
        for (int i = indexRank ; i > 0; i--) {
          if (player.equals(ranked.get(i))){
            rs.add(i + 1);
            mapMaintain.put(player, i + 1);
            indexRank = i;
            break;
          }
          if (player > ranked.get(i) && player < ranked.get(i -1)){
            rs.add(i  + 1);
            mapMaintain.put(player, i + 1);
            indexRank = i;
            break;
          }
        }
      }

    }
    return rs;

  }

//  public static void main(String[] args) {
//
//    System.out.println(climbingLeaderboard(new ArrayList<>(
//        Arrays.asList(295,294,291,287,287,285,285,284,283,279,277,274,274,271,270,268,268,268,264,260
//            ,259,258,257,255,252,250,244,241,240,237,236,236,231,227,227,227,226,225,224,223,216
//            ,212,200,197,196,194,193,189,188,187,183,182,178,177,173,171,169,165,143,140,137,135,133
//            ,130,130,130,128,127,122,120,116,114,113,109,106,103,99,92,85,81,69,68,63,63,63,61,57,51,47,46,38,30,28,25,22,15,14,12,6,4)
//    ), new ArrayList<>(
//        Arrays.asList(5,5,6,14,19,20,23,25,29,29,30,30,32,37,38,38,38,41,41,44,45,45,47,59,59,62,63,65,67,69,70,72,72,76,79,82,83,90,91,92,93,98,98,100,100,102,103,105,106,107,109,112,115,118,118,121,122,122,123,125,125,125,127,128,131,131,133,134,139,140,141,143,144,144,144,144,147,150,152,155,156,160,164,164,165,165,166,168,169,170,171,172,173,174,174,180,184,187,187,188,194,197,197,197,198,201,202,202,207,208,211,212,212,214,217,219,219,220,220,223,225,227,228,229,229,233,235,235,236,242,242,245,246,252,253,253,257,257,260,261,266,266,268,269,271,271,275,276,281,282,283,284,285,287,289,289,295,296,298,300,300,301,304,306,308,309,310,316,318,318,324,326,329,329,329,330,330,332,337,337,341,341,349,351,351,354,356,357,366,369,377,379,380,382,391,391,394,396,396,400) )));
//
//
//  }
//public static void main(String[] args) {
//  System.out.println(climbingLeaderboard(new ArrayList<>(Arrays.asList(100,90,90,80,75,60)),
//      new ArrayList<>(Arrays.asList(50,65,77,90,102))));
//}

  public static void main(String[] args) {
    System.out.println(climbingLeaderboard(new ArrayList<>(Arrays.asList(997,988,981,966,957,937,933,930,929,928,927,926,922,920,916,915,903,896,887,874,872,866,863,863,860,859,858,857,857,847,847,842,830,819,815,809,803,797,796,794,794,789,785,783,778,772,765,765,764,757,755,751,744,740,737,733,730,730,724,716,710,709,691,690,684,677,676,653,652,650,625,620,619,602,587,587,585,583,571,568,568,556,552,546,541,540,538,531,530,529,527,506,504,501,498,493,493,492,489,482,475,468,457,452,445,442,441,438,435,435,433,430,429,427,422,422,414,408,404,400,396,394,387,384,380,379,374,371,369,369,369,368,366,365,363,354,351,341,337,336,328,325,318,316,314,307,306,302,287,282,281,277,276,271,246,238,236,230,229,229,228,227,220,212,199,194,179,173,171,168,150,144,136,125,125,124,122,118,98,98,95,92,88,85,70,68,61,60,59,44,43,35,32,30,28,23,20,13,12,12
        )),
        new ArrayList<>(Arrays.asList(83,129,140,184,198,300,312,325,341,344,349,356,370,405,423,444,465,471,491,500,506,508,539,543,569,591,607,612,614,623,645,670,689,726,744,747,764,773,777,787,805,811,819,829,841,905,918,918,955,997))));
  }

}
