package com.ohgiraffers.autoconfiguration.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// SpringBootApplication 의 설정창에 들어가 확인해보면 알 수 있듯이
// componentScan 의 basepackage 가 비어 있다
// basepackage 가 비어 있다는 것은 해당 클래스가 존재하는 패키지내부에 있는 값들만 스캔을 하겠다는 의미인것이고
// 따라서 다른 패키지에 존재하는 SpringConfiguration은 Ioc 컨테이너에 생성되지 않게 되어
// 인식이 되지 않는것이다
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		// yaml 과 properties 가 중복된 key 값을 가질때 확인해본결과
		// properties 에 우선순위가 있다

		//key 값이 username 인 값이 뜬금없이 'hi' 가 나왔다
		//properties 나 yaml 보다 더 우선순위 있는것은 시스템 환경변수이다
		// cmd 창에 set 을 적으면 username이  존재하는것을 확인할수 있다
	}

}
