package pl.amsort.votings.model;

import java.time.Duration;
import org.junit.Assert;
import org.junit.Test;

public class VotingTest {

    @Test
    public void shouldVoteForYes() throws InterruptedException {
        //given
        Voting voting = new Voting(Duration.ofSeconds(1), "Is sky blue?");
        Vote vote = new Vote(voting.getId(), true, "Pawel");

        //when
        voting.give_A_Vote(vote);
        Thread.sleep(2000);

        //then
        Assert.assertEquals(Decision.YES, voting.getVotingResult());
    }

    @Test
    public void shouldGetNoResultFromVoting() throws InterruptedException {
        //given
        Voting voting = new Voting(Duration.ofSeconds(1), "Is sky blue?");
        Vote voteA = new Vote(voting.getId(), true,"Pawel");
        Vote voteB = new Vote(voting.getId(), false,"Basia");

        //when
        voting.give_A_Vote(voteA);
        voting.give_A_Vote(voteB);
        Thread.sleep(2000);

        //then
        Assert.assertEquals(Decision.NO_RESULT, voting.getVotingResult());
    }

    @Test
    public void shouldReturnVotingNotFinished() throws InterruptedException {
        //given
        Voting voting = new Voting(Duration.ofSeconds(2), "Is sky blue?");
        Vote vote = new Vote(voting.getId(), true,"Pawel");

        //when
        voting.give_A_Vote(vote);

        //then
        Assert.assertEquals(Decision.NOT_FINISHED, voting.getVotingResult());
    }

}