public class StringCompression {

    public static void main(String[] args) {
        System.out.println(getCompressedString("Aabcccccaaa"));
    }

    static String getCompressedString(String st){
        int counter=1;
        int maxCounter=0;
        StringBuilder sb=new StringBuilder();
        sb.append(st.charAt(0));
        for(int i=1; i<st.length();i++)
        {
            if(st.charAt(i)==st.charAt(i-1))counter++;
            if(st.charAt(i)!=st.charAt(i-1)){
                sb.append(counter).append(st.charAt(i));
                if(maxCounter<counter)maxCounter=counter;
                counter=1;
            }

        }
        sb.append(counter);
        if(maxCounter<counter)maxCounter=counter;
        if(maxCounter==1)return st;
        return sb.toString();
    }
}
