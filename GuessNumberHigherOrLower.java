/*
We are playing the Guess Game. The game is as follows:
I pick a number from 1 to n. You have to guess which number I picked.
Every time you guess wrong, I'll tell you whether the number is higher or lower.
You call a pre-defined API guess(int num) which returns 3 possible results
(-1, 1, or 0):
-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
 */
public class GuessNumberHigherOrLower {
    /* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
//    public int guessNumber(int n) {
//        int low = 1;
//        int high = n;
//        int mid = low + (high - low) / 2;
//        while (guess(mid) != 0) {
//            // My number means the number picked by the game.
//            int guess = guess(mid);
//            if (guess == -1) {
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
//            mid = low + (high - low) / 2;
//        }
//        return mid;
//    }
}
