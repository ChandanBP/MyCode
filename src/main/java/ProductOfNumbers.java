public class ProductOfNumbers {

    int product[] = new int[40000];
    int i=0;
    int h=0;
    int p=1;

    public ProductOfNumbers() {

    }

    public void add(int num) {
        p*=num;
        product[i++]=p;
        if(p==0){
            h=i;
            p=1;
        }
    }

    public int getProduct(int k) {
        if(i==0)return 0;
        int t = product[i-1];
        k = i-k;
        if(h>k)return 0;
        if(k==0)return t;
        return product[k-1]==0?t:t/product[k-1];
    }

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(1);
        System.out.println(productOfNumbers.getProduct(1));
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);
        System.out.println(productOfNumbers.getProduct(2));
        System.out.println(productOfNumbers.getProduct(3));
        System.out.println(productOfNumbers.getProduct(4));
        productOfNumbers.add(8);
        System.out.println(productOfNumbers.getProduct(2));
    }
}
