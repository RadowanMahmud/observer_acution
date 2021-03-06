package youtbe;

import user.observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class auction {

    ArrayList<observer> list=new ArrayList<observer>();
    private int amount=0;
    public void setAmount(int am){
        this.amount=am;
    }

    public void subscribe(observer a){
        list.add(a);
    }
    public void unsubscribe(observer a){
        list.remove(a);
    }
    public void notification(observer a,int ch) throws IOException {
        Iterator<observer> iter = list.iterator();

        while (iter.hasNext()) {
            iter.next().getNotification(a,ch);
        }
    }

    public void notifyerror(observer a,int ch) throws IOException {
        Iterator<observer> iter = list.iterator();

        while (iter.hasNext()) {
            iter.next().getError(a,ch);
        }
    }

    public void resetObservers() throws IOException {
        Iterator<observer> iter = list.iterator();

        while (iter.hasNext()) {
            iter.next().reset();
        }
    }

    public void ressetAuction() throws IOException {
        setAmount(0);
        resetObservers();
    }

    public boolean upload(observer a,int ch) throws IOException {
        if(ch>amount){
            setAmount(ch);
            notification(a,ch);
            return true;
        }
        else{
            notifyerror(a,ch);
            return false;
        }
    }

}
