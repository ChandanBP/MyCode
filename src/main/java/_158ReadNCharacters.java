import java.util.LinkedList;
import java.util.Queue;

public class _158ReadNCharacters {

    Queue<Character>queue = new LinkedList<>();

    public int read4(char[] buf){
        buf = new char[3];
        buf = "abc".toCharArray();
        return 3;
    }

    public int read(char[] buf, int n) {

        if(n==0)return 0;
        int k=0;
        int count=0;

        if(!queue.isEmpty()){
            int len = Math.min(queue.size(),n);

            while (len>0){
                ++count;
                buf[k++]=queue.poll();
                --len;
            }
            if(n==count)return n;
        }
        int numRemCharacters = (int)Math.ceil(n-count/4);
        char temp[];
        while (numRemCharacters!=0){
            temp = new char[4];
            int ret = read4(temp);
            if(ret==0){
                break;
            }

            for(char ch: temp){
                if(count<n && ch!='\0'){
                    buf[k++]=ch;
                    ++count;
                }
                else{
                    queue.add(ch);
                }
            }
            --numRemCharacters;
        }
        return count;
    }

    public static void main(String[] args) {
        _158ReadNCharacters obj = new _158ReadNCharacters();
        obj.read(new char[]{},1);
        obj.read(new char[]{},2);
        obj.read(new char[]{},1);
    }
}
