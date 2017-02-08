package automobile.business.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="WantedsSmallClassesMiddle")
public class WantedsSmallClassesMiddle implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer wantedsSmallClassesMiddleId = null;
	
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="smallClassId")
	@JsonIgnore
	private SmallClass smallClass = null;
	
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="wantedId")
	private Wanted wanted = null;

	public WantedsSmallClassesMiddle() {
		super();
	}

	public WantedsSmallClassesMiddle(SmallClass smallClass, Wanted wanted) {
		super();
		this.smallClass = smallClass;
		this.wanted = wanted;
	}

	public Integer getWantedsSmallClassesMiddleId() {
		return wantedsSmallClassesMiddleId;
	}

	public void setWantedsSmallClassesMiddleId(Integer wantedsSmallClassesMiddleId) {
		this.wantedsSmallClassesMiddleId = wantedsSmallClassesMiddleId;
	}

	public SmallClass getSmallClass() {
		return smallClass;
	}

	public void setSmallClass(SmallClass smallClass) {
		this.smallClass = smallClass;
	}

	public Wanted getWanted() {
		return wanted;
	}

	public void setWanted(Wanted wanted) {
		this.wanted = wanted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((wantedsSmallClassesMiddleId == null) ? 0 : wantedsSmallClassesMiddleId.hashCode());
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
		WantedsSmallClassesMiddle other = (WantedsSmallClassesMiddle) obj;
		if (wantedsSmallClassesMiddleId == null) {
			if (other.wantedsSmallClassesMiddleId != null)
				return false;
		} else if (!wantedsSmallClassesMiddleId.equals(other.wantedsSmallClassesMiddleId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"wantedsSmallClassesMiddleId\":\"");
		builder.append(wantedsSmallClassesMiddleId);
		builder.append("\",\"smallClass\":\"");
		builder.append(smallClass);
		builder.append("\"}");
		return builder.toString();
	}

}
