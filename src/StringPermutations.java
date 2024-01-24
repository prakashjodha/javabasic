import java.util.HashSet;
import java.util.Set;

public class StringPermutations {

    public static void main(String[] args) {
        StringPermutations sp=new StringPermutations();
        System.out.println(sp.getAllPermutations("ABC"));
    }

    Set<String> getAllPermutations(String st){
        Set<String> stSet=new HashSet<>();
        permute(st,stSet,0,st.length());
        return stSet;
    }

    String swap(String st, int i,int j){
        char[] arr=st.toCharArray();
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return String.valueOf(arr);
    }

    void permute(String st, Set<String> stSet, int start, int end){

            if(start==end-1){
                System.out.println(st);
                stSet.add(st);
            }else{
                for(int i=start;i<end;i++){
                    st=swap(st,start,i);
                    permute(st, stSet,start+1,end);
                    st=swap(st,start,i);
                }
            }
    }

}
