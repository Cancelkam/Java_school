package com.javaSchool.eCare.service.implementation;

import com.javaSchool.eCare.model.entity.Tariff;
import com.javaSchool.eCare.service.api.AdStandMessage;
import com.javaSchool.eCare.service.api.MessageSender;
import com.javaSchool.eCare.service.api.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

@Service
public class AdStandMessageImpl implements AdStandMessage {

    @Autowired
    MessageSender messageSender;

    @Autowired
    TariffService tariffService;

    @Override
    public void sendMessage() {
        messageSender.sendMessage(convert());
    }

    private String convert() {
        List<Tariff> tariffList = tariffService.getLimit(5);
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(tariffList);
    }
}
