package com.wjl.apigateway;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx=RequestContext.getCurrentContext();
		HttpServletRequest request=ctx.getRequest();
		Object accessToken=request.getParameter("accessToken");
		if(accessToken==null){
			ctx.setSendZuulResponse(false);
			/*设置错误的状态码是执行内部错误处理程序的关键步骤，不能省略。
			      也可以这样设置：ctx.set("error.status_code",HttpServletResponse.SC_INTERNAL_SERVER_ERROR); */
			ctx.setResponseStatusCode(401);
			return null;
		}
		return null;
	}

	@Override
	public String filterType() {
		// 包括"pre","route","post"和"error",4种过滤器类型
		return "pre";
	}

	@Override
	public int filterOrder() {
		// 返回的数值越小优先级越高，可以为负数，但是不建议
		return 0;
	}

}
