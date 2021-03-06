package com.fd.springbootdemo.aspect;

import com.fd.springbootdemo.annotation.PageQuery;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author fengdi
 * @Create 2018-09-18 9:46
 * @Desc 切面
 **/
@Aspect
@Component
public class PageAop {

    @Around("@annotation(pageQuery)")
    public Object pageQuery(ProceedingJoinPoint joinPoint, PageQuery pageQuery) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Class<?> clazz = signature.getMethod().getReturnType();  //得到方法的返回类型
        if (clazz == List.class) {
            String pageNumName = pageQuery.pageNumName();//page的页码
            String pageSizeName = pageQuery.pageSizeName();//一页的条数
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            String pageNum = request.getParameter(pageNumName);
            String pageSize = request.getParameter(pageSizeName);
            if (StringUtils.isNotBlank(pageNum)&&StringUtils.isNotBlank(pageSize)) {
                try {
                    PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize));
                    List<?> result = (List<?>) joinPoint.proceed();
                    return result;
//                    PageInfo pageInfo =  new PageInfo<>((result));
//                    DataGridResult dataGridResult = new DataGridResult();
//                    dataGridResult.setTotal(pageInfo.getTotal());
//                    dataGridResult.setRows(result);
//                    return dataGridResult;
                }finally {
                    if (PageHelper.getLocalPage() != null)
                        PageHelper.clearPage();
                }
            }
        }
        return joinPoint.proceed();
    }
}
