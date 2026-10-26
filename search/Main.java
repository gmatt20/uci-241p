public class Main {
  public static void main(String[] args) {
    BinarySearch binarySearch = new BinarySearch();
    int[] found = binarySearch.binarySearch(new int[] { 4, 9, 10, 13, 17, 17, 19, 21 }, 17);

    System.out.println(found[0] + " " + found[1]);

    found = binarySearch.binarySearch(new int[] { 2, 4, 6, 8, 10, 14, 16 }, 17);

    System.out.println(found[0] + " " + found[1]);

    found = binarySearch.binarySearch(new int[] {}, 17);

    System.out.println(found[0] + " " + found[1]);

    found = binarySearch.binarySearch(new int[] { 4, 17, 17, 17, 17, 17, 19, 21 }, 17);

    System.out.println(found[0] + " " + found[1]);

    boolean matrix = binarySearch.matrixSearch(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } },
        3);

    System.out.println(matrix);

    matrix = binarySearch.matrixSearch(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } },
        13);

    System.out.println(matrix);

    matrix = binarySearch.matrixSearch(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } },
        13);

    System.out.println(matrix);
  }
}
