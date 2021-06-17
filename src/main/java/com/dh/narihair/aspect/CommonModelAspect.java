package com.dh.narihair.aspect;

import com.dh.narihair.entity.Admin;
import com.dh.narihair.repo.AdminRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class CommonModelAspect {
    final private AdminRepo adminRepo;

    @Around("execution(public * com.dh..*Controller.*(..))")
    public Object commonModelSet(ProceedingJoinPoint joinPoint) throws Throwable{
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        log.debug("methodName : {}",methodName);
        if(!methodName.equals("loginPage")) {
            ModelMap modelMap = null;
            int pos = 0;
            for (Object object : args) {
                if (object instanceof ModelMap) {
                    modelMap = (ModelMap) object;
                    break;
                }
                pos++;
            }

            UserDetails principal = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            Admin loginVO = adminRepo.findOneById(principal.getUsername());

            modelMap.addAttribute("loginVO", loginVO);
            modelMap.addAttribute("methodName", methodName);

            //데이터 전달
            if (args.length > 0 && modelMap != null) {
                args[pos] = modelMap;
            }
        }

        return joinPoint.proceed(args);
    }
}
