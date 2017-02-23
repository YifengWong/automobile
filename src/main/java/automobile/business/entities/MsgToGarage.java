package automobile.business.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author CrazeWong
 * 给汽修厂的消息
 */
@Entity(name="MsgToGarage")
public class MsgToGarage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer msgToGarageId = null;

	// from
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="autoMakerDetailId")
	protected AutoMakerDetail autoMakerDetail = null;
	
	// to
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="garageDetailId")
	protected GarageDetail garageDetail = null;
	
	@Column(nullable = false)
	private String time = null;	
	
	@Column(nullable = false)
    private String content = null;

	public MsgToGarage(AutoMakerDetail autoMakerDetail, GarageDetail garageDetail, String time, String content) {
		super();
		this.autoMakerDetail = autoMakerDetail;
		this.garageDetail = garageDetail;
		this.content = content;
		this.time = time;
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


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((msgToGarageId == null) ? 0 : msgToGarageId.hashCode());
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
		MsgToGarage other = (MsgToGarage) obj;
		if (msgToGarageId == null) {
			if (other.msgToGarageId != null)
				return false;
		} else if (!msgToGarageId.equals(other.msgToGarageId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"msgToGarageId\":\"");
		builder.append(msgToGarageId);
		builder.append("\",\"autoMakerDetail\":");
		builder.append(autoMakerDetail);
		builder.append(",\"garageDetail\":");
		builder.append(garageDetail);
		builder.append(",\"content\":\"");
		builder.append(content);
		builder.append("\"}");
		return builder.toString();
	}

	
}
