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

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="FavorablesSmallClassesMiddle")
public class FavorablesSmallClassesMiddle implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
    private String favorablesSmallClassesMiddleId = null;
	
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="smallClassId")
	@JsonIgnore
	private SmallClass smallClass = null;
	
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="favorableId")
	private Favorable favorable = null;
	
	

	public FavorablesSmallClassesMiddle() {
		super();
	}

	public FavorablesSmallClassesMiddle(SmallClass smallClass, Favorable favorable) {
		super();
		this.smallClass = smallClass;
		this.favorable = favorable;
	}

	public String getFavorablesSmallClassesMiddleId() {
		return favorablesSmallClassesMiddleId;
	}

	public void setFavorablesSmallClassesMiddleId(String favorablesSmallClassesMiddleId) {
		this.favorablesSmallClassesMiddleId = favorablesSmallClassesMiddleId;
	}

	public SmallClass getSmallClass() {
		return smallClass;
	}

	public void setSmallClass(SmallClass smallClass) {
		this.smallClass = smallClass;
	}

	public Favorable getFavorable() {
		return favorable;
	}

	public void setFavorable(Favorable favorable) {
		this.favorable = favorable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((favorablesSmallClassesMiddleId == null) ? 0 : favorablesSmallClassesMiddleId.hashCode());
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
		FavorablesSmallClassesMiddle other = (FavorablesSmallClassesMiddle) obj;
		if (favorablesSmallClassesMiddleId == null) {
			if (other.favorablesSmallClassesMiddleId != null)
				return false;
		} else if (!favorablesSmallClassesMiddleId.equals(other.favorablesSmallClassesMiddleId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"favorablesSmallClassesMiddleId\":\"");
		builder.append(favorablesSmallClassesMiddleId);
		builder.append("\",\"smallClass\":\"");
		builder.append(smallClass);
		builder.append("\"}");
		return builder.toString();
	}
	
	
}
