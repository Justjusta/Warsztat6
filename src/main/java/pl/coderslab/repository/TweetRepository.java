package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.coderslab.entity.Tweet;

public interface TweetRepository extends JpaRepository <Tweet, Long> {
	
    List<Tweet> findAllByUserId(long userId);

    @Query("Select t From Tweet t Where t.title like :start% order by t.created DESC")
    List<Tweet> findAllByTitleLike(@Param("start") String start);

}