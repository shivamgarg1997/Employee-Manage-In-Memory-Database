package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;


public class EmployeeManage {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void enterEmployee() throws Exception {
		try {
			Employee e = new Employee();
			e.setName(enterName());
			String[] names = Utility.parseName(e.getName());
			e.setFirstName(names[0]);
			e.setMiddleName(names[1]);
			e.setLastName(names[2]);
			e.setGender(enterGender());
			e.setDob(enterDob());
			e.setPhno(enterPhno());
			e.setEmail(enterEmail());
			e.setId(Utility.getMD5(e.getPhno(), e.getEmail()));			
			e.setAddress(enterAddress()); 
			e.setDept(enterDept());
			Mapper.put(e.getId(),e);	
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private String enterName() throws Exception {
		try {
			String tName = null;
			while(true) {
				System.out.println("Enter name");
				tName = br.readLine();
				if(Utility.isValidName(tName)) {
					return tName;
				}
				else System.out.println("Wrong input");;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	private String enterGender() throws Exception {
		try {
			while(true) {
				System.out.println("1. Male \n2. Female \n3. Transgender");
				int tGen = Integer.parseInt(br.readLine());
				if(Utility.isValidGender(tGen)) {
					return Employee.mapToGender(tGen);
				} else {
					System.out.println("Wrong input");
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	private String enterDob() throws Exception{
		try {
			while(true) {
				System.out.println("Enter Date Of Birth");			
				String tDate = br.readLine();
				if(Utility.isValidDate(tDate,"dd-mm-yyyy")) {
					return tDate;
				}
				else System.out.println("Wrong input ");		
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	private String enterPhno() throws Exception {
		try {
			while(true) {
				System.out.println("Enter Phone Number");
				String tPhno = br.readLine();
				if(Utility.isValidPhnoNumber(tPhno)) {
					return tPhno;
				}
				else System.out.println("Wrong input");;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	private String enterEmail() throws Exception {
		try {
			while(true) {
				System.out.println("Enter email");
				String tMail = br.readLine();
				if(Utility.isValidEmail(tMail)) 
					return tMail;
				
				else  System.out.println("Wrong input \n");;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	private String enterAddress() throws Exception {
		try {
			while(true) {
				System.out.println("Enter Address");
				String tAdd = br.readLine();
				if(Utility.isValidAddress(tAdd)) {
					return tAdd;
					
				}	
				else System.out.println("Wrong input \n");
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	private String enterDept() throws Exception {
		try {
			while(true) {
				System.out.println("Enter Department");
				int tDept = Integer.parseInt(br.readLine());
				if(Utility.isValidDept(tDept)) {
					return Employee.mapToDept(tDept);
				}
				else System.out.println("Wrong input \n"); 
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public void update() throws Exception {
		try {
			while(true) {
				System.out.println("Enter the ID of the Employee to be updated\n"
						+ "For Exit enter 0");
				String iD = br.readLine();
				if(Mapper.get(iD) != null){
					Employee e = Mapper.get(iD);				
					System.out.println("Employee Details");					
					display(e);
					while(true) {
						System.out.println("what do you want to update \n"
								+ "1. Name \n2. Address \n3. Phone Number \n4. Department \n"
								+ "5. Email \n6. Age \nFor Exit enter 0");
						int up_res = Integer.parseInt(br.readLine());
						if(up_res == 0){
							System.out.println("Taking you back\n");
							break;
						} else if(up_res == 1){
							e.setName(enterName());
						} else if(up_res == 2){
							e.setAddress(enterAddress());
						} else if(up_res == 3){
							e.setPhno(enterPhno());
						} else if(up_res == 4){
							e.setDept(enterDept());
						} else if(up_res == 5){
							e.setEmail(enterEmail());
						}  
						display(e);
					}
				}
				else {
					System.out.println("No such employee exists \n Please enter again");
				}
			}
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}		
	}
	
	public void deleteEmp() throws Exception {
		while(true){
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try{
				System.out.println("Enter the email of the employee to be deleted");
				String eMail = br.readLine();
				if(!Utility.isValidEmail(eMail)) {
					continue;
				}
				System.out.println("Enter the Phno of the employee to be deleted");
				String pHno = br.readLine();
				if(!Utility.isValidPhnoNumber(pHno)) {
					continue;
				}
				String iD = Utility.getMD5(pHno, eMail);
				boolean flag = false;
				
				Iterator<Map.Entry<String, Employee>> itr = Mapper.iterate();
				while(itr.hasNext()) {
					Map.Entry<String, Employee> entry = itr.next(); 
					if(iD.equals(entry.getKey())){
						flag = true;
						Mapper.remove(iD);
						System.out.println("The Employee has been deleted");
						break;
					}
				}
				if(!flag){
					System.out.println("There is no such employee \n Please enter a correct ID");
				}
				else 
					break;
			}catch(Exception e){}
			finally {
				br.close();
			}
		}
	}

	public void displayInfo() throws IOException {	
		
		  if(Mapper.size() == 0){
			  System.out.println("Currently there is no employee");
		  } else{
				 System.out.println("-----------------------------------------------------------------------------------" +
						 "----------------------------------------------------------------------------");
		  System.out.printf("%33s %2s %15s %2s %10s %2s %5s %2s %10s %2s %30s %2s %15s %2s %10s %2s"
				  ,"ID","|", "Name","|",
				  "Gender","|","Age","|","Phno","|","Email","|","Address","|","Dept","|");
		  System.out.println();
		  System.out.println("-----------------------------------------------------------------------------------" +
				  	"----------------------------------------------------------------------------"); 
		  Iterator<Map.Entry<String, Employee>> itr = Mapper.iterate();
		  while(itr.hasNext()) {
				Map.Entry<String, Employee> entry = itr.next(); 
				Employee p = entry.getValue();
				  System.out.printf("%33s %2s %15s %2s %10s %2s %5s %2s %10s %2s %30s %2s %15s %2s %10s %2s",p.getId(),"|",p.getName(),
						  "|",p.getGender(),"|",Utility.getRealTimeAge(p.getDob()),
						  "|",p.getPhno(),"|",p.getEmail(),"|"
						  ,p.getAddress(),"|",p.getDept(),"|");
				  
			  System.out.println(); } System.out.println();
			  System.out.println("-------------------------------------------------------------------------------" +
			  "--------------------------------------------------------------------------------");
		  }	
	}
	
	static void display(Employee p){
			System.out.println();
		  System.out.println("-----------------------------------------------------------------------------------" +
					 "----------------------------------------------------------------------------");
		  System.out.printf("%33s %2s %15s %2s %10s %2s %5s %2s %10s %2s %30s %2s %15s %2s %10s %2s"
				  ,"ID","|", "Name","|",
				  "Gender","|","Age","|","Phno","|","Email","|","Address","|","Dept","|");
		  System.out.println();
		  System.out.println("-----------------------------------------------------------------------------------" +
					 "----------------------------------------------------------------------------" ); 
		  System.out.printf("%33s %2s %15s %2s %10s %2s %5s %2s %10s %2s %30s %2s %15s %2s %10s %2s",p.getId(),"|",p.getName(),
				  "|",p.getGender(),"|",Utility.getRealTimeAge(p.getDob()),
				  "|",p.getPhno(),"|",p.getEmail(),"|"
				  ,p.getAddress(),"|",p.getDept(),"|");
		  System.out.println();
		  System.out.println();
		  System.out.println("-----------------------------------------------------------------------------------" +
					 "----------------------------------------------------------------------------");	 
	}
}
