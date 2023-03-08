import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /**
     * sum: This method takes a list List<Integer> L and
     * returns the total sum of the elements in that list.
     * If the list is empty, it method should return 0.
     * @param L
     * @return
     */
    public Integer sum(List<Integer> L) {
        Integer total = 0;
        for (int i : L) {
            total += i;
        }
        return total;
    }

    //

    /**
     * evens: This method takes a list List<Integer> L and
     * returns a new list containing the even numbers of the given list.
     * If there are no even elements, it should return an empty list.
     * @param L
     * @return List<Integer>
     */
    public List<Integer> evens(List<Integer> L) {
        List<Integer> newLst = new ArrayList<>();
        for (int i : L) {
            if (i % 2 == 0) {
                newLst.add(i);
            }
        }
        return newLst;
    }

    /**
     * common: This method takes two lists List<Integer> L1, List<Integer> L2 and
     * returns a new list containing the common item of the two given lists.
     * If there are no common items, it should return an empty list.
     * @param L1
     * @param L2
     * @return
     */
    public List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> newLst = new ArrayList<>();
        for (int i : L1) {
            for (int j : L2) {
                if (i == j) {
                    newLst.add(i);
                }
            }
        }
        return newLst;
    }

    /**
     * countOccurrencesOfC: This method takes a list and a character List<String> words, char c and
     * returns the number of occurrences of the given character in a list of strings.
     * If the character does not occur in any of the words, it should return 0.
     * @param words
     * @param c
     * @return
     */
    public Integer countOccurrencesOfC(List<String> words, char c) {
        Integer occurrences = 0;
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    occurrences += 1;
                }
            }
        }
        return occurrences;
    }

    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            lst.add(i);
        }
        List<Integer> lst2 = new ArrayList<>();
        for (int i = 2; i < 7; i++) {
            lst2.add(i);
        }

        List<String> words = new ArrayList<>();
        words.add("I ");
        words.add("love");
        words.add("java!");

        ListExercises obj = new ListExercises();
        System.out.println(obj.sum(lst));
        System.out.println(obj.evens(lst));
        System.out.println(obj.common(lst, lst2));
        System.out.println(obj.countOccurrencesOfC(words, 'i'));

    }
}
