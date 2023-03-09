public class _388LongestAbsolutePath {

    public int lengthLongestPath(String input) {
        String [] paths  = input.split("\n");
        int [] pathLength = new int [paths.length];
        int res = 0;
        for(int i =0;i<paths.length;i++){
            int level = 0;
            boolean isFile = false;
            int lengthOfFileOrDir = 0;
            int finalLength = 0;
            String curr = paths[i];
            for(int j =0;j<curr.length();j++){
                char c = curr.charAt(j);
                if(c == '.')
                    isFile = true;
                if(c == '\t')
                    level++;
                else
                    lengthOfFileOrDir++;
            }
            finalLength = (level == 0?0:(pathLength[level -1]+1)) + lengthOfFileOrDir;
            if(isFile)
                res = Math.max(res,finalLength ) ;
            else
                pathLength[level] = finalLength;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _388LongestAbsolutePath().lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }
}
