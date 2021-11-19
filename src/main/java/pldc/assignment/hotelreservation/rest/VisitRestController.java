package pldc.assignment.hotelreservation.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import pldc.assignment.hotelreservation.entity.Visit;
import pldc.assignment.hotelreservation.service.VisitService;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class VisitRestController {
    private final VisitService visitService;

    @GetMapping("/visits")
    public List<Visit> getVisits(){
        return visitService.getVisits();
    }

    @GetMapping("/visits/{visit_id}")
    public Visit getVisit(@PathVariable("visit_id") int id){
        Visit visit = visitService.getVisit(id);
        if(visit == null){
            throw new RuntimeException("Visit not found");
        }
        return visit;
    }

    @GetMapping("/visitsByUser/{user_id}")
    public List<Visit> getVisitByUser(@PathVariable("user_id") long id, HttpServletRequest request){
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        return visitService.getVisitsByUser(authorizationHeader,id);
    }

    @GetMapping("/visitsByDate/{date}")
    public List<Visit> getVisitByDate(@PathVariable("date") String date) throws ParseException {
        Date visitDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        return visitService.getVisitsByDate(visitDate);
    }

    @PostMapping("/visits")
    public Visit addVisit(@RequestBody Visit visit){
        visit.setId(0);
        visitService.saveVisit(visit);
        return visit;
    }

    @DeleteMapping("/visits/{visit_id}")
    public String deleteVisit(@PathVariable("visit_id") int id){
        Visit visit = visitService.getVisit(id);
        if(visit == null){
            throw new RuntimeException("Visit not found");
        }
        visitService.deleteVisit(id);
        return "Deleted the visit data with id - " + id;
    }

}
