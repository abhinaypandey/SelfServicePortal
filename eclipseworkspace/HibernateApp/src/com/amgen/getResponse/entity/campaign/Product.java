/**
 * 
 */
package com.amgen.getResponse.entity.campaign;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;





/**
 * Model class for Person
 */
@Entity
@Table(name="Product")

/**
 * @author chaudmee
 *
 */
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "PRODUCTNAME", unique = true)
	private String productname;
	
	@OneToMany(mappedBy= "product", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Collection<Campaign> campaign = new ArrayList<Campaign>();
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

    public Product(Collection<Campaign> campaign) {
		super();
		this.campaign = campaign;
	}


    public Product(String productname, Collection<Campaign> campaign) {
		super();
		this.productname = productname;
		this.campaign = campaign;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Collection<Campaign> getCampaign() {
		return campaign;
	}

	public void setCampaign(Collection<Campaign> campaign) {
		this.campaign = campaign;
	}

	
}
