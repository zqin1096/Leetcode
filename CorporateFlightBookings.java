/*
There are n flights, and they are labeled from 1 to n.

We have a list of flight bookings.  The i-th booking bookings[i] = [i, j, k]
means that we booked k seats from flights labeled i to j inclusive.

Return an array answer of length n, representing the number of seats booked on
each flight in order of their label.
 */
public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] seats = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            seats[bookings[i][0] - 1] += seats[bookings[i][2]];
            if (bookings[i][1] < n) {
                seats[bookings[i][1]] -= seats[bookings[i][2]];
            }
        }
        for (int i = 1; i < seats.length; i++) {
            seats[i] = seats[i - 1] + seats[i];
        }
        return seats;
    }
}
/*
Since ranges are continuous, we can add reservations to the first flight in the
range, and remove them after the last flight in range. Then we can use the
running sum to update reservations for all flights.

[1,2,10], [2,3,20], [3,5,25]
Flights     1   2   3   4   5
booking#1   10     -10
booking#2      20      -20
booking#3          25
All bookings to this flight. Remove the seats once the range is over.
 */
