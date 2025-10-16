package in.ineuron.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import in.ineuron.dto.StudentDTO;
import in.ineuron.service.IStudentService;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		IStudentService service = factory.getBean(IStudentService.class);
		String name = null, address = null, age = null, id = null;
		StudentDTO studentDTO = null;
		try {
			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("1. CREATE");
				System.out.println("2. READ BY ID");
				System.out.println("3. READ ALL RECORDS");
				System.out.println("4. UPDATE");
				System.out.println("5. DELETE WITH RESPECT TO ID");
				System.out.println("6. DELETE WITH RESPECT TO BEAN");
				System.out.println("7. EXIT");
				System.out.print("Your Option :: [1,2,3,4,5,6,7]:: ");
				Integer option = Integer.parseInt(br.readLine());
				switch (option) {
				case 1:
					System.out.println("Enter the name:");
					name = br.readLine();
					System.out.println("Enter the address:");
					address = br.readLine();
					System.out.println("Enter the age::");
					age = br.readLine();

					studentDTO = new StudentDTO();
					studentDTO.setSname(name);
					studentDTO.setSage(Integer.parseInt(age));
					studentDTO.setSaddress(address);

					int rowID = service.insert(studentDTO);
					System.out.println("Row ID:: " + rowID + " id affected");
					break;
				case 2:
					System.out.println("Enter the id of the record::");
					id=br.readLine();
					studentDTO=service.getStudent(Integer.parseInt(id));
					if (studentDTO != null) {
						System.out.println("Record info:: " + studentDTO);
					} else {
						System.out.println("Record not available for the given id :: " + id);
					}
					
					break;
				case 3:
					List<StudentDTO> students = service.getAllStudents();
					students.forEach(System.out::println);
					break;
				case 4:
					System.out.print("Enter the id of the record:: ");
					id = br.readLine();

					System.out.print("Enter the name:: ");
					name = br.readLine();

					System.out.print("Enter the age:: ");
					age = br.readLine();

					System.out.print("Enter the address:: ");
					address = br.readLine();

					studentDTO = new StudentDTO();
					studentDTO.setSid(Integer.parseInt(id));
					studentDTO.setSname(name);
					studentDTO.setSage(Integer.parseInt(age));
					studentDTO.setSaddress(address);
					service.update(studentDTO);
					break;
				case 5:
					System.out.print("Enter the id of the record which you want to delete:: ");
					id = br.readLine();
					service.delete(Integer.parseInt(id));
					
					break;
				case 6:
					System.out.print("Enter the id:: ");
					id = br.readLine();

					System.out.print("Enter the name:: ");
					name = br.readLine();

					System.out.print("Enter the age:: ");
					age = br.readLine();

					System.out.print("Enter the address:: ");
					address = br.readLine();

					studentDTO = new StudentDTO();
					studentDTO.setSid(Integer.parseInt(id));
					studentDTO.setSname(name);
					studentDTO.setSage(Integer.parseInt(age));
					studentDTO.setSaddress(address);

					service.delete(studentDTO);
					break;
				case 7:
					System.out.println("Thanks for using the application");
					System.exit(0);

				default:
					System.out.println("Plz enter the option like 1,2,3,4,5,6,7 for operation");
					break;

				}
			}

		} catch (DataAccessException de) {
			de.printStackTrace();
			System.out.println("DataAccessException is::" + de.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception is ::" + e.getMessage());
		} finally {
			factory.close();
		}

	}
}
