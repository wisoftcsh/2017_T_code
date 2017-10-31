import java.util.List;

/**
 * Created by csh9196 on 2017-04-05.
 */

class QuickSort {
    private List<Product> array;

    QuickSort(List<Product> array) {
        this.array = array;
    }

    void quickSort(int p, int r) {
        if (p < r) {
            int q = partition(this.array, p, r);
            quickSort(p, q - 1);
            quickSort(q + 1, r);
        }
    }

    private int partition(List<Product> array, int p, int r) {
        int pivot = array.get(r).getTotalPrice();
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (array.get(j).getTotalPrice() >= pivot) {
                Product tmp = array.get(++i);
                array.set(i, array.get(j));
                array.set(j, tmp);
            }
        }
        Product tmp = array.get(i+1);
        array.set(i+1, array.get(r));
        array.set(r, tmp);
        return i+1;
    }
}
