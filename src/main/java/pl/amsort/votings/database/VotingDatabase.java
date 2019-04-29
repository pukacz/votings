package pl.amsort.votings.database;

import java.util.Collection;
import java.util.HashMap;
import org.springframework.stereotype.Repository;
import pl.amsort.votings.model.Decision;
import pl.amsort.votings.model.Vote;
import pl.amsort.votings.model.Voting;

@Repository
public class VotingDatabase {

    private HashMap<Integer, Voting> votings;

    public VotingDatabase() {
        votings = new HashMap<>();
    }

    public Voting addVoting(Voting voting) {
        int votingId = voting.getId();
        votings.put(votingId, voting);
        return voting;
    }

    public Collection<Voting> getVotings() {
        return votings.values();
    }

    public Decision getVotingResult(int id) {
        if (votings.containsKey(id)) {
            return votings.get(id).getVotingResult();
        }
        return Decision.NOT_EXISTING;
    }

    public String give_A_Vote(Vote vote) {
        int votingId = vote.getVotingId();

        if (votings.containsKey(votingId)) {
            Voting voting = votings.get(votingId);
            return voting.give_A_Vote(vote);
        }
        return "Voting with id{" + votingId + "} doesn't exist!";
    }


}
