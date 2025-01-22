import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> leftToppings = new HashMap<>();
        Map<Integer, Integer> rightToppings = new HashMap<>();

        for (int t : topping) {
            rightToppings.put(t, rightToppings.getOrDefault(t, 0) + 1);
        }

        int fairCuts = 0;

        for (int t : topping) {
            rightToppings.put(t, rightToppings.get(t) - 1);
            if (rightToppings.get(t) == 0) {
                rightToppings.remove(t);
            }

            leftToppings.put(t, leftToppings.getOrDefault(t, 0) + 1);

            if (leftToppings.size() == rightToppings.size()) {
                fairCuts++;
            }
        }

        return fairCuts;
    }
}
