public class _165ComparingVersions {

    public int getIntValue(String str){
        int k=0;
        int val=0;
        while(k<str.length()){
            val = (val*10)+(str.charAt(k++)-48);
        }
        return val;
    }

    public int compareStr(String v1,String v2){
        int val1 = getIntValue(v1);
        int val2 = getIntValue(v2);
        return (val1==val2)?0:(val1>val2)?1:-1;
    }

    public int compareVersion(String version1, String version2) {

        if(version1==null && version2==null)return 0;
        else if(version1==null)return -1;
        else if(version2==null)return 1;
        else{

            String version1Arr[] = version1.split("\\.");
            String version2Arr[] = version2.split("\\.");

            int i=0,j=0;
            while(i<version1Arr.length && j<version2Arr.length){

                String v1 = version1Arr[i++];
                String v2 = version2Arr[j++];
                int retVal = compareStr(v1,v2);
                if(retVal!=0){
                    return retVal;
                }
            }

            while(i<version1Arr.length){
                if(getIntValue(version1Arr[i++])>0)return 1;
            }

            while(j<version2Arr.length){
                if(getIntValue(version2Arr[j++])>0)return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        _165ComparingVersions obj = new _165ComparingVersions();
        System.out.println(obj.compareVersion("0.1","1.1"));
        System.out.println(obj.compareVersion("1.0.1","1"));
        System.out.println(obj.compareVersion("7.5.2.4","7.5.3"));
        System.out.println(obj.compareVersion("1.01","1.001"));
        System.out.println(obj.compareVersion("1.0","1.0.0"));
    }
}
