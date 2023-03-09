import java.util.Objects;

public class _1778ShortestPath {

    class RobotPosition{
        int i;
        int j;
        public RobotPosition(int i,int j){
            this.i=i;
            this.j=j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RobotPosition that = (RobotPosition) o;
            return i == that.i &&
                    j == that.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public static void main(String[] args) {

    }
}
