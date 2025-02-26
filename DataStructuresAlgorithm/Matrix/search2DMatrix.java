package Matrix;
public class search2DMatrix {
    public static void main(String[] args) throws Exception {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int target = 13;
        System.out.println(searchElementIn2DMatrix(matrix, target));
    }

    private static boolean searchElementIn2DMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int beg = 0;
        int end = row * col - 1;
        while(beg <= end ) {
            int mid = beg + (end - beg)/2;
            int idx = matrix[mid / col][mid % col];
            if(idx == target) {
                return true;
            } else if(idx > target){
                end = mid-1;
            } else{
                beg = mid + 1;
            }
        }
        return false;
    }
}