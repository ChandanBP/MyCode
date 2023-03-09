import java.util.LinkedList;
import java.util.List;

public class _68TextJustification {

    public String appendSpaces(String str, int numSpaces){
        StringBuilder sb = new StringBuilder();
        while(numSpaces>0){
            sb.append(" ");
            --numSpaces;
        }
        sb.append(str);
        return sb.toString();
    }

    public String justifySentence(List<String> list,int maxWidth,int sL){

        int size = list.size();
        if(size==1){
            return list.get(0)+appendSpaces("",maxWidth-sL);
        }

        int numSpaces = maxWidth-sL;
        int q = numSpaces/(list.size()-1);
        int r = numSpaces%(list.size()-1);

        StringBuilder sb = new StringBuilder();
        int count = size;
        if(r==0){
            for(String str:list){
                if(count!=size)
                    sb.append(appendSpaces(str,q));
                else
                    sb.append(str);
                --count;
            }
        }else{
            for(String str:list){
                if(count!=size){
                    sb.append(appendSpaces(str,(r>0)?q+1:q));
                    --r;
                }
                else
                    sb.append(str);
                --count;
            }
        }

        return sb.toString();
    }

    public void justifyLast(List<String>list,int maxWidth){
        String str[] = list.get(list.size()-1).split("\\s+");
        list.remove(list.size()-1);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length;i++){
            if(i>0)
                sb.append(" ");
            sb.append(str[i]);
        }
        int len = maxWidth-sb.toString().length();
        while(len>0){
            sb.append(" ");
            --len;
        }
        list.add(sb.toString());
    }

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String>list = new LinkedList();

        List<String>result = new LinkedList();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<words.length;i++){
            String word = words[i];
            int numSpaces = result.size()-1;
            int strLen = sb.length();

            if(strLen+numSpaces+((i>0)?1:0)+word.length()<=maxWidth){
                result.add(word);
                sb.append(word);
            }else{
                list.add(justifySentence(result,maxWidth,sb.length()));
                result = new LinkedList();
                sb = new StringBuilder();
                result.add(word);
                sb.append(word);
            }
        }
        if(result.size()>0){
            list.add(justifySentence(result,maxWidth,sb.length()));
        }

        if(list.size()>0)
            justifyLast(list,maxWidth);
        return list;
    }

    public void spawnThread() {

        Thread innerThread = new Thread(new Runnable() {

            public void run() {

                for (int i = 0; i < 100; i++) {
                    System.out.println("I am a new thread !");
                }
            }
        });

        innerThread.start();
        System.out.println("Main thread exiting");
    }

    public static void main(String[] args) {
        _68TextJustification object = new _68TextJustification();
        //object.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"},16);
        object.spawnThread();
    }
}
