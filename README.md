This project is a simple example of [ml-camel-mlcp](https://github.com/rjrudin/ml-camel-mlcp), a [Camel](http://camel.apache.org/) component for invoking [MarkLogic Content Pump](https://docs.marklogic.com/guide/ingestion/content-pump). This project shows you how to setup a "hot folder" such that any time a file is copied into a certain directory, it is automatically ingested into MarkLogic via Content Pump. And you can reuse all Content Pump import arguments while doing so.

To try this out, just do the following:

1. Clone this repository
2. Run "./gradlew mlDeploy camelRun"
  1. Make sure "gradlew" is executable
  2. If you're on Windows, run "gradlew mlDeploy camelRun" instead
  3. If you have Gradle available on your path already, just run "gradle". "gradlew" is included to minimize the setup necessary.

The first Gradle task - mlDeploy - uses [ml-gradle](https://github.com/rjrudin/ml-gradle) to create a new MarkLogic application with a REST API server on port 8310 and an XDBC server on port 8311. The XDBC server will be used by Content Pump, and you can use the REST API server to browse/search documents, along with all the other nice out-of-the-box operations you get with a MarkLogic REST API server. 

The second task - camelRun - fires up Camel. By default, Camel will watch a directory named "inbox" within the directory where you cloned this repository. When you a copy/move a file into that directory, Camel will read it in and then pass it off to Content Pump, which will ingest it into MarkLogic. 

To customize how this application works, just edit the gradle.properties file:

- fileUri is the URI for the [Camel File component](http://camel.apache.org/file2.html). You can change this to be whatever path you would like. 
- mlcpUri is the URI for the Camel MarkLogic component. You can attach any of the [Content Pump import arguments](https://docs.marklogic.com/guide/ingestion/content-pump#id_63999) onto the querystring. For reference, the default value of mlcpUri specifies a collection to place each ingested document into. 
  
