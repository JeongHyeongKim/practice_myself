# INFRA - 20190412

인스턴스 삭제 후 기존 존재하던 볼륨에 인스턴스 연결하면 장치 호환이 안맞기 때문에 안될수도 있다.

이럴 경우를 대비해 리눅스에서 복구 툴을 제공한다. 비번치면 데이터는 복구된다. 


어제한거 삭제하기
-------------------
한거 아깝지만 삭제하자. 그냥 만드는 프로세스 반대로 하면 된다.
라우터 삭제할때는 꼭 인터페이스 먼저 삭제하고 라우터를 삭제해야한다. 안그러면 에러남.




yum install pdns pdns-recursor httpd pdns-backend-mysql mariadb-server
yum -y install php-cli php-pdo php-mcrypt php-common php-mysql php
 rpm -qa | grep pdns
power admin 다운 받고

tar xzf로 압출 푼다

poweradmin폴더를 /var/www/html로 옮긴다.
옮겨서 curl명령어로 poweradmin/index.php를 실행하면 403 Error가 뜬다.
이번 경우도 SELINUX가 실행되고 있기 때문에, 보안그룹이 다르다는 것을 ls -alZ로 확인 가능하다.

	drwxr-xr-x. root   root   system_u:object_r:httpd_sys_content_t:s0 .
	drwxr-xr-x. root   root   system_u:object_r:httpd_sys_content_t:s0 ..
	drwxrwxr-x. apache apache unconfined_u:object_r:default_t:s0 poweradmin

이를 바꿔주기 위해 chcon -R --reference=/var/www/html/ poweradmin 를 입력하면,

	drwxr-xr-x. root   root   system_u:object_r:httpd_sys_content_t:s0 .
	drwxr-xr-x. root   root   system_u:object_r:httpd_sys_content_t:s0 ..
	drwxrwxr-x. apache apache system_u:object_r:httpd_sys_content_t:s0 poweradmin

다음과 같이 보안그룹이 바뀐 것을 알 수 있다.

그다음, 파워어드민에 접속하면, 	
빨간화면이 뜨는데, 이를 위해 데이터베이스를 만들어주자.
mysql_secure_installation
하고 root비번 생성한 뒤, 디폴트로 다 생성한다 (엔터 광클)

mysql -u root -p하면 다음과 같이 DB콘솔이 뜬다.

	Enter password:
	Welcome to the MariaDB monitor.  Commands end with ; or \g.
	Your MariaDB connection id is 22
	Server version: 5.5.60-MariaDB MariaDB Server

	Copyright (c) 2000, 2018, Oracle, MariaDB Corporation Ab and others.

	Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

	MariaDB [(none)]>

콘솔창에다가 

	create database pdns
	grant all privilieges on pdns.* to 'pdns'@'locathost' identified by '~~~~~~';
	flush privilieges;

쳐서 pdns에 쓸 데이터베이스와 사용자를 생성한다.

생성한 다음, public_IP/poweradmin/install 드가서
step3 -> 자기가 만든 pdns계정과 pdns 데이터베이스 정보를 다 입력한다. 
step4 -> 앞으로 사용할 poweradmin user의 정보를 기입한다.
step5 -> 스킵
step6 -> 내용들을 복사해놓자.

다시 터미널 창 가서 
cp -a config-me.inc.php  config.inc.php

vi config.inc.php
한 다음 덮어쓰기 하자.

db_user와 db_password를 아까 만들었던 pdns계정과 동일하게 만들어준다.

그다음,  mv install/ install_bak 입력한다.

그다음,  public_IP/poweradmin/    들어가면,  다음과 같이 뜬다.
사진2

	username : admin
	password : config.inc.php 작성할 때 만든 user_password

다음과 같은 정보를 입력하면, 이런 화면이 뜰 것이다.
사진3


그 다음, List Zone 메뉴에 드가서 다음을 작성한다.
	
	Name			Type		content

	사번			NS			ns.사번.주어지는 주소
	사번			A				퍼블릭주소
	사번			A				퍼블릭주소
	www.사번		CNAME		ns.사번.주어지는 주소


위와 같이 추가하자.

다음, 최종적으로 설정을 추가하기 위해 vi에디터로 /etc/pdns/pdns.conf를 연다.
shift + G를 하면 맨 밑에 내려가는데, 거기다가 이거 때려넣자.

	launch=gmysql
	gmysql-host=127.0.0.1
	gmysql-port=3306
	gmysql-dbname=pdns
	gmysql-user=pdns
	gmysql-password=자신이 처음에 만든 사용자비번
	gmysql-dnssec=no
	gmysql-timeout=600

