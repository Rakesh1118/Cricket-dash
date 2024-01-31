package io.java.ipldashboard.repository;

import java.time.LocalDate;


import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import io.java.ipldashboard.model.Match;

public interface MatchRespository extends CrudRepository<Match, Long> {

     List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable pageable); 
    @Query("select m from Match m where (m.team1 = :teamName or m.team2 = :teamName) and m.matchDate between :dateStart and :dateEnd order by date desc")
    List<io.java.ipldashboard.model.Match> getMatchesByTeamBetweenDates(
        @Param("teamName") String team, 
        @Param("dateStart") LocalDate dateStart, 
        @Param("dateEnd") LocalDate dateEnd
        );
     //List<Match> getByTeam1AndMatchDateBetweenOrTeam2AndMatchDateBetweenOrderByMatchDateDesc(String team1, LocalDate startDate1,
      //LocalDate endDate1, String team2, LocalDate startDate2, LocalDate endDate2);

    default List<Match> findLatestMatchesbyTe0am(String teamName, int count) {
        return getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0, count));
    }

    List<io.java.ipldashboard.model.Match> findLatestMatchesbyTeam(String teamName, int i);

}
