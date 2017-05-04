# rsademo
RSA Login Demo

流程简要说明：

1.	进入登录页面时，Ajax 请求 ‘getKey’  url，得到RSA公钥等相关信息。
2.	点击登录时，使用JSEncrypt这个js库对用户信息进行加密，并传递加密后的用户信息以及公钥ID到后台进行验证。
3.	后台通过私钥进行解密得到解密后的用户名和密码，然后判断该用户名和密码是否存在。

截图说明：
1.	进入登录界面时，首先请求后台获取公钥相关信息。
![image](https://github.com/jasonli822/rsademo/blob/master/src/main/resources/image/1.png)

  包含公钥id,公钥产生时间，公钥等信息。



2.	点击登录按钮
![image](https://github.com/jasonli822/rsademo/blob/master/src/main/resources/image/2.png)

  传入公钥对应的id，以及通过公钥加密后的用户名和密码。
  
  

3.	后台通过公钥对应的id找到对应的私钥解密得到用户输入的用户名和密码
![image](https://github.com/jasonli822/rsademo/blob/master/src/main/resources/image/3.png)
