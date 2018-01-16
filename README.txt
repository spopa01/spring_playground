Spring key strategies
1. Lightweight and minimally invasive development with POJOs
2. Loose coupling through DI and interface orientation
3. Declarative programming through aspects and common conventions
4. Eliminating boilerplate code with aspects and templates

At its core Spring is a Dependency Injection Container.
With DI, objects are given their dependencies at creation time by some 3rd party that coordinates each object in the system.
Objects aren't expected to create or obtain their dependencies.
Creating associations between application components is commonly called "wiring".
In a Spring application, an "application context" loads bean definitions and wires them together.
Spring application context is fully responsible for the creation and wiring of the objects that make up the application.
Spring comes with several implementations for the ApplicationContext, e.g. XML or Java configs.

Although DI makes it possible to tie software components together loosely, aspect oriented programming (AOP) enables to
capture functionality that's used throughout your application in reusable components.
AOP is often defined as a technique that promotes separation of concerns in a software system, e.g. logging, transaction management, security.
These system services are commonly referred to as "cross-cutting concerns" because they tend to cut across multiple components in the system.