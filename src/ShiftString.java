public class ShiftString {
    public static void main(String[] args) {
        String st="Mr John Smith    ";
        getShiftedString(st,"%20",' ',12);
    }

    static void getShiftedString(String st, String toReplace,char ch,int stLength){
        //replace space with %20
        char[] arr= st.toCharArray();
        int actLength=arr.length-1;
        while(stLength>=0){
            if(arr[stLength]!=ch){
                arr[actLength]=arr[stLength];
                actLength--;
            }else{
                for(int i=0;i<toReplace.length();i++){
                    arr[actLength]=toReplace.charAt(i);
                    actLength--;
                }
            }
            stLength--;

        }
        System.out.println(String.valueOf(arr));
    }
}
