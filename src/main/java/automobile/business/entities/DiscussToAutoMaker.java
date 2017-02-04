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

import automobile.util.converter.JsonStringConverter;

@Entity(name="DiscussToAutoMaker")
public class DiscussToAutoMaker implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer discussToAutoMakerId = null;
	
	// to 
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="autoMakerDetailId")
	private AutoMakerDetail autoMakerDetail = null;
	
	// from
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="garageDetailId")
    private GarageDetail garageDetail = null;
	
	
	@Column(nullable = false)
    private Integer stars = null;
	
	
	@Column(nullable = false)
    private String discuss = null;
	
	
	
	
	@Override
    public int hashCode() {
        return discussToAutoMakerId;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final DiscussToAutoMaker other = (DiscussToAutoMaker) obj;
        if (discussToAutoMakerId == null) {
            if (other.discussToAutoMakerId != null) return false;
        } else if (!discussToAutoMakerId.equals(other.discussToAutoMakerId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        try {
			return JsonStringConverter.getJSONString("discussToAutoMaker", this);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "discussToAutoMaker : id = " + discussToAutoMakerId;
    }

}
