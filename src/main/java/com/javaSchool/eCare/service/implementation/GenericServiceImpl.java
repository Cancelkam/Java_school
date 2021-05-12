//package com.javaSchool.eCare.service.implementation;
//
//import com.javaSchool.eCare.dao.interfaces.GenericRepository;
//import com.javaSchool.eCare.model.entity.Tariff;
//import com.javaSchool.eCare.service.api.GenericService;
//import lombok.*;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//public class GenericServiceImpl<Entity, DAO extends GenericRepository<Entity>> implements GenericService<Entity> {
//
//    @Getter(value = AccessLevel.PROTECTED)
//    @Setter(value = AccessLevel.PROTECTED)
//    private DAO dao;
//
//    @Getter(value = AccessLevel.PROTECTED)
//    @Setter(value = AccessLevel.PROTECTED)
//    private ModelMapper mapper;
//
//
//    private final Class<Entity> entityClass;
//
////    private final TariffService tariffService;
//
//    @Override
//    @Transactional
//    public List<Entity> findAll() {
//        return dao.findAll();
//    }
//
//}
