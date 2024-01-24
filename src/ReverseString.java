public class ReverseString {

    public static void main(String[] args) {
        String st="Ab,c,de!$";
        System.out.println(reverseString(st));
    }

    static String reverseString(String input){
        int i=0;
        int j=input.length()-1;
        char[] arr=new char[input.length()];
        while(i<=j){
            char c=input.charAt(i);
            char d=input.charAt(j);
            if(isCharacter(c) && isCharacter(d)){
                arr[i++]=d;
                arr[j--]=c;
            }
            if(!isCharacter(c)){
                arr[i++]=c;
            }
            if(!isCharacter(d)){
                arr[j--]=d;
            }
        }
        return String.valueOf(arr);
    }

    static boolean isCharacter(char c){
        return (c>='a'&&c<='z')||(c>='A'&&c<='Z');
    }
}
