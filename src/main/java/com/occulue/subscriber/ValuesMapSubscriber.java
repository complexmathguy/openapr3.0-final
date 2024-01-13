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
 * Subscriber for ValuesMap related events.  .
 * 
 * @author your_name_here
 *
 */
@Component("valuesMap-subscriber")
public class ValuesMapSubscriber extends BaseSubscriber {

	public ValuesMapSubscriber() {
		queryGateway = applicationContext.getBean(QueryGateway.class);
	}
	
    public SubscriptionQueryResult<List<ValuesMap>, ValuesMap> valuesMapSubscribe() {
        return queryGateway
                .subscriptionQuery(new FindAllValuesMapQuery(), 
                		ResponseTypes.multipleInstancesOf(ValuesMap.class),
                		ResponseTypes.instanceOf(ValuesMap.class));
    }

    public SubscriptionQueryResult<ValuesMap, ValuesMap> valuesMapSubscribe(@DestinationVariable UUID valuesMapId) {
        return queryGateway
                .subscriptionQuery(new FindValuesMapQuery(new LoadValuesMapFilter(valuesMapId)), 
                		ResponseTypes.instanceOf(ValuesMap.class),
                		ResponseTypes.instanceOf(ValuesMap.class));
    }




    // -------------------------------------------------
    // attributes
    // -------------------------------------------------
	@Autowired
    private final QueryGateway queryGateway;
}

