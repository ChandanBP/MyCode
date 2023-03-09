import java.util.*;

public class _721AccountMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        ListIterator<List<String>>ite1 = accounts.listIterator();
        HashMap<String,Integer>map = new HashMap();
        HashMap<Integer,HashSet<String>>map2 = new HashMap();
        HashMap<Integer,String>nameMap = new HashMap<>();

        while(ite1.hasNext()){
            List<String>list = ite1.next();
            ListIterator<String>ite2 = list.listIterator();

            HashSet<String>emailList = new HashSet();
            boolean flag = false;
            boolean first = true;
            int count = -1;
            String name = "";
            while(ite2.hasNext()){
                if(first){
                    first = false;
                    name = ite2.next();
                }else{
                    String email = ite2.next();
                    emailList.add(email);
                    if(map.containsKey(email)){
                        count = map.get(email);
                        flag = true;
                    }
                }
            }
            if(flag){
                emailList.addAll(map2.get(count));
            }else{
                ++count;
            }

            Iterator<String>t = emailList.iterator();
            while(t.hasNext()){
                String email = t.next();
                map.put(email,count);
            }
            nameMap.put(count,name);
            map2.put(count,emailList);
        }

        List<List<String>>result = new LinkedList();
        map2.forEach((k,v)->{
            HashSet<String>emails = v;
            LinkedList<String>l = new LinkedList<>(emails);
            Collections.sort(l);
            LinkedList<String>t = new LinkedList<>();
            t.add(nameMap.get(k));
            t.addAll(l);
            result.add(t);
        });
        return result;
    }

    public static void main(String[] args) {
        new _721AccountMerge().accountsMerge(new LinkedList<>());
    }
}
