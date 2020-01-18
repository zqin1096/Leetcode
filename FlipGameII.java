/*
You are playing the following Flip Game with your friend: Given a string that
contains only these two characters: + and -, you and your friend take turns to
flip two consecutive "++" into "--". The game ends when a person can no longer
make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.
 */
public class FlipGameII {
    // Can use a map or set to memorize winning string and/or losing string
    // to reduce the complexity.
    public boolean canWin(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i) == s.charAt(i + 1)) {
                char[] ch = s.toCharArray();
                ch[i] = '-';
                ch[i + 1] = '-';
                // If the opponent cannot win, then this player can win.
                // For the first player to win, the second player cannot win.
                // If the the second player loses, then the first player wins.
                if (!canWin(new String(ch))) {
                    return true;
                }
            }
        }
        return false;
    }
}
