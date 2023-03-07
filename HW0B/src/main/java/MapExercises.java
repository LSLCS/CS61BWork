import java.util.*;

public class MapExercises {
//    letterToNum: This method returns a map from every lower case letter to the number corresponding to that letter starting with ‘a’ is 1.
    public Map<Character,Integer> letterToNum(){
        Map<Character,Integer> map = new TreeMap<>();
        for (int i = 0; i+'a'<='z';i++){
            map.put((char)(i+'a'),i+1);
        }
//        Map<Character,Integer> map = new HashMap<>();
//        for (int i = 0; i+'a'<='z';i++){
//            map.put((char)(i+'a'),i+1);
//        }
//        map.put('A',100);
//        map.put('D',200);
        return map;
    }

//    squares: This method takes a list List<Integer> nums and returns a map from the integers in the list to their squares.
//    If the given list is empty, it should return an empty map.
    public Map<Integer,Integer> squares(List<Integer> nums){
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i : nums){
            map.put(i, i*i);
        }
        return map;
    }

//    countWords: This method takes a list List<String> words and returns a map of the counts of all words that appear in a list of words.
//    If the given list is empty, it should return an empty map.
    public Map<String,Integer> countWords(List<String> words){
        Map<String,Integer> map = new TreeMap<>();
        for (String i : words){
            map.put(i, i.length());
        }
        return map;
    }


    public static void main(String[] args) {
        MapExercises obj = new MapExercises();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i<5; i++){
            nums.add(i);
        }
        List<String> words = new ArrayList<>();
        words.add("I ");
        words.add("love");
        words.add("java!");

        System.out.println(obj.letterToNum());
        System.out.println(obj.squares(nums));
        System.out.println(obj.countWords(words));

    }
}
