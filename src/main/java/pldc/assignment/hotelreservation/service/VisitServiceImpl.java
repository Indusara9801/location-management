package pldc.assignment.hotelreservation.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pldc.assignment.hotelreservation.entity.User;
import pldc.assignment.hotelreservation.entity.Visit;
import pldc.assignment.hotelreservation.repository.VisitRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisitServiceImpl implements VisitService{
    private final VisitRepository visitRepository;
    private final RestTemplate restTemplate;




    @Override
    public Visit getVisit(int visitId) {
        Optional<Visit> result = visitRepository.findById(visitId);
        Visit obj = null;
        if (result.isPresent()){
            obj = result.get();
        }
        return obj;
    }

    @Override
    public List<Visit> getVisits() {
        return visitRepository.findAll();
    }

    @Override
    public List<Visit> getVisitsByUser(String header,Long userId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.AUTHORIZATION, header);
        HttpEntity<String> request = new HttpEntity<>(httpHeaders);
        User user = restTemplate.exchange("http://user-management-service/api/userById/"+userId, HttpMethod.GET,request, User.class).getBody();
        return visitRepository.findVisitsByUserOrderByDate(user);
    }

    @Override
    public List<Visit> getVisitsByDate(Date date) {
        return visitRepository.findVisitsByDate(date);
    }

    @Override
    public void saveVisit(Visit visit) {
        visitRepository.save(visit);
    }

    @Override
    public void deleteVisit(int visitId) {
        visitRepository.deleteById(visitId);
    }
}
