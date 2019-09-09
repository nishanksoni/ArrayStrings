package Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianFinder {
    List<Integer> list = new ArrayList<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        this.list.add(num);
    }

    public double findMedian() {
        Collections.sort(this.list);
        int size = this.list.size();
        int mid = 0 + (size - 0) / 2;
        if (size % 2 == 0)
        {
            if (list.size() == 2)
            {

            }
            int num1 = list.get(mid);
            int num2 = list.get(mid + 1);
            return (num1 + num2) / 2;

        } else {
            return list.get(mid);
        }
    }


    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(30);
        medianFinder.addNum(40);


    }
}
