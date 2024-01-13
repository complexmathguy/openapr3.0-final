/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.subscriber;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.axonframework.messaging.responsetypes.ResponseTypes;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;


import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;

/**
 * Subscriber for Interval related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("interval-subscriber")
public class IntervalSubscriber extends BaseSubscriber {

	public IntervalSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<Interval>, Interval> intervalSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllIntervalQuery(), 
                		ResponseTypes.multipleInstancesOf(Interval.class),
                		ResponseTypes.instanceOf(Interval.class));
    }

    public SubscriptionQueryResult<Interval, Interval> intervalSubscribe(@DestinationVariable UUID intervalId) {
        return queryGateway
                .subscriptionQuery(new FindIntervalQuery(new LoadIntervalFilter(intervalId)), 
                		ResponseTypes.instanceOf(Interval.class),
                		ResponseTypes.instanceOf(Interval.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

