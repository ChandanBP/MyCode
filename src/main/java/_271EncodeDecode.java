import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

public class _271EncodeDecode {

    public String encode(List<String> strs) {

        if(strs==null || strs.size()<1)return "";

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<strs.size();i++){
            String str = strs.get(i);
            if(str.length()==0){
                sb.append("");
            }else{
                byte[] bytesEncoded = Base64.getEncoder().encode(str.getBytes());
                sb.append(new String(bytesEncoded));
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {

        List<String>list = new LinkedList();
        if(s==null || s.length()<1)return list;

        String sentences[] = s.split(",",-1);

        for(int i=0;i<sentences.length-1;i++){
            byte[] valueDecoded = Base64.getDecoder().decode(sentences[i].getBytes());
            list.add(new String(valueDecoded));
        }
        return list;
    }

    public static void main(String[] args) {
        LinkedList<String>list = new LinkedList<>();
        list.add("");
        list.add("");

        _271EncodeDecode obj = new _271EncodeDecode();
        obj.decode(obj.encode(list));
        // Encode data on your side using BASE64
//        byte[] bytesEncoded = Base64.getEncoder().encode("Hello".getBytes());
//        System.out.println("encoded value is " + new String(bytesEncoded));

// Decode data on other side, by processing encoded data
//        byte[] valueDecoded = Base64.getDecoder().decode(bytesEncoded);
//        System.out.println("Decoded value is " + new String(valueDecoded));
    }
}
