package bitburner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BB_Merge_Overlapping_Intervals {

    public static void main(String[] args) {
        //[[4,5],[25,34],[23,32],[4,7],[9,14],[14,16],[8,16],[3,9],[2,12],[11,16],[14,20]]
        //[[4,7]],[23,34],[8,16]
        int[][] arrays = new int[][]{
                new int[]{4,5},
                new int[]{25,34},
                new int[]{23,32},
                new int[]{4,7},
                new int[]{9,14},
                new int[]{14,16},
                new int[]{8,16},
                new int[]{3,9},
                new int[]{2,12},
                new int[]{11,16},
                new int[]{14,20}
        };

        List<int[]> processedArrays = new ArrayList<>();

        for (int i = 0; i < arrays.length-1; i++) {
            boolean isOverlap = false;
            int[] arrA = arrays[i];
            for (int j = i+1; j < arrays.length; j++) {
                int[] arrB = arrays[j];

                //check if arrays have intersection
                boolean isB0_between_A = (arrA[0] <= arrB[0] && arrB[0] <= arrA[1]);
                boolean isB1_between_A = (arrA[0] <= arrB[1] && arrB[1] <= arrA[1]);
                boolean isA0_between_B = (arrB[0] <= arrA[0] && arrA[0] <= arrB[1]);
                boolean isA1_between_B = (arrB[0] <= arrA[1] && arrA[1] <= arrB[1]);

                if (isB0_between_A || isB1_between_A || isA0_between_B || isA1_between_B) {
                    isOverlap = true;
                    //adjust the processed overlap to extend its bounds as needed
                    arrB[0] = Math.min(arrA[0], arrB[0]);
                    arrB[1] = Math.max(arrA[1], arrB[1]);
                    // break loop j
                    break;
                }
            }
            // should only reach here if no overlap found
            // only possible if the array is unique
            if (!isOverlap) {
                processedArrays.add(arrA);
            }
        }
        processedArrays.add(arrays[arrays.length-1]);

        processedArrays.sort(Comparator.comparingInt(arrA -> arrA[0]));

        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append("[").append(processedArrays.get(0)[0]).append(",").append(processedArrays.get(0)[1]).append("]");
        for (int i = 1; i < processedArrays.size() ; i++) {
            stringBuilder.append(",[").append(processedArrays.get(i)[0]).append(",").append(processedArrays.get(i)[1]).append("]");
        }
        stringBuilder.append("]");

        System.out.println(stringBuilder);
    }
}
