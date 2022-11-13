# Gorgeous Sandwich


## Build Project From Sources

To build the project using the current version of the code source, it is necessary to 
execute the Maven package goal, creating the JAR file in target, test 


```bat
./mvn package
```

Then, to access and run the application just execute the following commands

```bat
java -jar .\target\gorgeousSandwich-0.0.1-SNAPSHOT.jar
```

Then the application will run and be similar to the following text excerpt

```text
$> java -jar .\target\gorgeousSandwich-0.0.1-SNAPSHOT.jar
______                    _      _____          __  _
|  ___|                  | |    /  ___|        / _|| |
| |_     ___    ___    __| |    \ `--.   ___  | |_ | |_ __      __  __ _  _ __   ___
|  _|   / _ \  / _ \  / _` |     `--. \ / _ \ |  _|| __|\ \ /\ / / / _` || '__| / _ \
| |    | (_) || (_) || (_| |    /\__/ /| (_) || |  | |_  \ V  V / | (_| || |   |  __/
\_|     \___/  \___/  \__,_|    \____/  \___/ |_|   \__|  \_/\_/   \__,_||_|    \___|


Gorgeous Sandwich 0.0.1-SNAPSHOT
Powered by Spring Boot 2.7.5
2022-11-10 18:10:00.771  INFO 23056 --- [           main] p.i.a.g.GorgeousSandwichApplication      : Starting GorgeousSandwichApplication v0.0.1-SNAPSHOT using Java 17.0.4.1 on Barbatos-Rex with PID 23056 (D:\ARQSOFT\arqsoft-22-23-202\part 1\projects\gorgeousSandwich\target\gorgeousSandwich-0.0.1-SNAPSHOT.jar started by Andre in D:\ARQSOFT\arqsoft-22-23-202\part 1\projects\gorgeousSandwich)
2022-11-10 18:10:00.777  INFO 23056 --- [           main] p.i.a.g.GorgeousSandwichApplication      : No active profile set, falling back to 1 default profile: "default"
2022-11-10 18:10:01.340  INFO 23056 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data MongoDB repositories in DEFAULT mode.
2022-11-10 18:10:01.384  INFO 23056 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 40 ms. Found 3 MongoDB repository interfaces.
2022-11-10 18:10:01.924  INFO 23056 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2022-11-10 18:10:01.935  INFO 23056 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-11-10 18:10:01.935  INFO 23056 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.68]
2022-11-10 18:10:02.594  INFO 23056 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-11-10 18:10:02.595  INFO 23056 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1752 ms
2022-11-10 18:10:02.788  INFO 23056 --- [           main] org.mongodb.driver.client                : MongoClient with metadata {"driver": {"name": "mongo-java-driver|sync|spring-boot", "version": "4.6.1"}, "os": {"type": "Windows", "name": "Windows 11", "architecture": "amd64", "version": "10.0"}, "platform": "Java/Eclipse Adoptium/17.0.4.1+1"} created with settings MongoClientSettings{readPreference=primary, writeConcern=WriteConcern{w=null, wTimeout=null ms, journal=null}, retryWrites=true, retryReads=true, readConcern=ReadConcern{level=null}, credential=MongoCredential{mechanism=null, userName='arqsoft', source='admin', password=<hidden>, mechanismProperties=<hidden>}, streamFactoryFactory=null, commandListeners=[], codecRegistry=ProvidersCodecRegistry{codecProviders=[ValueCodecProvider{}, BsonValueCodecProvider{}, DBRefCodecProvider{}, DBObjectCodecProvider{}, DocumentCodecProvider{}, IterableCodecProvi
der{}, MapCodecProvider{}, GeoJsonCodecProvider{}, GridFSFileCodecProvider{}, Jsr310CodecProvider{}, JsonObjectCodecProvider{}, BsonCodecProvider{}, EnumCodecProvider{}, com.mongodb.Je
p395RecordCodecProvider@2cae1042]}, clusterSettings={hosts=[127.0.0.1:27017], srvHost=gorgeoussandwic.u0yair9.mongodb.net, srvServiceName=mongodb, mode=MULTIPLE, requiredClusterType=RE
PLICA_SET, requiredReplicaSetName='atlas-1253ha-shard-0', serverSelector='null', clusterListeners='[]', serverSelectionTimeout='30000 ms', localThreshold='30000 ms'}, socketSettings=So
cketSettings{connectTimeoutMS=10000, readTimeoutMS=0, receiveBufferSize=0, sendBufferSize=0}, heartbeatSocketSettings=SocketSettings{connectTimeoutMS=10000, readTimeoutMS=10000, receiv
eBufferSize=0, sendBufferSize=0}, connectionPoolSettings=ConnectionPoolSettings{maxSize=100, minSize=0, maxWaitTimeMS=120000, maxConnectionLifeTimeMS=0, maxConnectionIdleTimeMS=0, main
tenanceInitialDelayMS=0, maintenanceFrequencyMS=60000, connectionPoolListeners=[], maxConnecting=2}, serverSettings=ServerSettings{heartbeatFrequencyMS=10000, minHeartbeatFrequencyMS=5
00, serverListeners='[]', serverMonitorListeners='[]'}, sslSettings=SslSettings{enabled=true, invalidHostNameAllowed=false, context=null}, applicationName='null', compressorList=[], uuidRepresentation=JAVA_LEGACY, serverApi=null, autoEncryptionSettings=null, contextProvider=null}
2022-11-10 18:10:02.811  INFO 23056 --- [ir9.mongodb.net] org.mongodb.driver.cluster               : Adding discovered server ac-bwlzoyb-shard-00-00.u0yair9.mongodb.net:27017 to client view of cluster
2022-11-10 18:10:02.841  INFO 23056 --- [ir9.mongodb.net] org.mongodb.driver.cluster               : Adding discovered server ac-bwlzoyb-shard-00-02.u0yair9.mongodb.net:27017 to client view of cluster
2022-11-10 18:10:02.842  INFO 23056 --- [ir9.mongodb.net] org.mongodb.driver.cluster               : Adding discovered server ac-bwlzoyb-shard-00-01.u0yair9.mongodb.net:27017 to client view of cluster
2022-11-10 18:10:03.386  INFO 23056 --- [ngodb.net:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:5, serverValue:113684}] to ac-bwlzoyb-shard-00-01.u0yair9.mongodb.net:27017
2022-11-10 18:10:03.386  INFO 23056 --- [ngodb.net:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:1, serverValue:114481}] to ac-bwlzoyb-shard-00-00.u0yair9.mongodb.net:27017
2022-11-10 18:10:03.386  INFO 23056 --- [ngodb.net:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:4, serverValue:115962}] to ac-bwlzoyb-shard-00-02.u0yair9.mongodb.net:27017
2022-11-10 18:10:03.386  INFO 23056 --- [ngodb.net:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:2, serverValue:115962}] to ac-bwlzoyb-shard-00-02.u0yair9.mongodb.net:27017
2022-11-10 18:10:03.386  INFO 23056 --- [ngodb.net:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:3, serverValue:113684}] to ac-bwlzoyb-shard-00-01.u0yair9.mongodb.net:27017
2022-11-10 18:10:03.386  INFO 23056 --- [ngodb.net:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:6, serverValue:114481}] to ac-bwlzoyb-shard-00-00.u0yair9.mongodb.net:27017
2022-11-10 18:10:03.387  INFO 23056 --- [ngodb.net:27017] org.mongodb.driver.cluster               : Monitor thread successfully connected to server with description ServerDescription{
address=ac-bwlzoyb-shard-00-02.u0yair9.mongodb.net:27017, type=REPLICA_SET_PRIMARY, state=CONNECTED, ok=true, minWireVersion=0, maxWireVersion=13, maxDocumentSize=16777216, logicalSess
ionTimeoutMinutes=30, roundTripTimeNanos=293619500, setName='atlas-1253ha-shard-0', canonicalAddress=ac-bwlzoyb-shard-00-02.u0yair9.mongodb.net:27017, hosts=[ac-bwlzoyb-shard-00-00.u0y
air9.mongodb.net:27017, ac-bwlzoyb-shard-00-02.u0yair9.mongodb.net:27017, ac-bwlzoyb-shard-00-01.u0yair9.mongodb.net:27017], passives=[], arbiters=[], primary='ac-bwlzoyb-shard-00-02.u
0yair9.mongodb.net:27017', tagSet=TagSet{[Tag{name='nodeType', value='ELECTABLE'}, Tag{name='provider', value='AWS'}, Tag{name='region', value='EU_WEST_3'}, Tag{name='workloadType', va
lue='OPERATIONAL'}]}, electionId=7fffffff000000000000000e, setVersion=1, topologyVersion=TopologyVersion{processId=63668b3b1aedf63bc7dd1bca, counter=6}, lastWriteDate=Thu Nov 10 18:10:03 WET 2022, lastUpdateTimeNanos=39131400049600}
2022-11-10 18:10:03.386  INFO 23056 --- [ngodb.net:27017] org.mongodb.driver.cluster               : Monitor thread successfully connected to server with description ServerDescription{
address=ac-bwlzoyb-shard-00-01.u0yair9.mongodb.net:27017, type=REPLICA_SET_SECONDARY, state=CONNECTED, ok=true, minWireVersion=0, maxWireVersion=13, maxDocumentSize=16777216, logicalSe
ssionTimeoutMinutes=30, roundTripTimeNanos=293614000, setName='atlas-1253ha-shard-0', canonicalAddress=ac-bwlzoyb-shard-00-01.u0yair9.mongodb.net:27017, hosts=[ac-bwlzoyb-shard-00-00.u
0yair9.mongodb.net:27017, ac-bwlzoyb-shard-00-02.u0yair9.mongodb.net:27017, ac-bwlzoyb-shard-00-01.u0yair9.mongodb.net:27017], passives=[], arbiters=[], primary='ac-bwlzoyb-shard-00-02
.u0yair9.mongodb.net:27017', tagSet=TagSet{[Tag{name='nodeType', value='ELECTABLE'}, Tag{name='provider', value='AWS'}, Tag{name='region', value='EU_WEST_3'}, Tag{name='workloadType', 
value='OPERATIONAL'}]}, electionId=null, setVersion=1, topologyVersion=TopologyVersion{processId=63668bf206ccfd67649e1773, counter=3}, lastWriteDate=Thu Nov 10 18:10:03 WET 2022, lastUpdateTimeNanos=39131400049600}
2022-11-10 18:10:03.387  INFO 23056 --- [ngodb.net:27017] org.mongodb.driver.cluster               : Monitor thread successfully connected to server with description ServerDescription{
address=ac-bwlzoyb-shard-00-00.u0yair9.mongodb.net:27017, type=REPLICA_SET_SECONDARY, state=CONNECTED, ok=true, minWireVersion=0, maxWireVersion=13, maxDocumentSize=16777216, logicalSe
ssionTimeoutMinutes=30, roundTripTimeNanos=293645200, setName='atlas-1253ha-shard-0', canonicalAddress=ac-bwlzoyb-shard-00-00.u0yair9.mongodb.net:27017, hosts=[ac-bwlzoyb-shard-00-00.u
0yair9.mongodb.net:27017, ac-bwlzoyb-shard-00-02.u0yair9.mongodb.net:27017, ac-bwlzoyb-shard-00-01.u0yair9.mongodb.net:27017], passives=[], arbiters=[], primary='ac-bwlzoyb-shard-00-02
.u0yair9.mongodb.net:27017', tagSet=TagSet{[Tag{name='nodeType', value='ELECTABLE'}, Tag{name='provider', value='AWS'}, Tag{name='region', value='EU_WEST_3'}, Tag{name='workloadType', 
value='OPERATIONAL'}]}, electionId=null, setVersion=1, topologyVersion=TopologyVersion{processId=63668a68e8fb118a421ba262, counter=4}, lastWriteDate=Thu Nov 10 18:10:03 WET 2022, lastUpdateTimeNanos=39131400049600}
2022-11-10 18:10:03.392  INFO 23056 --- [ngodb.net:27017] org.mongodb.driver.cluster               : Setting max election id to 7fffffff000000000000000e from replica set primary ac-bwlzoyb-shard-00-02.u0yair9.mongodb.net:27017
2022-11-10 18:10:03.395  INFO 23056 --- [ngodb.net:27017] org.mongodb.driver.cluster               : Setting max set version to 1 from replica set primary ac-bwlzoyb-shard-00-02.u0yair9.mongodb.net:27017
2022-11-10 18:10:03.396  INFO 23056 --- [ngodb.net:27017] org.mongodb.driver.cluster               : Discovered replica set primary ac-bwlzoyb-shard-00-02.u0yair9.mongodb.net:27017    
2022-11-10 18:10:03.562  INFO 23056 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-11-10 18:10:03.569  INFO 23056 --- [           main] p.i.a.g.GorgeousSandwichApplication      : Started GorgeousSandwichApplication in 3.246 seconds (JVM running for 3.648)
```

After that, the application will be accessible in port 8080, witch can be exposed to the internet or mapped to another external port

