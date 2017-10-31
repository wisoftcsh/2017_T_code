import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by csh9196 on 2017-10-30.
 */
public class ProductList {
    private List<Product> list = new ArrayList<>();

    ProductList() {
    }

    public void setProductList() {
        BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\developments\\2017_Tmon\\src\\data.csv"), "euc-kr"));
            while ((line = br.readLine()) != null) {
                String[] field = line.split(cvsSplitBy);
                if (field.length == 5) {
                    list.add(new Product(field[0], field[2], field[1], Integer.parseInt(field[3]), Integer.parseInt(field[4])));
                } else {
                    list.add(new Product((field[0]+","+field[1]), field[3], field[2], Integer.parseInt(field[4]), Integer.parseInt(field[5])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Product> getProductList() {
        return list;
    }
}
