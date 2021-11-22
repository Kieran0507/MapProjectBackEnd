package com.qa.demo.domain;





import java.util.Objects;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


@Entity


public class DoorKey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	private boolean keycard;
	
	@ManyToOne
	private Map map;

//	public DoorKey(Long id, String name, boolean keycard, Map map) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.keycard = keycard;
//		this.map = map;
//	}

	public DoorKey(Long id, String name, boolean keycard, Map map) {
		super();
		this.id = id;
		this.name = name;
		this.keycard = keycard;
		this.map = map;


	public DoorKey(String name, boolean keycard, Map map) {
		super();
		this.name = name;
		this.keycard = keycard;
		this.map = map;
	}
	

//	public DoorKey(String name, boolean keycard) {
//		super();
//		this.name = name;
//		this.keycard = keycard;
//	}
//
//	public DoorKey() {
//		super();
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public boolean isKeycard() {
//		return keycard;
//	}
//
//	public void setKeycard(boolean keycard) {
//		this.keycard = keycard;
//	}
//
//	public Map getMap() {
//		return map;
//	}
//
//	public void setMap(Map map) {
//		this.map = map;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(id, keycard, map, name);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		DoorKey other = (DoorKey) obj;
//		return Objects.equals(id, other.id) && keycard == other.keycard && Objects.equals(map, other.map)
//				&& Objects.equals(name, other.name);
//	}
//
//	@Override
//	public String toString() {
//		return "Key [id=" + id + ", name=" + name + ", keycard=" + keycard + ", map=" + map + "]";
//	}
//	


	

	
	
	
	

