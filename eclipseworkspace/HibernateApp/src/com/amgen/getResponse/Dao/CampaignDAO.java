/**
 * 
 */
package com.amgen.getResponse.Dao;

import java.util.List;
import java.util.Set;

import com.amgen.getResponse.entity.campaign.Channel;
import com.amgen.getResponse.entity.campaign.Product;

/**
 * @author chaudmee
 *
 */
public interface CampaignDAO {

	/**
	 * @param campaignName
	 */
	//public void addcampaign(String campaignName);  
	
	public void addcampaign(String campaignName,String productName,String channelName);
	//public void addcampaign(String camapaignName ,Long productid);
}