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
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("AutoMakerDetail [id=").append(autoMakerDetail.getAutoMakerDetailId())
        		.append("] SmallClass [id=").append(smallClass.getSmallClassId()).append("]");
        return builder.toString();
    }

	
}
