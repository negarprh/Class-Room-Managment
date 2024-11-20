import java.util.Scanner;

class Comp248secU_Dr {

    public static void main(String[] args) {
 
    	 System.out.println("Welcome to the Simple Classroom Managment System:");
    	 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
    	 
                Scanner input = new Scanner(System.in);
                System.out.println("Enter instructure's particulars (FirstName, LastName, LectureRoom, Semester, MaxClasssize) as a single line entry:)");
                
                String fName = input.next();
                String lName = input.next();
                String room = input.next();
                String semYr = input.next();
               
                int size = 0;
                
                if(input.hasNextInt()) {
                	size = input.nextInt();
                }
                else {
                	System.out.println ("Error: Your input/entry for 'MaxClassSize' is NOT a valid integer. Kindly retry again!");
                	System.exit(0);
                }

                
                Comp248secU comp248secU = new Comp248secU(fName, lName, room, semYr, size);
                
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
                
                
                byte option = 0 ; 
                if (input.hasNextByte()) {
                	option = input.nextByte();
                
                }
                
                else {
                	System.out.println("Error: Your input/entry is not a valid integer between -128 to 127. Kinfly retry again!");
                	System.exit(0);
                }

                if (option != 103 && option!= 106 && option!= 109 && option!= 112 && option!= 115 && option!= 118 && option!= 121 && option!= 124 && option!= 127 & option!= 0) {
                	
                	System.out.println("\nThank you for patronizing our Simple Classroom Mangement System.");
               
                }
                
                int indexArray = -1;
                
                while (true) {
                	
                switch (option) {
                
                //if the user enter 103
                case 103:
                	indexArray++;
                	
                	System.out.println("\n\nEnrlling New Student...");
                	System.out.println("---------------------------");
                	System.out.println("Enter student's particulars (FirstName, LastName, StudentID) as a single-line entry:");
                	
                	String studFname = input.next();
                	String studLname = input.next();
                	
                	if (indexArray >= size) {
                		int studID = input.nextInt();
                		System.out.println("Student with ID: "+studID+" CANNOT be added. Class is already full.");
                		indexArray--;
                }
                
                	else if (input.hasNextInt()) {
                		int studID = input.nextInt();
                		comp248secU.addStudent(studFname, studLname, studID, indexArray);
                		System.out.println("Student with ID: "+studID+" added successfully.");
                	}
                	
                	else {
                		System.out.println("Error: Your input/entry 'Student ID' is NOT a valid integer. Kindly retry again!");
                		input.next();
                	}
                	
                	System.out.println("Kindly continue by entering a Code, from the menu above, that corrponds to your task:");
                	option = input.nextByte();
                	break;
                	
                	//if the user enter 106
                case 106:
                	System.out.println("\n\nFinding Student's Position in Class List...");
                	System.out.println("---------------------------");
                	System.out.println("Enter Student ID");
                	
                	if (input.hasNextInt()) {
                		int studID = input.nextInt();
                		if (comp248secU.getStudentIdx(studID) == 9999999) {
                			System.out.println("Student with ID: "+studID+" does NOT exist.");
                		}
                		else {
                			comp248secU.getStudentIdx(studID);
                			System.out.println("The position of student with ID: "+studID+", in the class list, is:"+comp248secU.getStudentIdx(studID));
                		}
                		}
                	else 
                		System.out.println("Error: Your input/entry 'Student ID' is NOT a valid integer. Kinfly retry again!");
                	 input.next();
                
                
                System.out.println("Kindly continue by entering a Code, from the menu above, that corrponds to your task:");
            	option = input.nextByte();
            	break;
                
            	//if the user enter 109
                case 109:
              	  	System.out.println("\n\nRetrieving Student's Information");
              	  		System.out.println("------------------------------");
              	  		System.out.println("Enter StudentID: ");
              	  		
              	  		int studID = input.nextInt();
              	
              
              	  	  
              	  	  if(comp248secU.getStudentIdx(studID) == 9999999) {
              	  	   System.out.println("Student ID: "+studID+" does not exist");
              	  	   System.out.println("Unable to retrieve information for Student with ID: "+studID);
              	  	  }
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
              	  	  
              	  //if the user enter 112
              	  	  case 112:
              	  	   
              	  	  System.out.println("\n\nUnerolling Student...");
              	  	  System.out.println("---------------------------------");
              	  	  System.out.println("Enter StudentID: ");
              	  	  
              	  	      studID = input.nextInt();
              	  	      
              	  	      if(comp248secU.getStudentIdx(studID) == 1) {
              	  	       System.out.println("Student ID: "+studID+" does NOT exist.");
              	  	       System.out.println("Unable to retieve information for student with ID: "+studID);
              	  	      }
              	  	      else {comp248secU.getStudentIdx(studID);
              	  	      indexArray--;
              	  	      System.out.println("Successfully removed Student with ID: "+studID);  
              	  	      }
              	  	      System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: " ); 
              	  	   option = input.nextByte();
              	  	   break;
              	  	   
              	  	//if the user enter 115
              	  	  case 115:
              	  	   
              	  	   System.out.println("\n\nUpdating Student's Particulars...");
              	  	   System.out.println("---------------------------------");
              	  	   System.out.println("Enter update to student's particulars (FirstName, LastName, StudentID) as a single-line entry: ");
              	  	   
              	  	   fName = input.next();
              	  	   lName = input.next();
              	  	   studID = 0;
              	  	   
              	  	   if (input.hasNextInt()) {
              	  	    studID = input.nextInt();
              	  	    if (comp248secU.getStudentIdx(studID) == 1) {
              	  	     System.out.println("Student with ID: "+studID+" does NOT exist");
              	  	     System.out.println("Unable to retrieve information for Student with ID: " +studID);
              	  	     
              	  	    }
              	  	    else {
              	  	     comp248secU.updateStudentPart(fName, lName, studID);
              	  	     System.out.println("Successfully updated identification particulars for Student with ID: "+studID);
              	  	     
              	  	    }
              	  	    
              	  	   } else {
              	  	    System.out.println("Error: Your input/entry for 'Student ID' is NOT a valid integer. Kindly retry again!" );
              	  	    input.next();
              	  	   } 
              	  	   
              	  	   System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: " ); 
              	  	   option = input.nextByte();
              	  	   break;
              	  	    
              	  	//if the user enter 118
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
              	  	    if (comp248secU.getStudentIdx(studID) == 1) {
              	  	     System.out.println("Student with ID: "+studID+" does NOT exist");
              	  	     System.out.println("Unable to retrieve information for Student with ID: " +studID);
              	  	   
              	  	  }
              	  	    else {
              	  	     comp248secU.updateAssgtScore(a1, a2, a3, a4, studID);
              	  	     System.out.println("Successfully updated identification particulars for Student with ID: "+studID);
              	  	  }
              	  	    
              	  	   } else {
              	  	    System.out.println("Error: Your input/entry for 'Student ID' is NOT a valid integer. Kindly retry again!" );
              	  	    input.next();
              	  	   } 
              	  	   
              	  	   System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: " ); 
              	  	   option = input.nextByte();
              	  	   break;
              	  	   
              	  	//if the user enter 121
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
              	  	    if (comp248secU.getStudentIdx(studID) == 1) {
              	  	     System.out.println("Student with ID: "+studID+" does NOT exist");
              	  	     System.out.println("Unable to retrieve information for Student with ID: " +studID);
              	  	   
              	  	    }
              	  	    else {
              	  	     comp248secU.updateOtherScore(lab, test, exam, studID);
              	  	     System.out.println("Successfully updated identification particulars for Student with ID: "+studID);
              	  	     
              	  	    }
              	  	    
              	  	   } else {
              	  	    System.out.println("Error: Your input/entry for 'Student ID' is NOT a valid integer. Kindly retry again!" );
              	  	    input.next();
              	  	   } 
              	  	   
              	  	   System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: " ); 
              	  	   option = input.nextByte();
              	  	   break;
              	  	   
              	  	//if the user enter 124
              	  	  case 124:
              	  	  
              	  	   System.out.println("\n\nDisplaying Student's Report Card...");
              	  	   System.out.println("---------------------------------------");
              	  	   System.out.println("Enter StudentID: ");
              	  	   
              	  	   
              	  	   if (input.hasNextInt()) {
              	  	    studID = input.nextInt();
              	  	    if (comp248secU.getStudentIdx(studID) == 1) {
              	  	     System.out.println("Student with ID: "+studID+" does NOT exist");
              	  	     System.out.println("Unable to retrieve information for Student with ID: " +studID);
              	  	   
              	  	    }
              	  	    else {
              	  	     //comp248secU.updateOtherScore(lab, test, exam, studID);
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
              	  	    
              	  	   } else {
              	  	    System.out.println("Error: Your input/entry for 'Student ID' is NOT a valid integer. Kindly retry again!" );
              	  	    input.next();
              	  	   } 
              	  	   
              	  	   System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: " ); 
              	  	   option = input.nextByte();
              	  	   break;
              	  	   
              	  	//if the user enter 127
              	  	  case 127:
              	  	   System.out.println("Displaying Class Report Card...");
              	  	   System.out.println("-------------------------------");
              	  	   System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
              	  	   System.out.printf("%-16s %-16s %s %7s %7s %7s %7s %7s %7s %7s %8s %2s","First Name","Last Name","stud. ID", "A1", "A2", "A3", "A4", "Labs", "Test","Exam", "Wgt", "*");
              	  	   System.out.println("\n------------------------------------");
              	  	   
              	  	 for (int j=0;j<size;j++) {
              	  	  //  String fName=
              	  	   }
              	  	 
              	  	 
              	  	 
        	
              	
              	
              	
              	
              
              
              }
              
              
              
              
              
          }

    }
  }