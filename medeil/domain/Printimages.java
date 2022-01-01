package com.medeil.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "print_images", catalog = "medc_printsettings")
public class Printimages {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "imageid")
	
	private int imageid;
	private Integer formid;
	private Integer printtype;
	private String printlabel;
	private String printurl;

	@Lob
	 private byte[] printimage;
		
	 private String imageurl;
	 
	 private String imagetype;

	/**
	 * @return the formid
	 */
	public Integer getFormid() {
		return formid;
	}

	/**
	 * @param formid the formid to set
	 */
	public void setFormid(Integer formid) {
		this.formid = formid;
	}

	/**
	 * @return the printtype
	 */
	public Integer getPrinttype() {
		return printtype;
	}

	/**
	 * @param printtype the printtype to set
	 */
	public void setPrinttype(Integer printtype) {
		this.printtype = printtype;
	}

	/**
	 * @return the printlabel
	 */
	public String getPrintlabel() {
		return printlabel;
	}

	/**
	 * @param printlabel the printlabel to set
	 */
	public void setPrintlabel(String printlabel) {
		this.printlabel = printlabel;
	}

	/**
	 * @return the print_image
	 */
	public byte[] getPrint_image() {
		return printimage;
	}

	/**
	 * @param print_image the print_image to set
	 */
	public void setPrint_image(byte[] print_image) {
		this.printimage = print_image;
	}

	/**
	 * @return the imageurl
	 */
	public String getImageurl() {
		return imageurl;
	}

	/**
	 * @param imageurl the imageurl to set
	 */
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	/**
	 * @return the imagetype
	 */
	public String getImagetype() {
		return imagetype;
	}

	/**
	 * @param imagetype the imagetype to set
	 */
	public void setImagetype(String imagetype) {
		this.imagetype = imagetype;
	}

	public String getPrinturl() {
		return printurl;
	}

	public void setPrinturl(String printurl) {
		this.printurl = printurl;
	}

}
