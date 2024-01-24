public class OneWayOperation {

    public static void main(String[] args) {
        System.out.println(isOneStepAwayString("PALE","PAD"));
    }

    static boolean isOneStepAwayString(String st1, String st2){
        if(Math.abs(st1.length()-st2.length())>1)return false;
            int i=0;
            int j=0;
            int opsCount=0;
            while(i<st1.length() && j<st2.length()){
                if(st1.charAt(i)!=st2.charAt(j)){
                    opsCount++;
                    if(st1.length()<st2.length())j++;
                    else if(st1.length()>st2.length()) i++;
                    else {
                        i++;
                        j++;
                    }

                }else{
                    i++;
                    j++;
                }
                if(opsCount>1)return false;
            }


        return true;

    }
}
