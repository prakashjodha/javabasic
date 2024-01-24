import java.util.HashSet;
import java.util.Set;

public class WordPermutations {
    static Set<String> set=new HashSet<>();
    static int[] dbArr;
    public static void main(String[] args) {
        String[] words=new String[]{"ab","cd","ef"};
        dbArr=new int[words.length];
        getPermutations(words,0,words.length);
        System.out.println(set);
    }

    public static Set<String> getPermutationOfWord(String[] words){
        set.clear();
        getPermutations(words,0,words.length);
        return set;
    }


    static void getPermutations(String[] words, int start, int end){
        System.out.println(String.join(",",words));
        if(start==end) {
            set.add(String.join("",words));
        };
        for(int i=start;i<end;i++){
            swap(words, start,i);
            getPermutations(words, start+1,end);
            swap(words,start,i);
        }
    }
    static String[] swap(String[] words, int i, int j){
        String temp=words[i];
        words[i]=words[j];
        words[j]=temp;
        return words;
    }
}
