import java.util.HashSet;
import java.util.Set;

public class ParentParenthsis {
    public static void main(String[] args) {
        createParenthesis(2);
    }

    static void createParenthesis(int number){
        System.out.println(createParenthsisRecursive( number));

    }

    static Set<String> createParenthsisRecursive(int num)
    {
        Set<String> set=new HashSet<>();
        if(num==0){
            set.add("");
        }else {
            Set<String> prev = createParenthsisRecursive(num - 1);
            for (String st : prev) {
                for (int i = 0; i < st.length(); i++) {
                    if (st.charAt(i) == '(') {
                            set.add(getMiddleString(st,i));
                    }
                }
                set.add("()"+st);
            }
        }

        return set;
    }

    static String getMiddleString(String st, int left){
        String leftSub=st.substring(0, left+1);
        String rightSub=st.substring(left+1, st.length());
        return leftSub+"()"+rightSub;
    }
}
