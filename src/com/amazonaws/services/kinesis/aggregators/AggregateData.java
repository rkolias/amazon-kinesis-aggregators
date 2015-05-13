/**
 * Amazon Kinesis Aggregators
 *
 * Copyright 2014, Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Amazon Software License (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/asl/
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.kinesis.aggregators;

import java.util.Date;
import java.util.Map;

public class AggregateData {
    private String uniqueId;

    private LabelSet labels;

    private Date date;

    private Map<String, Double> summaries;
    
    private Map<String, String> attribMap;
    
    private String tagValue;

    public AggregateData(final String uniqueId, final LabelSet labels, final Date date, final Map<String, Double> summaries) {
        this.uniqueId = uniqueId;
        this.labels = labels;
        this.date = date;
        this.summaries = summaries;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public String getLabel() {
        return this.labels.valuesAsString();
    }

    public LabelSet getLabels() {
        return this.labels;
    }

    public Date getDate() {
        return this.date;
    }

    public Map<String, Double> getSummaries() {
        return this.summaries;
    }

	/**
	 * @return the attribMap
	 */
	public Map<String, String> getAttribMap()
	{
		return this.attribMap;
	}

	/**
	 * @param argAttribMap the attribMap to set
	 */
	public void setAttribMap(final Map<String, String> argAttribMap)
	{
		this.attribMap = argAttribMap;
	}
	
    /**
     * 
     * @param value
     * @return
     */
    public AggregateData withTagValue(String value)
    {
    	this.tagValue = value;
    	
    	return this;
    }
    
    /**
     * 
     * @return
     */
    public String getTagValue()
    {
    	return this.tagValue;
    }
	
}
