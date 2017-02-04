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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author CrazeWong
 *
 */
@Entity(name="AutosSmallClassesMiddle")
public class AutosSmallClassesMiddle implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
    private Integer autosSmallClassesMiddleId = null;
	
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="smallClassId")
	@JsonIgnore
	private SmallClass smallClass = null;
	
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="autoMakerDetailId")
	private AutoMakerDetail autoMakerDetail = null;
	
	
	public AutosSmallClassesMiddle() {
		super();
	}
	
	public AutosSmallClassesMiddle(final SmallClass smallClass, final AutoMakerDetail autoMakerDetail) {
		super();
		this.smallClass = smallClass;
		this.autoMakerDetail = autoMakerDetail;
	}

	public SmallClass getSmallClass() {
		return smallClass;
	}

	public void setSmallClass(SmallClass smallClass) {
		this.smallClass = smallClass;
	}

	public AutoMakerDetail getAutoMakerDetail() {
		return autoMakerDetail;
	}

	public void setAutoMakerDetail(AutoMakerDetail autoMakerDetail) {
		this.autoMakerDetail = autoMakerDetail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autosSmallClassesMiddleId == null) ? 0 : autosSmallClassesMiddleId.hashCode());
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
		AutosSmallClassesMiddle other = (AutosSmallClassesMiddle) obj;
		if (autosSmallClassesMiddleId == null) {
			if (other.autosSmallClassesMiddleId != null)
				return false;
		} else if (!autosSmallClassesMiddleId.equals(other.autosSmallClassesMiddleId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"autosSmallClassesMiddleId\":\"");
		builder.append(autosSmallClassesMiddleId);
		builder.append("\",\"smallClass\":");
		builder.append(smallClass);
		builder.append("}");
		return builder.toString();
	}
	
	

	
}
