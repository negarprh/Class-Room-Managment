// This program build for Class management
// It is help instructor of COMP-248 course at the Gina Cody School of Computer Science and Engineering to manage the class
// Such as enrolling or unrolling students, Update assignment scores and so on.


import java.util.Scanner;
public class Comp248secU {

	Scanner in = new Scanner(System.in);
	 
	//All variables and attributes
	private static int classSize;
	private static String semesterYear;
	private static String lectureRoom;
	private static String instructorFname;
	private static String instructorLname;
	private String[] studFname;
	private String[] studLname;
	private int[] studID;
	private double[] assgt1;
	private double[] assgt2; 
	private double[] assgt3;
	private double[] assgt4;
	private double[] labs;
	private double[] midTerm;
	private double[] finalExam;
	
	//Building Comp248secU method
	public Comp248secU(String fName, String lName, String room, String semYr, int size) {
		this.instructorFname = fName;
		this.instructorLname = lName;
		this.lectureRoom = room;
		this.semesterYear = semYr;
		this.classSize = size;
		this.studFname = new String[size];
		this.studLname = new String[size];
		this.studID = new int[size];
		this.assgt1 = new double [size];
		this.assgt3 = new double [size];
		this.assgt2 = new double [size];
		this.assgt4 = new double [size];
		this.labs = new double [size];
		this.midTerm = new double [size];
		this.finalExam = new double [size];
		
		
	}
	
	// Defining the addStudent method
	public void addStudent (String fname, String lname, int studID, int arrIdx) {
		this.studFname[arrIdx] = fname;
		this.studLname [arrIdx] = lname;
		this.studID [arrIdx] = studID;
	}
	
	
	// Defining the getStudentIdx method
	public int getStudentIdx (int studID) {
		for(int i = 0; i<this.studID.length; i++) {
			if (this.studID[i] == studID) {
		return i;
		}
	}
		return 99;
	}
	
	// Defining the getStudentInfo method
	private String[] studentAttributes = new String [10];
	public String[] getStudentInfo (int studID) {
		this.studentAttributes[0] = this.studFname[getStudentIdx(studID)];
		this.studentAttributes[1] = this.studLname[getStudentIdx(studID)];
		this.studentAttributes[2] = this.studID[getStudentIdx(studID)]+"";
		this.studentAttributes[3] = this.assgt1[getStudentIdx(studID)]+"";
		this.studentAttributes[4] = this.assgt2[getStudentIdx(studID)]+"";
		this.studentAttributes[5] = this.assgt3[getStudentIdx(studID)]+"";
		this.studentAttributes[6] = this.assgt4[getStudentIdx(studID)]+"";
		this.studentAttributes[7] = this.labs[getStudentIdx(studID)]+"";
		this.studentAttributes[8] = this.midTerm[getStudentIdx(studID)]+"";
		this.studentAttributes[9] = this.finalExam[getStudentIdx(studID)]+"";
		return studentAttributes;
	}
	
	// Defining the delStudent method
	public int delStudent (int studID) {
		for (int s = getStudentIdx(studID); s < this.classSize-1 ; s++) {
			this.studFname[s] = this.studFname[s+1];
			this.studLname[s] = this.studLname[s+1];
			this.studID[s] = this.studID[s+1];
			this.assgt1[s] = this.assgt1[s+1];
			this.assgt2[s] = this.assgt2[s+1];
			this.assgt3[s] = this.assgt3[s+1];
			this.assgt4[s] = this.assgt4[s+1];
			this.labs[s] = this.labs[s+1];
			this.midTerm[s] = this.midTerm[s+1];
			this.finalExam[s] = this.finalExam[s+1];
			
			}
		
		// Putting the default data as zero or null
		this.studFname[this.classSize-1] = null;
		this.studLname[this.classSize-1] = null;
		this.studID[this.classSize-1] = 0;
		this.assgt1[this.classSize-1] = 0.0;
		this.assgt2[this.classSize-1] = 0.0;
		this.assgt3[this.classSize-1] = 0.0;
		this.assgt4[this.classSize-1] = 0.0;
		this.labs[this.classSize-1] = 0.0;
		this.midTerm[this.classSize-1] = 0.0;
		this.finalExam[this.classSize-1] = 0.0;
		
		return 99;
		}
		
	// Defining the updateStudentPart method
	public int updateStudentPart (String fname, String lname, int studID) {
		this.studFname [getStudentIdx(studID)] = fname;
		this.studLname [getStudentIdx(studID)] = lname;
		this.studID [getStudentIdx(studID)] = studID;
		return 99;
	}
	
	// Defining the updateAssgtScore method
	public int updateAssgtScore (double a1, double a2, double a3, double a4, int studID) {
		this.assgt1 [getStudentIdx(studID)]= a1;
		this.assgt2 [getStudentIdx(studID)] = a2;
		this.assgt3 [getStudentIdx(studID)] = a3;
		this.assgt4 [getStudentIdx(studID)] = a4;
		this.studID [getStudentIdx(studID)] = studID;
		return 99;
	}
	
	// Defining the updateOtherScore method
	public int updateOtherScore (double lab, double test, double exam, int studID) {
		this.labs [getStudentIdx(studID)] = lab;
		this.midTerm [getStudentIdx(studID)] = test;
		this.finalExam [getStudentIdx(studID)] = exam;
		this.studID [getStudentIdx(studID)] = studID;
		return 99;

	}
	
	//Defining computeWeightScore method via using formula
	public double computeWeightScore (int studID) {
		double wgtScore =0;
		
		wgtScore = (0.02 *(this.assgt1[getStudentIdx(studID)]/20)+0.03*(this.assgt2[getStudentIdx(studID)]/20)+0.05*(this.assgt3[getStudentIdx(studID)]/20)
			    +0.08 *(this.assgt4[getStudentIdx(studID)]/20)+0.12*(this.labs[getStudentIdx(studID)]/12)+0.30*(this.midTerm[getStudentIdx(studID)]/30)
			    +0.4*(this.finalExam[getStudentIdx(studID)]/40))*100;
		return wgtScore ;
		
		
	}

	// Defining computeGrade method via using formula (Calculated the grades using weight score
	// which Calculated before
	public static char computeGrade (double wgtScore) {
		  char letterGrade=' ';
		  if (wgtScore >= 88)
		   letterGrade = 'A';
		  else if (wgtScore >= 80)
		   letterGrade = 'B';
		  else if (wgtScore >= 67)
		   letterGrade = 'C';
		  else if (wgtScore >= 60)
		   letterGrade = 'D';
		  else 
		   letterGrade = 'F';
		return letterGrade;
		
	}

	
	// Defining findMin method
	public static double findMin(double[] dataArr) {
		  double min = dataArr[0];
		  for (int j = 0 ; j< classSize-1 ; j++) {
		   if (dataArr[j] < min) {
		    dataArr[j] = min;
		   }
		 }
		  return min;
	 }
				
	
	// Defining findMax method
	public static double findMax(double[] dataArr) {
		  double max = dataArr[0];
		   for (int j = 0 ; j < dataArr.length ; j++) {
		    if (dataArr[j] > max) {
		     dataArr[j] = max;
		    }
		  }
		  return max;
	}
	
	// Defining findAvg method
	public static double findAvg(double[] dataArr) {
		   double sum = 0;
		   for (int i = 0 ; i < dataArr.length ; i++) {
		    sum += dataArr[i];
		     }
		   double average = sum / (dataArr.length);
		   return average;
	}
	
	// Defining getClassMin method
	public double[] getClassMin() {
		 double [] getClassMin = new double[7];
		   getClassMin[0] = findMin(this.assgt1);
		   getClassMin[1] = findMin(this.assgt2);
		   getClassMin[2] = findMin(this.assgt3);
		   getClassMin[3] = findMin(this.assgt4);
		   getClassMin[4] = findMin(this.labs);
		   getClassMin[5] = findMin(this.midTerm);
		   getClassMin[6] = findMin(this.finalExam);

		   System.out.printf("%-15s%-15s%-15.2f%-15.2f%-15.2f%-15.2f%-15.2f%-15.2f%-15.2f","","Minimum Score in Class:",findMin(this.assgt1),findMin(this.assgt2),findMin(this.assgt3)
					,findMin(this.assgt4), findMin(this.labs),findMin(this.midTerm),findMin(this.finalExam));
			System.out.println();
			return getClassMin;
		}

	// Defining getClassMax method
	public double[] getClassMax() {
		   double [] getClassMax = new double[7];
		   getClassMax[0] = findMax(this.assgt1);
		   getClassMax[1] = findMax(this.assgt2);
		   getClassMax[2] = findMax(this.assgt3);
		   getClassMax[3] = findMax(this.assgt4);
		   getClassMax[4] = findMax(this.labs);
		   getClassMax[5] = findMax(this.midTerm);
		   getClassMax[6] = findMax(this.finalExam);
		   
			System.out.printf("%-15s%-15s%-15.2f%-15.2f%-15.2f%-15.2f%-15.2f%-15.2f%-15.2f","","Maximum Score in Class:",findMax(this.assgt1),findMax(this.assgt2),findMax(this.assgt3)
					,findMax(this.assgt4), findMax(this.labs),findMax(this.midTerm),findMax(this.finalExam));
			System.out.println();
			return getClassMax;
	}
	
	// Defining getClassAvg method
	public double[] getClassAvg() {
		 double [] getClassAvg = new double[7];
		    getClassAvg[0] = findAvg(this.assgt1);
		    getClassAvg[1] = findAvg(this.assgt2);
		    getClassAvg[2] = findAvg(this.assgt3);
		    getClassAvg[3] = findAvg(this.assgt4);
		    getClassAvg[4] = findAvg(this.labs);
		    getClassAvg[5] = findAvg(this.midTerm);
		    getClassAvg[6] = findAvg(this.finalExam);

			System.out.printf("%-15s%-15s%-15.2f%-15.2f%-15.2f%-15.2f%-15.2f%-15.2f%-15.2f","","Average Score in Class:",findAvg(this.assgt1),findAvg(this.assgt2),findAvg(this.assgt3)
					,findAvg(this.assgt4), findAvg(this.labs),findAvg(this.midTerm),findAvg(this.finalExam));
			System.out.println();
			
			return getClassAvg;	
	}
	
	// define classReportCard method    
	 public void classReportCard() {
	   for (int i= 0; i<classSize; i++) {
		   
		   String FirstName = studFname[i];
		   String LastName = studLname[i];
		   int studID = this.studID[i];
		   double a1 = this.assgt1[i];
		   double a2=this.assgt2[i];
		   double a3=this.assgt3[i];
		   double a4=this.assgt4[i];
		   double labs= this.labs[i];
		   double Midterm=this.midTerm[i];
		   double finalExam=this.finalExam[i] ;
		   
		   System.out.printf("%-16s%-16s%8d%7.2f%7.2f%7.2f%7.2f%7.2f%7.2f%7.2f%8.2f%2s%n",FirstName,LastName,
					studID,a1,a2,a3,a4,labs,Midterm,finalExam,computeWeightScore(this.studID[i]),computeGrade(computeWeightScore(this.studID[i]))) ;
		   System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		}
	 }
	 
	 public static void main(String[] args) {
		 
		 //Display Welcome massage
    	 System.out.println("Welcome to the Simple Classroom Managment System:");
    	 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
    	 
    	// Asking the user to enter the instructor's first name and last name, the semester and the maximum class capacity
         Scanner input = new Scanner(System.in);
         System.out.println("Enter instructure's particulars (FirstName, LastName, LectureRoom, Semester, MaxClasssize) as a single line entry:");
                
         // Declaration of Variables
                String fName = input.next();
                String lName = input.next();
                String room = input.next();
                String semYr = input.next();
                int size = 0;
                
                if(input.hasNextInt()) {
                	size = input.nextInt();
                }
                //If the user enter invalid integer
                else {
                	System.out.println ("Error: Your input/entry for 'MaxClassSize' is NOT a valid integer. Kindly retry again!");
                	System.exit(0);
                }

         // Getting access to Comp248secU method 
                Comp248secU comp248secU = new Comp248secU(fName, lName, room, semYr, size);
                
         // Codes' instructions
                System.out.println("Code => Description");
                System.out.println("--------------------");
                System.out.println("103 => Enrol New Student");
                System.out.println("106 => Find Student Position in Class List ");
                System.out.println("109 => Retrieve Student's Information");
                System.out.println("112 => Unenrol Student");
                System.out.println("115 => Update Student's Particulars");
                System.out.println("118 => Update Assigment Scores ");
                System.out.println("121 => Update Other Scores");
                System.out.println("124 => Display Student's Report card");
                System.out.println("127 => Display Class Report Card");
                System.out.println("0 ===> Exit");
                System.out.print("Please enter a Code, from the aformentioed, that corresponds to your task:");
                
                
          //If  the user input 0 as an input
                byte option = 0 ; 
                if (input.hasNextByte()) {
                	option = input.nextByte();
                
                }
                
           //If the user enters invalid integer between that is not between -128 to 127 
                else {
                	System.out.println("Error: Your input/entry is not a valid integer between -128 to 127. Kinfly retry again!");
                	System.exit(0);
                }

                if (option != 103 && option!= 106 && option!= 109 && option!= 112 && option!= 115 && option!= 118 && option!= 121 && option!= 124 && option!= 127 & option!= 0) {
                	
                	System.out.println("\nThank you for patronizing our Simple Classroom Mangement System.");
               
                }
                
                int indexArray = -1;
                
                while (true) {
                	
                //Switch key	
                switch (option) {
                
                //If the user enter 103 c
                case 103:
                	indexArray++;
                	
                	System.out.println("\n\nEnrlling New Student...");
                	System.out.println("---------------------------");
                	System.out.println("Enter student's particulars (FirstName, LastName, StudentID) as a single-line entry:");
                	
                	String studFname = input.next();
                	String studLname = input.next();
                	
                	// If the user add students more than the capacity of class capacity
                	if (indexArray >= size) {
                		int studID = input.nextInt();
                		System.out.println("Student with ID: "+studID+" CANNOT be added. Class is already full.");
                		indexArray--;
                }
                
                // Enrolling new students
                	else if (input.hasNextInt()) {
                		int studID = input.nextInt();
                		comp248secU.addStudent(studFname, studLname, studID, indexArray);
                		System.out.println("Student with ID: "+studID+" added successfully.");
                	}
                	
               //The user enter invalid integer
                	else {
                		System.out.println("Error: Your input/entry 'Student ID' is NOT a valid integer. Kindly retry again!");
                		input.next();
                	}
                	
                	System.out.println("Kindly continue by entering a Code, from the menu above, that corrponds to your task:");
                	option = input.nextByte();
                	break;
                	
                	//If the user enter 106 as an input
                case 106:
                	System.out.println("\n\nFinding Student's Position in Class List...");
                	System.out.println("---------------------------");
                	System.out.println("Enter Student ID");
                	
                	if (input.hasNextInt()) {
                		int studID = input.nextInt();
                		
                		//If the user add an ID which is not added before to the class
                		if (comp248secU.getStudentIdx(studID) == 9999999) {
                			System.out.println("Student with ID: "+studID+" does NOT exist.");
                		}
                		
                		//Getting student ID
                		else {
                			comp248secU.getStudentIdx(studID);
                			System.out.println("The position of student with ID: "+studID+", in the class list, is:"+comp248secU.getStudentIdx(studID));
                			}
                		}
                	
                	 //The user enter invalid integer
                	else 
                		System.out.println("Error: Your input/entry 'Student ID' is NOT a valid integer. Kinfly retry again!");
                	 input.next();
                
                
                System.out.println("Kindly continue by entering a Code, from the menu above, that corrponds to your task:");
            	option = input.nextByte();
            	break;
                
            	//If the user enter 109 as an input
                case 109:
              	  	System.out.println("\n\nRetrieving Student's Information");
              	  		System.out.println("------------------------------");
              	  		System.out.println("Enter StudentID: ");
              	  		
              	  		int studID = input.nextInt();
              	
              
              	  //If the user add an ID which is not added before to the class
              	  	  if(comp248secU.getStudentIdx(studID) == 9999999) {
              	  	   System.out.println("Student ID: "+studID+" does not exist");
              	  	   System.out.println("Unable to retrieve information for Student with ID: "+studID);
              	  	  }
              	  	  
              	 //Printing the default data to the user
              	  	  else {
              	  	   System.out.println("Student's First Name = "+comp248secU.getStudentInfo(studID)[0]);
              	  	   System.out.println("Student's Last Name = "+comp248secU.getStudentInfo(studID)[1]);
              	  	   System.out.println("Student's ID = "+comp248secU.getStudentInfo(studID)[2]);
              	  	   System.out.println("Score in Assignment 1 = "+comp248secU.getStudentInfo(studID)[3]);
              	  	   System.out.println("Score in Assignment 2 = "+comp248secU.getStudentInfo(studID)[4]);
              	  	   System.out.println("Score in Assignment 3 = "+comp248secU.getStudentInfo(studID)[5]);
              	  	   System.out.println("Score in Assignment 4 = "+comp248secU.getStudentInfo(studID)[6]);
              	  	   System.out.println("Cumulative Score in Labs  = "+comp248secU.getStudentInfo(studID)[7]);
              	  	   System.out.println("Mid-Term = "+comp248secU.getStudentInfo(studID)[8]);
              	  	   System.out.println("Final Examination Score = "+comp248secU.getStudentInfo(studID)[9]);
              	  	  }
              	  	  System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: " ); 
              	  	  option = input.nextByte();
              	  	  break;
              	  	  
              	  //If the user enter 112 as an input
              	  	  case 112:
              	  	   
              	  	  System.out.println("\n\nUnerolling Student...");
              	  	  System.out.println("---------------------------------");
              	  	  System.out.println("Enter StudentID: ");
              	  	  
              	  	      studID = input.nextInt();
              	  	      
              	  	//If the user add an ID which is not added before to the class
              	  	      if(comp248secU.getStudentIdx(studID) == 1) {
              	  	       System.out.println("Student ID: "+studID+" does NOT exist.");
              	  	       System.out.println("Unable to retieve information for student with ID: "+studID);
              	  	      }
              	  	      
              	  	//Removing the student from class
              	  	      else {comp248secU.getStudentIdx(studID);
              	  	      indexArray--;
              	  	      System.out.println("Successfully removed Student with ID: "+studID);  
              	  	      }
              	  	      System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: " ); 
              	  	   option = input.nextByte();
              	  	   break;
              	  	   
              	  	   
              	  	//if the user enter 115 as an integer
              	  	  case 115:
              	  	   
              	  	   System.out.println("\n\nUpdating Student's Particulars...");
              	  	   System.out.println("---------------------------------");
              	  	   System.out.println("Enter update to student's particulars (FirstName, LastName, StudentID) as a single-line entry: ");
              	  	   
              	  	   fName = input.next();
              	  	   lName = input.next();
              	  	   studID = 0;
              	  	   
              	  	   
              	  	   if (input.hasNextInt()) {
              	  	    studID = input.nextInt();
              	  	    
              	  	//If the user add an ID which is not added before to the class
              	  	    if (comp248secU.getStudentIdx(studID) == 1) {
              	  	     System.out.println("Student with ID: "+studID+" does NOT exist");
              	  	     System.out.println("Unable to retrieve information for Student with ID: " +studID);
              	  	    }
              	  	    
              	  	//Updating student's first name and last name 
              	  	    else {
              	  	     comp248secU.updateStudentPart(fName, lName, studID);
              	  	     System.out.println("Successfully updated identification particulars for Student with ID: "+studID);
              	  	     
              	  	    }
              	  	    
              	  	   }
              	  	//The user enter invalid integer
              	  	    else {
              	  	    System.out.println("Error: Your input/entry for 'Student ID' is NOT a valid integer. Kindly retry again!" );
              	  	    input.next();
              	  	   } 
              	  	   
              	  	   System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: " ); 
              	  	   option = input.nextByte();
              	  	   break;
              	  	    
              	  	//if the user enter 118 as an input
              	  	  case 118:
              	  	   
              	  	   System.out.println("\n\nUpdating Assigment Scores...");
              	  	   System.out.println("--------------------------------");
              	  	   System.out.println("Enter update to student's Assigments' scores (Assignment 1, Assignment 2, Assignment 3, Assignment 4, StudentID) as a single-line entry: ");
              	  	  
              	  	   int a1 = input.nextInt();
              	  	   int a2 = input.nextInt();
              	  	   int a3 = input.nextInt();
              	  	   int a4 = input.nextInt();
              	  	   studID = 0;
              	  	   
              	  	   if (input.hasNextInt()) {
              	  	    studID = input.nextInt();
              	  	//If the user add an ID which is not added before to the class
              	  	    if (comp248secU.getStudentIdx(studID) == 99) {
              	  	     System.out.println("Student with ID: "+studID+" does NOT exist");
              	  	     System.out.println("Unable to retrieve information for Student with ID: " +studID);
              	  	   
              	  	  }
              	  	//Updating student's assignments score 1 & 2 & 3 & 4 	
              	  	    else {
              	  	     comp248secU.updateAssgtScore(a1, a2, a3, a4, studID);
              	  	     System.out.println("Successfully updated identification particulars for Student with ID: "+studID);
              	  	  }
              	  	    
              	  	//The user enter invalid integer
              	  	   } else {
              	  	    System.out.println("Error: Your input/entry for 'Student ID' is NOT a valid integer. Kindly retry again!" );
              	  	    input.next();
              	  	   } 
              	  	   
              	  	   System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: " ); 
              	  	   option = input.nextByte();
              	  	   break;
              	  	   
              	  	//if the user enter 121 as an input
              	  	  case 121:
              	  	   
              	  	   System.out.println("\n\nUpdating Assigment Scores...");
              	  	   System.out.println("--------------------------------");
              	  	   System.out.println("Enter update to student's other scores (CumulativeLabs, MidTerm, FinalExam, StudentID) as a single-line entry: ");
              	  	  
              	  	   int lab = input.nextInt();
              	  	   int test = input.nextInt();
              	  	   int exam = input.nextInt();
              	  	   studID = 0;
              	  	   
              	  	   if (input.hasNextInt()) {
              	  	    studID = input.nextInt();
              	  	//If the user add an ID which is not added before to the class
              	  	    if (comp248secU.getStudentIdx(studID) == 1) {
              	  	     System.out.println("Student with ID: "+studID+" does NOT exist");
              	  	     System.out.println("Unable to retrieve information for Student with ID: " +studID);
              	  	   
              	  	    }
              	  	// Updating Assignments' scores
              	  	    else {
              	  	     comp248secU.updateOtherScore(lab, test, exam, studID);
              	  	     System.out.println("Successfully updated identification particulars for Student with ID: "+studID);
              	  	     
              	  	    }
              	  	   
              	  	   } 
              	  	   
              	  	//The user enters an ID that is not a valid integer
              	  	   else {
              	  	    System.out.println("Error: Your input/entry for 'Student ID' is NOT a valid integer. Kindly retry again!" );
              	  	    input.next();
              	  	   } 
              	  	   
              	  	   System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: " ); 
              	  	   option = input.nextByte();
              	  	   break;
              	  	   
              	  	//if the user enter 124 as an input
              	  	  case 124:
              	  	  
              	  	   System.out.println("\n\nDisplaying Student's Report Card...");
              	  	   System.out.println("---------------------------------------");
              	  	   System.out.println("Enter StudentID: ");
              	  	   
              	  	   
              	  	   if (input.hasNextInt()) {
              	  	    studID = input.nextInt();
              	  	    
              	  	//If the user add an ID which is not added before to the class
              	  	    if (comp248secU.getStudentIdx(studID) == 1) {
              	  	     System.out.println("Student with ID: "+studID+" does NOT exist");
              	  	     System.out.println("Unable to retrieve information for Student with ID: " +studID);
              	  	   
              	  	    }
              	  	    
              	  	    //Printing student data
              	  	    else {
              	  	  
              	  	     System.out.println("Student's First Name = "+comp248secU.getStudentInfo(studID)[0]);
              	  	     System.out.println("Student's Last Name = "+comp248secU.getStudentInfo(studID)[1]);
              	  	     System.out.println("Student's ID = "+comp248secU.getStudentInfo(studID)[2]);
              	  	     System.out.println("Score in Assigment 1  = "+comp248secU.getStudentInfo(studID)[3]);
              	  	     System.out.println("Score in Assigment 2  = "+comp248secU.getStudentInfo(studID)[4]);
              	  	     System.out.println("Score in Assigment 3  = "+comp248secU.getStudentInfo(studID)[5]);
              	  	     System.out.println("Score in Assigment 4  = "+comp248secU.getStudentInfo(studID)[6]);
              	  	     System.out.println("Cumulative Score in Labs  = " +comp248secU.getStudentInfo(studID)[7]);
              	  	     System.out.println("Mid-Term Test Score  = "+comp248secU.getStudentInfo(studID)[8]);
              	  	     System.out.println("Final Examination Score  = "+comp248secU.getStudentInfo(studID)[9]);
              	  	     System.out.println("-------------------------------");
              	  	     System.out.println("Student's Cummulativve Weighted Score ="+comp248secU.computeWeightScore(studID));
              	  	     System.out.println("Student's Final Letter Grade =");
              	  	    }
              	  	    
              	  	   }
              	  	   
              	  	//if user enters an ID which is not a valid integer
              	  	   else {
              	  	    System.out.println("Error: Your input/entry for 'Student ID' is NOT a valid integer. Kindly retry again!" );
              	  	    input.next();
              	  	   } 
              	  	   
              	  	   System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: " ); 
              	  	   option = input.nextByte();
              	  	   break;
              	  	   
              	  	//if the user enter 127 as an input
              	  	case 127:
            			System.out.println("\n\nDisplaying Class Report Card...");
            			System.out.println("-------------------------------");
            			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
            			System.out.printf("%-16s%-16s%s%7s%7s%7s%7s%7s%7s%7s%8s%2s","First Name","Last Name","stud.ID", "A1", "A2", "A3", "A4", "Labs", "Test","Exam", "Wgt.", "*");
            			System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------");
            			
            			comp248secU.classReportCard();
            			
            			comp248secU.getClassMin();
            			comp248secU.getClassAvg();
            			comp248secU.getClassMax();
            			
            			System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: " );	
            			option = input.nextByte();
            			break;

              
              
              }
              
              
              
              
              
          }

	 }
}
//Q1
