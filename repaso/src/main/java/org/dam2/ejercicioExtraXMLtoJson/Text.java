package org.dam2.ejercicioExtraXMLtoJson;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Text {
	@XmlAttribute
	private String data;
	@XmlAttribute
	private int size;
	@XmlAttribute
	private String style;
	private String name;
	private int hOffset;
	private int vOffset;
	private String alignment;
	private String onMouseUp;
	
	

}
