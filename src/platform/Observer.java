package platform;

/***
 * 抽象观察者
 * 定义了一个update()方法，为所有的具体观察者定义一个接口，在得到主题的同时更新自己；
 * 当被观察者调用notifyObservers()方法时，观察者的update()方法会被回调。
 *
 */
public interface Observer {
    public void update(String message);
}