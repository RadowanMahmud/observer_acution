package user;

import java.io.IOException;

public interface observer {
    public abstract void getNotification(observer a,int am) throws IOException;
    public abstract String getName();
}
