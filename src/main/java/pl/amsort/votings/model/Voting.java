package pl.amsort.votings.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Voting {

    private int id;
    private String question;

    private List<Vote> votes;
    private Set<String> votersNames;

    private LocalDateTime startTime;
    private Duration duration;

    Voting(Duration duration, String question) {
        this();
        this.question = question;
        this.duration = duration;
    }

    private Voting() {
        this.votes = new ArrayList<>();
        this.votersNames = new TreeSet<>();
        this.startTime = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public Set<String> getVotersNames() {
        return votersNames;
    }

    public void setVotersNames(Set<String> votersNames) {
        this.votersNames = votersNames;
    }

    public String give_A_Vote(Vote vote) {
        String voterName = vote.getVoterName();
        if (hasVoted(voterName) || isTimesUp()) {
            return voterName + " has voted before or Voting has finished!";
        }
        votersNames.add(voterName);
        Vote voteWithoutName= new Vote(vote.getVotingId(), vote.isYes());
        votes.add(voteWithoutName);
        return voterName + "'s vote added!";
    }

    public Decision getVotingResult() {
        if (isTimesUp()) {
            if (yesVotes() > 0) {
                return Decision.YES;
            } else if (yesVotes() < 0) {
                return Decision.NO;
            } else {
                return Decision.NO_RESULT;
            }
        }
        return Decision.NOT_FINISHED;
    }

    private int yesVotes() {
        int votesForYes = 0;

        for (Vote vote : votes) {
            if (vote.isYes()) {
                votesForYes++;
            } else {
                votesForYes--;
            }
        }
        return votesForYes;
    }

    private boolean hasVoted(String voterName) {
        return votersNames.contains(voterName);
    }

    private LocalDateTime getEndVotingTime() {
        return startTime.plusSeconds(duration.getSeconds());
    }

    private boolean isTimesUp() {
        return LocalDateTime.now().isAfter(getEndVotingTime());
    }
}
