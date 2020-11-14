![Java CI](https://github.com/qcdis-sdia/sdia-orchestrator/workflows/Java%20CI/badge.svg?branch=master)

# sdia-orchestrator
Software Defined Infrastructure Automator orchestrator.


Orchestrator for TOSCA workflows. Deploys, manages at runtime or undeploys a TOSCA topology of declarative workflows and imperative workflows. 

Generates declarative workflows which are automatically generated by the orchestrator based on nodes, relationships, and groups defined in the topology. 

The Orchestrator also executes imperative workflows which are manually specified. 


## Install


All components of this architecture are build as docker containers. 
To quickly run the engine use this [docker-compose.yaml](./blob/master/docker-compose.yml)
```
sudo docker stack deploy sdia -c docker-compose.yml
```

### Services
The architecture contains the following services:
* Rabbitmq: It is used to pass messages between the orchestrator and the planner, provisioner and deployer 
* MySQL: Used by Ansible Semaphore
* Ansible Semaphore: This is used by the deployer to run playbooks on provisioned VMs to mainly install k8s cluster 
* Logspout: A helping service to display all the log messages of all running services 
* MongoDB: Used by the orchestrator to store TOSCA templates 
* TOSCA Simple qUeRy sErvice (SURE): A RESTful service for verifying and querying TOSCA templates. The API definition and documentation  can be found here https://app.swaggerhub.com/apis-docs/skoulouzis/tosca-sure/1.0.0
* Planner: This service takes a TOSCA template as input that may contain only an application definition and generates a valid plan i.e. a plan that has all dependencies resolved.
* Provisioner: This service contacts a cloud provider to set up the virtual infatuate (mainly VMs)
* Deployer: This service initially deploys installs and  configures k8's cluster on the virtual infatuate and next install docker containers on that cluster 


## Architecture 
![SDIA Architecture](https://raw.githubusercontent.com/qcdia-sdia/sdia-orchestrator/master/images/Untitled%20drawing.png)
