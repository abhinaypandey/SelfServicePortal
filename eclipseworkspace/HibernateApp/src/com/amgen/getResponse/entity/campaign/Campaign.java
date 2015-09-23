/**
 * 
 */
package com.amgen.getResponse.entity.campaign;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.amgen.getResponse.entity.campaign.Product;
import com.amgen.getResponse.entity.userProfileManagement.User;

@Entity
@Table(name = "Campaign", uniqueConstraints = { @UniqueConstraint(columnNames = "ID") })

/**
 * @author chaudmee
 *
 */
public class Campaign {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "CAMPAIGNNAME", unique = false, nullable = false, length = 100)
	private String campaignname;
	
	@ManyToOne
	private Product product;
	
	@ManyToOne
	private Channel channel;
	
	@ManyToOne 
	private UserSubscription usersubscription;



	
	public Campaign() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Campaign(String campaignname) {
		super();
		this.campaignname = campaignname;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCampaignname() {
		return campaignname;
	}

	public void setCampaignname(String campaignname) {
		this.campaignname = campaignname;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public UserSubscription getUsersubscription() {
		return usersubscription;
	}

	public void setUsersubscription(UserSubscription usersubscription) {
		this.usersubscription = usersubscription;
	}

	
	
	
	
}