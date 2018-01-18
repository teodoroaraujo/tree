package br.com.configuration.web.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.configuration.web.DTO.NodeDTO;
import br.com.configuration.web.entity.Node;

@Component
public class NodeConverter implements Converter<Node, NodeDTO> {

	/**
	 * Convert Node to NodeDTO
	 * @return NodeDTO
	 */
	@Override
	public NodeDTO convert(Node node) {
		NodeDTO nDTO = new NodeDTO();
		nDTO.setId(node.getId());
		nDTO.setCode(node.getCode());
		nDTO.setDescription(node.getDescription());
		nDTO.setDetail(node.getDetail());
		nDTO.setParentId(node.getParentId());
		nDTO.setChildren(convert(node.getNodes()));

		return nDTO;
	}

	/**
	 * Convert Set<Node> to List<NodeDTO>
	 * @param listNode
	 * @return
	 */
	 private List<NodeDTO> convert(Set<Node> listNode) {
		 List<NodeDTO> teste = new ArrayList<>();
				 
		 listNode.stream().filter(c -> c != null).forEach((c) -> {
		      teste.add(convert(c));
		 });
		
	
	 return teste;
	
	 }

}
