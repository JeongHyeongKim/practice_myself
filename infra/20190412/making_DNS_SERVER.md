# INFRA - 20190412

�ν��Ͻ� ���� �� ���� �����ϴ� ������ �ν��Ͻ� �����ϸ� ��ġ ȣȯ�� �ȸ±� ������ �ȵɼ��� �ִ�.

�̷� ��츦 ����� ���������� ���� ���� �����Ѵ�. ���ġ�� �����ʹ� �����ȴ�. 


�����Ѱ� �����ϱ�
-------------------
�Ѱ� �Ʊ����� ��������. �׳� ����� ���μ��� �ݴ�� �ϸ� �ȴ�.
����� �����Ҷ��� �� �������̽� ���� �����ϰ� ����͸� �����ؾ��Ѵ�. �ȱ׷��� ������.




yum install pdns pdns-recursor httpd pdns-backend-mysql mariadb-server
yum -y install php-cli php-pdo php-mcrypt php-common php-mysql php
 rpm -qa | grep pdns
power admin �ٿ� �ް�

tar xzf�� ���� Ǭ��

poweradmin������ /var/www/html�� �ű��.
�Űܼ� curl��ɾ�� poweradmin/index.php�� �����ϸ� 403 Error�� ���.
�̹� ��쵵 SELINUX�� ����ǰ� �ֱ� ������, ���ȱ׷��� �ٸ��ٴ� ���� ls -alZ�� Ȯ�� �����ϴ�.

	drwxr-xr-x. root   root   system_u:object_r:httpd_sys_content_t:s0 .
	drwxr-xr-x. root   root   system_u:object_r:httpd_sys_content_t:s0 ..
	drwxrwxr-x. apache apache unconfined_u:object_r:default_t:s0 poweradmin

�̸� �ٲ��ֱ� ���� chcon -R --reference=/var/www/html/ poweradmin �� �Է��ϸ�,

	drwxr-xr-x. root   root   system_u:object_r:httpd_sys_content_t:s0 .
	drwxr-xr-x. root   root   system_u:object_r:httpd_sys_content_t:s0 ..
	drwxrwxr-x. apache apache system_u:object_r:httpd_sys_content_t:s0 poweradmin

������ ���� ���ȱ׷��� �ٲ� ���� �� �� �ִ�.

�״���, �Ŀ����ο� �����ϸ�, 	
����ȭ���� �ߴµ�, �̸� ���� �����ͺ��̽��� ���������.
mysql_secure_installation
�ϰ� root��� ������ ��, ����Ʈ�� �� �����Ѵ� (���� ��Ŭ)

mysql -u root -p�ϸ� ������ ���� DB�ܼ��� ���.

	Enter password:
	Welcome to the MariaDB monitor.  Commands end with ; or \g.
	Your MariaDB connection id is 22
	Server version: 5.5.60-MariaDB MariaDB Server

	Copyright (c) 2000, 2018, Oracle, MariaDB Corporation Ab and others.

	Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

	MariaDB [(none)]>

�ܼ�â���ٰ� 

	create database pdns
	grant all privilieges on pdns.* to 'pdns'@'locathost' identified by '~~~~~~';
	flush privilieges;

�ļ� pdns�� �� �����ͺ��̽��� ����ڸ� �����Ѵ�.

������ ����, public_IP/poweradmin/install �尡��
step3 -> �ڱⰡ ���� pdns������ pdns �����ͺ��̽� ������ �� �Է��Ѵ�. 
step4 -> ������ ����� poweradmin user�� ������ �����Ѵ�.
step5 -> ��ŵ
step6 -> ������� �����س���.

�ٽ� �͹̳� â ���� 
cp -a config-me.inc.php  config.inc.php

vi config.inc.php
�� ���� ����� ����.

db_user�� db_password�� �Ʊ� ������� pdns������ �����ϰ� ������ش�.

�״���,  mv install/ install_bak �Է��Ѵ�.

�״���,  public_IP/poweradmin/    ����,  ������ ���� ���.
����2

	username : admin
	password : config.inc.php �ۼ��� �� ���� user_password

������ ���� ������ �Է��ϸ�, �̷� ȭ���� �� ���̴�.
����3


�� ����, List Zone �޴��� �尡�� ������ �ۼ��Ѵ�.
	
	Name			Type		content

	���			NS			ns.���.�־����� �ּ�
	���			A				�ۺ��ּ�
	���			A				�ۺ��ּ�
	www.���		CNAME		ns.���.�־����� �ּ�


���� ���� �߰�����.

����, ���������� ������ �߰��ϱ� ���� vi�����ͷ� /etc/pdns/pdns.conf�� ����.
shift + G�� �ϸ� �� �ؿ� �������µ�, �ű�ٰ� �̰� ��������.

	launch=gmysql
	gmysql-host=127.0.0.1
	gmysql-port=3306
	gmysql-dbname=pdns
	gmysql-user=pdns
	gmysql-password=�ڽ��� ó���� ���� ����ں��
	gmysql-dnssec=no
	gmysql-timeout=600

