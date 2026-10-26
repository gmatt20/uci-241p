import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
  private static void swap(char[] arr, int x, int y) {
    char temp = arr[y];
    arr[y] = arr[x];
    arr[x] = temp;
  }

  private static void quickSort(char[] charArr, int itemLeft, int itemRight) {
    if (itemLeft >= itemRight) {
      return;
    }

    int left = itemLeft;
    int right = itemRight;
    int pivot = itemLeft + (itemRight - itemLeft) / 2;

    swap(charArr, pivot, itemRight);
    pivot = itemRight;
    itemRight--;

    while (itemLeft <= itemRight) {
      if (charArr[itemLeft] > charArr[pivot] && charArr[itemRight] < charArr[pivot]) {
        swap(charArr, itemLeft, itemRight);
        itemLeft++;
        itemRight--;
      } else if (charArr[itemLeft] <= charArr[pivot]) {
        itemLeft++;
      } else if (charArr[itemRight] >= charArr[pivot]) {
        itemRight--;
      }
    }
    swap(charArr, itemLeft, pivot);

    // Recurse over right side
    quickSort(charArr, itemLeft + 1, right);
    // Recurse over left side
    quickSort(charArr, left, itemLeft - 1);
  }

  private static void radixSort(char[] charArr, int div, List<LinkedList<Character>> buckets) {
    for (int i = 0; i < charArr.length; i++) {
      int index = (charArr[i] / div) % 10;
      buckets.get(index).add(charArr[i]);
    }

    int pos = 0;

    for (int i = 0; i < buckets.size(); i++) {
      for (char c : buckets.get(i)) {
        charArr[pos] = c;
        pos++;
      }
      buckets.get(i).clear();
    }
  }

  public static String quickSort(String str) {
    char[] charArr = str.toCharArray();

    quickSort(charArr, 0, charArr.length - 1);

    return new String(charArr);
  }

  public static String radixSort(String str) {
    char[] charArr = str.toCharArray();
    List<LinkedList<Character>> buckets = new ArrayList<>(10);

    for (int i = 0; i < 10; i++) {
      buckets.add(new LinkedList<>());
    }

    for (int i = 1; i <= 100; i *= 10) {
      radixSort(charArr, i, buckets);
    }

    return new String(charArr);
  }

  public static List<List<String>> groupAnagram(List<String> strings) {
    HashMap<String, List<String>> groups = new HashMap<>();

    for (int i = 0; i < strings.size(); i++) {
      String og = strings.get(i);
      // String sorted = quickSort(og);
      String sorted = radixSort(og);
      if (groups.containsKey(sorted)) {
        groups.get(sorted).add(og);
      } else {
        groups.put(sorted, new ArrayList<>(List.of(og)));
      }
    }

    return new ArrayList<>(groups.values());
  }

  public static void test(List<String> strings) {
    List<List<String>> grouped = groupAnagram(strings);
    System.out.println(grouped);
  }

  public static void main() {
    test(List.of("bucket", "rat", "mango", "tango", "ogtan", "tar"));
    test(List.of("eat", "tea", "tan", "ate", "nat", "bat"));
    test(List.of("abc", "def", "ghi", "xyz"));
    test(List.of("abc", "bca", "cab", "cba", "bac", "acb"));
    test(List.of("ab", "ba", "cc"));
  }
}
