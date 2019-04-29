package pl.amsort.votings.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Vote {

    private int votingId;
    private boolean isYes;
    private String voterName;

    Vote(int votingId, boolean isYes) {
        this.votingId = votingId;
        this.isYes = isYes;
    }

    @JsonCreator
    Vote(@JsonProperty("votingId") int votingId, @JsonProperty("isYes") boolean isYes, @JsonProperty("voterName") String voterName) {
        this.votingId = votingId;
        this.isYes = isYes;
        this.voterName = voterName;
    }

    public int getVotingId() {
        return votingId;
    }

    public void setVotingId(int votingId) {
        this.votingId = votingId;
    }

    boolean isYes() {
        return isYes;
    }

    public void setYes(boolean yes) {
        isYes = yes;
    }

    String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }
}
