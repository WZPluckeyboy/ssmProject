package com.ping.Controller;

import com.ping.Service.ISysLogService;
import com.ping.domain.SysLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {
    @Autowired
    private ISysLogService iSysLogService;
    @Autowired
    private HttpServletRequest request;
    private Date visitTime;
    private Class clazz;
    private Method method;
    @Before("execution(* com.ping.Controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
       visitTime=new Date() ;
       clazz=jp.getTarget().getClass();
      String methodName=jp.getSignature().getName();
        Object[] args = jp.getArgs();
        if(args==null ||args.length==0) {
            method = clazz.getMethod(methodName);
        }else {
            Class[] classargs=new Class[args.length];
           for (int i=0;i<args.length;i++){
               classargs[i]= args[i].getClass();
           }
            method = clazz.getMethod(methodName,classargs);
        }
    }

    @After("execution(* com.ping.Controller.*.*(..))")
    public void doAfter(JoinPoint jp){
        String url=null;
        long time=new Date().getTime()-visitTime.getTime();
        if(clazz!=null&&method!=null&&clazz!= LogAop.class){
           RequestMapping classannotation = (RequestMapping)clazz.getAnnotation(RequestMapping.class);
           if(classannotation!=null){
               String s = classannotation.value()[0];
               RequestMapping methodannotation = method.getAnnotation(RequestMapping.class);
               if (methodannotation!=null){
                   String[] s1 = methodannotation.value();
                   url=s+s1;
                   String ip=request.getRemoteAddr();
                   SecurityContext context= SecurityContextHolder.getContext();
                   User user = (User) context.getAuthentication().getPrincipal();
                   String username=user.getUsername();

                   SysLog sysLog=new SysLog();
                   sysLog.setVisitTime(visitTime);
                   sysLog.setMethod(ip);
                   sysLog.setUrl(url);
                   sysLog.setUsername(username);
                   sysLog.setExecutionTime((double) time);
                   sysLog.setMethod(clazz.getName()+method);
                   iSysLogService.save(sysLog);
               }
           }
        }
    }
}
