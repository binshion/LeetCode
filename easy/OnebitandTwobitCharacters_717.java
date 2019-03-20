public class OnebitandTwobitCharacters_717 {
    public static void main(String[] args){
        Solution_717 solution = new Solution_717();
        System.out.println(solution.isOneBitCharacter(new int[]{1,1,1,0}));
    }
}

class Solution_717 {
    public boolean isOneBitCharacter(int[] bits) {
        int index = 0;
        while (index < bits.length) {
            if (bits[index] == 0) {
                index++;
                if (index == bits.length) {
                    return true;
                }
            } else {
                index += 2;
            }
        }
        return false;
    }
}
