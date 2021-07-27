class Result {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
    // Write your code here
    int [][] squares = new int[][]{
        {8, 3, 4, 1, 5, 9, 6, 7, 2},
        {4, 3, 8, 9, 5, 1, 2, 7, 6},
        {8, 1, 6, 3, 5, 7, 4, 9, 2},
        {6, 1, 8, 7, 5, 3, 2, 9, 4},
        {2, 9, 4, 7, 5, 3, 6, 1, 8},
        {4, 9, 2, 3, 5, 7, 8, 1, 6},
        {2, 7, 6, 9, 5, 1, 4, 3, 8},
        {6, 7, 2, 1, 5, 9, 8, 3, 4}
    };
    int min = Integer.MAX_VALUE;
    
    List<Integer> flat = s.stream().flatMap(List::stream).collect(Collectors.toList());
        
        int [][] values = new int [3][3];

        int k = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                values[i][j] = flat.get(k); 
                k++;
            }
            
        }

    
    for(int i=0; i<squares.length; i++){
        int total = 0;
        for(int j=0; j<squares[i].length; j++){
            total += Math.abs(values[j/3][j%3]-squares[i][j]);
        }
        if(total < min) min = total;
    }
    return min;
    }

}