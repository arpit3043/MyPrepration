package Matrix;
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int R = a.length;
        int C = a[0].length;
        spiralPrint(a);
    }
    private static void spiralPrint(int matrix[][]){
        if(matrix.length==0) {
            return;
        }
        int row=matrix.length;
        int column=matrix[0].length;
        int topRow=0;
        int bottomRow=row-1;
        int leftColumn=0;
        int rightColumn=column-1;
        while (topRow<=bottomRow && leftColumn<=rightColumn) {
            //toprow->leftcolumn-rightcolumn
            for (int i=leftColumn;i<=rightColumn ;i++) {
                System.out.print(matrix[topRow][i]+" ");
            }
            topRow++;
            //rightcolumn->toprow-bottomrow
            for (int j=topRow;j<=bottomRow; j++) {
                System.out.print(matrix[j][rightColumn]+" ");
            }
            rightColumn--;
            //bottomrow->rightcolumn-lastcolumn
            if(topRow<=bottomRow){
                for (int i=rightColumn; i>=leftColumn; i--){
                    System.out.print(matrix[bottomRow][i]+" ");
                }
                bottomRow--;
            }
            //leftcolumn->bottomrow-toprow
            if(leftColumn<=rightColumn) {
                for (int j=bottomRow;j>=topRow ;j--) {
                    System.out.print(matrix[j][leftColumn]+" ");
                }
                leftColumn++;
            }
        }
    }
}