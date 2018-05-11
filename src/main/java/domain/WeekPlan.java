package domain;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

import java.util.GregorianCalendar;

public class WeekPlan {
    private User user;
    private DayPlan[] dayPlans;
    private DateTime firstDayOfWeek;
    public WeekPlan(User user, DateTime firstDayOfWeek){
        this.user = user;
        this.firstDayOfWeek = new DateTime(firstDayOfWeek);
        while (this.firstDayOfWeek.getDayOfWeek() != DateTimeConstants.MONDAY)
            this.firstDayOfWeek = this.firstDayOfWeek.minusDays(1);

        this.updateDayPlans();
    }

    public void nextWeek(){
        this.firstDayOfWeek = this.firstDayOfWeek.plusWeeks(1);
        this.updateDayPlans();
    }

    public void prevWeek(){
        this.firstDayOfWeek = this.firstDayOfWeek.minusWeeks(1);
        this.updateDayPlans();
    }

    public void updateDayPlans() {
        this.dayPlans = new DayPlan[7];
        DateTime day = new DateTime(this.firstDayOfWeek);
        for (int i=0;i<7;i++){
            this.dayPlans[i] = new DayPlan(this.user, day);
            day = day.plusDays(1);
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DayPlan[] getDayPlans() {
        return dayPlans;
    }

    public void setDayPlans(DayPlan[] dayPlans) {
        this.dayPlans = dayPlans;
    }

    public DateTime getFirstDayOfWeek() {
        return firstDayOfWeek;
    }

    public void setFirstDayOfWeek(DateTime firstDayOfWeek) {
        this.firstDayOfWeek = firstDayOfWeek;
    }
}
