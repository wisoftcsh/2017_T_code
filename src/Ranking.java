import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * Created by csh9196 on 2017-10-30.
 */
public class Ranking {
    private ProductList productList;

    Ranking() {
    }

    Ranking(ProductList productList) {
        this.productList = productList;
    }

    public void setPreListRank() {
        QuickSort quickSort = new QuickSort(productList.getProductList());
        quickSort.quickSort(0, productList.getProductList().size() - 1);
        int rank = 1;
        for (Product product : productList.getProductList()) {
            product.setRanking(rank++);
        }
    }

    public void listUpdate() {
        for (Product product : productList.getProductList()) {
            try {
                product.setTotalPrice(product.getQuantity() * (new DecimalFormat("#,###").parse(product.getPrice()).intValue()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        QuickSort quickSort = new QuickSort(productList.getProductList());
        quickSort.quickSort(0, productList.getProductList().size() - 1);
        int rank = 1;
        for (Product product : productList.getProductList()) {
            product.setRankFluctuation(rank);
            product.setRanking(rank++);
        }
    }

    public void printList() {
        System.out.println(String.format("%s %10s %10s %50s %20s %20s",
                "현재 순위", "순위 변동", "상품명", "정상가", "판매가", "할인율"));
        for (Product product : productList.getProductList()) {
            System.out.println(String.format("%5s %15s           %-30s %20s %20s %20s",
                    product.getRanking(),
                    product.getRankFluctuation(),
                    product.getName(),
                    product.getNormalPrice(),
                    product.getPrice(),
                    product.getDisCount()));
        }
    }
}
