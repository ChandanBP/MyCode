public class _166FractionReccurance {

    public String fractionToDecimal(int numerator, int denominator) {

        int quotient = numerator/denominator;
        int rem = numerator%denominator;

        if(rem==0)return String.valueOf(quotient);

        StringBuilder sb = new StringBuilder();
        sb.append(quotient);
        sb.append(".");



        return String.valueOf(numerator/denominator);
    }

    public static void main(String[] args) {
        System.out.println();
        new _166FractionReccurance().fractionToDecimal(4,2);
    }
}
