public class DisjointSetTest {
    public static void main(String[] args) {
        int[] arr = {1,5,2,7,4,-3,-5};
        UnionFind uf = new UnionFind(arr);
        uf.printData();
        uf.union(2,7);
        uf.union(-3,4);
        uf.union(5,-5);
        uf.printData();
        uf.union(-5,7);
        uf.printData();
        System.out.println(uf.find(7));
        uf.printData();
    }
}
