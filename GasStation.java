/*
There are N gas stations along a circular route, where the amount of gas at
station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel
from station i to its next station (i+1). You begin the journey with an empty
tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit
once in the clockwise direction, otherwise return -1.

If there exists a solution, it is guaranteed to be unique.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        // The amount of gas in the tank when the car leave station i.
        int tank = 0;
        int lack = 0;
        for (int i = 0; i < gas.length; i++) {
            tank = tank + gas[i] - cost[i];
            // If tank is lower than 0, it means the car cannot go from start
            // station to the next station.
            if (tank < 0) {
                start = i + 1;
                lack += tank;
                tank = 0;
            }
        }
        return (tank + lack) >= 0 ? start : -1;
    }
}
/*
如果到中间的某个位置, 剩余的油量为负了, 那么说明之前累积剩下的油量不够从这一站到下一站了. 那
么就从下一站从新开始计数. 为什么是下一站, 而不是之前的某站呢? 因为第一站剩余的油量肯定是大于
等于0的, 然而到当前一站油量变负了, 说明从第一站之后开始的话到当前油量只会更少而不会增加. 也
就是说从第一站之后, 当前站之前的某站出发到当前站剩余的油量是不可能大于0的. 所以只能从下一站
重新出发开始计算从下一站开始剩余的油量, 并且把之前欠下的油量也累加起来, 看到最后剩余的油量是
不是大于欠下的油量.
 */
