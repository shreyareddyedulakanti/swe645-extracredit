# Homework Assignment 3:

- Shreya Edulakanti - G01395111
- Sai Sirichandana Kanuri - G01371765
- Karthik Vanam - G01397770
- Vijaya Sravani Anuhya Pannala - G01378474

This assignment is the continuation of previous homework assignment one. In this assignment we are going to implement CRUD operations using spring boot and use docker, git, rancher, kubernetes, jenkins, AWS EC2 with elastic IPs, Amazon RDS, and MYSQL workbench.

## URLs

1. Homepage : http://ec2-3-233-16-227.compute-1.amazonaws.com:31281/survey
2. Jenkins : http://ec2-3-233-16-227.compute-1.amazonaws.com:8080/
3. Rancher : http://ec2-52-55-79-102.compute-1.amazonaws.com/
4. Github : https://github.com/shreyareddyedulakanti/swe645-hw3
5. Docker : https://hub.docker.com/repository/docker/shreyare97/surveyformpage/general

## Instructions

## Create a MYSQL database on Amazon RDS

1. To create a database in Amazon RDS, click on create database.
2. Then select "Standard create" and in Engine options select "MySQL".
3. Then select the latest engine version and template as "free tier".
4. Give a name in DB instance identifier and set up the credentials.
5. Then select the CPU as t3.micro and storage.
6. Configure connectivity settings.
7. Next, create a new VPC.
8. Choose database authentication as password.
9. In database options, we gave a database name. "surveypagedb".
10. We configured other settings as below and created the database.
11. The database is created.
12. Edit the inbound rules in Security groups from custom to Anywhere.

## MySQL workbench

1. We created a new connection in the workbench with the name surveypage database.
2. Then we tested the database by performing some operations.
3. After the operations are performed successfully. We close it.

## Spring Boot Application

1. We created a springboot application from Spring Initializr https://start.spring.io/ by filling the details and adding dependencies necessary for the assignment.
2. Then unzip the folder and import this project into eclipse IDE.
3. Run the application as Spring boot App.
4. After running it successfully, we stop it and implemented the CRUD operations and ran it again locally as spring boot app. We check and perform operations on the database using the URL.
5. We performed the operations on Postman.
6. We use POST verb along with the http://localhost:8888/survey/create as URL and send it. We receive 201 created after the data is stored successfully in the database.
7. Similarly, we perform rest of the operations.
8. Retrieve all surveys, http://localhost:8888/survey with GET verb.
9. Delete a survey, http://localhost:8080/survey/delete/3 with DELETE verb.
10. Individual survey data, http://localhost:8888/survey/1 with GET verb.
11. Update survey data, http://localhost:8080/survey/update/3 with PUT verb.
12. Then stop the instance.

## Create a jar file

1. We create a jar file using the Run as maven clean and then Run as maven install which will create jar file in the target folder.

## Creating a docker image and pushing it to dockerhub.

1. We installed docker with docker desktop on our machine, and also created an account on dockerhub.
2. Now create a dockerfile and define steps for copying the jar file, run the docker, check the docker is working by posting the requests to docker URL and then push the changes to docker hub.
3. The dockerfile contains the statements below:
   - FROM openjdk:17
   - COPY target/surveyformpage.jar surveyformpage.jar
   - ENTRYPOINT ["java","-jar","/surveyformpage.jar"]
   - EXPOSE 8080
4. On command line we used "docker build -t surveyformpage ." to build the project make sure to keep your docker desktop open.
5. To run the docker image we use, "docker run -it --rm -p 8888:8080 surveyformpage"
6. The above command launches tomcat container and maps the port 8888 to port 8080 inside that container.
7. We can now access the application using port 8888 as below
   http://localhost:8888/survey
8. This will run successfully.
9. Now we need to deploy our docker image to dockerhub using the commands below
   - "docker login -u shreyare97" (username of dockerhub account)
   - Tag the image using "docker tag surveyformpage shreyare97/studentsurvey"
   - Push the image to dockerhub using "docker push shreyare97/studentsurvey"
   - Verify if the image is published successfully on dockerhub.

## Git

- Create a Github account and also download gitbash to run git on your local machine.
- Create a repository on Github named swe645-hw3.
- Then we go to the terminal and navigate to the root directory of the project and use "git init" command to initialize repository for the project.
- After creating the repository, we copy the URL and go back to the terminal and run "git remote add origin git@github.com:shreyareddyedulakanti/swe645-hw3.git". We used ssh as we have already configured ssh locally for git.
- Now stage and commit the changes using the commands:
  - git add .
  - git commit -m "Initial commit"
- Finally push the changes to GitHub using "git push -u origin master". Here we push changes to master branch.
- Verify that the code is pushed to GitHub by refreshing the GitHub page.
- Later we also add Jenkinsfile to the github for autobuild.

## Installing Rancher on AWS

1. Create two new EC2 instances(Rancher and Kubernetes) from the console in AWS learner lab.
2. To create these instances, we used Ubuntu server 20.24 AMI. In this we used 20.04 LTS(HVM), ssd volume type.
3. Few specifications we did on these instances is, we allowed inbound traffic for the ports custom:8080, http:80, https:443 and ssh:22.
   And also we have configured the outbound rule to allow full traffic.
4. We used t3.large system type and changed the storage to 30GB.
5. In advance settings, select IAM instance profile as Labinstance profile.
6. Configure Elastic IPs for both the EC2 instances.
7. Connect the two instances using ssh command on terminal using public IP addresses or using connect button on console.
8. After connecting, use sudo su- command to go to root.
9. We installed docker and verified on both instances by using these commands :
   "sudo apt-get update"
   "sudo apt install docker.io"
   "sudo docker -v"
   "sudo usermod -aG docker ubuntu"
10. On rancher instance, we are installing Rancher UI.
11. We goto rancher.io -> get started and copy the command under the start server box and paste it on the your rancher instance:
    "$ sudo docker run --privileged -d --restart=unless-stopped -p 80:80 -p 443:443 rancher/rancher"
12. Check if the rancher is installed using the command docker ps
13. Goto the PublicIPV4 dns address -> advanced setting -> goto the link using http protocol
14. We get a welcome to rancherUI page, use the following command :
    'docker logs 81705876660e 2>&1 | grep "Bootstrap Passwrd:"' on the instance terminal and generate a random password for first time login
15. Using the generated password, we login to the rancher
16. Once you login , set a specific password to use in the future
17. We already see a default cluster created, but we need to create a new cluster:
    Go to cluster management
    Click on create
    Select custom
    Under use existing node, create a cluster using rke custom
18. Custom -> add a name to cluster and hit next
    Click the three checkboxes, etcd, controlplane, worker, and copy the command with insecure as checked and paste it on instance 2 (Kubernetes)terminal and run it
19. On the rancher UI Wait for the cluster to become active. After we see active we are ready to deploy.
20. We click on the explore button on the newly created cluster, then click workload then deployment
21. Click create, we fill in the name, increase the replicas to 3 and add a container image i.e a docker image and add a port
22. For the port service type, select NodPort, give it a name and for the private container port, list 8080 leave the listening port blank and it will auto populate with a port ranging from 30000 to 32767.
23. Hit Create and wait for it to configure
24. After it becomes active, we copy the endpoints, portnumbers and paste it in the network inbound rules to allow the traffic and then use the same port on the URL(Public DNS) of EC2 instance as below:
    http://ec2-3-233-16-227.compute-1.amazonaws.com:31281/survey
25. After seeing the homepage we go back to rancher, and checkbox the cluster and then download the kubeconfig YAML file
26. Copy content from that file and go back to Kubernetes instance terminal and execute the commands below:

- Make a directory on home directory using:
  - mkdir ~/.kube/
- Inside the .kube file create a config file using the command below and paste the content copied from the kubeconfig.yml file and paste it here.
  - nano config
- After saving the file, we install kubectl using:
  - %snap install kubectl -classic

## Installing Jenkines on EC2 instance(Kubernetes)

1. We need to install Jenkins on the same instance where we launched our website.
2. Go to the terminal of instance, navigate to root by using "sudo su -" and install java to run Jenkins as below
   - sudo apt-update
   - sudo apt install openjdk-17-jdk
3. For checking the version, java -version
4. For Jenkins, import gpg key of Jenkins repository using the following commands:
   - sudo apt install wget
   - sudo wget -O /usr/share/keyrings/jenkins-keyring.asc \ https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key
5. Now add the Jenkins repository
   - echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \ https://pkg.jenkins.io/debian-stable binary/ | sudo tee \ /etc/apt/sources.list.d/jenkins.list > /dev/null
6. Now the repository is enabled, we update the package, and install latest Jenkins versions
   - sudo apt update
   - sudo apt install jenkins
7. We can verify Jenkins using "systemctl status jenkins"
8. Then we setup the Jenkins on "http://ec2-3-233-16-227.compute-1.amazonaws.com:8080/"
9. Get the password using "sudo cat /var/lib/jenkins/secrets/initialAdminPassword", and we get a 32 character long password.
10. Copy and paste it in password field and click continue.
11. Use sudo usermod -aG docker jenkins. This is done to ensure that user running the Docker commands is a member of Docker group.

## Setting up jenkins

1. Install suggested plugins box
2. Once the plugins are installed, setup the user
3. the next page will automatically populate jenkins URL
4. Click on start using jenkins button, You will be redirected to jenkins dashboard
5. Next time we use login credentials to log in to the dashboard

## Project Folder

We create a Jenkinsfile and mention steps necessery for automating our project and push it to Git.

## Create a pipeline on Jenkins

1. We need to install plugins using Manage plugins and install "BitBucket" , "Docker", "Build time stamp", "Docker pipeline"Click on "create a job" and enter a name and select pipeline and click OK.
2. Update the maven configuration settings to use maven 3.9.6 and also add docker credentials globally.
3. Then we configure the pipeline, go to build trigger section and select poll SCM.
4. In the schedule text field, we set up every minute build trigger value as `* * * * *`.
5. On the same page, we go to pipeline section, under definition, select pipeline script from SCM.
6. In the SCM field, select Git and give the repository URL of our project along with credentials of Git also select branch as main to pull the latest files of the project.
7. we also specify that we will put Jenkinsfile in the root directory of our project and click save.

## Jenkins pipeline UI

The pipeline will detect the Jenkinsfile from the Git and execute the steos mentioned in the file as below.

- First, it pulls the project from Git and uses maven to build the jar file. Next, build docker image and attach the build number for tagging the version.
- Next, we push the image to docker hub using the credentials of docker hub.
- Finally, we deploy the latest docker image to rancher from which the AWS displays the form website.

## Final Output

- We again performed CRUD operations using http://ec2-3-233-16-227.compute-1.amazonaws.com:31281/survey on postman and successfully obtained the results. The output screen is present in the document or report file.

## References

- Lecture slides
- https://www.jenkins.io/doc/
- https://www.jenkins.io/doc/book/installing/linux/#debianubuntu
- https://hub.docker.com/
- Pushing the spring boot application to git: https://medium.com/@gayankurukulasooriya/how-to-push-a-spring-boot-application-on-github-3e4b7688bdc6
