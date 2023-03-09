import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class _1087BraceExpansion {

    LinkedList<String>list = new LinkedList<>();

    public void appendStr(LinkedList<Character>l){

        ListIterator<Character>ite1 = l.listIterator();

        if(list.size()==0){
            while(ite1.hasNext()){
                list.add(ite1.next()+"");
            }
        }else{
            LinkedList<String>r = new LinkedList<>();
            while(ite1.hasNext()){
                char c = ite1.next();
                ListIterator<String>ite2 = list.listIterator();
                while(ite2.hasNext()){
                    r.add(c+""+ite2.next());
                }
            }
            list = r;
        }
    }

    public String[] expand(String S) {

        int i = S.length()-1;

        while(i>=0){
            LinkedList<Character>r = new LinkedList<>();
            if(S.charAt(i)=='}'){
                while(i>=0 && S.charAt(i)!='{'){
                    if(S.charAt(i)!=',' && S.charAt(i)!='}'){
                        r.add(S.charAt(i));
                    }
                    --i;
                }
            }else if(S.charAt(i)=='{'){
                --i;
            }else{
                r.add(S.charAt(i));
                --i;
            }
            if(r.size()>0){
                Collections.sort(r);
                appendStr(r);
            }
        }

        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        new _1087BraceExpansion().expand("{a,b}c{d,e}f");
    }
}
