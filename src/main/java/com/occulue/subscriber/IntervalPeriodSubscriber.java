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
 * Subscriber for IntervalPeriod related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("intervalPeriod-subscriber")
public class IntervalPeriodSubscriber extends BaseSubscriber {

	public IntervalPeriodSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<IntervalPeriod>, IntervalPeriod> intervalPeriodSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllIntervalPeriodQuery(), 
                		ResponseTypes.multipleInstancesOf(IntervalPeriod.class),
                		ResponseTypes.instanceOf(IntervalPeriod.class));
    }

    public SubscriptionQueryResult<IntervalPeriod, IntervalPeriod> intervalPeriodSubscribe(@DestinationVariable UUID intervalPeriodId) {
        return queryGateway
                .subscriptionQuery(new FindIntervalPeriodQuery(new LoadIntervalPeriodFilter(intervalPeriodId)), 
                		ResponseTypes.instanceOf(IntervalPeriod.class),
                		ResponseTypes.instanceOf(IntervalPeriod.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

