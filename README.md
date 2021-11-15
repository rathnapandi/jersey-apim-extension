# OpenID Connect (OIDC) based SSO for API Manager and Portal UI

## API Management Version Compatibility
This artefact was successfully tested for the following versions:
- V7.7 August 2021 Release

## Prerequisites

    - Maven 6.7  or above
    - JDK 1.8

## Compile/Build
In build.gradle file, update dependencies location :
```groovy
    dependencies {
        compile fileTree(dir: '<Install_dir_apigateway>/apigateway/system/lib', include: '*.jar')
        compile fileTree(dir: '<Install_dir_apigateway>/apigateway/system/lib/modules', include: '*.jar')
        compile fileTree(dir: '<Install_dir_apigateway>/apigateway/system/lib/plugins', include: '*.jar')
    }

    where <Install_dir_apigateway>; <Install_dir_policyStudio> and <current_version> are replaced with adequate values 
```
**If JAVA_HOME is not setup, setup JAVA_HOME to JDK 1.8 and run the gradle command**
```bash

 ./gradlew build
```
## Configure Policystudio

- Start Policy Studio, and connect to the API Gateway.
- Select Environment Configuration > Listeners > API Gateway > Default Services > Paths.
- Right-click Paths and select Add Servlet Application. On the General tab, enter / in the Relative Path field. Click OK.
- Right-click the servlet application path you just created in the Paths window, and select Add Servlet.
- Enter **jersey** in the Name field.
- Enter **jsrsey** in the URI field.
- Enter org.glassfish.jersey.servlet.ServletContainer in the Class field.
- Click Add under the Servlet Properties table to add a new property with the following values:
    
    - Name: jersey.config.server.provider.packages
    - Value: com.axway.apim
- Click OK.
- Click Deploy or press F6 to deploy the new configuration on the API Gateway.



## Install

    - Copy the jar file in the API Gateway VORDEL_HOME/groups/group-x/instance-x/ext/lib 
    - Setup environement variables




## Test Jersey JAX-RS API
    - Open a browser or postman
    - Type http://APIManagerhost:8080/jersey/health
   


## Bugs

Please reach out [ACS Global Team](mailto:rnatarajan@axway.com)


