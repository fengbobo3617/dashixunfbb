package cn.jiyun.zuul.jiyunzull.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component

public class LoginFilter extends ZuulFilter {
    /**
     * 过滤器类型 前置过滤器
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 过滤器是否生效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     *
     * 登录校验
     */
    @Override
    public Object run() throws ZuulException {
        //获取zull网关提供的上下文对象
        RequestContext currentContext = RequestContext.getCurrentContext();
        //从上下文对象获取请求对象
        HttpServletRequest request = currentContext.getRequest();
        //获取token信息
        String token = request.getParameter("access-token");
        if (StringUtils.isBlank(token)){
            //过滤该请求,不对其进行路由
            currentContext.setSendZuulResponse(false);
            //设置相应状态码 401(身份未认证)
            currentContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            //设置信息
            currentContext.setResponseBody("request error");
        }
        //验证通过 把登录信息放到上下文
        currentContext.set("token",token);
        //返回null 过滤器什么也不做
        return null;
    }
}
