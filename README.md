# SCAPE Loader Application

The SCAPE Loader Application helps to ingest SCAEP Digital Objects into a SCAPE Digital Object Repository.

### What does the Loader Application do?


The Loader Application helps the user to ingest SCAPE Digital Objects into the SCAPE Digital Object Repository.
The digital objects can reside in a directory on the useres file system, in a zip file or even in a sequence file on HDFS, the Hadoop file system.
the Loader Application queues the objects for ingest and monitors the ingest process by retrieving the lifecycle states of the ingested object.
A log file helps the user to watch the ingest process. 

### Who is intended audience?

The SCAPE Loader Application is meant for the Content Holder to have a tool ready that helps to ingest a large amount of objects.

## Features and roadmap


### Version 0.0.1

    * added support for sequence files on HDFS
    
### Version 0.0.2

    * added new SCAPE platform model



## How to install and use


The usage of the application is via command line

```bash
usage: java -jar loader-app-0.0.2-SNAPSHOT-jar-with-dependencies.jar [-c
       <arg>] [-d <arg>] [-h] [-i <arg>] [-l <arg>] [-p <arg>] [-r <arg>]
       [-t <arg>] [-u <arg>]
 -c,--checklifecycle <arg>   activate the periodic lifecycle retrieval.
                             [default: true]
 -d,--dir <arg>              Local input directory (Required). If a
                             hadoop sequence file or a zip-file is given, an extraction into a
                             local sips directory will be performed
 -h,--help                   print this message.
 -i,--ingest <arg>           ingest REST endpoint [default: entity-async].
 -l,--lifecycle <arg>        lifecycle REST endpoint [default: lifecycle].
 -p,--password <arg>         password of the repository user.
 -r,--url <arg>              base URL of the repository (Required).
 -t,--period <arg>           Period in min to fetch lifecycle states
                             [default: 100 min].
 -u,--username <arg>         username of the repository user.

```
 
To use the Loader Application with your Repository you must provide an
implementation of the IAuthentication interface. An example impl with escidoc
is called EsciDocAuthentication. Please refere to the Loader.java class for further usage.
```Java
LoaderApplication loaderapp = new LoaderApplication(conf, new EsciDocAuthentication());
```

The Input source can be a sequence file on hdfs. In this case check the hadoop-core version 
in the POM to avoid version mismatch of Hadoop versions. The -d option can be then 
```bash
hdfs://your_hadoop_host:your_hadoop_port/path_to_the_sequencefile/the_sequence_file.seq
e.g. hdfs://localhost:8020/user/scape/mysequencefile.seq
```

The Input source can be also a zip file on the local file system. 
```bash
The -d option can be then e.g. /path_to_the_zipfile/the_zip_file.zip
```
