public class _604CompressedStringIterator {

    String str;
    int i=0;

    public _604CompressedStringIterator(String compressedString){
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<compressedString.length()){
            char ch = compressedString.charAt(i);
            i++;
            StringBuilder sbr = new StringBuilder();
            while(i<compressedString.length() && Character.isDigit(compressedString.charAt(i))){
                sbr.append(compressedString.charAt(i));
                i++;
            }
            int count = Integer.parseInt(sbr.toString());
            while(count!=0){
                sb.append(ch);
                --count;
            }
        }

        str = sb.toString();
    }

    public char next() {
        if(i==str.length()) return ' ';

        char ch = str.charAt(i++);
        return ch;
    }

    public boolean hasNext() {
        if(str==null||str.length()==0)return false;

        return (i<str.length())?true:false;
    }

    public static void main(String[] args) {
        _604CompressedStringIterator obj = new _604CompressedStringIterator("L10e2t1C1o1d1e11");
        System.out.println(obj.str);
    }
}
