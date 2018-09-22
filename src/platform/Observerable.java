package platform;
/*抽象被观察者接口，一有更新通知观察者*/


public interface Observerable {
    public void registerObserver(Observer o);//用户关注
    public void removeObserver(Observer o);//用户不再关注
    public void notifyObserver();//展示信息

}
