package automobile.business.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import automobile.util.converter.JsonStringConverter;

/**
 * @author CrazeWong
 * ��������Ϣ
 *
 */
@Entity(name="AutoMakerDetail")
public class AutoMakerDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer autoMakerDetailId = null;
	
	@Column(nullable = false)
    private String name = null;
	
	@OneToMany(mappedBy="autoMakerDetail", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<AutosSmallClassesMiddle> autosSmallClassesMiddleSet = new HashSet<AutosSmallClassesMiddle>();
	
	
	@OneToMany(mappedBy="autoMakerDetail", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<DiscussToAutoMaker> discussToAutoMakerSet = new HashSet<DiscussToAutoMaker>();
	
	@OneToMany(mappedBy="autoMakerDetail", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<DiscussToGarage> discussToGarageSet = new HashSet<DiscussToGarage>();
	
	@Column(nullable = false)
    private String managerName = null;
	
	@Column(nullable = false)
    private String phone = null;
	
	@Column(nullable = false)
    private String qq = null;
	
	@Column(nullable = false)
    private String wechat = null;
	
	@Column(nullable = false)
    private String province = null;
	
	@Column(nullable = false)
    private String city = null;
	
	@Column(nullable = false)
    private String address = null;
	
	@Column(nullable = false)
    private Integer like = 0;
	
	
	public AutoMakerDetail() {
		super();
	}
	
	
	public AutoMakerDetail(String name, String managerName, String phone, String qq, String wechat, String province,
			String city, String address) {
		super();
		this.name = name;
		this.managerName = managerName;
		this.phone = phone;
		this.qq = qq;
		this.wechat = wechat;
		this.province = province;
		this.city = city;
		this.address = address;
	}



	// TODO delte this
	public AutoMakerDetail(final String name) {
		super();
		this.name = name;
		this.managerName = "";
		this.phone = "";
		this.qq = "";
		this.wechat = "";
		this.province = "";
		this.city = "";
		this.address = "";
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
	
	
	
	public String getManagerName() {
		return managerName;
	}
	
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}


	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	
	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}


	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public Integer getLike() {
		return like;
	}

	public void setLike(Integer like) {
		this.like = like;
	}

	// getter for json
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
        try {
			return JsonStringConverter.getJSONString("autoMakerDetail", this);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "autoMakerDetail : id = " + autoMakerDetailId;
    }

}
