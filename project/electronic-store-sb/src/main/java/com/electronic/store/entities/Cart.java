package com.electronic.store.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {
	
	@Id
	private String cartId;
	
	private Date createdAt;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	//mapping card items
	@OneToMany(mappedBy  ="cart",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<CartItems>items=new ArrayList<>();

}
