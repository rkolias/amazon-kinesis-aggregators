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

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class AggregateData {
    private String uniqueId;

    private LabelSet labels;

    private Date date;

    private Map<String, Double> summaries;
    
    private Map<String, String> attribMap;
    
    private String tagValue;

    public AggregateData(String uniqueId, LabelSet labels, Date date, Map<String, Double> summaries) {
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

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		final int maxLen = 20;
		StringBuilder builder = new StringBuilder();
		builder.append("AggregateData [");
		if (this.uniqueId != null)
		{
			builder.append("uniqueId=");
			builder.append(this.uniqueId);
			builder.append(", ");
		}
		if (this.labels != null)
		{
			builder.append("labels=");
			builder.append(this.labels);
			builder.append(", ");
		}
		if (this.date != null)
		{
			builder.append("date=");
			builder.append(this.date);
			builder.append(", ");
		}
		if (this.summaries != null)
		{
			builder.append("summaries=");
			builder.append(toString(this.summaries.entrySet(), maxLen));
			builder.append(", ");
		}
		if (this.attribMap != null)
		{
			builder.append("attribMap=");
			builder.append(toString(this.attribMap.entrySet(), maxLen));
			builder.append(", ");
		}
		if (this.tagValue != null)
		{
			builder.append("tagValue=");
			builder.append(this.tagValue);
		}
		builder.append("]");
		return builder.toString();
	}

	private String toString(Collection<?> collection, int maxLen)
	{
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++)
		{
			if (i > 0)
			{
				builder.append(", ");
			}
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}
	
}
