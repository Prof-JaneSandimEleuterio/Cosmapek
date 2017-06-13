package db.entity.company;

import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Created by Junior Cupe on 8/22/2015.
 */
public class CompanyAttentionHour {
    @Id
    private Object idObject;

    @Version
    private Object version;
    private int  beginHour;
    private int beginMinute;
    private int  endingHour;
    private int endingMinute;

    public int getBeginHour() {
        return beginHour;
    }

    public void setBeginHour(int beginHour) {
        this.beginHour = beginHour;
    }

    public int getBeginMinute() {
        return beginMinute;
    }

    public void setBeginMinute(int beginMinute) {
        this.beginMinute = beginMinute;
    }

    public int getEndingHour() {
        return endingHour;
    }

    public void setEndingHour(int endingHour) {
        this.endingHour = endingHour;
    }

    public int getEndingMinute() {
        return endingMinute;
    }

    public void setEndingMinute(int endingMinute) {
        this.endingMinute = endingMinute;
    }
}

