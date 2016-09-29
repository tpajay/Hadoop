# Hadoop

1. Setup a Virtual Machine using Oracle VM Virtual Box

2. Installed Cloudera CDH

3. Created this project to test getting Big Data with Mappers and Reducers, etc to get a better understanding of HaDoop.




-- Random Notes --

HDFS: HaDoop Disributed File System (Cluster, 1..* servers)
MapReduce
   HIVE: Analyze code using SQL (runs MapReduce jobs, good for long batch jobs)
   Apache PIG: Analyze code in scripting lanaguage  (still runs MapReduce jobs)
Impala: Query data with SQL but directly with HDFS like MR (quicker)
Sqoop: Takes data from SQL database and puts in HDFS as delimeinted files
Flume: injest data from external systems and adds to HDFS cluster
Hue: GUI to cluster
Oozie: Workflow management
Mahout: MAchine learning library

NAMENODE holds meta data of where data is stored on which clusters/nodes
To prevent failure:
   1. Store on NFS
   2. Configure two NameNodes Active, Standby

Mappers: pull data, like sales record store:price 1..* records
Reducers: reduces to singular: storeA:$300k, storeB:500k

Daemon running on each machine in the cluster HDFS
Run MapReduce job that is submitted to the Job Tracker
The Job Tracker splits the work into Mappers and Reducers
The Mappers and Reducers will run on the other cluster nodes
Running the actual task is by a Daemon called the Task Tracker
  Task Tracker software runs on each of the nodes
  
