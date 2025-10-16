package in.ineuron;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import in.ineuron.bo.MarraigeSeeker;
import in.ineuron.service.IMarraigeServiceMgmt;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext factory = SpringApplication.run(Application.class, args);

		IMarraigeServiceMgmt service = factory.getBean(IMarraigeServiceMgmt.class);

		try {
			String name = null;
			String address = null;
			Boolean isIndian = null;
			String photoPath = null;
			String bioDataPath = null;

			Scanner sc = new Scanner(System.in);

			System.out.println("Enter Name:");
			name = sc.next();
			System.out.println("Enter Address:");
			address = sc.next();
			System.out.println("Enter photoPath:");
			photoPath = sc.next();
			System.out.println("Enter bioDataPath:");
			bioDataPath = sc.next();
			System.out.println("Are you Indian?:");
			isIndian = sc.nextBoolean();

			// Input

			FileInputStream stream = new FileInputStream(photoPath);
			byte[] photo = new byte[stream.available()];
			stream.read(photo);

			File file = new File(bioDataPath);
			FileReader reader = new FileReader(file);
			char[] bioData = new char[(int) file.length()];
			reader.read(bioData);

			MarraigeSeeker seeker = new MarraigeSeeker(name, address, photo, bioData,
					LocalDateTime.of(1997, 04, 30, 10, 22, 43), isIndian);
			String marraigeSeeker = service.registerMarraigeSeeker(seeker);
			System.out.println(marraigeSeeker);

			stream.close();
			reader.close();
			sc.close();

			// Retrival Data

			Optional<MarraigeSeeker> data = service.searchById(1L);
			if (data.isPresent()) {
				MarraigeSeeker seeker1 = data.get();
				System.out.println(seeker1.getName());
				System.out.println(seeker1.getAddress());
				System.out.println(seeker1.getDob());
				System.out.println(seeker1.getIsIndian());

				// output

				OutputStream os = new FileOutputStream("retrival_photo.jpg");
				os.write(seeker1.getPhoto());
				os.flush();

				Writer writer = new FileWriter("retrival_biodata.txt");
				writer.write(seeker1.getBioData());
				writer.flush();

				os.close();

				writer.close();

				System.out.println("LOB Data Retrive");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		factory.close();

	}

}
