package com.hb.inp.model;

import java.sql.Date;

public class CityVo {
	private int ID;
	private String Name;
	private String CountryCode;
	private String District;
	private int Population;
	public CityVo() {

	}
	public CityVo(int iD, String name, String countryCode, String district, int population) {
		super();
		ID = iD;
		Name = name;
		CountryCode = countryCode;
		District = district;
		Population = population;
	}
	@Override
	public String toString() {
		return "CityVo [ID=" + ID + ", Name=" + Name + ", CountryCode=" + CountryCode + ", District=" + District
				+ ", Population=" + Population + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CountryCode == null) ? 0 : CountryCode.hashCode());
		result = prime * result + ((District == null) ? 0 : District.hashCode());
		result = prime * result + ID;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + Population;
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
		CityVo other = (CityVo) obj;
		if (CountryCode == null) {
			if (other.CountryCode != null)
				return false;
		} else if (!CountryCode.equals(other.CountryCode))
			return false;
		if (District == null) {
			if (other.District != null)
				return false;
		} else if (!District.equals(other.District))
			return false;
		if (ID != other.ID)
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Population != other.Population)
			return false;
		return true;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public int getPopulation() {
		return Population;
	}
	public void setPopulation(int population) {
		Population = population;
	}
	
	
	
}
