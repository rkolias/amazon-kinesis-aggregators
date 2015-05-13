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

import java.util.Arrays;
import com.amazonaws.services.kinesis.model.Record;

public class InputEvent {
    private String sequenceNumber;

    private String partitionKey;

    private byte[] data;

    public InputEvent(Record record) {
        this.sequenceNumber = record.getSequenceNumber();
        this.partitionKey = record.getPartitionKey();
        this.data = record.getData().array();
    }

    public InputEvent withSequence(String sequence) {
        this.sequenceNumber = sequence;
        return this;
    }

    public InputEvent withPartitionKey(String partitionKey) {
        this.partitionKey = partitionKey;
        return this;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public String getPartitionKey() {
        return partitionKey;
    }

    public byte[] getData() {
        return data;
    }

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("InputEvent [");
		if (this.sequenceNumber != null)
		{
			builder.append("sequenceNumber=");
			builder.append(this.sequenceNumber);
			builder.append(", ");
		}
		if (this.partitionKey != null)
		{
			builder.append("partitionKey=");
			builder.append(this.partitionKey);
			builder.append(", ");
		}
		if (this.data != null)
		{
			builder.append("data=");
			builder.append(Arrays.toString(Arrays.copyOf(this.data, Math.min(this.data.length, maxLen))));
		}
		builder.append("]");
		return builder.toString();
	}
}
