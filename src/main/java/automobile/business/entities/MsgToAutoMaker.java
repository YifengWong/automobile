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

import org.hibernate.annotations.GenericGenerator;

/**
 * @author CrazeWong
 * 给汽配商的消息
 */
@Entity(name="MsgToAutoMaker")
public class MsgToAutoMaker implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
    private String msgToAutoMakerId = null;
	
	// to 
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="autoMakerDetailId")
	private AutoMakerDetail autoMakerDetail = null;
	
	// from
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="garageDetailId")
    private GarageDetail garageDetail = null;
	
	@Column(nullable = false)
	private String time = null;	
	
	@Column(nullable = false)
    private String content = null;
	
	
	public MsgToAutoMaker(AutoMakerDetail autoMakerDetail, GarageDetail garageDetail, String time, String content) {
		super();
		this.autoMakerDetail = autoMakerDetail;
		this.garageDetail = garageDetail;
		this.content = content;
		this.time = time;
	}
	

	public String getMsgToAutoMakerId() {
		return msgToAutoMakerId;
	}

	public void setMsgToAutoMakerId(String msgToAutoMakerId) {
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
