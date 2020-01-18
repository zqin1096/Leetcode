public class StoneGame {
//    public boolean stoneGame(int[] piles) {
//        return pickPile(piles, 0, piles.length - 1, 0, 0);
//    }
//
//    private boolean pickPile(int[] piles, int start, int end, int alex,
//                             int lee) {
//        if (start >= end) {
//            return alex > lee;
//        }
//        return pickPile(piles, start + 2, end, alex + piles[start],
//                lee + piles[start + 1]) || pickPile(piles, start, end - 2,
//                alex + piles[end], lee + piles[end - 1]) || pickPile(piles,
//                start + 1, end - 1, alex + piles[start],
//                lee + piles[end]) || pickPile(piles, start + 1, end - 1,
//                alex + piles[end], lee + piles[start]);
//    }

    public boolean stoneGame(int[] piles) {
        // stones[i][j][0] represents the most the stones that Alex can get from
        // piles[i] to piles[j].
        // stones[i][j][1] represents the remaining stones that Lee can get from
        // piles[i] to piles[j].
        int[][][] stones = new int[piles.length][piles.length][2];
        // If there is only one pile of stone, then Alex will get the pile and
        // Lee will get nothing.
        for (int i = 0; i < piles.length; i++) {
            stones[i][i][0] = piles[i];
            stones[i][i][1] = 0;
        }
        // i represents the length (number of piles).
        for (int i = 2; i <= piles.length; i++) {
            // j represents the starting index.
            for (int j = 0; i + j - 1 < piles.length; j++) {
                if (piles[j] + stones[j + 1][i + j - 1][1] >= piles[i + j - 1] + stones[j][i + j - 2][1]) {
                    stones[j][i + j - 1][0] =
                            piles[j] + stones[j + 1][i + j - 1][1];
                    stones[j][i + j - 1][1] = stones[j + 1][i + j - 1][0];
                } else {
                    stones[j][i + j - 1][0] =
                            piles[i + j - 1] + stones[j][i + j - 2][1];
                    stones[j][i + j - 1][1] = stones[j][i + j - 2][0];
                }
            }
        }
        return stones[0][piles.length - 1][0] > stones[0][piles.length - 1][1];
    }
}
