# Scoreboard Setup

## Terraform

```bash
  docker run --name terraform -d -it -v ./:/root/terraform ubuntu
  docker exec -it terraform bash

  # Download terraform installation file and move to /usr/local/bin/
  cd ~/terraform
  mv terraform /usr/local/bin/
  terraform --version

  # Install aws-cli
  apt update && apt install -y curl unzip gnupg less nano
  curl -fsSL https://awscli.amazonaws.com/v2/install.sh | bash -s -- --system
  aws --version
  aws configure
  aws sts get-caller-identity

  # Terraform commands
  terraform init
  terraform plan
  terraform apply
  terraform destroy
```

## Ansible

```bash
  docker run --name ansible -d -it -v ./:/root/ansible ubuntu
  docker exec -it ansible bash

  cd ~/ansible
  apt update && apt install -y software-properties-common nano
  add-apt-repository --yes --update ppa:ansible/ansible
  apt install -y ansible
  ansible --version

  # Ansible commands
  ansible-inventory -i inventory.ini --list
  ansible myhosts -m ping -i inventory.ini
  ansible-playbook -i inventory.ini playbook-install-docker.yml
  ansible-playbook -i inventory.ini playbook-install-nginx.yaml
  ansible-playbook -i inventory.ini playbook-add-domain.yaml
```

## Jenkins

```bash
  # Install Java
  sudo apt update
  sudo apt install fontconfig openjdk-21-jre
  java -version

  # Install Jenkins
  sudo wget -O /etc/apt/keyrings/jenkins-keyring.asc \
    https://pkg.jenkins.io/debian-stable/jenkins.io-2026.key
  echo "deb [signed-by=/etc/apt/keyrings/jenkins-keyring.asc]" \
    https://pkg.jenkins.io/debian-stable binary/ | sudo tee \
    /etc/apt/sources.list.d/jenkins.list > /dev/null
  sudo apt update && sudo apt install jenkins

  sudo systemctl status jenkins
  sudo systemctl edit jenkins
  # Add this config
  [Service]
  Environment="JAVA_OPTS=-Djava.awt.headless=true -Djava.net.preferIPv4Stack=true -Djava.io.tmpdir=/var/cache/jenkins/tmp/"
  Environment="JENKINS_OPTS=--pluginroot=/var/cache/jenkins/plugins"

  # Create folder and set owner jenkins
  sudo mkdir -p /var/cache/jenkins/tmp
  sudo chown -R jenkins:jenkins /var/cache/jenkins/tmp
  sudo mkdir -p /var/cache/jenkins/plugins
  sudo chown -R jenkins:jenkins /var/cache/jenkins/plugins

  # Check config
  systemd-analyze verify jenkins.service

  # Credentials to setup
  ssh-login
  github-login
  docker-login
  ip-server-be
  ip-server-fe
```

## Github Action

```bash
  # Credentials to setup
  SSH_USER
  SSH_KEY
  DOCKER_USER
  DOCKER_PASS
  IP_SERVER_RUN
```
