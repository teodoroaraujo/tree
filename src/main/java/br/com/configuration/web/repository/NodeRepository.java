package br.com.configuration.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.configuration.web.entity.Node;

public interface NodeRepository extends JpaRepository<Node, Long> {
	
	List<Node> findByParentId(Long parentId);

}
