import java.util.*;

public class test {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        ArrayList<Integer> arr2 = arr;
        arr2.add(3);
        System.out.println(arr);
        System.out.println(arr2);
    }
    public static String featuredProduct(List<String> products) {
        Map<String, Integer> map = new TreeMap<>();
        int count = 0;
        for (String product: products) {
            map.put(product, map.getOrDefault(product, 0) + 1);
            count = Math.max(count, map.get(product));
        }
        List<String> p = new ArrayList<>();
        for (String product: products) {
            if (map.get(product) == count) p.add(product);
        }
        String[] productToString = new String[p.size()];
        for (int i = 0; i < p.size(); i++) productToString[i] = p.get(i);
        Arrays.sort(productToString);

        return productToString[p.size() - 1];
    }
}
