package entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="thread", catalog="totw")
public class ThreadModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "title", unique = true, nullable = false)
	private String title;
	
	@Column(name = "body", unique = true, nullable = false)
	private String body;
	
	@Column(name = "tags")
	private List<String> tags;
	
	@Column(name = "timestamp", unique = true, nullable = false)
	private String timestamp;
	
	@Column(name = "author", unique = true, nullable = false)
	private String author;
	
	@Column(name = "numberOfLikes", unique = true, nullable = false)
	private int numberOfLikes;
	
	@Column(name = "numberOfDislikes", unique = true, nullable = false)
	private int numberOfDislikes;
	
	@Column(name = "numberOfComments", unique = true, nullable = false)
	private int numberOfComments;
	
	@Column(name = "category", unique = true, nullable = false)
	private String category;
	
	public ThreadModel(String title, String body, ArrayList<String> tags, String timestamp, String author, String category) {
		this.title = title;
		this.body = body;
		this.tags = tags;
		this.timestamp = timestamp;
		this.author = author;
		this.category = category;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public List<String> getTags() {
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
	public void setNumberOfLikes(int numberOfLikes) {
		this.numberOfLikes = numberOfLikes;
	}
	public long getNumberOfDislikes() {
		return numberOfDislikes;
	}
	public void setNumberOfDislikes(int numberOfDislikes) {
		this.numberOfDislikes = numberOfDislikes;
	}
	public int getNumberOfComments() {
		return numberOfComments;
	}
	public void setNumberOfComments(int numberOfComments) {
		this.numberOfComments = numberOfComments;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}	
	@Override
	public String toString(){
		StringBuilder tagStringBuilder = new StringBuilder();
//		for(String tag:tags){
//			tagStringBuilder.append(tag);
//			tagStringBuilder.append(" ");
//		}
		
		return "Author:" + this.author +
				"\ntitle:" + this.title +
				"\nbody:" + this.body + 
				"\ntimestamp:" + this.timestamp +
				"\ntags:" + tagStringBuilder.toString() +
				"\ncategory: " + this.category;
	}
}
