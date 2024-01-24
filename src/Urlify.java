public class Urlify {


    String replace(char[] arr, char toreplace, String byReplace) {
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        Urlify urlify=new Urlify();
        String st=urlify.trimString("   I am     d ".toCharArray());
        System.out.println("%"+st+"%");
    }

    String trimString(char[] arr){
        int i=0;
        while(i<arr.length){
            if(arr[i]!=' '){
                break;
            }
            i++;
        }
        int startIndex=i;
        i=arr.length-1;
        while(i>0){
            if(arr[i]!=' '){
                break;
            }
            i--;
        }
        int endIndex=i;
        char[] returnArr=new char[endIndex-startIndex+1];
        for(int j=startIndex;j<=endIndex;j++){

            returnArr[j-startIndex]=arr[j];
        }
        return String.valueOf(returnArr);
    }
}