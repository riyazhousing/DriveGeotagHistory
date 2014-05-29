package org.riyaz.man.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Drive_geotag_history {
	
	@Id
	private int Id;
	private double feature_location_lat;
	private double feature_location_lon;
	private String modified_by;
	private BigInteger drive_geotag_id;
	private BigInteger fr_job_execution_unit_id;
	private BigInteger sign_id;
	private String value;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public double getFeature_location_lat() {
		return feature_location_lat;
	}
	public void setFeature_location_lat(double feature_location_lat) {
		this.feature_location_lat = feature_location_lat;
	}
	public double getFeature_location_lon() {
		return feature_location_lon;
	}
	public void setFeature_location_lon(double feature_location_lon) {
		this.feature_location_lon = feature_location_lon;
	}
	public String getModified_by() {
		return modified_by;
	}
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	public BigInteger getDrive_geotag_id() {
		return drive_geotag_id;
	}
	public void setDrive_geotag_id(BigInteger drive_geotag_id) {
		this.drive_geotag_id = drive_geotag_id;
	}
	public BigInteger getFr_job_execution_unit_id() {
		return fr_job_execution_unit_id;
	}
	public void setFr_job_execution_unit_id(BigInteger fr_job_execution_unit_id) {
		this.fr_job_execution_unit_id = fr_job_execution_unit_id;
	}
	public BigInteger getSign_id() {
		return sign_id;
	}
	public void setSign_id(BigInteger sign_id) {
		this.sign_id = sign_id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public Drive_geotag_history(int Id,double feature_location_lat,double feature_location_lon,String modified_by,BigInteger drive_geotag_id,	BigInteger fr_job_execution_unit_id,BigInteger sign_id,	String value)
	{
		setId(Id);
		setFeature_location_lat(feature_location_lat);
		setFeature_location_lon( feature_location_lon);
		setModified_by( modified_by);
		setDrive_geotag_id( drive_geotag_id);
		setFr_job_execution_unit_id( fr_job_execution_unit_id);
		setSign_id( sign_id);
		setValue(value);
		
	}
	public Drive_geotag_history()
	{
		
	}
}
