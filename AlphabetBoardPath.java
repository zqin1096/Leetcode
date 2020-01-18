public class AlphabetBoardPath {
    int[][] alphabet = new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}, {1, 0}, {1, 1}
            , {1, 2}, {1, 3}, {1, 4}, {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {3, 0}, {3, 1}, {3, 2}, {3, 3}
            , {3, 4}, {4, 0}, {4, 1}, {4, 2}, {4, 3}, {4, 4}, {5, 0}};

    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int[] location = new int[]{0, 0};
        char s = ' ';
        for (char c : target.toCharArray()) {
            sb.append(findNextAlphabet(location, c, s));
            s = c;
        }
        return sb.toString();
    }

    private String findNextAlphabet(int[] location, char c, char s) {
        StringBuilder sb = new StringBuilder();
        int[] nextLocation = alphabet[c - 'a'];
        int nextI = nextLocation[0];
        int nextJ = nextLocation[1];
        // If the starting alphabet is 'z', then moves vertically first.
        // Otherwise, moves horizontally first.
        if (s == 'z') {
            if (nextI > location[0]) {
                for (int i = 0; i < (nextI - location[0]); i++) {
                    sb.append("D");
                }
            } else if (nextI < location[0]) {
                for (int i = 0; i < (location[0] - nextI); i++) {
                    sb.append("U");
                }
            }
            if (nextJ > location[1]) {
                for (int i = 0; i < (nextJ - location[1]); i++) {
                    sb.append("R");
                }
            } else if (nextJ < location[1]) {
                for (int i = 0; i < (location[1] - nextJ); i++) {
                    sb.append("L");
                }
            }
        } else {
            if (nextJ > location[1]) {
                for (int i = 0; i < (nextJ - location[1]); i++) {
                    sb.append("R");
                }
            } else if (nextJ < location[1]) {
                for (int i = 0; i < (location[1] - nextJ); i++) {
                    sb.append("L");
                }
            }
            if (nextI > location[0]) {
                for (int i = 0; i < (nextI - location[0]); i++) {
                    sb.append("D");
                }
            } else if (nextI < location[0]) {
                for (int i = 0; i < (location[0] - nextI); i++) {
                    sb.append("U");
                }
            }
        }

        sb.append("!");
        location[0] = nextI;
        location[1] = nextJ;
        return sb.toString();
    }
}
