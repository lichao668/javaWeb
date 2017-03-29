
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
### response
``` java
//设置响应文本字符集
response.setCharacterEncoding("utf-8");
//告诉浏览器以何种方式解析响应信息
response.setHeader("content-type", "text/html;charset=utf-8");
//设置字符编码简便方式，可以替代上面两行代码
//response.setContentType("text/html;charset=utf-8");

// 字符输出流
PrintWriter out = response.getWriter();
//三种方式向客户端响应文本内容
out.println("中国<br/>");
out.print("java<br/>");
out.write("hello<br/>");

//设置浏览器不缓存
response.setHeader("pragma", "no-cache");
response.setHeader("cache-control", "no-cache");
response.setHeader("expires", "0");

// 设置自动刷新
response.setIntHeader("refresh", 1);

//三秒自动跳转到指定页面
response.setHeader("refresh", "3;url=/javaWeb/");

//重定向访问路径
response.setStatus(302);
response.setHeader("location", "/javaWeb/ServletCdx2");
//重定向访问路径，可以替代以上两行代码
response.sendRedirect("/javaWeb/ServletCdx2");

//获取指定的消息头
response.getHeader("location")

//获取请求消息头
String header = request.getHeader("User-Agent");

//设置请求端字符编码
request.setCharacterEncoding("utf-8");




```


