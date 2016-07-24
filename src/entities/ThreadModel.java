package entities;
import java.util.ArrayList;

public class ThreadModel {
	private String title;
	private String body;
	private ArrayList<String> tags;
	private String timestamp;
	private String author;
	private long numberOfLikes;
	private long numberOfDislikes;
	private long numberOfComments;
	private String category;
	
	public ThreadModel(String title, String body, ArrayList<String> tags, String timestamp, String author, String category) {
		this.title = title;
		this.body = body;
		this.tags = tags;
		this.timestamp = timestamp;
		this.author = author;
		this.category = category;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public ArrayList<String> getTags() {
		return tags;
	}
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public long getNumberOfLikes() {
		return numberOfLikes;
	}
	public void setNumberOfLikes(long numberOfLikes) {
		this.numberOfLikes = numberOfLikes;
	}
	public long getNumberOfDislikes() {
		return numberOfDislikes;
	}
	public void setNumberOfDislikes(long numberOfDislikes) {
		this.numberOfDislikes = numberOfDislikes;
	}
	public long getNumberOfComments() {
		return numberOfComments;
	}
	public void setNumberOfComments(long numberOfComments) {
		this.numberOfComments = numberOfComments;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}	
}
