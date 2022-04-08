import java.util.ArrayList;
import java.util.List;

public class MajorityVote {
    // Implement the Moore voting algorithm where at most 2 candidates will be selected (exceed 1/3 of total appearance)
    public static List<Integer> oneThirdMajorityElement(int[] nums) {
        // 要选超过n/3的元素，所以最多有两个这样的candidate
        int candidate1 = nums[0], candidate2 = nums[0];
        int c1_counter = 0, c2_counter = 0;
      
        // 选两个可能的candidate
        for (int i: nums) {
            // candidate1或2找到和自己一样的元素，给自己加票
            if (i == candidate1) {
                c1_counter ++;
                continue;
            }
            if (i == candidate2) {
                c2_counter ++;
                continue;
            }
          
            // 因为之前两个if都没有进入，就表示i是一个与两个candidate不同的元素
            // 此时应该给两个candidate都扣一票
            // 在扣票之前，如果有candidate的票数为0，则替换该candidate为当前元素
            if (c1_counter == 0) {
                candidate1 = i;
                c1_counter = 1;
                continue;
            }
            if (c2_counter == 0) {
                candidate2 = i;
                c2_counter = 1;
                continue;
            }
          
            // 如果前面的if都没有进入，则表示这两个candidate都可以被扣票
            c1_counter --;
            c2_counter --;
        }
      
        // 重新计票一遍，验证两个candidate是否真的票数超过n/3
        List<Integer> res = new ArrayList<Integer>();
        c1_counter = 0; c2_counter = 0;
        for (int n: nums) {
            if (n == candidate1) {c1_counter ++;}
            else if (n == candidate2) {c2_counter ++;}
        }
        if (c1_counter > nums.length / 3) {res.add(candidate1);}
        if (c2_counter > nums.length / 3) {res.add(candidate2);}
        return res;
    }

    public static void main(String[] args) {
        int[] test = {1,1,1,3,3,2,2,2};
        System.out.println(oneThirdMajorityElement(test));
    }
}
