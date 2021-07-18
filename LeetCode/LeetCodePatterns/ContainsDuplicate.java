/**
 * * Intuition
 * For an array of nn integers, there are C(n,2) = n(n+1)/ 2 pairs of integers. Thus, we may check all n(n+1)/ 2 pairs and see if there is any pair with duplicates.
 * 
 * 
 * * Algorithm
 * To apply this idea, we employ the linear search algorithm which is the simplest search algorithm. 
 * Linear search is a method of finding if a particular value is in a list by checking each of its elements, one at a time and in sequence until the desired one is found.
 * 
 * For our problem, we loop through all nn integers. For the iith integer nums[i], we search in the previous i-1 integers for the duplicate of nums[i]. 
 * If we find one, we return true; if not, we continue. Return false at the end of the program.
 * 
 * To prove the correctness of the algorithm, we define the loop invariant. A loop invariant is a property that holds before (and after) each iteration. 
 * Knowing its invariant(s) is essential for understanding the effect of a loop. Here is the loop invariant:
 */

class ContainsDuplicats {
    public boolean q(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int n: nums) {
            if (set.contains(n)) return true;
            set.add(n);
        }
        return false;
    }
}
