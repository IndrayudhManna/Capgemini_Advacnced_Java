# Jenkins CI/CD Pipeline

## CI/CD Concepts

**CI - Continuous Integration**
Developers frequently integrate their code into a shared repository. Each integration triggers automated builds and tests.

**CD - Continuous Delivery**
After integration, the application is automatically prepared for release so it can be deployed anytime.

**CI + CD** together are called a **methodology** used in modern DevOps practices.

---

## Jenkins

**Jenkins** is a tool used to implement **CI/CD automation**.

---

# Item Creation in Jenkins

Create a **Freestyle Project** in Jenkins.

---

## Connect Git Repository

1. Add **Git repository link**
2. Select **Credentials**

---

## Poll SCM

Enable **Poll SCM** and add the following schedule:

```
H/2 * * * *
```

This means Jenkins will check the repository **every 2 minutes** for changes.

---

## Branch Configuration

Change the branch from:

```
master
```

to

```
main
```

(according to your repository branch)

---

# Add Build Steps

Select:

```
Execute Windows batch command
```

Then add the following commands:

```
cd src
javac com/git2/pipe2.java
java com.git2.pipe2
```

These commands compile and run the Java program.

---

# Creating a Jenkins Pipeline (Project Chaining)

To create a pipeline between multiple projects:

Go to:

```
Project1 → Post Build Steps → Build Other Projects
```

Enable:

```
Trigger even if build fails
```

Then write:

```
Project2
```

Click **Save**.

---

## Pipeline Chain

To create a chain of builds:

```
Project1 → Project2 → Project3
```

Steps:

1. Configure **Project1** to trigger **Project2**
2. Configure **Project2** to trigger **Project3**

This creates a **simple CI/CD pipeline using Jenkins**.

**Refer to the repos PipeLineRepo1, PipeLineRepo2, PipeLineRepo3 for File Details.
To Visit and use Jenkins in any browser write localhost:8080**
