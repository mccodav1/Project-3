/**
 * CLASS: Roster (Roster.java)
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
 * 
 * TEMPLATE AUTHOR
 * Kevin R. Burger (burgerk@asu.edu)
 * Computer Science & Engineering Program
 * Fulton Schools of Engineering
 * Arizona State University, Tempe, AZ 85287-8809
 * (c) Kevin R. Burger 2014-2019
 */
package proj3;

import java.util.ArrayList;

/**
 * The Roster class encapsulates an ArrayList<Student> object named mStudentList which stores the
 * information for each student that was read from "gradebook.dat" when the app started.
 */
public class Roster {

    /**
     * Declare mStudentList as ArrayList<Student>
     */
    private ArrayList<Student> mStudentList;

    /**
     * Roster()
     */
    public Roster() {
    	/* todo
    	 *	PSEUDOCODE:
    	 * method Roster()
    	 *     -- Note that mStudentList was already declared so we do not need to declare it here.
    	 *     -- What we need to do here is create the ArrayList<Student> object that mStudentList
    	 *     -- will refer to.
    	 *     create an ArrayList<Student> object and then pass that object as the argument to
    	 *     setStudentList() to make mStudentList refer to the ArrayList
    	 * end Roster
    	 */
    	setStudentList(new ArrayList<Student>);
    }

    /**
     * Adds pstudent to the ArrayList
     */
    public void addStudent(Student pStudent) {
    	/*
    	 * PSEUDOCODE:
    	 * method addStudent(pStudent : Student) : void
    	 *     add (will append) pStudent to mStudentList
    	 * end method
    	 */
    	mStudentList.add(pStudent);
    } // end addstudent, implemented

    /**
     * Searches mStudentList for a Student with pLastName.
     */
    public Student getStudent(String pLastName) {
    	/*
    	 * PSEUDOCODE:
    	 * method getStudent(pLastName : String) : Student
    	 *     -- Get the index of the student in the student list
    	 *     index = call Searcher.search(getStudentList(), pLastName)
    	 *     -- If index is -1 then no student with that last name could be found so we return
    	 *     -- null. Otherwise, we get the Student from the student list at the index and return
    	 *     -- the Student.
    	 *     if index == -1 then return null
    	 *     else return the Student object in getStudentList() at index 'index'
    	 * end getStudent
    	 */
    	int index = Searcher.search(getStudentList(), pLastName);
    	if (index==-1) return null;
    	else {
    		return getStudentList().get(index);
    	}
    } // end getstudent, implemented

    /**
     * getStudentList()
     *
     * Accessor method for mStudentList.
     *
     * Note: it is extremely sleazy to provide public access to the entire private student list
     * (mStudentList) in this way because it gives whoever calls this method the ability to
     * modify any Student in the roster. It would be better to have the Roster class implement an
     * iterator that would permit other objects to iterate over the elements of the list, but in an
     * effort to keep the project as simple as possible, I am taking the sleazy route.
     *
     * If you are so inclinded, by all means, implement the iterator.
     */
    public ArrayList<Student> getStudentList() {
        return mStudentList;
    }

    /**
     * setStudentList()
     *
     * Mutator method for mStudentList.
     */
    private void setStudentList(ArrayList<Student> pStudentList) {
        mStudentList = pStudentList;
    }

    /**
     * Called to sort the roster by last name.
     */
    public void sortRoster() {
    	/*
    	 * PSEUDOCODE:
    	 * method sortRoster()
    	 *     -- Note that all of the methods in Sorter are class methods, so we call the sort()
    	 *     -- method on the class Sorter.
    	 *     call Sorter.sort() passing the list of students returned from getStudentList()
    	 * end sortRoster
    	 */
    	Sorter.sort(getStudentList());
    } // end sortroster, implemented

    /**
     * Returns a String representation of this Roster. toString() methods are very handy for
     * debugging because given access to a Roster object, say named roster, then you can print
     * the entire roster in one statement: System.out.println(roster);
     */
    @Override
    public String toString() {
        String result = "";
        for (Student student : getStudentList()) {
            result += student + "\n";
        }
        return result;
    }
}
