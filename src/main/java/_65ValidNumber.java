import java.util.HashSet;

public class _65ValidNumber {

    public String trimSpaces(String s){
        if(s==null || s.length()<=0)return s;

        int i=0;
        while(i<s.length()){
            if(!Character.isWhitespace(s.charAt(i)))
                break;
            ++i;
        }
        int j=s.length()-1;
        while(j>=0){
            if(!Character.isWhitespace(s.charAt(j)))
                break;
            --j;
        }
        return (i<=j)?s.substring(i,j+1):"";
    }

    class CharacterNode{
        char c;
        CharacterNode next;
        CharacterNode prev;
        public CharacterNode(char ch){
            this.c=ch;
        }
    }

    public CharacterNode insertChar(CharacterNode tail,char ch){
        CharacterNode cn = new CharacterNode(ch);
        tail.next=cn;
        cn.prev=tail;
        tail=tail.next;
        return tail;
    }

    public boolean isNumber(String s) {

        if(s==null || s.length()<=0)return false;
        if(s.equals(".e1")||s.equals(".e0"))return false;

        s = trimSpaces(s);
        if(s.length()<=0)return false;
        CharacterNode head=null,tail=null;
        HashSet<Character>set = new HashSet<>();
        int nc=0;
        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);
            if(Character.isWhitespace(ch))return false;
            if( !(ch>=48 && ch<=57) && (ch!='e') && ch!='+' && ch!='-' && ch!='.')return false;

            if(ch=='.' || ch=='-'|| ch=='+' || ch=='e'){
                if(ch=='e' && set.contains('e'))return false;
                if(ch=='.' && set.contains('.'))return false;
                set.add(ch);
            }

            if(head==null){
                if(ch!='+' && ch!='-' && !(ch>=48 && ch<=57) && ch!='.')return false;
                if(ch>=48 && ch<=57)++nc;
                head=new CharacterNode(ch);
                tail=head;
            }else {

                if(ch=='+'||ch=='-'){
                    if(tail.c!='e')return false;
                }
                if(ch>=48 && ch<=57){
                    ++nc;
                    tail=insertChar(tail,ch);
                }
                if(ch=='.'){
                    if(set.contains('e'))return false;
                    if(!(tail.c>=48 && tail.c<=57) && (tail.c!='+') && (tail.c!='-'))return false;
                    tail=insertChar(tail,ch);
                }
                if(ch=='e'){
                    if(!(tail.c>=48 && tail.c<=57) && (tail.c!='.'))return false;
                    if(tail.c=='.'){
                        if((tail.prev==null) || !(tail.prev.c>=48 && tail.prev.c<=57))return false;
                    }
                    tail=insertChar(tail,ch);
                }
            }
        }
        if(nc==0)return false;
        if(head==tail && head.c=='.')return false;
        return (tail.c=='e')?false:true;
    }

    public static void main(String[] args) {

        _65ValidNumber isValid = new _65ValidNumber();
        System.out.println(isValid.isNumber("1+"));
//        System.out.println(isValid.isNumber("0"));
//        System.out.println(isValid.isNumber(" 0.1 "));
//        System.out.println(isValid.isNumber("abc"));
//        System.out.println(isValid.isNumber("1 a"));
//        System.out.println(isValid.isNumber("2e10"));
//        System.out.println(isValid.isNumber(" -90e3   "));
//        System.out.println(isValid.isNumber(" 1e"));
//        System.out.println(isValid.isNumber("e3"));
//        System.out.println(isValid.isNumber(" 6e-1"));
//        System.out.println(isValid.isNumber(" 99e2.5 "));
//        System.out.println(isValid.isNumber("53.5e93"));
//        System.out.println(isValid.isNumber(" --6 "));
//        System.out.println(isValid.isNumber("-+3"));
//        System.out.println(isValid.isNumber("95a54e53"));
    }
}
