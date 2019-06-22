package com.mkyong.rest;

import org.codehaus.jackson.annotate.JsonProperty;
// TODO: Auto-generated Javadoc

/**
 * The Class FileProperty.
 */
public class FileProperty {
	
	/** The filename. */
	@JsonProperty("filename")
	private String filename;
	
	/** The fileurl. */
	@JsonProperty("fileurl")
	private String fileurl;
	
	/**
	 * Gets the filename.
	 *
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	
	/**
	 * Sets the filename.
	 *
	 * @param filename the new filename
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	/**
	 * Gets the fileurl.
	 *
	 * @return the fileurl
	 */
	public String getFileurl() {
		return fileurl;
	}
	
	/**
	 * Sets the fileurl.
	 *
	 * @param fileurl the new fileurl
	 */
	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}
}
