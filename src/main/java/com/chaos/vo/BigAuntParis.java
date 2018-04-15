package com.chaos.vo;

import com.chaos.po.Event;
import com.chaos.util.CommonUtil;

import java.util.Date;

public class BigAuntParis {

    private Event bigAuntCome;

    private Event bigAuntGo;

    public BigAuntParis(Event bigAuntCome, Event bigAuntGo) {
        this.bigAuntCome = bigAuntCome;
        this.bigAuntGo = bigAuntGo;
    }

    public int getLastDays() {
        Date goTime = bigAuntGo.getEventTime();
        Date comeTime = bigAuntCome.getEventTime();

        int LastDays=CommonUtil.getSubDay(comeTime,goTime);
        return LastDays;
    }

    public Event getBigAuntCome() {
        return bigAuntCome;
    }

    public void setBigAuntCome(Event bigAuntCome) {
        this.bigAuntCome = bigAuntCome;
    }

    public Event getBigAuntGo() {
        return bigAuntGo;
    }

    public void setBigAuntGo(Event bigAuntGo) {
        this.bigAuntGo = bigAuntGo;
    }
}
