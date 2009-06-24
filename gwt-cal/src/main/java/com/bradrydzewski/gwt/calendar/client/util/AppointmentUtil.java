package com.bradrydzewski.gwt.calendar.client.util;

import com.bradrydzewski.gwt.calendar.client.Appointment;
import com.bradrydzewski.gwt.calendar.client.AppointmentInterface;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Brad Rydzewski
 */
public class AppointmentUtil {

    

    /**
     * filters a list of appointments and returns only appointments with a start
     * date equal to the date provided. FYI - I hate everything about this
     * method and am pissed off I have to use it. May be able to avoid it in the
     * future
     * 
     * @param fullList
     * @param startDate
     * @return
     */
    public static ArrayList filterListByDate(ArrayList fullList, Date startDate) {

        ArrayList<AppointmentInterface> group = new ArrayList<AppointmentInterface>();
        startDate = new Date(startDate.getYear(), startDate.getMonth(),
                startDate.getDate(), 0, 0, 0);
        Date endDate = new Date(startDate.getYear(), startDate.getMonth(),
                startDate.getDate(), 0, 0, 0);
        endDate.setDate(endDate.getDate() + 1);

        for (int i = 0; i < fullList.size(); i++) {

            AppointmentInterface tmpAppt = (AppointmentInterface) fullList.get(i);

            if (tmpAppt.getEnd().before(endDate)) {

                if (tmpAppt.getStart().after(startDate)) {
                    group.add(tmpAppt);
                } else {
                    // System.out.println(" exiting filter at index " +i+ " ,"
                    // +group.size()+ " found");
                    // return group;
                }
            }
        }

        return group;
    }

    public static Appointment checkAppointmentElementClicked(Element element,List<Appointment> appointments) {
        for (Appointment appt : appointments) {
            
            if ( DOM.isOrHasChild(appt.getElement(), element) ) {
                
                return appt;
            }
        }
        
        return null;
    }
}