package hibernetBasic;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "student_address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String city;

	@Column(length = 50)
	private String state;

	@Transient
	private int x;

	@Temporal(TemporalType.DATE)
	@Column(name = "created_at")
	private Date AddedDate;

	@Column(name = "is_open")
	private boolean isOpen;

	@Lob
	private byte[] image;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int id, String city, String state, int x, Date AddedDate, boolean isOpen, byte[] image) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
		this.x = x;
		this.AddedDate = AddedDate;
		this.isOpen = isOpen;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", state=" + state + ", x=" + x + ", created_at=" + AddedDate
				+ ", isOpen=" + isOpen + ", image=" + Arrays.toString(image) + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Date getAddedDate() {
		return AddedDate;
	}

	public void setAddedDate(Date addedDate) {
		AddedDate = addedDate;
	}

}
