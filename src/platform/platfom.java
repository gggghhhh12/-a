package platform;

import java.util.ArrayList;
import java.util.List;


public class platfom implements Observerable{

    //注意到这个List集合的泛型参数为Observer接口，设计原则：面向接口编程而不是面向实现编程
    private List<Observer> list;
    private String message;
    public platfom() {
        list = new ArrayList<Observer>();
    }
    public void registerObserver(Observer o) {

        list.add(o);
    }
    @Override
    public void removeObserver(Observer o) {
        if(!list.isEmpty())
            list.remove(o);
    }
    //遍历
    @Override
    public void notifyObserver() {
        for(int i = 0; i < list.size(); i++) {
            Observer oserver = list.get(i);
            oserver.update(message);
        }
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("论坛更新帖子： " + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }
}

