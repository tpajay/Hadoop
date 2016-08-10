package com.tpajay.hadoop.reducers;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class NoKeyRecordCountReducer extends Reducer<Text, IntWritable, NullWritable, IntWritable> {

	@Override
	public void reduce(Text key, Iterable<IntWritable> records, Context context)
			throws IOException, InterruptedException {
		int sum = 0;

		for (IntWritable record : records) {
			sum += record.get();
		}
		
		//using nullwritable to just omit the key and only get the count
		context.write(NullWritable.get(), new IntWritable(sum));
				
	}
}