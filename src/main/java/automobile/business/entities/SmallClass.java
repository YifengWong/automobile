package automobile.business.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * @author CrazeWong
 * 小分类，包括车型、水箱等。
 *
 */
@Entity(name="SmallClass")
public class SmallClass implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer smallClassId = null;
	
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="bigClassId")
	private BigClass bigClass = null;
	
	@Column(nullable = false, unique = true)
    private String name = null;
	
	@OneToMany(mappedBy="smallClass", fetch = FetchType.EAGER)
	private Set<AutosSmallClassesMiddle> autosSmallClassesMiddleSet = new HashSet<AutosSmallClassesMiddle>();

	
	public SmallClass() {
		super();
	}
	
	public SmallClass(final BigClass bigClass, final String name) {
		super();
		this.bigClass = bigClass;
		this.name = name;
	}
	
	
	public Integer getSmallClassId() {
		return smallClassId;
	}

	public void setSmallClassId(Integer smallClassId) {
		this.smallClassId = smallClassId;
	}

	public BigClass getBigClass() {
		return bigClass;
	}

	public void setBigClass(BigClass bigClass) {
		this.bigClass = bigClass;
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


	@Override
    public int hashCode() {
        return smallClassId;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final SmallClass other = (SmallClass) obj;
        if (smallClassId == null) {
            if (other.smallClassId != null) return false;
        } else if (!smallClassId.equals(other.smallClassId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("SmallClass [id=").append(smallClassId)
        		.append(" name=").append(name)
        		.append(" bigClass=").append(bigClass.getName()).append("]");
        return builder.toString();
    }

}
