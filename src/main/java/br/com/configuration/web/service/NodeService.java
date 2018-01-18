package br.com.configuration.web.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.configuration.web.DTO.NodeDTO;
import br.com.configuration.web.entity.Node;
import br.com.configuration.web.exceptions.BadRequestException;
import br.com.configuration.web.exceptions.NodeNotFoundException;
import br.com.configuration.web.repository.NodeRepository;
import br.com.configuration.web.utils.Constants;

@Service
@Transactional
public class NodeService {

	private static final Logger LOGGER = Logger.getLogger(NodeService.class);

	@Autowired
	private NodeRepository nodeRepository;

	@Autowired
	private ConversionService conversionService;

	/**
	 * Create a Node
	 * 
	 * @param node
	 */
	public NodeDTO createNode(Node node) {

		try {

			Long parentId = node.getParentId();
			if (parentId != null) {
				LOGGER.info("buscando o parentId: " + parentId);
				Node parent = nodeRepository.findOne(parentId);

				if (parent == null) {
					throw new NodeNotFoundException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND, null);
				}

				node.setNode(parent);
			}

			Node newNode = nodeRepository.saveAndFlush(node);
			LOGGER.info("Salvando o novo nó: " + newNode.getId());

			NodeDTO nDTO = new NodeDTO();
			nDTO.setId(newNode.getId());

			return nDTO;
		} catch (DataAccessException e) {
			throw new BadRequestException(HttpStatus.BAD_REQUEST, Constants.BAD_REQUEST, e.getMessage());
		}

	}

	/**
	 * Update a Node
	 * 
	 * @param node
	 * @return
	 */
	public NodeDTO updateNode(Node node) {
		Node upadateNode = null;
		try {

			Long id = node.getId();
			if (id != null) {
				LOGGER.info("buscando o id: " + id);
				upadateNode = nodeRepository.findOne(id);

				if (upadateNode == null) {
					LOGGER.info("No nao encontrado com o id: " + id);
					throw new NodeNotFoundException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND, null);
				}

				upadateNode.setDescription(node.getDescription());
				upadateNode.setDetail(node.getDetail());
				upadateNode.setCode(node.getCode());

			}

			Long parentId = node.getParentId();
			if (parentId != null) {
				LOGGER.info("buscando o parentId: " + parentId);
				Node parent = nodeRepository.findOne(parentId);
				if (parent != null) {
					upadateNode.setNode(parent);
				}
			}

			Node n = nodeRepository.saveAndFlush(upadateNode);
			LOGGER.info("alterando o nó: " + n.getId());

			NodeDTO nDTO = new NodeDTO();
			nDTO.setId(n.getId());

			return nDTO;
		} catch (DataAccessException e) {
			throw new BadRequestException(HttpStatus.BAD_REQUEST, Constants.BAD_REQUEST, e.getMessage());
		}
	}

	/**
	 * Get all node with children
	 * 
	 * @return
	 */
	public List<NodeDTO> getAllNode() {
		//
		try {

			List<Node> allNodes = nodeRepository.findByParentId(null);
			LOGGER.info("buscando todos os nós");

			if (allNodes == null) {
				LOGGER.info("Nao existe nenhum no cadastrado");
				throw new NodeNotFoundException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND, null);
			} else if (allNodes.size() == 0) {
				LOGGER.info("Nao existe nenhum no cadastrado");
				throw new NodeNotFoundException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND, null);
			}

			List<NodeDTO> nodeDTOS = new ArrayList<>();

			allNodes.stream().filter(n -> n != null).forEach((n) -> {
				NodeDTO nodeDTO = conversionService.convert(n, NodeDTO.class);
				nodeDTOS.add(nodeDTO);

			});

			return nodeDTOS;
		} catch (Exception e) {
			throw new BadRequestException(HttpStatus.BAD_REQUEST, Constants.BAD_REQUEST, e.getMessage());
		}

	}

	/**
	 * 
	 * @param parentId
	 * @return
	 */
	public NodeDTO getChildrenNodeByParentId(Long parentId) {
		try {

			List<Node> children = nodeRepository.findByParentId(parentId);

			List<NodeDTO> childrenNode = new ArrayList<>();

			if (children == null) {
				throw new NodeNotFoundException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND, null);
			} else if (children.isEmpty()) {
				throw new NodeNotFoundException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND, null);
			}

			children.stream().filter(c -> c != null).forEach((c) -> {
				NodeDTO nodeDTO = conversionService.convert(c, NodeDTO.class);
				nodeDTO.setHasChildren(Boolean.TRUE);

				if (nodeDTO.getChildren() != null && nodeDTO.getChildren().size() > 0) {
					nodeDTO.setChildren(null);
					nodeDTO.setHasChildren(Boolean.TRUE);
				}

				childrenNode.add(nodeDTO);
			});
			NodeDTO dto = new NodeDTO();
			dto.setChildren(childrenNode);
			return dto;

		} catch (DataAccessException e) {
			throw new BadRequestException(HttpStatus.BAD_REQUEST, Constants.BAD_REQUEST, e.getMessage());
		}
	}

}
