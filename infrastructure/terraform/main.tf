provider "aws" {
  region = "ap-southeast-1"
}
data "aws_ami" "ubuntu" {
  most_recent = true
  filter {
    name   = "name"
    values = ["ubuntu/images/hvm-ssd-gp3/ubuntu-noble-24.04-amd64-server-*"]
  }
  owners = ["099720109477"] # Canonical
}

locals {
  servers = {
    "scoreboard_be" = "t3.small"
    "scoreboard_fe" = "t3.small"
    "jenkins" = "m7i-flex.large"
    "grafana" = "m7i-flex.large"
  }
}

resource "aws_instance" "app_server" {
  for_each = local.servers

  ami                    = data.aws_ami.ubuntu.id
  instance_type          = each.value
  key_name               = "devops04"
  vpc_security_group_ids = [aws_security_group.scoreboard_sg.id]

  tags = {
    Name = each.key
  }
}

resource "aws_security_group" "scoreboard_sg" {
  name = "scoreboard-sg"

  # inbound
  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
  ingress {
    from_port   = 443
    to_port     = 443
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  # outbound
  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

output "public_ips" {
  value = { for name, inst in aws_instance.app_server : name => inst.public_ip }
}