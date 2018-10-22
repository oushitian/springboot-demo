//package com.fd.springbootdemo.shiro;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.subject.Subject;
//import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@Slf4j
//public class MyAuthenticationFilter extends FormAuthenticationFilter {
//
//    @Override
//    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
//        if (request instanceof HttpServletRequest) {
//            System.out.println(request.getParameter("username"));
//            if (((HttpServletRequest) request).getMethod().toUpperCase().equals("OPTIONS")) {
//                return true;
//            }
//        }
//        return super.isAccessAllowed(request, response, mappedValue);
//    }
//
//    @Override
//    protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
//            throws Exception {
//        if (this.isLoginRequest(request, response)) {
//            if (this.isLoginSubmission(request, response)) {
//                if (log.isTraceEnabled()) {
//                    log.trace("Login submission detected.  Attempting to execute login.");
//                }
//
//                return this.executeLogin(request, response);
//            } else {
//                if (log.isTraceEnabled()) {
//                    log.trace("Login page view.");
//                }
//                return true;
//            }
//        } else {
//            if (log.isTraceEnabled()) {
//                log.trace("Attempting to access a path which requires authentication.  Forwarding to the Authentication url [" + this.getLoginUrl() + "]");
//            }
//            response.setContentType("application/json");
//            response.setCharacterEncoding("UTF-8");
//            PrintWriter out = response.getWriter();
////            ServletResponse serverResponse = ServletResponse.createByErrorMessage("未登录，无法访问该地址");
////            Gson gson = GsonFactory.getGson();
////            String s = gson.toJson(serverResponse);
//            out.println("未登录，无法访问该地址");
//            out.flush();
//            out.close();
//            return false;
//        }
//    }
//
//    @Override
//    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter out = null;
//        try {
//            out = response.getWriter();
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
////        HttpSession session = ((HttpServletRequest) request).getSession();
////        OmUser user = userMapper.selectByUserName(token.getPrincipal().toString());
////        session.setAttribute(Const.CURRENT_USER, user);
////        ServerResponse serverResponse = ServerResponse.createBySuccessMsg("登录成功");
////        Gson gson = GsonFactory.getGson();
////        String s = gson.toJson(serverResponse);
//        out.println("登录成功");
//        out.flush();
//        out.close();
//        return true;
//    }
//
//    @Override
//    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter out = null;
//        try {
//            out = response.getWriter();
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
////        ServerResponse serverResponse = ServerResponse.createByErrorMessage("登录失败");
////        Gson gson = GsonFactory.getGson();
////        String s = gson.toJson(serverResponse);
//        out.println("登录失败");
//        out.flush();
//        out.close();
//        return false;
//    }
//
//}
