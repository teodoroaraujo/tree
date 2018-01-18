package br.com.configuration.web.restcontroller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.configuration.web.DTO.NodeDTO;
import br.com.configuration.web.entity.Node;
import br.com.configuration.web.service.NodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/node")
@Api(tags = { "API de arvore binaria" })
public class TreeRestController {

	private static final Logger LOGGER = Logger.getLogger(TreeRestController.class);

	@Autowired
	private NodeService nodeService;

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Salva o novo nó")
	public ResponseEntity<NodeDTO> createNode(@RequestBody Node node) {
		LOGGER.info("Salvando o novo no");
		NodeDTO nodeDTO = nodeService.createNode(node);
		return new ResponseEntity<NodeDTO>(nodeDTO, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Altera o nó")
	public ResponseEntity<NodeDTO> updateNode(@RequestBody Node node) {
		LOGGER.info("Salvando o novo no");
		NodeDTO nodeDTO = nodeService.updateNode(node);
		return new ResponseEntity<NodeDTO>(nodeDTO, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Busca todos os elementos o nó")
	public ResponseEntity<List<NodeDTO>> getNode() {
		LOGGER.info("Salvando o novo no");
		return new ResponseEntity<List<NodeDTO>>(nodeService.getAllNode(), HttpStatus.OK);
	}

	@RequestMapping(value = "{parentId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Busca os elementos o nó")
	public ResponseEntity<NodeDTO> getNodeById(@PathVariable("parentId") Long parentId) {
		LOGGER.info("Buscando ");
		return new ResponseEntity<NodeDTO>(nodeService.getChildrenNodeByParentId(parentId), HttpStatus.OK);
	}
}
