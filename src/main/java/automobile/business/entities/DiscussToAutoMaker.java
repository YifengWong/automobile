package automobile.business.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="DiscussToAutoMaker")
public class DiscussToAutoMaker implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer discussToAutoMakerId = null;
	
	// to 
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="autoMakerDetailId")
	private AutoMakerDetail autoMakerDetail = null;
	
	// from
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="garageDetailId")
    private GarageDetail garageDetail = null;
	
	
	@Column(nullable = false)
    private Integer stars = null;
	
	@Column(nullable = false)
	private String time = null;	
	
	@Column(nullable = false)
    private String discuss = null;
	
	
	public DiscussToAutoMaker(AutoMakerDetail autoMakerDetail, GarageDetail garageDetail, String time, Integer stars,
			String discuss) {
		super();
		this.autoMakerDetail = autoMakerDetail;
		this.garageDetail = garageDetail;
		this.stars = stars;
		this.discuss = discuss;
		this.time = time;
	}
	
	
	public Integer getDiscussToAutoMakerId() {
		return discussToAutoMakerId;
	}


	public void setDiscussToAutoMakerId(Integer discussToAutoMakerId) {
		this.discussToAutoMakerId = discussToAutoMakerId;
	}


	public AutoMakerDetail getAutoMakerDetail() {
		return autoMakerDetail;
	}

	public void setAutoMakerDetail(AutoMakerDetail autoMakerDetail) {
		this.autoMakerDetail = autoMakerDetail;
	}
	
	
	public GarageDetail getGarageDetail() {
		return garageDetail;
	}


	public void setGarageDetail(GarageDetail garageDetail) {
		this.garageDetail = garageDetail;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getStars() {
		return stars;
	}


	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public String getDiscuss() {
		return discuss;
	}


	public void setDiscuss(String discuss) {
		this.discuss = discuss;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discussToAutoMakerId == null) ? 0 : discussToAutoMakerId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiscussToAutoMaker other = (DiscussToAutoMaker) obj;
		if (discussToAutoMakerId == null) {
			if (other.discussToAutoMakerId != null)
				return false;
		} else if (!discussToAutoMakerId.equals(other.discussToAutoMakerId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"discussToAutoMakerId\":\"");
		builder.append(discussToAutoMakerId);
		builder.append("\",\"autoMakerDetail\":");
		builder.append(autoMakerDetail);
		builder.append(",\"garageDetail\":");
		builder.append(garageDetail);
		builder.append(",\"stars\":\"");
		builder.append(stars);
		builder.append("\",\"discuss\":\"");
		builder.append(discuss);
		builder.append("\"}");
		return builder.toString();
	}
	
	

}
