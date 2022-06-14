/**
 * CLASS: Searcher (GradebookWriter.java)
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

public class Searcher {
	// implement binary search algorithm: iterative (loop) or recursive
	
	public static int search(ArrayList<Student> pList, String pKey) {
		return recursiveBinarySearch(pList, pKey, 0, pList.size());
	}
	
	public static int recursiveBinarySearch(ArrayList<Student> pList, String pKey, int pLow, int pHigh) {
        if (pLow > pHigh) return -1;
        int middle = (pLow + pHigh) / 2;
        if (pKey.compareTo(pList.get(middle).getLastName())==0) return middle;
        //else if (pKey < pList.get(middle)) {
        else if (pKey.compareTo(pList.get(middle).getLastName())<0){
            return recursiveBinarySearch(pList, pKey, pLow, middle-1);
        } else {
            return recursiveBinarySearch(pList, pKey, middle+1, pHigh);
        }
    }
}
