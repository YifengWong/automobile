package automobile.business.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


/**
 * @author CrazeWong
 * 大分类
 *
 */
@Entity(name="BigClass")
public class BigClass implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
    private String bigClassId = null;
	
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
	
	public String getBigClassId() {
		return bigClassId;
	}

	public void setBigClassId(String bigClassId) {
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bigClassId == null) ? 0 : bigClassId.hashCode());
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
		BigClass other = (BigClass) obj;
		if (bigClassId == null) {
			if (other.bigClassId != null)
				return false;
		} else if (!bigClassId.equals(other.bigClassId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"bigClassId\":\"");
		builder.append(bigClassId);
		builder.append("\",\"name\":\"");
		builder.append(name);
		builder.append("\",\"smallClassesSet\":");
		builder.append(smallClassesSet);
		builder.append("}");
		return builder.toString();
	}
	
	
	

}
