package com.mondia.app.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Service Entity
 * 
 * @author Mohammed Mostafa
 */
@Entity
@Table(name = "services")
@NamedQueries({ @NamedQuery(name = "Service.findAll", query = "SELECT serv FROM Service as serv"),
		@NamedQuery(name = "Service.findByOperatorId", query = "SELECT serv FROM Service as serv WHERE serv.operatorId.id=?"),
		@NamedQuery(name = "Service.findByProductId", query = "SELECT serv FROM Service as serv WHERE serv.productId.id=?"), })

@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class Service implements Serializable {

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
	@Column(name = "TYPE")
	private int type;
	@Column(name = "OPERATOR_SERVICE_ID")
	private Integer operatorServiceId;
	@Column(name = "OPERATOR_PACKAGE_ID")
	private Integer operatorPackageId;
	@JoinColumn(name = "OPERATOR_ID", referencedColumnName = "ID")
	@ManyToOne(optional = false)
	//@JsonBackReference
	//@JsonIgnore
	private Operator operatorId;
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
	@ManyToOne(optional = false)
	//@JsonBackReference(value="service")
	//@JsonIgnore
	private Product productId;

	public static enum Type {
		SUBSCRIPTION(new Integer(0)), ALACARTE(new Integer(1));

		private Integer value;

		private Type(Integer value) {
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}
	}

	public Service() {
	}

	public Service(Integer id) {
		this.id = id;
	}

	public Service(Integer id, String name, int type) {
		this.id = id;
		this.name = name;
		this.type = type;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Integer getOperatorServiceId() {
		return operatorServiceId;
	}

	public void setOperatorServiceId(Integer operatorServiceId) {
		this.operatorServiceId = operatorServiceId;
	}

	public Integer getOperatorPackageId() {
		return operatorPackageId;
	}

	public void setOperatorPackageId(Integer operatorPackageId) {
		this.operatorPackageId = operatorPackageId;
	}

	public Operator getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Operator operatorId) {
		this.operatorId = operatorId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Service)) {
			return false;
		}
		Service other = (Service) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.entity.Services[ id=" + id + " ][ name=" + name + " ]";
	}

}
