package br.com.brunoluz.breeweer.repository.helper.cerveja;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.brunoluz.breeweer.model.Cerveja;
import br.com.brunoluz.breeweer.repository.filtro.CervejasFiltro;

public class CervejasRepositoryImpl implements CervejasRepositoryQueries {

	
	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Page<Cerveja> filtrar(CervejasFiltro filtro, Pageable pageable) {
		
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Cerveja.class);
		
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;
		
		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);
		
		Sort sort = pageable.getSort();
		
		if (sort != null) {
			Sort.Order order  = sort.iterator().next();
			String propriedade = order.getProperty();
			criteria.addOrder(order.isAscending() ? Order.asc(propriedade) : Order.desc(propriedade) );
		}
		
		adicionarFiltro(filtro, criteria);
		
		return new PageImpl<Cerveja>(criteria.list(), pageable, total(filtro));
	}
	
	
	/**
	 * total
	 * @param filtro
	 * @return
	 */
	private Long total(CervejasFiltro filtro) {
		
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Cerveja.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());
		
		return (Long) criteria.uniqueResult();
	}


	/**
	 * adicionarFiltro
	 * @param filtro
	 * @param criteria
	 */
	private void adicionarFiltro(CervejasFiltro filtro, Criteria criteria) {
		
		if (filtro != null) {
			
			if (!StringUtils.isEmpty(filtro.getSku())) {
				criteria.add(Restrictions.eq("sku", filtro.getSku()));
			}
			
			if (!StringUtils.isEmpty(filtro.getNome())) {
				criteria.add(Restrictions.like("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}
			
			if (isEstiloPresente(filtro)) {
				criteria.add(Restrictions.eq("estilo", filtro.getEstilo()));
			}
			
			if (filtro.getSabor() != null) {
				criteria.add(Restrictions.eq("sabor", filtro.getSabor()));
			}
			
			if (filtro.getOrigem() != null) {
				criteria.add(Restrictions.eq("origem", filtro.getOrigem()));
			}
			
			if (filtro.getValorDe() != null) {
				criteria.add(Restrictions.ge("valor", filtro.getValorDe()));
			}
			
			if (filtro.getValorAte() != null) {
				criteria.add(Restrictions.le("valor", filtro.getValorAte()));
			}
			
		}
	}
	


	/**
	 * isEstiloPresente
	 * @param filtro
	 * @return
	 */
	private boolean isEstiloPresente(CervejasFiltro filtro) {
		return (filtro.getEstilo() != null && filtro.getEstilo().getId() != null);
	}
	

}