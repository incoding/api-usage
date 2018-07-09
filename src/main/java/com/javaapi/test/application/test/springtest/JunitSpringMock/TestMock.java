package com.javaapi.test.application.test.springtest.JunitSpringMock;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

/**
 * 这种方式在单元测试中不生效
 * 
 */
@Deprecated
@Component
public class TestMock implements ServletContextAware, BeanFactoryAware {

    private ServletContext servletContext;

    public ServletContext getMockServlet() {
        return this.servletContext;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

	/**
	 * spring test 下, 传入得是DefaultListableBeanFactory
	 */
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

		// MockServletContext msc = new MockServletContext(
		// "/home/kk/www/webclient/ROOT");
		// DefaultListableBeanFactory context = (DefaultListableBeanFactory)
		// beanFactory;
		// context.setServletContext(msc);
		// context.refresh();
		// msc.setAttribute(
		// WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE,
		// context);

	}

}
