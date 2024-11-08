package org.dam2.ejercicio1;

import javax.xml.bind.annotation.XmlEnum;

import com.google.gson.annotations.SerializedName;

public enum SecretBase {
	
	@SerializedName(value = "top")
	TOP,
	@SerializedName(value = "down")
	DOWN,
	@SerializedName(value = "left")
	LEFT,
	@SerializedName(value = "right")
	RIGHT;
	

}
