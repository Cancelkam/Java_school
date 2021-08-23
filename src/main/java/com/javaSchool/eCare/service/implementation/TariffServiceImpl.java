package com.javaSchool.eCare.service.implementation;


import com.javaSchool.eCare.dao.interfaces.TariffRepository;
import com.javaSchool.eCare.model.dto.Tariff.TariffViewForm;
import com.javaSchool.eCare.model.entity.Tariff;
import com.javaSchool.eCare.service.api.MessageSender;
import com.javaSchool.eCare.service.api.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;
import java.util.List;

@Service
public class TariffServiceImpl implements TariffService {

    private final TariffRepository tariffRepository;
    private final MessageSender messageSender;

    @Autowired
    public TariffServiceImpl(TariffRepository tariffRepository, MessageSender messageSender) {
        this.tariffRepository = tariffRepository;
        this.messageSender = messageSender;
    }


    @Override
    @Transactional
    public void createEntity(Tariff entity) {
        tariffRepository.save(entity);
        messageSender.sendMessage(entity.convertToJson());

    }

    @Override
    @Transactional
    public void createNewTariff(TariffViewForm tariff) {
        Tariff newTariff = new Tariff();
        newTariff.setTitle(tariff.getTitle());
        newTariff.setPrice(tariff.getPrice());
        createEntity(newTariff);
        messageSender.sendMessage(newTariff.convertToJson());
    }

    @Override
    @Transactional
    public Tariff getEntityById(Integer id) {
        return tariffRepository.read(id);
    }

    @Override
    @Transactional
    public void updateEntity(Tariff entity) {
        tariffRepository.update(entity);
        messageSender.sendMessage(entity.convertToJson());
    }

    @Override
    @Transactional
    public void deleteEntity(Tariff tariff) {
        tariffRepository.delete(tariff);
        messageSender.sendMessage(tariff.convertToJson());
    }

    @Override
    @Transactional
    public List<Tariff> findAll() {
        return tariffRepository.findAll();
    }

    @Override
    public void saveEntity(Tariff tariff) {

    }

    @Override
    @Transactional
    public List<TariffViewForm> getTariffViewList(Collection<Tariff> tariffs) {
        return null;
    }

    @Override
    @Transactional
    public void updateTariff(TariffViewForm tariff) {
        Tariff newTariff = new Tariff();
        newTariff.setIdTariff(tariff.getIdTariff());
        newTariff.setTitle(tariff.getTitle());
        newTariff.setPrice(tariff.getPrice());
        newTariff.setDeprecated(tariff.isDeprecated());
        createEntity(newTariff);
//        tariffRepository.save(newTariff);
    }

//    @Override
//    @Transactional
//    public void addOption(Tariff tariff, Option option) {
//        tariff.addOption(option);
//        for (Option opt : option.getAssociatedOptions()) {
//            tariff.addOption(opt);
//        }
//        updateEntity(tariff);
//
//    }
//
//    @Override
//    @Transactional
//    public void deleteOption(Tariff tariff, Option option) {
//        tariff.getOptions().remove(option);
//        for (Option opt : option.getAssociatedOptions()) {
//            tariff.getOptions().remove(opt);
//        }
//        tariffRepository.update(tariff);
//    }

    @Override
    @Transactional
    public void makeTariffDeprecated(int id) {
        Tariff tariff = getEntityById(id);
        tariff.setDeprecated(true);
        updateEntity(tariff);
    }

    @Override
    @Transactional
    public List<Tariff> getLimit(int limit) {
        return tariffRepository.getLimit(limit);
    }
}
