/**
 * Created by csh9196 on 2017-10-30.
 */
public class Product {
    private String name;
    private String normalPrice;
    private String price;
    private int preQuantity;
    private int quantity;
    private int ranking = 0;
    private String rankFluctuation;
    private int disCount;
    private int totalPrice;

    Product() {
    }

    public Product(String name, String normalPrice, String price, int preQuantity, int quantity) {
        this.name = name;
        this.normalPrice = String.format("%,d", Integer.parseInt(normalPrice));
        this.price = String.format("%,d", Integer.parseInt(price));
        this.preQuantity = preQuantity;
        this.quantity = quantity;
        this.totalPrice = Integer.parseInt(price) * preQuantity;
        setDisCount(((Integer.parseInt(normalPrice) - Integer.parseInt(price)) * 100) / Integer.parseInt(normalPrice));
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getRankFluctuation() {
        return rankFluctuation;
    }

    public void setRankFluctuation(int rank) {
        if (rank == this.ranking) {
            this.rankFluctuation = "-";
        } else if (rank < this.ranking) {
            this.rankFluctuation = "+" + (this.ranking - rank);
        } else {
            this.rankFluctuation = "" + (this.ranking - rank);
        }
    }

    public int getDisCount() {
        return disCount;
    }

    public void setDisCount(int disCount) {
        this.disCount = disCount;
    }

    public String getName() {
        return name;
    }

    public String getNormalPrice() {
        return normalPrice;
    }

    public String getPrice() {
        return price;
    }

    public int getPreQuantity() {
        return preQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getRanking() {
        return ranking;
    }
}
