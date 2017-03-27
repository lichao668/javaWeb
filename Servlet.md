
## 创建 Servlet 三种方式
1. 实现接口 javax.servlet.Servlet
2. 继承 javax.servlet.GenericServlet
3. 继承 javax.servlet.http.HttpServlet



``` java
    //Servlet 生命周期

    //构造方法 第一次访问servlet时调用
    public ServletDemo1() {
        super();
        System.out.println("构造方法");
    }

	// 初始化 生成servlet时调用
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init...");
	}   
    // 销毁 关闭tomcat服务器或者卸载应用时调用
	public void destroy() {
		super.destroy();
		System.out.println("destory");
	}
    // 服务 每次访问servlet时都会调用
    @Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		super.service(arg0, arg1);
		System.out.println("service");
	}

```

## 配置 Servlet 
``` xml
    <!--web.xml-->
	<servlet>
		<description>
		这是一个测试servlet</description>
		<display-name>ServletDemo1</display-name>
		<servlet-name>ServletDemo1</servlet-name>
		<servlet-class>com.lc.demo.ServletDemo1</servlet-class>
        <!-- 服务器启动时创建Servlet 启动优先级 取值为数字越小优先级越高，不能写0 -->
		<load-on-startup>1</load-on-startup>
	</servlet>
```


