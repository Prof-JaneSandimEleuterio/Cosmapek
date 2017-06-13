package db.entity.general;

import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Created by Junior Cupe on 8/22/2015.
 */
public class Configuration {
    @Id
    private Object idObject;
    @Version
    private Object version;
    private long timeLapse;
    private boolean acceptMonitor;

    public long getTimeLapse() {
        return timeLapse;
    }

    public void setTimeLapse(long timeLapse) {
        this.timeLapse = timeLapse;
    }

    public boolean isAcceptMonitor() {
        return acceptMonitor;
    }

    public void setAcceptMonitor(boolean acceptMonitor) {
        this.acceptMonitor = acceptMonitor;
    }
}
