import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class SILab2 {

    public static List<String> function(List<String> list) {
        if (list.size() <= 0) {
            throw new IllegalArgumentException("List length should be greater than 0");
        }
        int n = list.size();
        int rootOfN = (int) Math.sqrt(n);
        if (rootOfN * rootOfN  != n) {
            throw new IllegalArgumentException("List length should be a perfect square");
        }
        List<String> numMines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!list.get(i).equals("#")) {
                int num = 0;
                if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) || (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) ) {
                    if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) && (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) ){
                        num += 2;
                    }
                    else {
                        num  += 1;
                    }
                }
                if (i - rootOfN >= 0 && list.get(i - rootOfN).equals("#")){
                    num++;
                }
                if (i + rootOfN < n && list.get(i + rootOfN).equals("#")){
                    num++;
                }
                numMines.add(String.valueOf(num));
            }
            else {
                numMines.add(list.get(i));
            }
        }
        return numMines;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List ls = new ArrayList<>();

        for (int i=0; i<N; i++)
        {
            ls.add(in.next());
        }

        System.out.println(function(ls));

    }

}

