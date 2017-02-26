package automobile.business.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author CrazeWong
 * 求购信息
 */
@Entity(name="Wanted")
public class Wanted implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
    private String wantedId = null;
	
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="garageDetailId")
	private GarageDetail garageDetail = null;
	
	@Column(nullable = false)
	private String dateFrom = null;
	
	@Column(nullable = false)
	private String dateTo = null;
	
	@OneToMany(mappedBy="wanted", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<WantedsSmallClassesMiddle> wantedsSmallClassesMiddleSet = new HashSet<WantedsSmallClassesMiddle>();

	
	@Column(nullable = false)
	private String content = null;


	public Wanted() {
		super();
	}


	public Wanted(GarageDetail garageDetail, String dateFrom, String dateTo, String content) {
		super();
		this.garageDetail = garageDetail;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.content = content;
	}


	public String getWantedId() {
		return wantedId;
	}


	public void setWantedId(String wantedId) {
		this.wantedId = wantedId;
	}


	public GarageDetail getGarageDetail() {
		return garageDetail;
	}


	public void setGarageDetail(GarageDetail garageDetail) {
		this.garageDetail = garageDetail;
	}


	public String getDateFrom() {
		return dateFrom;
	}


	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}


	public String getDateTo() {
		return dateTo;
	}


	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}


	public Set<WantedsSmallClassesMiddle> getWantedsSmallClassesMiddleSet() {
		return wantedsSmallClassesMiddleSet;
	}


	public void setWantedsSmallClassesMiddleSet(Set<WantedsSmallClassesMiddle> wantedsSmallClassesMiddleSet) {
		this.wantedsSmallClassesMiddleSet = wantedsSmallClassesMiddleSet;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((wantedId == null) ? 0 : wantedId.hashCode());
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
		Wanted other = (Wanted) obj;
		if (wantedId == null) {
			if (other.wantedId != null)
				return false;
		} else if (!wantedId.equals(other.wantedId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"wantedId\":\"");
		builder.append(wantedId);
		builder.append("\",\"garageDetail\":\"");
		builder.append(garageDetail);
		builder.append("\",\"dateFrom\":\"");
		builder.append(dateFrom);
		builder.append("\",\"dateTo\":\"");
		builder.append(dateTo);
		builder.append("\",\"wantedsSmallClassesMiddleSet\":\"");
		builder.append(wantedsSmallClassesMiddleSet);
		builder.append("\",\"content\":\"");
		builder.append(content);
		builder.append("\"}");
		return builder.toString();
	}
	
}
