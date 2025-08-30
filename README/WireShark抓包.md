#过滤抓包的请求 URI
#过滤抓包的请求ip
http && ip.src == 192.168.11.212

#过滤抓包的请求 URI
http.request.uri == "/api/ws/event-management/"
