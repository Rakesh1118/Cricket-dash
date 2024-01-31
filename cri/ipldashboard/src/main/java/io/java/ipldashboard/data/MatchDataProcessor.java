package io.java.ipldashboard.data;


import java.time.LocalDate;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
      
import io.java.ipldashboard.model.Match;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

       private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

        @Override 
        public Match process( final MatchInput matchinput) throws Exception {
        
          Match match = new Match();
          match.setId(Long.parseLong(matchinput.getId()));
          match.setCity(matchinput.getCity());

          match.setDate(LocalDate.parse(matchinput.getDate()));
          
          match.setPlayerOfMatch(matchinput.getPlayer_of_match());
          match.setVenue(matchinput.getVenue());

          String firstInningsTeam, secondInningsTeam; 

          if("bat".equals(matchinput.getToss_decision())){
            firstInningsTeam = matchinput.getToss_winner();
            secondInningsTeam = matchinput.getToss_winner()
            .equals(matchinput.getTeam1())? matchinput.getTeam2() : matchinput.getTeam1();


          }else {
            secondInningsTeam = matchinput.getToss_winner();
            firstInningsTeam = matchinput.getToss_winner()
            .equals(matchinput.getTeam1())? matchinput.getTeam2() : matchinput.getTeam1();
          }
          match.setTeam1(firstInningsTeam);
          match.setTeam2(secondInningsTeam);

          match.setTossWinner(matchinput.getToss_winner());
          match.setTossDecision(matchinput.getToss_decision());
          match.setMatchWinner(matchinput.getWinner());
          match.setResult(matchinput.getResult());
          match.setResultMargin(matchinput.getResult_margin());
          match.setUmpire1(matchinput.getUmpire1());
          match.setUmpire2(matchinput.getUmpire2());
           


 
         return match;
      }
    


    }
     

