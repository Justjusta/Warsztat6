package pl.coderslab.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "tweeter_tweet" )
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 5, max = 50)
    private String title;

    @NotNull
    @Size(max = 160)
    private String tweetText;

    private LocalDate created;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private User user;

    public Tweet() { }
    
	public Tweet(String title, String tweetText, User user) {
		super();
		this.title = title;
		this.tweetText = tweetText;
		this.user = user;
	}

	public Tweet(long id, String title, String tweetText, User user) {
		super();
		this.id = id;
		this.title = title;
		this.tweetText = tweetText;
		this.user = user;
	}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }
}
