import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class StringUnique {

    public static void main(String[] args) {


    }

    boolean isUniqueCharactersWithSet(String st){
        char[] arr=st.toCharArray();
        Set<Character> set=new HashSet<>();
        for(char c: arr){
            if(set.contains(c))return false;
            set.add(c);
        }
        return true;
    }
    boolean isUniqueCharacters(String st){
        int checker=0;
        for(int i=0;i<st.length();i++){
            int bitAt=st.charAt(i)-'a';
            if((checker&(1<<bitAt))>0)return false;
            checker=checker|(1<<bitAt);
        }
        return true;
    }
}
