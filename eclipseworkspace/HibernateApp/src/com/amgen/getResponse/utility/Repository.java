package com.amgen.getResponse.utility;

import java.util.List;
import com.amgen.getResponse.entity.campaign.Channel;
import com.amgen.getResponse.entity.campaign.Product;
import com.amgen.getResponse.entity.campaign.UserSubscription;
import com.amgen.getResponse.entity.userProfileManagement.User;



public interface Repository {

	 public Object retrieve(Class<User> entityClass);
	 public List<Product> fetchData();
     public List<Channel> fetchChannel();
     public List<UserSubscription>fetchUserData();
	
	}