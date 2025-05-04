import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans= new ArrayList<List<Integer>>();
        List<Integer> temp2 = new ArrayList<Integer>();
        temp2.add(1);
        ans.add(temp2);
        n--;
        if(n==0) return ans;
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(1);
        ans.add(temp);
        n--;
        if(n==0) return ans;
        while(n-->0){
            List<Integer> temp1 = new ArrayList<Integer>();
            temp1.add(1);
            for(int i=1;i<temp.size();i++) temp1.add(temp.get(i-1)+temp.get(i));
            temp1.add(1);
            ans.add(temp1);
            temp=temp1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        int n = 5; // Example input
        List<List<Integer>> result = obj.generate(n);
        System.out.println("Pascal's Triangle with " + n + " rows:");
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}
