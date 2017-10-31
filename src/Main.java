/**
 * Created by csh9196 on 2017-10-30.
 */
public class Main {
    public static void main(String[] args) {
        ProductList productList = new ProductList();
        productList.setProductList();

        Ranking ranking = new Ranking(productList);
        ranking.setPreListRank();
        ranking.listUpdate();
        ranking.printList();
    }
}
