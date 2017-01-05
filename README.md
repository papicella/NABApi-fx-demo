<h1> NAB API FX demo for Cloud Foundry </h1>

The following example is using the NAB API from https://developer.nab.com.au/ to consume the FX Rates API. To run this 
demo follow the steps below. To push to Pivotal Cloud Foundry follow the steps further down

![alt tag](https://dl.dropboxusercontent.com/u/15829935/platform-demos/images/piv-nabapi-1.png)

<h3> Run Locally </h3>

- Clone as shown below

```
$ git clone https://github.com/papicella/NABApi-fx-demo.git
```

- Add a file called "**nabapikey.properties**" to the resource directory with your NAB API Key obtained after registering 
at https://developer.nab.com.au/

Note: If you omit this step you will not be able to run this demo as it's expecting your NAB API KEY for this to work
in the "./resources" directory with the file name being "**nabapikey.properties**"

```
NAB_API_KEY=YOUR-NAB-API-KEY
```

- Run as shown below

```
pasapicella@pas-macbook:~/piv-projects/NABApi-fx-demo$ mvn spring-boot:run
....

2017-01-05 14:21:50.765  INFO 61966 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2017-01-05 14:21:50.770  INFO 61966 --- [           main] c.p.n.a.fx.demo.NabapiFxDemoApplication  : Started NabapiFxDemoApplication in 2.256 seconds (JVM running for 4.076)

```

- Access as follows

```
http://localhost:8080/
```

<h3> Deploy to Cloud Foundry </h3>

- Edit the supplied "manifest.yml" to create a unique route/name

```
applications:
- name: pas-nabapi-fx
  host: pas-nabapi-fx
  memory: 512M
  instances: 1
  timeout: 180
  path: ./target/nabapi-fx-demo-0.0.1-SNAPSHOT.jar
  env:
    JAVA_OPTS: -Djava.security.egd=file:///dev/urando
```

- Ensure your logged in and targetted the right ORG/SPACE

```
pasapicella@pas-macbook:~/piv-projects/NABApi-fx-demo$ cf target

API endpoint:   https://api.run.pivotal.io (API version: 2.68.0)
User:           papicella@pivotal.io
Org:            ben.farrelly-org
Space:          nabapi
```

- Push as follows

```
pasapicella@pas-macbook:~/piv-projects/NABApi-fx-demo$ cf push
...

Showing health and status for app pas-nabapi-fx in org ben.farrelly-org / space nabapi as papicella@pivotal.io...
OK

requested state: started
instances: 1/1
usage: 512M x 1 instances
urls: pas-nabapi-fx.cfapps.io
last uploaded: Thu Jan 5 03:27:52 UTC 2017
stack: cflinuxfs2
buildpack: java-buildpack=v3.11-offline-https://github.com/cloudfoundry/java-buildpack.git#eba4df6 java-main java-opts open-jdk-like-jre=1.8.0_111 open-jdk-like-memory-calculator=2.0.2_RELEASE spring-auto-reconfiguration=1.10.0_RELEASE

     state     since                    cpu      memory           disk           details
#0   running   2017-01-05 02:28:40 PM   106.2%   288.6M of 512M   144.8M of 1G
```

<hr />
Pas Apicella [papicella at pivotal.io] is a Senior Platform Architect at Pivotal Australia 
