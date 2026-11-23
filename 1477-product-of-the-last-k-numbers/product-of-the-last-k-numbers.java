class ProductOfNumbers {

    List<Integer> ls;
    List<Integer> zero;
    List<Integer> nums;
    int n, c = 0;
    int prod;

    public ProductOfNumbers() {
        ls = new ArrayList<>();
        zero = new ArrayList<>();
        nums = new ArrayList<>();
        n = 0;
        prod = 1;
    }

    public void add(int num) {
        nums.add(num);

        if (num == 0) {
            c++;
            ls.add(0);
            prod = 1;
        } else {
            prod *= num;
            ls.add(prod);
        }

        zero.add(c);
        n++;
    }

    public int getProduct(int k) {
        int i = n - k - 1; 
        int zBefore = (i < 0) ? 0 : zero.get(i);
        if (zero.get(n - 1) != zBefore)
            return 0; 
        if (i < 0 || nums.get(i) == 0)
            return ls.get(n - 1);
        return ls.get(n - 1) / ls.get(i);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */