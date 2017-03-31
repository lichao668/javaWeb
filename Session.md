

``` java
//设置session
HttpSession session = request.getSession();
session.setAttribute("name", name);

//获取Session
HttpSession session= request.getSession();
String name = (String) session.getAttribute("name");


```