### Springboot Starter Application 

- Spring boot starter project. It auto-configures beans if property --score.filePath is present in Spring's Environment.

- It creates a 'thin' jar via a gradle task. 

- Injects properties into a class using @ConfigurationProperties

- Implements Conditional Interface to look for property --score.filePath. If present, triggers Spring Bean creation.

- Provides an Interface for developers to provide their own implementation.

- Provides default logic to calculate scores. 