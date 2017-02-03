package automobile.business.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author CrazeWong
 * ∆˚≈‰…Ã–≈œ¢
 *
 */
@Entity(name="AutoMakerDetail")
public class AutoMakerDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
    private Integer autoMakerDetailId = null;
	
	@Column(nullable = false)
    private String name = null;
	
	@OneToMany(mappedBy="autoMakerDetail", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<AutosSmallClassesMiddle> autosSmallClassesMiddleSet = new HashSet<AutosSmallClassesMiddle>();
	
	
	public AutoMakerDetail() {
		super();
	}
	
	public AutoMakerDetail(final String name) {
		super();
		this.name = name;
	}
	
	public Integer getAutoMakerDetailId() {
		return autoMakerDetailId;
	}

	public void setAutoMakerDetailId(Integer autoMakerDetailId) {
		this.autoMakerDetailId = autoMakerDetailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Set<AutosSmallClassesMiddle> getAutosSmallClassesMiddleSet() {
		return autosSmallClassesMiddleSet;
	}

	public void setAutosSmallClassesMiddleSet(Set<AutosSmallClassesMiddle> autosSmallClassesMiddleSet) {
		this.autosSmallClassesMiddleSet = autosSmallClassesMiddleSet;
	}
	
	public String getSmallClasses() {
		if (autosSmallClassesMiddleSet.size() == 0) return "";
		StringBuilder strBuilder = new StringBuilder();
		for(AutosSmallClassesMiddle asc: autosSmallClassesMiddleSet) {
			strBuilder.append(asc.getSmallClass().getName()).append(" ");
		}
		return strBuilder.toString();
	}

	@Override
    public int hashCode() {
        return autoMakerDetailId;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final AutoMakerDetail other = (AutoMakerDetail) obj;
        if (autoMakerDetailId == null) {
            if (other.autoMakerDetailId != null) return false;
        } else if (!autoMakerDetailId.equals(other.autoMakerDetailId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("AutoMakerDetail [id=").append(autoMakerDetailId)
        		.append(" smallClass=").append(autosSmallClassesMiddleSet.toString()).append("]");
        return builder.toString();
    }

}
