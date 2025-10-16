package in.ineuron.bo;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity

public class MarraigeSeeker implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public MarraigeSeeker (String name, String address, byte[] photo, char[] bioData, LocalDateTime dob,
			Boolean isIndian) {

		this.name = name;
		this.address = address;
		this.photo = photo;
		this.bioData = bioData;
		this.dob = dob;
		this.isIndian = isIndian;
	}

	private String name;
	private String address;
	@Lob
	private byte[] photo;
	@Lob
	private char[] bioData;
	private LocalDateTime dob;
	private Boolean isIndian;

	public MarraigeSeeker() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public char[] getBioData() {
		return bioData;
	}

	public void setBioData(char[] bioData) {
		this.bioData = bioData;
	}

	public LocalDateTime getDob() {
		return dob;
	}

	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}

	public Boolean getIsIndian() {
		return isIndian;
	}

	public void setIsIndian(Boolean isIndian) {
		this.isIndian = isIndian;
	}

	
}
