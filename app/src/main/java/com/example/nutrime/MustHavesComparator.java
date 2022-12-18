package com.example.nutrime;

import com.example.nutrime.dal.DailyNeedsDatabase;
import com.example.nutrime.enums.MustHaves;

import java.util.Map;

public class MustHavesComparator implements java.util.Comparator<Map.Entry<MustHaves, Float>> {

    @Override
    public int compare(Map.Entry<MustHaves, Float> t0, Map.Entry<MustHaves, Float> t1) {
        if (getScore(t0.getKey(), t0.getValue()) > getScore(t1.getKey(), t1.getValue()))
        {
            return -1;
        }
        else if (getScore(t0.getKey(), t0.getValue()) < getScore(t1.getKey(), t1.getValue()))
        {
            return 1;
        }

        return 0;
    }

    private Float getScore(MustHaves mustHave, Float value) {
        DailyNeedsDatabase dailyNeeds = DailyNeedsDatabase.getInstance();
        return dailyNeeds.getRelativeAmount(mustHave, value);
    }
}
