package com.tpajay.hadoop.drivers;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.io.*  ///see all the different output types
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.tpajay.hadoop.mappers.TokenizerMapper;
import com.tpajay.hadoop.reducers.IntSumReducer;

public class CountByKey extends Configured implements Tool {
	
	public static void main( String[] args ) throws Exception {
        int exitCode = ToolRunner.run(new RowCount(), args);
        System.exit(exitCode);
    }
	
	public int run(String[] args) throws Exception {
		
		//Configuration conf = new Configuration();
	    //Job job = Job.getInstance(conf, "word count");
	    Job job = Job.getInstance(getConf(),  "word count");
	    job.setJarByClass(CountByKey.class);
	    job.setMapperClass(TokenizerMapper.class);
	    job.setReducerClass(IntSumReducer.class);
	    job.setOutputKeyClass(Text.class); //key type String
	    job.setOutputValueClass(IntWritable.class); //value type int
	    FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, new Path(args[1]));
	    //System.exit(job.waitForCompletion(true) ? 0 : 1);
	    return job.waitForCompletion(true) ? 0 : 1;
		
	}

}
