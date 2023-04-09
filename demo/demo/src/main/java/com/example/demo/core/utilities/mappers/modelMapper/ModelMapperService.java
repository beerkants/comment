package com.example.demo.core.utilities.mappers.modelMapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

    ModelMapper forResponse();
    ModelMapper forRequest();
    
}
