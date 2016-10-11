package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import utils.UserTypes;

@Entity
@Table(name="users")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nickname")
	private String nickname;
	
	@Column(name = "type")
	private UserTypes type;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "image")
	private byte[] image;
	
	public UserModel(int id, String nickname, UserTypes type, String password, byte[] image) {
		this.id = id;
		this.nickname = nickname;
		this.type = type;
		this.password = password;
		this.image = image;
	}
	
	public UserModel(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public UserTypes getType() {
		return type;
	}
	public void setType(UserTypes type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	//TODO: tostring method
	
}
