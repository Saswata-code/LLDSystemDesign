package com.example.isro.specification;

import com.example.isro.model.CustomerSatellite;
import com.example.isro.model.FilterCustomerSatelliteDTO;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CustomerSatelliteSpecification {

    public static Specification<CustomerSatellite> columnsEqual(List<FilterCustomerSatelliteDTO> filterCustomerSatelliteDTOList){

        return new Specification<CustomerSatellite>() {
            @Override
            public Predicate toPredicate(Root<CustomerSatellite> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                filterCustomerSatelliteDTOList.forEach((filter) -> {
                    Predicate predicate = criteriaBuilder.equal(root.get(filter.getColumnName()),filter.getColumnValue());
                    predicates.add(predicate);
                });
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}
