package com.bookity.project.candidate.arda.onur.persistence.mapper;

import com.bookity.project.candidate.arda.onur.persistence.dto.CustomerDto;
import com.bookity.project.candidate.arda.onur.persistence.model.Customer;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface CustomerMapper {
    Customer map(CustomerDto customerDto);
}
