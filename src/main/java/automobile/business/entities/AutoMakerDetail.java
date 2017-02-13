package automobile.business.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author CrazeWong
 *
 */
@Entity(name="AutoMakerDetail")
public class AutoMakerDetail extends AbstractUserDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer autoMakerDetailId = null;
	
	@Column(nullable = false, unique = true)
	private String username = null;
	
	@Column(nullable = false)
	@JsonIgnore
    private String password = null;
	
	@Column(nullable = false)
    private String name = null;
	
	@OneToMany(mappedBy="autoMakerDetail", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<AutosSmallClassesMiddle> autosSmallClassesMiddleSet = new HashSet<AutosSmallClassesMiddle>();
	
	@OneToMany(mappedBy="autoMakerDetail", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<DiscussToAutoMaker> discussToAutoMakerSet = new HashSet<DiscussToAutoMaker>();
	
	@OneToMany(mappedBy="autoMakerDetail", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<DiscussToGarage> discussToGarageSet = new HashSet<DiscussToGarage>();
	
	@OneToMany(mappedBy="autoMakerDetail", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<MsgToAutoMaker> msgToAutoMaker = new HashSet<MsgToAutoMaker>();
	
	@OneToMany(mappedBy="autoMakerDetail", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<MsgToGarage> msgToGarage = new HashSet<MsgToGarage>();
	
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
	
	
	public AutoMakerDetail() {
		super();
	}
	
	
	public AutoMakerDetail(String username, String password, String name, String managerName, String phone, String qq, String wechat, String province,
			String city, String address) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.managerName = managerName;
		this.phone = phone;
		this.qq = qq;
		this.wechat = wechat;
		this.province = province;
		this.city = city;
		this.address = address;
		this.likes = 0;
	}



	// TODO delte this
	public AutoMakerDetail(String username, String password, final String name) {
		super();
		this.username = username;
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
	
	public Integer getAutoMakerDetailId() {
		return autoMakerDetailId;
	}

	public void setAutoMakerDetailId(Integer autoMakerDetailId) {
		this.autoMakerDetailId = autoMakerDetailId;
	}	

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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


	public Set<AutosSmallClassesMiddle> getAutosSmallClassesMiddleSet() {
		return autosSmallClassesMiddleSet;
	}

	public void setAutosSmallClassesMiddleSet(Set<AutosSmallClassesMiddle> autosSmallClassesMiddleSet) {
		this.autosSmallClassesMiddleSet = autosSmallClassesMiddleSet;
	}
	
	
	public Set<MsgToGarage> getMsgToGarage() {
		return msgToGarage;
	}


	public void setMsgToGarage(Set<MsgToGarage> msgToGarage) {
		this.msgToGarage = msgToGarage;
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

	public void setLikes(Integer likes) {
		this.likes = likes;
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
	
	
	public Set<MsgToAutoMaker> getMsgToAutoMaker() {
		return msgToAutoMaker;
	}


	public void setMsgToAutoMaker(Set<MsgToAutoMaker> msgToAutoMaker) {
		this.msgToAutoMaker = msgToAutoMaker;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autoMakerDetailId == null) ? 0 : autoMakerDetailId.hashCode());
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
		AutoMakerDetail other = (AutoMakerDetail) obj;
		if (autoMakerDetailId == null) {
			if (other.autoMakerDetailId != null)
				return false;
		} else if (!autoMakerDetailId.equals(other.autoMakerDetailId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"autoMakerDetailId\":\"");
		builder.append(autoMakerDetailId);
		builder.append("\",\"name\":\"");
		builder.append(name);
		builder.append("\",\"autosSmallClassesMiddleSet\":");
		builder.append(autosSmallClassesMiddleSet);
		builder.append(",\"managerName\":\"");
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
		builder.append("\"}");
		return builder.toString();
	}

	

}
