import java.util.List;
import java.util.ArrayList;

public class Queens {
  public int backtrack(int c, List<Integer> board, List<Integer> potential) {
    if (c == board.size()) {
      int moves = 0;

      for (int i = 0; i < potential.size(); i++) {
        if (!potential.get(i).equals(board.get(i))) {
          moves++;
        }
      }

      return moves;
    }
    int minMoves = Integer.MAX_VALUE;
    for (int row = 1; row <= board.size(); row++) {
      boolean safe = true;
      for (int i = 0; i < potential.size(); i++) {
        if (row == potential.get(i) || Math.abs(potential.get(i) - row) == Math.abs(i - c))
          safe = false;
      }
      if (safe) {
        potential.add(row);
        minMoves = Math.min(minMoves, backtrack(c + 1, board, potential));
        potential.remove(potential.size() - 1);
      }
    }

    return minMoves;
  }

  public void main() {
    System.out.println(backtrack(0, List.of(1, 2, 3, 4, 5, 6, 7, 8), new ArrayList<>()));
    System.out.println(backtrack(0, List.of(1, 1, 1, 1, 1, 1, 1, 1), new ArrayList<>()));
    System.out.println(backtrack(0, List.of(1, 5, 8, 6, 3, 7, 2, 4), new ArrayList<>()));
    System.out.println(backtrack(0, List.of(4, 2, 7, 3, 6, 8, 5, 1), new ArrayList<>()));
    System.out.println(backtrack(0, List.of(8, 7, 6, 5, 4, 3, 2, 1), new ArrayList<>()));
    System.out.println(backtrack(0, List.of(8, 8, 8, 8, 8, 8, 8, 8), new ArrayList<>()));
    System.out.println(backtrack(0, List.of(2, 5, 8, 6, 3, 7, 2, 4), new ArrayList<>()));
    System.out.println(backtrack(0, List.of(1, 5, 8, 6, 3, 7, 2, 5), new ArrayList<>()));
  }
}
