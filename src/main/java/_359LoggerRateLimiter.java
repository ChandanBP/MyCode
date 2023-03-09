import java.util.HashMap;

public class _359LoggerRateLimiter {

    HashMap<String,Integer>map = new HashMap<>();

    public boolean shouldPrintMessage(int timestamp, String message) {

        if(!map.containsKey(message)){
            map.put(message,timestamp);
            return true;
        }else{
            int oldTimeStamp = map.get(message);
            if(timestamp-10>=oldTimeStamp){
                map.put(message,timestamp);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
