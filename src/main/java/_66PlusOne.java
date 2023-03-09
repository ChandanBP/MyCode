import java.util.LinkedList;
import java.util.ListIterator;

public class _66PlusOne {

    public int[] plusOne(int[] digits) {

        int carry=1;
        int i=digits.length-1;
        LinkedList<Integer>list = new LinkedList<>();
        while(i>=0){
            list.addFirst((digits[i]+carry)%10);
            carry=(digits[i]+carry)/10;
            i--;
        }
        if(carry>0)
            list.addFirst(carry);

        int res[] = new int[list.size()];
        i=0;
        ListIterator<Integer>ite = list.listIterator();
        while(ite.hasNext()){
            res[i++]=ite.next();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _66PlusOne().plusOne(new int[]{1,2,3}));
    }
}
