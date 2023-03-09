import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SetNumbers {

    public static int countSetBits(String bits){
        int count = 0;
        for(int i=0;i<bits.length();i++){
            if(bits.charAt(i)=='1'){
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            long N = Long.parseLong(br.readLine());
            long i = N/2;
            long largest = 1;
            long max = N;
            while(i>0){
                if(i<=N){
                    int count = countSetBits(Long.toBinaryString(i));
                    if(count>=largest){
                        largest = count;
                        max = i;
                    }
                }
                i/=2;
            }
            System.out.println(max);
        }
    }
}
