import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int basicTime = fees[0], basicFee = fees[1];
        int unitTime = fees[2], unitFee = fees[3];

        Map<String, Integer> inTime = new HashMap<>();
        Map<String, Integer> parkingTime = new HashMap<>();

        for (String record : records) {
            String[] parts = record.split(" ");
            String[] timeParts = parts[0].split(":");
            int time = Integer.parseInt(timeParts[0]) * 60 + Integer.parseInt(timeParts[1]);
            String car = parts[1];

            if (parts[2].equals("IN")) {
                inTime.put(car, time);
            } else {
                if (!parkingTime.containsKey(car)) {
                    parkingTime.put(car, 0);
                }
                parkingTime.put(car, parkingTime.get(car) + time - inTime.get(car));
                inTime.remove(car);
            }
        }

        for (String car : inTime.keySet()) {
            if (!parkingTime.containsKey(car)) {
                parkingTime.put(car, 0);
            }
            parkingTime.put(car, parkingTime.get(car) + (23 * 60 + 59) - inTime.get(car));
        }

        List<String> carList = new ArrayList<>(parkingTime.keySet());
        Collections.sort(carList);

        int[] result = new int[carList.size()];
        int index = 0;

        for (String car : carList) {
            int time = parkingTime.get(car);
            if (time <= basicTime) {
                result[index++] = basicFee;
            } else {
                result[index++] = basicFee + ((time - basicTime + unitTime - 1) / unitTime) * unitFee;
            }
        }

        return result;
    }
}
