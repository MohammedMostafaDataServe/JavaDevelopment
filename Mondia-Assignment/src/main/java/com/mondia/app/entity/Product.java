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
 * Product Entity 
 * 
 * @author Mohammed Mostafa
 */
@Entity
@Table(name = "products")
@NamedQueries({ @NamedQuery(name = "Product.findAll", query = "SELECT prod FROM Product as prod"),
		@NamedQuery(name = "Product.findByName", query = "SELECT prod FROM Product as prod WHERE prod.name=?"), })
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	@Basic(optional = false)
	@Column(name = "NAME")
	private String name;
	@Column(name = "DESCRIPTION")
	private String description;
	@Basic(optional = false)
	@Column(name = "MIN_PRICE")
	private float minPrice;
	@Basic(optional = false)
	@Column(name = "MAX_PRICE")
	private float maxPrice;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
	//@JsonManagedReference(value="service")
	//@JsonIgnore
	private List<Service> servicesList;


	public Product() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(float minPrice) {
		this.minPrice = minPrice;
	}

	public float getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(float maxPrice) {
		this.maxPrice = maxPrice;
	}
	public List<Service> getServicesList() {
		return servicesList;
	}

	public void setServicesList(List<Service> servicesList) {
		this.servicesList = servicesList;
	}

	  @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += id;
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Product)) {
	            return false;
	        }
	        Product other = (Product) object;
	        if ((this.id != other.id)) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "com.entity.Products[ id=" + id + " ]";
	    }
	

}
