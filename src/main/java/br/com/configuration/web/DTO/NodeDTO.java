package br.com.configuration.web.DTO;

import java.io.Serializable;
import java.util.List;

public class NodeDTO implements Serializable {

	private static final long serialVersionUID = -3780009328224656844L;

	private Long id;

	private String code;

	private String description;

	private Long parentId;

	private String detail;

	private List<NodeDTO> children;

	private Boolean hasChildren;

	public NodeDTO(Long id) {
		this.id = id;
	}

	public NodeDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public List<NodeDTO> getChildren() {
		return children;
	}

	public void setChildren(List<NodeDTO> children) {
		this.children = children;
	}

	public Boolean getHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(Boolean hasChildren) {
		this.hasChildren = hasChildren;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		NodeDTO other = (NodeDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NodeDTO [id=" + id + ", code=" + code + ", description=" + description + ", parentId=" + parentId
				+ ", detail=" + detail + ", children=" + children + "]";
	}

}
