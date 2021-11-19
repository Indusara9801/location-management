package pldc.assignment.hotelreservation.service;



import pldc.assignment.hotelreservation.entity.Visit;

import java.util.Date;
import java.util.List;

public interface VisitService {
    public Visit getVisit(int visitId);
    public List<Visit> getVisits();
    public List<Visit> getVisitsByUser(String header,Long userId);
    public List<Visit> getVisitsByDate(Date date);
    public void saveVisit(Visit visit);
    public void deleteVisit(int visitId);
}
