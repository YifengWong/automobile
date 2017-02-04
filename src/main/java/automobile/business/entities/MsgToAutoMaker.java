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
public class MsgToAutoMaker implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer msgToAutoMakerId = null;
	
	// to 
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="autoMakerDetailId")
	private AutoMakerDetail autoMakerDetail = null;
	
	// from
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="garageDetailId")
    private GarageDetail garageDetail = null;
	
	
	@Column(nullable = false)
    private String content = null;
	
	
	public MsgToAutoMaker(AutoMakerDetail autoMakerDetail, GarageDetail garageDetail, String content) {
		super();
		this.autoMakerDetail = autoMakerDetail;
		this.garageDetail = garageDetail;
		this.content = content;
	}
	

	public Integer getMsgToAutoMakerId() {
		return msgToAutoMakerId;
	}

	public void setMsgToAutoMakerId(Integer msgToAutoMakerId) {
		this.msgToAutoMakerId = msgToAutoMakerId;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((msgToAutoMakerId == null) ? 0 : msgToAutoMakerId.hashCode());
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
		MsgToAutoMaker other = (MsgToAutoMaker) obj;
		if (msgToAutoMakerId == null) {
			if (other.msgToAutoMakerId != null)
				return false;
		} else if (!msgToAutoMakerId.equals(other.msgToAutoMakerId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"msgToAutoMakerId\":\"");
		builder.append(msgToAutoMakerId);
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
