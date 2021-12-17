package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "datakaryawan")
@Table(name = "datakaryawan")
public class EmployeeView {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nama_kar;
	private String tgl_msk;
	private String no_hp;
	private String lim_reimburse;
	private String create_date;
	private String update_date;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNama_kar() {
		return nama_kar;
	}
	public void setNama_kar(String nama_kar) {
		this.nama_kar = nama_kar;
	}
	public String getTgl_msk() {
		return tgl_msk;
	}
	public void setTgl_msk(String tgl_msk) {
		this.tgl_msk = tgl_msk;
	}
	public String getNo_hp() {
		return no_hp;
	}
	public void setNo_hp(String no_hp) {
		this.no_hp = no_hp;
	}
	public String getLim_reimburse() {
		return lim_reimburse;
	}
	public void setLim_reimburse(String lim_reimburse) {
		this.lim_reimburse = lim_reimburse;
	}
	
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	
}
