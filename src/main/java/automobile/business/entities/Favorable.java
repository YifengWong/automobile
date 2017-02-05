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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author CrazeWong
 * ”≈ª›–≈œ¢
 */
@Entity(name="Favorable")
public class Favorable implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer favorableId = null;
	
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="autoMakerDetailId")
	private AutoMakerDetail autoMakerDetail = null;
	
	@Column(nullable = false)
	private String dateFrom = null;
	
	@Column(nullable = false)
	private String dateTo = null;
	
	@OneToMany(mappedBy="favorable", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<FavorablesSmallClassesMiddle> favorablesSmallClassesMiddleSet = new HashSet<FavorablesSmallClassesMiddle>();

	
	@Column(nullable = false)
	private String content = null;


	public Favorable() {
		super();
	}


	public Favorable(AutoMakerDetail autoMakerDetail, String dateFrom, String dateTo, String content) {
		super();
		this.autoMakerDetail = autoMakerDetail;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.content = content;
	}


	public Integer getFavorableId() {
		return favorableId;
	}


	public void setFavorableId(Integer favorableId) {
		this.favorableId = favorableId;
	}


	public AutoMakerDetail getAutoMakerDetail() {
		return autoMakerDetail;
	}


	public void setAutoMakerDetail(AutoMakerDetail autoMakerDetail) {
		this.autoMakerDetail = autoMakerDetail;
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


	public Set<FavorablesSmallClassesMiddle> getFavorablesSmallClassesMiddleSet() {
		return favorablesSmallClassesMiddleSet;
	}


	public void setFavorablesSmallClassesMiddleSet(Set<FavorablesSmallClassesMiddle> favorablesSmallClassesMiddleSet) {
		this.favorablesSmallClassesMiddleSet = favorablesSmallClassesMiddleSet;
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
		result = prime * result + ((favorableId == null) ? 0 : favorableId.hashCode());
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
		Favorable other = (Favorable) obj;
		if (favorableId == null) {
			if (other.favorableId != null)
				return false;
		} else if (!favorableId.equals(other.favorableId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"favorableId\":\"");
		builder.append(favorableId);
		builder.append("\",\"autoMakerDetail\":\"");
		builder.append(autoMakerDetail);
		builder.append("\",\"dateFrom\":\"");
		builder.append(dateFrom);
		builder.append("\",\"dateTo\":\"");
		builder.append(dateTo);
		builder.append("\",\"favorablesSmallClassesMiddleSet\":\"");
		builder.append(favorablesSmallClassesMiddleSet);
		builder.append("\",\"content\":\"");
		builder.append(content);
		builder.append("\"}");
		return builder.toString();
	}

}
