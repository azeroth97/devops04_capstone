#### Terraform

cd capstone
docker run --name terraform -d -it -v ./:/root/terraform ubuntu
docker exec -it terraform bash

cd ~/terraform
mv terraform /usr/local/bin/

terraform --version

apt update && apt install -y curl unzip gnupg less nano
curl -fsSL https://awscli.amazonaws.com/v2/install.sh | bash -s -- --system

aws --version
aws configure
<!-- ap-southeast-1 -->
aws sts get-caller-identity

terraform fmt
terraform init
terraform validate
terraform plan
terraform apply
terraform destroy

#### Ansible

docker run --name ansible -d -it -v ./:/root/ansible ubuntu
docker exec -it ansible bash

cd ~/ansible

apt update && apt install -y software-properties-common nano
add-apt-repository --yes --update ppa:ansible/ansible
apt install -y ansible

ansible --version
sudo cp /home/thongth/azeroth/dev/keys/aws/devops04.pem ansible/keys/

ansible-inventory -i inventory.ini --list
ansible myhosts -m ping -i inventory.ini

ansible-playbook -i inventory.ini playbook-install-docker.yml
ansible-playbook -i inventory.ini playbook-install-nginx.yaml
ansible-playbook -i inventory.ini playbook-add-domain.yaml
