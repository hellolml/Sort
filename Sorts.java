public class Sorts {
    public static void insertSort(int []array){
        for(int i=0;i<array.length-1;i++){
            int key = array[i+1];
            int j;
            for (j=i;j>=0;j--){
                if(key>=array[j]){
                    break;
                }
            }
            for(int k=i;k>j;k--){
                array[k+1]=array[k];
            }
            array[j+1]=key;
        }
    }
    public static void insertSort2(int []array){
        for (int i=0;i<array.length-1;i++){
            int key = array[i+1];
            int j;
            for(j=i;j>=0&&key<=array[j];j--){
                array[j+1]=array[j];
            }
            array[j+1]=key;
        }
    }
    private static void Daying(int[]array){
        for (int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
    public static void shellSort(int[] array){
        int gap = array.length;
        while (true){
            gap = gap/3+1;
            insertSortWihtGap(array,gap);
            while (gap==1){
                return;
            }
        }
    }
    private static void insertSortWihtGap(int []array,int gap){
        for(int i=0;i<array.length-gap;i++){
            int key = array[i+gap];
            int j;
            for (j=i;j>=0&&key<array[j];j-=gap){
                array[j+gap]=array[j];
            }
            array[j+gap]= key;
        }
    }
    public static void selectSort(int []array){
        for(int i=0;i<array.length-1;i++){
            int max =0;
            for (int j=1;j<array.length-i;j++){
                if(array[j]>array[max]){
                      max = j;
                }
            }
            swap(array,max,array.length-i-1);
        }
    }
    private static void swap(int []array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void heapSort(int []array){
        creatHeap(array,array.length);
        for (int i=0;i<array.length-1;i++){
            swap(array,0,array.length-i-1);
            heapif(array,array.length-i-1,0);
        }
    }
    private static void creatHeap(int []array,int size){
        for (int i=(size-2)/2;i>=0;i--){
            heapif(array,size,i);
        }
    }
    private static void heapif(int []array,int size,int index){
       while (true){
           int left = 2*index+1;
           if(left>size){
               return;
           }
          int max = left;
          if(left+1<size){
             if(array[left+1]>array[left]){
                 max = left+1;
             }
          }
          if(array[index]>=array[max]){
              return;
          }
       swap(array,index,max);
          index = max;
       }
    }
    public static void main(String args[]){
        int []array = new int[]{1,2,4,6,3,3,7,9};
        insertSort(array);
        Daying(array);
        shellSort(array);
        Daying(array);
        selectSort(array);
        Daying(array);
        heapSort(array);
        Daying(array);
    }
}
