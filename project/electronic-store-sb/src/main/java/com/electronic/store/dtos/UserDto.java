package com.electronic.store.dtos;

import com.electronic.store.validate.ImageNameValid;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDto {

	private String userId;
	
	@Size(min=3,max=15,message="user name size should be in between (3,15)")
	private String name;
	
//	@Email(message="email format should be correct")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,}$",message="Invalid Email Format")
	@NotBlank(message="email is required")
	private String email;
	
	@NotBlank(message="password is required")
	private String password;
	
	@Size(min=4,max=6,message="gender should be either male or female")
	private String gender;
	
	@NotBlank
	private String about;
	
	@ImageNameValid
	private String imageName;
}
