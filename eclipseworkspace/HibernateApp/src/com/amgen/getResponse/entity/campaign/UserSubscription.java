/**
 * 
 */
package com.amgen.getResponse.entity.campaign;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author chaudmee
 *
 */
@Entity
@Table(name="usersubscription")
public class UserSubscription {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name = "CHANNELNAME")
	private String channelname;

	@Column(name = "PRODUCTNAME")
	private String productname;
	
	@OneToMany(mappedBy= "usersubscription", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Collection<Campaign> campaign = new ArrayList<Campaign>();

	public UserSubscription(){
		
	}
	public UserSubscription(String userName, String channelname,
			String productname, Collection<Campaign> campaign) {
		super();
		this.userName = userName;
		this.channelname = channelname;
		this.productname = productname;
		this.campaign = campaign;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getChannelname() {
		return channelname;
	}

	public void setChannelname(String channelname) {
		this.channelname = channelname;
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
