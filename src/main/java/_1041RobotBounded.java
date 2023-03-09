public class _1041RobotBounded {

    int x = 0;
    int y = 0;
    char dir = 'U';

    public void moveRobot(String instructions){

        for(int i=0;i<instructions.length();i++){
            char c = instructions.charAt(i);

            if(c=='G'){
                if(dir=='L'){
                    x = x-1;
                }
                if(dir=='R'){
                    x = x+1;
                }
                if(dir=='U'){
                    y = y+1;
                }
                if(dir=='B'){
                    y = y-1;
                }
            }
            if(c=='L'){
                if(dir=='U'){
                    dir = 'L';
                }
                else if(dir=='L'){
                    dir = 'B';
                }
                else if(dir=='R'){
                    dir = 'U';
                }
                else if(dir=='B'){
                    dir = 'R';
                }
            }
            if(c=='R'){
                if(dir=='U'){
                    dir = 'R';
                }
                else if(dir=='L'){
                    dir = 'U';
                }
                else if(dir=='R'){
                    dir = 'B';
                }
                else if(dir=='B'){
                    dir = 'L';
                }
            }
        }
    }

    public boolean isRobotBounded(String instructions) {

        if(instructions==null || instructions.length()==0)
            return false;

        for(int i=1;i<=100;i++){
            moveRobot(instructions);
            if(x==0 && y==0)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new _1041RobotBounded().isRobotBounded("GL");
    }
}
