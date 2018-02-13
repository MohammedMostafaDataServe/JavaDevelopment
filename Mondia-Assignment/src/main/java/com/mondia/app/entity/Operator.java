package com.mondia.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Operator Entity
 * 
 * @author Mohammed Mostafa
 */
@Entity
@Table(name = "operators")
@NamedQueries({
    @NamedQuery(name="Operator.findAll",
                query="SELECT op FROM Operator as op"),
    @NamedQuery(name="Operator.findByName",
                query="SELECT op FROM Operator as op WHERE op.name=?"),
})

@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class Operator implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer id;
	@Basic(optional = false)
	@Column(name = "NAME")
	private String name;
	@Basic(optional = false)
	@Column(name = "COUNTRY")
	private String country;
	@Basic(optional = false)
	@Column(name = "OPERATOR_SERVICE_FLAG")
	private int operatorServiceFlag;
	@Basic(optional = false)
	@Column(name = "OPERATOR_PACKAGE_FLAG")
	private int operatorPackageFlag;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "operatorId")
	//@JsonManagedReference
	//@JsonIgnore
	private List<Service> servicesList;

	public Operator() {
	}

	public Operator(Integer id) {
		this.id = id;
	}

	public Operator(Integer id, String name, String country, int operatorServiceFlag, int operatorPackageFlag) {
		this.id = id;
		this.name = name;
		this.country = country;
		this.operatorServiceFlag = operatorServiceFlag;
		this.operatorPackageFlag = operatorPackageFlag;
	}

	public Operator(String name, String country, int operatorServiceFlag, int operatorPackageFlag) {
		this.name = name;
		this.country = country;
		this.operatorServiceFlag = operatorServiceFlag;
		this.operatorPackageFlag = operatorPackageFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getOperatorServiceFlag() {
		return operatorServiceFlag;
	}

	public void setOperatorServiceFlag(int operatorServiceFlag) {
		this.operatorServiceFlag = operatorServiceFlag;
	}

	public int getOperatorPackageFlag() {
		return operatorPackageFlag;
	}

	public void setOperatorPackageFlag(int operatorPackageFlag) {
		this.operatorPackageFlag = operatorPackageFlag;
	}

	public List<Service> getServicesList() {
		return servicesList;
	}

	public void setServicesList(List<Service> servicesList) {
		this.servicesList = servicesList;
	}

	public boolean isOperatorServiceMandatory() {
		return operatorServiceFlag == 1 ? true : false;
	}

	public boolean isOperatorPackageMandatory() {
		return operatorPackageFlag == 1 ? true : false;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Operator)) {
			return false;
		}
		Operator other = (Operator) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.entity.Operators[ id=" + id + " ]";
	}

}
