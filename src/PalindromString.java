import java.util.HashMap;
import java.util.Map;

public class PalindromString {
    public static void main(String[] args) {
        //System.out.println(isPalindrom("Tacto Coa"));
        //System.out.println(GFG.canFormPalindrome("tactcoa"));
        System.out.println("max length "+maxLengthPalindrome("mada"));
    }


    static int maxLengthPalindrome(String str){
        char[] arr=str.toCharArray();
        if(arr.length==1)return 1;
        int maxLengthStr=1;
        for(int i=0;i<arr.length;i++){
            boolean isGot=false;
            for(int j=arr.length-1;j>i;j--){
                if(isPalendrop(arr,i,j) && maxLengthStr<(j-i)){
                    isGot=!isGot;
                    maxLengthStr=j-i+1;
                }
                if(isGot)break;
            }

        }
        return maxLengthStr;
    }

    static boolean isPalendrop( char[] arr,int i,int j){
        while(i<j){
            if(arr[i]!=arr[j])return false;
            i++;
            j--;
        }
        return true;
    }


    static boolean isPalindrom(String st){
        Map<Character, Integer> map=new HashMap<>();
        char[] arr=st.toLowerCase().toCharArray();
        for(char c: arr){
            if(c==' ')continue;
            Integer count=map.get(c);
            if(count==null){
                count=0;
                map.put(c,count);
            }
            map.put(c,++count);


        }
        int oddCount=0;
        for(int val:map.values()){
            if(val%2!=0)oddCount++;
            if(oddCount>1)return false;
        }
        return true;
    }
}


class GFG
{

    static boolean canFormPalindrome(String a)
    {

        // bitvector to store
        // the record of which character appear
        // odd and even number of times
        int bitvector = 0, mask = 0;
        for (int i = 0; i < a.length(); i++)
        {
            int x = a.charAt(i) - 'a';
            mask = 1 << x;

            bitvector = bitvector ^ mask;
        }

        return (bitvector & (bitvector - 1)) == 0;
    }

    // Driver Code
    public static void main (String[] args) {

        if (canFormPalindrome("geeksforgeeks"))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}


