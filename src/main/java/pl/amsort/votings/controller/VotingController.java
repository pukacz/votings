package pl.amsort.votings.controller;

import java.util.Collection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.amsort.votings.database.VotingDatabase;
import pl.amsort.votings.model.Decision;
import pl.amsort.votings.model.Vote;
import pl.amsort.votings.model.Voting;

@RequestMapping("/voting")
@RestController
public class VotingController {

    VotingDatabase votingDatabase = new VotingDatabase();
    private int votingId = 0;

    @PostMapping("/add")
    public Voting addVoting(@RequestBody Voting voting) {
        voting.setId(++votingId);
        return votingDatabase.addVoting(voting);
    }

    @GetMapping("/all")
    public Collection getVotings() {
        return votingDatabase.getVotings();
    }

    @GetMapping("/{id}")
    public Decision getVotingResult(@PathVariable int id) {
        return votingDatabase.getVotingResult(id);
    }

    @PostMapping("/vote")
    public String give_A_Vote(@RequestBody Vote vote) {
        return votingDatabase.give_A_Vote(vote);
    }
}
