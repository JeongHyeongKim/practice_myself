﻿# AWS study - 20190702

> AWS를 직접 사용하여 제품을 구성하기 위해 배워야 할 기초적인 부분을 서술함.


## Cloud Computing
>인터넷을 통해 IT Resource와 Applcation을 실시간으로 제공하는 서비스를 말하며, 사용한만큼만 요금이 청구되는 것을 말함.

클라우드로 서비스를 migration하는 이유는 향상된 민첩성? 때문이다. 민첩성은 속도, 실험, 혁신의 문화가 포함되어있다.

## 클라우드의 민첩성 요소
1. 속도
> AWS는 전 세계에 IT시설을 갖추고 있음. 언제 어디서든지 글로벌 규모로 사업을 할 수 있도록 support해준다. 고객이 있는 모든 곳에 Data Center를 두는 것은 impossable하지만, AWS를 통해 초기비용 투자 없이 시작 가능하다. 클라우드 컴퓨팅 환경 내에서는 IT Resource를 클릭 한번으로 접근 가능하다. 즉, 개발자에게 resource를 제공하는데 시간이 단축된다.
<br>
2. 실험
> 클라우드 컴퓨팅 환경에서는 IT Resource를 쉽게 제공 받을 수 있으므로, 이를 활용하여 실험 및 개발에 드는 비용이 절감된다. 그 결과 민첩성이 향상된다.
<br>
3. 혁신
- 실험 비용이 줄어들면 프로젝트를 빠르고 저렴하게 시작 할 수 있음. 그러므로 다양한 시도가 증가하게 되어 혁신의 가능성이 올라간다.

## Infra Components

1. Region
> 특정 영역 안의 2개 이상의 가용 영역의 모임. AWS 사용시, 데이터가 저장되고, 인스턴스를 실행하는 등 동작을 하는 region를 선택 가능하다. 가용 영역과는 달리, Region는 서로 독립적임.
<br>
2. AZ(가용 영역)
> 각 Region을 구성하는 구성요소. Resource의 격리된 모음. 가용영역간 발생한 장애로부터 독립적으로 설계된다. Region접속 시 가장 빠른 가용영역으로 연결이 된다.
<br>
3. Edge Location
- 정적 및 동적 스트리밍 컨텐츠를 전송하는데 필요한 전송 네트워크를 호스팅함. 컨텐츠 요청은 가장 가까운 Edge Location으로 전송되므로, 최적의 성능을 보장함.


## AWS(Cloud Service)의 핵심 이점

1. Cost
> On-Premise Infra 구축은 하드웨어 장비 주문부터 시작해서 어플리 케이션 구성까지 많은 요소들을 구성하여야 하며 이에 따른 많은 비용이 소모된다. 하지만 Cloud를 사용하면 선결제 비용없이 클라우드 서버를 실행 가능하고, 구성할 수 있기 때문에 사용한 만큼만 비용을 지불하게 된다.
<br>
2. Elasticity
> Resource규모를 수요에 따라 쉽게 확장 및 축소 할 수 있으며 실제 사용한 Resource에 대해서만 지불하면 된다.  또한 임의로 용량을 예측하여 인프라의 낭비가 없이 사용하도록 그 시점에 필요한 만큼의 용량만 프로비저닝 되게 설계되어있음.
<br>
3. Flexibility
> Cloud에서 다양한 서비스를 제한없이 담을 수 있기 때문에 유연함.
<br>
4. Security
> 오랫동안 운영하면서 노하우 쌓인만큼 보안 기술 지원이 빡셈. 이라고 함.
