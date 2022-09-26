# Prison System Application Tier
This repository is part of a larger, 3-tier system. All the details about the entire system can be found on the presentation tier repository: https://github.com/Mishanull/PrisonSystemPresentation
# Design of the Application Tier (Class Diagram)
![ApplicationDiagram](https://github.com/Mishanull/PrisonSystemApplication/blob/e0525f02d4e587f9701aad85fc31ea28359a93a4/Appendix-E_Application%20Tier%20Class%20Diagram.svg)
  The Application Tier is a Spring application, running on a Apache Tomcat server, so instead of subsystems, there are 
packages, the main ones being: rabbitmqservers, services, models, and utils. The 
rabbitmqservers package contains two sub-packages, namely config, and server. 
Configs package contains the configuration classes for setting up the RabbitMQ 
exchanges for each entity type and queues for each operation performed on these. 
The server package is comprised of components that act as servers for each entity 
type, listening to incoming messages on each declared queue and responding 
accordingly.

  The services package has interfaces and implementations of all the services that 
the servers use, grouped by entity type as well. These classes contain the main business 
logic that the application performs and also the operations that perform calls to the REST 
endpoints on the Data Access API. Email Service is an exception since it provides the 
functionality to send emails through SMTP to guards on creation, in order to provide them 
the credentials for logging into the system.

  Same as the entities subsystem in the presentation tier, the models package contains 
the main representations of entities from the domain model, which are present on all 
three tiers, with the same attributes.

  Utils has a few utility classes with static methods, such as PasswordGenerator, 
PasswordHasher, and UsernameGenerator, that are used to generate usernames and 
passwords for the guards and secure them.
The PrisonSystemApplication class is also included in the diagram, as it is the class 
that is used by Spring to run the application server.
