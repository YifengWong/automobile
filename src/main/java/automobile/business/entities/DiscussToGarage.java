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


@Entity(name="DiscussToGarage")
public class DiscussToGarage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer discussToGarageId = null;
	
	// from
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="autoMakerDetailId")
	private AutoMakerDetail autoMakerDetail = null;
	
	// to
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="garageDetailId")
    private GarageDetail garageDetail = null;
	
	
	@Column(nullable = false)
    private Integer stars = null;
	
	@Column(nullable = false)
	private String time = null;
	
	@Column(nullable = false)
    private String discuss = null;


	public DiscussToGarage(AutoMakerDetail autoMakerDetail, GarageDetail garageDetail, String time, Integer stars, String discuss) {
		super();
		this.autoMakerDetail = autoMakerDetail;
		this.garageDetail = garageDetail;
		this.stars = stars;
		this.discuss = discuss;
		this.time = time;
	}


	public Integer getDiscussToGarageId() {
		return discussToGarageId;
	}


	public void setDiscussToGarageId(Integer discussToGarageId) {
		this.discussToGarageId = discussToGarageId;
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


	public Integer getStars() {
		return stars;
	}


	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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
		result = prime * result + ((discussToGarageId == null) ? 0 : discussToGarageId.hashCode());
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
		DiscussToGarage other = (DiscussToGarage) obj;
		if (discussToGarageId == null) {
			if (other.discussToGarageId != null)
				return false;
		} else if (!discussToGarageId.equals(other.discussToGarageId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"discussToGarageId\":\"");
		builder.append(discussToGarageId);
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
