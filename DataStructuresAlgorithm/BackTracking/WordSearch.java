package BackTracking;
public class WordSearch {
    public static void main(String[] args) throws Exception {
        char[][] board = {
                {'c', 'z', 'k', 'l'},
                {'o', 'd', 'i', 'a'},
                {'r', 'g', 'n', 'm'},
                {'m', 'r', 's', 'd'},
        };
        String word="coding";
        int N=board.length;
        int M= board[0].length;
        System.out.println(isWordPresent(board, word, N, M));
    }

    private static boolean isWordPresent(char[][] board, String word, int N, int M) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                char ch = word.charAt(0);
                if(board[i][j] == ch) {
                    if(isPresentHelper(i, j, board, word, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isPresentHelper(int r, int c, char[][] board, String word, int count) {
        int N=board.length;
        int M=board[0].length;
        int K=word.length();
        if(count == K) {
            return true;
        }
        char currChar = board[r][c];
        board[r][c] = '!';
        char nextChar = word.charAt(count);
        if(r>0 && board[r-1][c] == nextChar) {
            if(isPresentHelper(r-1, c, board, word, count+1)) {
                return true;
            }
        }
        if(r<N-1 && board[r+1][c] == nextChar) {
            if(isPresentHelper(r+1, c, board, word, count+1)) {
                return true;
            }
        }
        if(c>0 && board[r][c-1] == nextChar) {
            if(isPresentHelper(r, c-1, board, word, count+1)) {
                return true;
            }
        }
        if(c<M-1 && board[r][c+1] == nextChar) {
            if(isPresentHelper(r, c+1, board, word, count+1)) {
                return true;
            }
        }
        board[r][c] = currChar;
        return false;
    }
}