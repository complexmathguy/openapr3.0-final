/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.validator;

import org.springframework.util.Assert;

import com.occulue.api.*;

public class IntervalPeriodValidator {
		
	/**
	 * default constructor
	 */
	protected IntervalPeriodValidator() {	
	}
	
	/**
	 * factory method
	 */
	static public IntervalPeriodValidator getInstance() {
		return new IntervalPeriodValidator();
	}
		
	/**
	 * handles creation validation for a IntervalPeriod
	 */
	public void validate( CreateIntervalPeriodCommand intervalPeriod )throws Exception {
		Assert.notNull( intervalPeriod, "CreateIntervalPeriodCommand should not be null" );
//		Assert.isNull( intervalPeriod.getIntervalPeriodId(), "CreateIntervalPeriodCommand identifier should be null" );
		Assert.notNull( intervalPeriod.getStart(), "Field CreateIntervalPeriodCommand.start should not be null" );
		Assert.notNull( intervalPeriod.getDuration(), "Field CreateIntervalPeriodCommand.duration should not be null" );
		Assert.notNull( intervalPeriod.getRandomizeStart(), "Field CreateIntervalPeriodCommand.randomizeStart should not be null" );
	}

	/**
	 * handles update validation for a IntervalPeriod
	 */
	public void validate( UpdateIntervalPeriodCommand intervalPeriod ) throws Exception {
		Assert.notNull( intervalPeriod, "UpdateIntervalPeriodCommand should not be null" );
		Assert.notNull( intervalPeriod.getIntervalPeriodId(), "UpdateIntervalPeriodCommand identifier should not be null" );
		Assert.notNull( intervalPeriod.getStart(), "Field UpdateIntervalPeriodCommand.start should not be null" );
		Assert.notNull( intervalPeriod.getDuration(), "Field UpdateIntervalPeriodCommand.duration should not be null" );
		Assert.notNull( intervalPeriod.getRandomizeStart(), "Field UpdateIntervalPeriodCommand.randomizeStart should not be null" );
    }

	/**
	 * handles delete validation for a IntervalPeriod
	 */
    public void validate( DeleteIntervalPeriodCommand intervalPeriod ) throws Exception {
		Assert.notNull( intervalPeriod, "{commandAlias} should not be null" );
		Assert.notNull( intervalPeriod.getIntervalPeriodId(), "DeleteIntervalPeriodCommand identifier should not be null" );
	}
	
	/**
	 * handles fetchOne validation for a IntervalPeriod
	 */
	public void validate( IntervalPeriodFetchOneSummary summary ) throws Exception {
		Assert.notNull( summary, "IntervalPeriodFetchOneSummary should not be null" );
		Assert.notNull( summary.getIntervalPeriodId(), "IntervalPeriodFetchOneSummary identifier should not be null" );
	}



}
