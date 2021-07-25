package user;

import java.io.IOException;

public interface observer {
    public abstract void getNotification(observer a,int am) throws IOException;
    public abstract void getError(observer a,int am);
    public abstract String getName();
    public abstract void reset();
}
