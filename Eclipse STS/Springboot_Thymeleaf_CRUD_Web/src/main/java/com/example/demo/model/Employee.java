package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "datakaryawan1")
@Table(name = "datakaryawan")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nama_kar;
	private String tgl_msk;
	private String no_hp;
	private String lim_reimburse;
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
}
