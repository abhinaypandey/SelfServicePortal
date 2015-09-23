/**
 * 
 */
package com.amgen.getResponse.entity.campaign;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.amgen.getResponse.entity.campaign.Product;

@Entity
@Table(name = "Channel", uniqueConstraints = { @UniqueConstraint(columnNames = "ID") })
/**
 * @author chaudmee
 *
 */
public class Channel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "CHANNELNAME", unique = true, nullable = false, length = 100)
	private String channelname;

	@OneToMany(mappedBy= "channel", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Collection<Campaign> campaign = new ArrayList<Campaign>();
	
	

	public Channel() {
		super();
		// TODO Auto-generated constructor stub
	}

    public Channel(String channelname, Collection<Campaign> campaign) {
		super();
		this.channelname = channelname;
		this.campaign = campaign;
	}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChannelname() {
		return channelname;
	}

	public void setChannelname(String channelname) {
		this.channelname = channelname;
	}

	public Collection<Campaign> getCampaign() {
		return campaign;
	}

	public void setCampaign(Collection<Campaign> campaign) {
		this.campaign = campaign;
	}

	}
