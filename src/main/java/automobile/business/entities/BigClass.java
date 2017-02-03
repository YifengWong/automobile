package automobile.business.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * @author CrazeWong
 * 大分类，包括车类（欧美、日系），单项件等。
 *
 */
@Entity(name="BigClass")
public class BigClass implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bigClassId = null;
	
	@Column(nullable = false, unique = true)
    private String name = null;
	
	@OneToMany(mappedBy="bigClass", fetch = FetchType.EAGER)
	private Set<SmallClass> smallClassesSet = new HashSet<SmallClass>();

	public BigClass() {
        super();
    }
	
    public BigClass(final String name) {
        super();
        this.name = name;
    }
	
	public Integer getBigClassId() {
		return bigClassId;
	}

	public void setBigClassId(Integer bigClassId) {
		this.bigClassId = bigClassId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Set<SmallClass> getSmallClassesSet() {
		return smallClassesSet;
	}

	public void setSmallClassesSet(Set<SmallClass> smallClassesSet) {
		this.smallClassesSet = smallClassesSet;
	}

	@Override
    public int hashCode() {
        return bigClassId;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final BigClass other = (BigClass) obj;
        if (bigClassId == null) {
            if (other.bigClassId != null) return false;
        } else if (!bigClassId.equals(other.bigClassId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("BigClass [id=").append(bigClassId).append(" name=").append(name).append("]");
        return builder.toString();
    }

}
