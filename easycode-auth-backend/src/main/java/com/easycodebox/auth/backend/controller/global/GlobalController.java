package com.easycodebox.auth.backend.controller.global;

import com.easycodebox.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.AbstractTemplateView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WangXiaoJin
 *
 */
@Controller
public class GlobalController extends BaseController {
	
	@Autowired
	private ViewResolver viewResolver;
	
	@Autowired
	private LocaleResolver localeResolver;
	
	/**
	 * index
	 */
	@RequestMapping("/")
	public String index() throws Exception {
		return "welcome";
	}
	
	@RequestMapping("/decorator")
	public void decorator(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AbstractTemplateView view = (AbstractTemplateView)viewResolver.resolveViewName("decorator", 
				localeResolver.resolveLocale(request));
		//因为此请求是Sitemesh forward进来的，如果不做下面配置的话会重复设置参数，而Spring MVC碰到重复参数名会抛异常
		//详细逻辑请阅读 {@link AbstractTemplateView} 的 renderMergedOutputModel方法
		view.setAllowRequestOverride(true);
		view.setExposeSpringMacroHelpers(false);
		view.render(null, request, response);
	}
	
}
