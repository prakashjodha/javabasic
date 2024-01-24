import java.util.ArrayList;
import java.util.Set;

public class GetWordsFoundInString {

    public static void main(String[] args) {
        String s="aaaaaaaaaaaaaa";
        String[] arr=new String[] {"aa","aa"};
        System.out.println(getIndexOFCommonString(s,arr));
    }

    static int getLength(String[] arr){
        int sum=0;
        for(String st:arr){
            sum+=st.length();
        }
        return sum;
    }

    public static  ArrayList<Integer>  getIndexOFCommonString(String s, String[] arr){
        ArrayList<Integer> indexes=new ArrayList<>();
        if(arr==null || s.length()<getLength(arr))return indexes;
        Set<String> set= WordPermutations.getPermutationOfWord(arr);
        System.out.println("set is "+set);
        for(String setSt:set){
            getIndex(s, setSt,indexes,0);
        }
        return indexes;
    }

    public static void getIndex(String s,String setSt,ArrayList<Integer> indexes, int oldIndex){
        int index=s.indexOf(setSt,oldIndex);
        if(index==-1) return;
        indexes.add(index) ;
        if(index<s.length()){
            getIndex(s, setSt,indexes,index+1);
        }

    }
}
