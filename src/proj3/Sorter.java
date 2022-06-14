/**
 * CLASS: Sorter (Sorter.java)
 *
 * DESCRIPTION:
 * TODO INSERT DESCRIPTION HERE
 * 
 *
 * COURSE AND PROJECT INFO
 * CSE205 Object Oriented Programming and Data Structures, Summer 2022 C-Session
 * Project Number: p-03
 *
 * Group 4
 * AUTHOR: David McConnell  dmcconn7    dmcconn7@asu.edu
 * AUTHOR: Lia Moua         amoua       amoua@asu.edu
 * AUTHOR: Arsal Akhtar     akakhta2    akakhta2@asu.edu
 * AUTHOR: Kari McBride     kemcbri2    kemcbri2@asu.edu
 */

package proj3;

import java.util.ArrayList;

public class Sorter {	
    
    public static void sort(ArrayList<Student> pList) {
        quickSort(pList, 0, pList.size()-1);                
    }
    
    
    private static int partition(ArrayList<Student> pList, int fromIndex, int toIndex) {
        int leftIndex = fromIndex -1;
        int rightIndex = toIndex +1;
        Student pivot = pList.get(fromIndex);
        while (leftIndex < rightIndex) {
            leftIndex++;
            while (pList.get(leftIndex).compareTo(pivot) < 0) {
            //while (pList.get(leftIndex) < pivot) {
                leftIndex++;
            }
            rightIndex--;
            while (pList.get(rightIndex).compareTo(pivot) > 0) {
                rightIndex--;
            }
            if (leftIndex < rightIndex) {
                swap(pList, leftIndex, rightIndex);
            }
            
        }
        return rightIndex;        
    }
	
	public static void quickSort(ArrayList<Student> pList, int fromIndex, int toIndex) {
        if (fromIndex >= toIndex ) return;
        int partitionIndex = partition(pList, fromIndex, toIndex);
        quickSort(pList, fromIndex, partitionIndex);
        quickSort(pList, partitionIndex+1, toIndex);
    }
	
	private static void swap(ArrayList<Student> pList, int leftIndex, int rightIndex) {
        Student tmp = pList.get(leftIndex);
        pList.set(leftIndex, pList.get(rightIndex));
        pList.set(rightIndex, tmp);
    }
}
