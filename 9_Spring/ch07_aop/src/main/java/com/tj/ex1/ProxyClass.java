package com.tj.ex1;

import org.aspectj.lang.ProceedingJoinPoint;

public class ProxyClass {
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {// joinPoint = 핵심기능
		//aroundAdvice : 핵심기능 전후로 공통기능 수행
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		String signatureName = joinPoint.getSignature().toShortString();
		String signatureNameLong = joinPoint.getSignature().toLongString();
		System.out.println(signatureName+"가 시작되었습니다.");
		System.out.println(signatureNameLong+"Long 시작되었습니다.");
		long startTime = System.currentTimeMillis();
		try {
			Object obj = joinPoint.proceed(); //핵심기능  수행해
			return obj;
		} finally {
			long endTime = System.currentTimeMillis();
			System.out.println(signatureName+"이 끝났습니다. 걸린시간 : "+(endTime-startTime));
		}
	}
	public void beforeAdvice() {
		System.out.println("beforeAdvice실행 : 이 공통기능 수행하고 알아서 핵심기능 수행하고 끝");
	}
	public void afterAdvice() {
		System.out.println("afterAdvice실행 : 핵심기능 수행하고 이 공통기능 수행");
	}
	public void afterReturningAdvice() {
		System.out.println("afterReturningAdvice실행 : 핵심기능이 예외발생 안되고 잘 실행된 후 이 공통기능 수행");
	}
	public void afterThrowingAdvice() {
		System.out.println("afterThrowingAdvice실행 : 예외가 발생된 핵심기능 수행된 후 이 공통기능 수행");
	}
	
}
