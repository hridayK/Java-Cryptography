class Matrix {
    int[] MatrixMul(int key[][],int txt[]){
        //running the matrix key.length times
        int arr[] = new int[txt.length];
        int pos=0;
        //print key
        // for(int i=0;i<key.length;i++){
        //     for(int j=0;j<key[i].length;j++){
        //         System.out.print(key[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        for(int i = 0; i<key.length; i++){
            for(int j = 0; j<key.length ; j++){
                //print val of j
                // System.out.println(j);
                // System.out.println("txt["+j+"]"+txt[j]);
                // System.out.println("key["+i+"]["+j+"]"+key[i][j]);
                arr[pos]+= (key[i][j]*txt[j]);
                //System.out.println("arr["+pos+"]"+arr[pos]);
            } 
            
            pos++;
        }
        return arr;
    }
    int[][] cofactorm(int ans[][], int i , int j, int arr[][])
    {
        int val1 = 0;
        int val2 = 0;
        for(int k = 0; k<ans.length; k++){
            if((i+1+j+1) % 2 == 0){
            for(int l = 0; l<ans.length; l++){
                
                    if(i==val1) {
                        val1++;
                        
                    }
                    if(j==val2){
                        val2++;
                    }
                    if(val1>arr.length-1 ){
                        val1=0;
                                                        
                    }
                    if(val2>arr.length-1){
                        val2=0;
                        
                    }
                    if(i==val1) {
                        val1++;
                        
                    }
                    if(j==val2){
                        val2++;
                    }
                   // System.out.println("J = "+j+" val 2 = " + val2);
                    ans[k][l] = arr[val1][val2];
                        val2++;
                }
                val1++;
            }
            if((i+1+j+1) % 2 != 0){
                for(int l = 0; l<ans.length; l++){
                    if(val1==i){
                        val1++;
                        }
                    if(val2==j){
                        val2++;
                    }
                    if(val1>arr.length-1 ){
                        val1=0;
                        if(val1==i && val2==j){
                            val1++;
                            val2++;
                        }
                        
                    }
                    if(val2>arr.length-1){
                        val2=0;
                        if(val1==i && val2==j){
                            val1++;
                            val2++;
                        }
                    }
                    if(i==val1) {
                        val1++;
                        
                    }
                    if(j==val2){
                        val2++;
                    }
                    ans[k][l] = (arr[val1][val2]) * -1;
                        val2++;
                }
                val1++;
            }
        } 
        return ans;
    }
    int[][] converter(int arr[][]){
        int ans[][] = new int[arr.length][arr.length];
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr.length; j++){
                if((i+1+j+1)%2 !=0){
                    ans[i][j]=arr[i][j]*-1;
                }
                else{
                    ans[i][j]=arr[i][j];
                }
            }

        }
        return ans;
    }
    int[][] cofactor(int arr[][]){
        int val1,val2;
        int ans[][] = new int[arr.length-1][arr.length-1];
        int transpose_array[][] = new int[ans.length][ans.length];
        int finalans[][] = new int[arr.length][arr.length];
        int finialfinalans[][] = new int[arr.length][arr.length];
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr.length; j++){
                 ans= cofactorm(ans,i,j,arr);
                transpose_array = transpose(ans);
            
            // //================
            // System.out.println("i = "+(i+1)+" j = "+(j+1));
            // System.out.println("\n=================\n");
            //  for(int k = 0; k<ans.length; k++){
            //      for(int l = 0; l<ans.length; l++){
            //           System.out.print(ans[k][l]+"  ");
            //          }
            //          System.out.println();
            //      }
            //      //transpose
                //  System.out.println("Transpose \ni = "+(i+1)+" j = "+(j+1));
                //  System.out.println("\n=================\n");
                //   for(int k = 0; k<transpose_array.length; k++){
                //       for(int l = 0; l<transpose_array.length; l++){
                //            System.out.print(transpose_array[k][l]+"  ");
                //           }
                //           System.out.println();
                //       }
            
                finalans[i][j] = determinant(transpose_array);
                
            
             }
        }
             finialfinalans= converter(finalans);
                // System.out.println("\n=================\n");
                  for(int k = 0; k<finialfinalans.length; k++){
                      for(int l = 0; l<finialfinalans.length; l++){
                          // System.out.print(finialfinalans[k][l]+"  ");
                          }
                         // System.out.println();
                      }
                      return finialfinalans;
    }
    
    //determinant of a Matrix by passing an array val 
    int determinant(int val[][]){
        int det = 0;
        if(val.length == 1){
            return val[0][0];
        }
        else{
            for(int i = 0; i<val.length; i++){
                int[][] sub = new int[val.length-1][val.length-1];
                for(int j = 1; j<val.length; j++){
                    int k = 0;
                    for(int l = 0; l<val.length; l++){
                        if(l == i){
                            continue;
                        }
                        sub[j-1][k] = val[j][l];
                        k++;
                    }
                }
                // //print val[0][i] and determinant of sub
                // if(i % 2 == 0){
                //     det += val[0][i] * determinant(sub);
                // }
                // else{
                //     det -= val[0][i] * determinant(sub);
                // }
                det += (int)Math.pow(-1,i)*val[0][i]*determinant(sub);
                //det += val[0][i]*determinant(sub);

            }
        }
        return det;
    }

    //transpose of a Matrix by passing an array val
    int[][] transpose(int val[][]){
        int tp[][] = new int[val.length][val.length];
        for(int i = 0; i<val.length; i++){
            for(int j = 0; j<val.length; j++){
                tp[i][j] = val[j][i];
            }
        }
        return tp;
    }
    //multiply matrix with value x
    int[][] multiply(int val[][], int x){
        int ans[][] = new int[val.length][val.length];
        for(int i = 0; i<val.length; i++){
            for(int j = 0; j<val.length; j++){
                ans[i][j] = val[i][j]*x;
            }
        }
        return ans;
    }
    

    
}