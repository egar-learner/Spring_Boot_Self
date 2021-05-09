package com.otp.testing.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOPMain {
	
	Logger log = LoggerFactory.getLogger(AOPMain.class);
	
	
	@Around("execution(* com.otp.testing.service.EmployeeService.getAllTheEmployee())")  
	public Object aroundAdvice(ProceedingJoinPoint pjp) {  
		
		long start = System.currentTimeMillis();
		Object obj = null;
		try {
			obj = pjp.proceed();
		} catch (Throwable e) {
			System.out.println("Exception e = "+ e.getMessage());
		}
		
		long end = System.currentTimeMillis();
		log.info("Method name" + pjp.getSignature() + "time taken to execute = "+ (end-start));
		System.out.println("Milli-second = "+ (end-start) );
		return obj;
	}
	
	@Around("@annotation(com.otp.testing.annotation.TrackExecutionTime)")  
	public Object aroundTimeAdvice(ProceedingJoinPoint pjp) {  
		
		long start = System.currentTimeMillis();
		Object obj = null;
		try {
			obj = pjp.proceed();
		} catch (Throwable e) {
			System.out.println("Exception e = "+ e.getMessage());
		}
		
		long end = System.currentTimeMillis();
		log.info("Method name" + pjp.getSignature() + "time taken to execute = "+ (end-start));
		System.out.println("Milli-second = "+ (end-start) );
		return obj;
	}
	
	@Pointcut("execution(public com.otp.testing.model.Employee com.otp.testing.service.EmployeeService.getEmployeeAdviceById(Long))")
	public void pointCutMethod() {
		System.out.println("PointCut executed!");
	}
	
	@Around("pointCutMethod()")
	public void aroundAdviceExecute() {
		System.out.println("Around method executed for pointcut!");
	}
	
	@Before("execution(public com.otp.testing.model.Employee com.otp.testing.service.EmployeeService.findEmployeeById(Long))")  
	public void beforeAdvice() {  
		System.out.println("Before Advice executed!");
	}  
	
	@After("execution(* com.otp.testing.service.EmployeeService.getAllEmployee())")  
	public void afterAdvice() {  
		System.out.println("After Advice executed!");
	} 
	
	/*@Around("execution(* com.otp.testing.service.EmployeeService.*(..))")  
	public void aroundAdvice(final ProceedingJoinPoint join) {  
		System.out.println("Around runs!");
		long start = System.currentTimeMillis();

        Object value;

        try {
            value = join.proceed();
        } catch (Throwable throwable) {
        	System.out.println(throwable.getMessage());
        } finally {
            long duration = System.currentTimeMillis() - start;

            System.out.println(
                    "{}.{} took {} ms"+
                    join.getSignature().getDeclaringType().getSimpleName()+
                    join.getSignature().getName()+
                    duration);
        }
        
	}*/

        
        @AfterReturning("execution(* com.otp.testing.service.EmployeeService.getResultIfRunning())")  
    	public void afterReturningAdvice() {
        	System.out.println("After returning method to test runs!");
        } 
        
        @AfterThrowing("execution(* com.otp.testing.service.EmployeeService.getEmployeeByThrowingId(..))")  
    	public void afterThrowingAdvice() {
        	System.out.println("After throwing method to test runs!");
        } 
        
        

}
