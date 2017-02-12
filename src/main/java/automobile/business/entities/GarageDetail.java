package automobile.business.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author CrazeWong
 * 汽修厂信息
 *
 */
@Entity(name="GarageDetail")
public class GarageDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    private String garageDetailId = null;
	
	@Column(nullable = false)
	@JsonIgnore
    private String password = null;	
	
	@Column(nullable = false)
    private String name = null;	
	
	@Column(nullable = false)
	@JsonIgnore
    private String managerName = null;
	
	@Column(nullable = false)
	@JsonIgnore
    private String phone = null;
	
	@Column(nullable = false)
	@JsonIgnore
    private String qq = null;
	
	@Column(nullable = false)
	@JsonIgnore
    private String wechat = null;
	
	@Column(nullable = false)
	@JsonIgnore
    private String province = null;
	
	@Column(nullable = false)
	@JsonIgnore
    private String city = null;
	
	@Column(nullable = false)
	@JsonIgnore
    private String address = null;
	
	@Column(nullable = false)
	@JsonIgnore
    private Integer likes = 0;
	
	@OneToMany(mappedBy="garageDetail", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<DiscussToAutoMaker> discussToAutoMakerSet = new HashSet<DiscussToAutoMaker>();
	
	@OneToMany(mappedBy="garageDetail", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<DiscussToGarage> discussToGarageSet = new HashSet<DiscussToGarage>();
	
	@OneToMany(mappedBy="garageDetail", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<MsgToAutoMaker> msgToAutoMakerSet = new HashSet<MsgToAutoMaker>();
	
	@OneToMany(mappedBy="garageDetail", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<MsgToGarage> msgToGarageSet = new HashSet<MsgToGarage>();
	
	// 单向一对多，收藏
	@OneToMany(fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<AutoMakerDetail> autoMakerDetailSet = new HashSet<AutoMakerDetail>();
	
	
	public GarageDetail() {
		super();
	}
	
	
	public GarageDetail(String garageDetailId, String password, String name, String managerName, String phone, String qq, String wechat, String province,
			String city, String address, Integer likes) {
		super();
		this.garageDetailId = garageDetailId;
		this.password = password;
		this.name = name;
		this.managerName = managerName;
		this.phone = phone;
		this.qq = qq;
		this.wechat = wechat;
		this.province = province;
		this.city = city;
		this.address = address;
		this.likes = likes;
	}


	// TODO delete this
	public GarageDetail(String garageDetailId, String password, final String name) {
		super();
		this.garageDetailId = garageDetailId;
		this.password = password;
		this.name = name;
		this.managerName = "1";
		this.phone = "1";
		this.qq = "1";
		this.wechat = "1";
		this.province = "1";
		this.city = "1";
		this.address = "1";
		this.likes = 0;
	}

	


	public Set<DiscussToAutoMaker> getDiscussToAutoMakerSet() {
		return discussToAutoMakerSet;
	}


	public void setDiscussToAutoMakerSet(Set<DiscussToAutoMaker> discussToAutoMakerSet) {
		this.discussToAutoMakerSet = discussToAutoMakerSet;
	}


	public Set<DiscussToGarage> getDiscussToGarageSet() {
		return discussToGarageSet;
	}


	public void setDiscussToGarageSet(Set<DiscussToGarage> discussToGarageSet) {
		this.discussToGarageSet = discussToGarageSet;
	}


	public Set<MsgToAutoMaker> getMsgToAutoMakerSet() {
		return msgToAutoMakerSet;
	}


	public void setMsgToAutoMakerSet(Set<MsgToAutoMaker> msgToAutoMakerSet) {
		this.msgToAutoMakerSet = msgToAutoMakerSet;
	}


	public Set<MsgToGarage> getMsgToGarageSet() {
		return msgToGarageSet;
	}
	
	
	public Set<AutoMakerDetail> getAutoMakerDetailSet() {
		return autoMakerDetailSet;
	}


	public void setAutoMakerDetailSet(Set<AutoMakerDetail> autoMakerDetailSet) {
		this.autoMakerDetailSet = autoMakerDetailSet;
	}


	public void setMsgToGarageSet(Set<MsgToGarage> msgToGarageSet) {
		this.msgToGarageSet = msgToGarageSet;
	}


	public void setLikes(Integer likes) {
		this.likes = likes;
	}


	public String getGarageDetailId() {
		return garageDetailId;
	}


	public void setGarageDetailId(String garageDetailId) {
		this.garageDetailId = garageDetailId;
	}
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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


	public Integer getLikes() {
		return likes;
	}

	public void setLike(Integer likes) {
		this.likes = likes;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((garageDetailId == null) ? 0 : garageDetailId.hashCode());
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
		GarageDetail other = (GarageDetail) obj;
		if (garageDetailId == null) {
			if (other.garageDetailId != null)
				return false;
		} else if (!garageDetailId.equals(other.garageDetailId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"garageDetailId\":\"");
		builder.append(garageDetailId);
		builder.append("\",\"name\":\"");
		builder.append(name);
		builder.append("\",\"managerName\":\"");
		builder.append(managerName);
		builder.append("\",\"phone\":\"");
		builder.append(phone);
		builder.append("\",\"qq\":\"");
		builder.append(qq);
		builder.append("\",\"wechat\":\"");
		builder.append(wechat);
		builder.append("\",\"province\":\"");
		builder.append(province);
		builder.append("\",\"city\":\"");
		builder.append(city);
		builder.append("\",\"address\":\"");
		builder.append(address);
		builder.append("\",\"likes\":\"");
		builder.append(likes);
		builder.append("\",\"autoMakerDetailSet\":\"");
		builder.append(autoMakerDetailSet);
		builder.append("\"}");
		return builder.toString();
	}

	
}
