import java.util.HashMap;

public class _273IntegerToEnglish {
    HashMap<String,String> map = new HashMap();
    HashMap<Integer,String>place = new HashMap();
    HashMap<String,String>tensMap = new HashMap();
    String res = "";

    public void generateMap(){
        map.put("0","Zero");
        map.put("1","One");
        map.put("2","Two");
        map.put("3","Three");
        map.put("4","Four");
        map.put("5","Five");
        map.put("6","Six");
        map.put("7","Seven");
        map.put("8","Eight");
        map.put("9","Nine");
        map.put("10","Ten");
        map.put("11","Eleven");
        map.put("12","Twelve");
        map.put("13","Thirteen");
        map.put("14","Fourteen");
        map.put("15","Fifteen");
        map.put("16","Sixteen");
        map.put("17","Seventeen");
        map.put("18","Eighteen");
        map.put("19","Nineteen");
        map.put("20","Twenty");

        tensMap.put("1","Ten");
        tensMap.put("2","Twenty");
        tensMap.put("3","Thirty");
        tensMap.put("4","Forty");
        tensMap.put("5","Fifty");
        tensMap.put("6","Sixty");
        tensMap.put("7","Seventy");
        tensMap.put("8","Eighty");
        tensMap.put("9","Ninety");

        place.put(2,"Thousand");
        place.put(3,"Million");
        place.put(4,"Billion");
    }

    public String getTwoDigitNumbers(String number){
        int val = Integer.parseInt(number);
        if(val==0)return "";
        if(val<10)return map.get(number.charAt(1)+"");
        if(number.charAt(1)=='0')return tensMap.get(number.charAt(0)+"");
        if(val>=10 && val<=20)
            return map.get(number);
        else{
            return tensMap.get(number.charAt(0)+"")+" "+map.get(number.charAt(1)+"");
        }
    }

    public String addNumbers(String number){

        if(number.length()==1)
            return map.get(number);
        else if(number.length()==2){
            return getTwoDigitNumbers(number);
        }else{
            String val = getTwoDigitNumbers(number.substring(1,3));
            if(number.charAt(0)=='0')
                return val;

            if(val.equals("")) return map.get(number.charAt(0)+"")+" Hundred";
            return map.get(number.charAt(0)+"")+" Hundred "+val;
        }
    }

    public void getString(String num,int p, int index){
        if(index<0)return;

        int to = Math.max(index-2,0);
        String str = num.substring(to,index+1);
        String r = addNumbers(str);

        if(p>1 && r.length()>0){
           r = r+" "+place.get(p);
        }

        if(res.length()==0 || r=="")res = r+res;
        else res = r+" "+res;

        getString(num,p+1,to-1);
    }

    public String numberToWords(int num) {
        generateMap();
        String str = String.valueOf(num);
        getString(str,1,str.length()-1);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _273IntegerToEnglish().numberToWords(12324019));

//        String[] students = new String[10];
//        String studentName = "You are an awesome developer";
//        students[0] = studentName;
//        studentName = null;
//        System.out.println(students[0]);
    }
}
