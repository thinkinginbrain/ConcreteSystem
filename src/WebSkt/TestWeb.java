//package WebSkt;
//
//import javax.websocket.CloseReason;
//import javax.websocket.OnClose;
//import javax.websocket.OnError;
//import javax.websocket.OnMessage;
//import javax.websocket.OnOpen;
//import javax.websocket.Session;
//import javax.websocket.server.PathParam;
//import javax.websocket.server.ServerEndpoint;
//
////ws://127.0.0.1:8087/Demo1/ws/张三
//@ServerEndpoint("/ws/{user}")
//public class TestWeb {
//    private String currentUser;
//    
//    //连接打开时执行
//    @OnOpen
//    public void onOpen(@PathParam("user") String user, Session session) {
//        currentUser = user;
//        System.out.println("Connected ... " + session.getId());
//    }
//
//    //收到消息时执行
//    @OnMessage
//    public String onMessage(String message, Session session) {
//        System.out.println(currentUser + "：" + message);
//        return currentUser + "：" + message;
//    }
//
//    //连接关闭时执行
//    @OnClose
//    public void onClose(Session session, CloseReason closeReason) {
//        System.out.println(String.format("Session %s closed because of %s", session.getId(), closeReason));
//    }
//
//    //连接错误时执行
//    @OnError
//    public void onError(Throwable t) {
//        t.printStackTrace();
//    }
//}