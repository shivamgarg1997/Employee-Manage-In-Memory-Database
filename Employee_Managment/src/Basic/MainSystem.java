package Basic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainSystem {	
	public static void main(String[] args) throws IOException {
		System.out.println("---------------WELCOME TO THE EMPLOYEE MANAGEMENT SYSTEM----------");
		FileSystem fs = new FileSystem();
		fs.mapLoad();
		while(true) {
			try {
				BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
					
				System.out.println("What do you want to do? \n" + 
					"1. Enter an Employee \n2. Show all Employess \n" + 
					"3. Update an Employee \n4. Delete an Employee \n5. Exit");
					
				int res = Integer.parseInt(br.readLine());
				EmployeeManage em = new EmployeeManage();
				if(res == 1) {
					em.enterEmployee();			// new entry	
				} else if(res == 2) {
					em.displayInfo();		// show details	
				} else if(res == 3) {
					em.update();			// update employee		
				} else if(res == 4) {
					em.deleteEmp();			// delete an employee
				} else if(res == 5) {
					fs.writeMap();
					System.out.println("closing");
					break;						// break from loop 
				} else {
					System.out.println("----Please select from them-------");
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
