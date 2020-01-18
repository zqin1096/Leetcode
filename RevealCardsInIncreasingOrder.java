import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        // Sort the deck in increasing order.
        Arrays.sort(deck);
        List<Integer> cards = new LinkedList<>();
        // Add the largest card.
        cards.add(deck[deck.length - 1]);
        for (int i = deck.length - 2; i >= 0; i--) {
            // Remove the last card.
            int last = cards.remove(cards.size() - 1);
            // Add it to the top of of the cards.
            cards.add(0, last);
            cards.add(0, deck[i]);
        }
        int[] result = new int[deck.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = cards.get(i);
        }
        return result;
    }
}
