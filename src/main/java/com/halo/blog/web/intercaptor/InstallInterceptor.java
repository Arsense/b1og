package com.halo.blog.web.intercaptor;

import com.halo.blog.enums.BaseConstant;
import com.halo.blog.enums.PropertyEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
/**
 *  <pre>
 *     博客初始化拦截器
 * </pre>
 *
 * @author tangwei
 * @date 2018/10/9 18:00
 */
@Component
public class InstallInterceptor  implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if (StringUtils.equals("true", BaseConstant.OPTIONS.get(PropertyEnum.IS_INSTALL.getProp()))) {
            return true;
        }
        //没安装走下面
        response.sendRedirect("/install");
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
